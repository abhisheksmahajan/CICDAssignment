const superagent = require('superagent');
const Events = require('events');

module.exports = class CreateSnapshot extends Events {
    command(browser) {
        let testRailHost = browser.globals.testRail.host;
        let runId = browser.globals.testRail.runId;
        let username = process.env.TESTRAIL_USERNAME;
        let apiKey = process.env.TESTRAIL_API_KEY;
        let testId = browser.testId;
        let testUpdate = {
            // TestRail equates 1 to passing and 5 to failing
            "status_id": (browser.currentTest.results.failed === 0) ? 1 : 5,
            "comment": returnStepsFromAssertions(browser.currentTest.results.assertions)
        };
        let url =
            `https://${testRailHost}/index.php?/api/v2/add_result_for_case/${runId}/${testId}`;

        if (!runId || !username || !apiKey) {
            console.info("Missing process.env variables for TestRail integration. TestRail will not be updated. Check README.md for help.");
            this.emit('complete');
            return;
        }

        // If the testId wasn't included but there is a runId we can try and find the testId
        // by name using the runId of the suite.
        if (!testId && runId) {
            superagent.get(
                `https://${testRailHost}/index.php?/api/v2/get_tests/${runId}`)
                .disableTLSCerts() // TestRail has self-signed?
                .set('Content-Type', 'application/json')
                .auth(username, apiKey)
                .then(res => {
                    let foundTest = res.body.filter(function (test) {
                        return test.title == browser.currentTest.name;
                    });

                    if (foundTest && foundTest.length > 0) {
                        testId = foundTest[0].case_id;
                        console.info(`\r\nTest name: "${browser.currentTest.name}" missing testId attribute in test case, ` +
                            `but was found in test runId: ${runId}. \r\nAdd browser.testId = ${testId}; to your test ` +
                            `for faster performance in future runs.\r\n`)

                        url = `https://${testRailHost}/index.php?/api/v2/add_result_for_case/${runId}/${testId}`;
                        sendUpdate(url, username, apiKey, testUpdate);
                    } else {
                        console.info(
                            `\r\nTest name: "${browser.currentTest.name}" missing testId attribute in test case ` +
                            "and could not be found by name in the TestRail test run. Please ensure the test exists in your " +
                            "test run and has the browser.testId(id) attribute in your test.\r\n")
                    }
                    this.emit('complete');
                })
                .catch(err => {
                    console.error(`\r\nError looking up testId(${testId}) from TestRail, received: ${err.message}`)
                })
        } else {
            sendUpdate(url, username, apiKey, testUpdate);
            this.emit('complete');
        }
    }
}

let sendUpdate = function (url, username, apiKey, testUpdate) {
    superagent.post(url)
        .disableTLSCerts() // Allows for self-signed TestRail certificates, but not expired or invalid
        .set('Content-Type', 'application/json')
        .auth(username, apiKey)
        .send(testUpdate)
        .end((err, res) => {
            if (err) {
                console.error(`\r\nError posting to TestRail, received: ${err}\r\n`)
            } else {
                console.info("\r\nTest result successfully posted to TestRail\r\n")
            }
        })
}

let returnStepsFromAssertions = function(assertions) {
    if (assertions === null || assertions === undefined) {
        return "";
    } else {
        var steps = "";

        for (let i = 0; i < assertions.length; i++) {
            let failed = assertions[i].failure == false ? "PASS" : "FAIL";
            let stepNumber = (i + 1).toString().padStart(3, 0);
            steps += `Step ${stepNumber} - ${failed}: ${assertions[i].fullMsg}\r\n`
        }

        return steps;
    }
}