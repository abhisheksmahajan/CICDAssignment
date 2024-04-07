# nightwatch-testrail-updater
NightwatchJS custom command to update your TestRail test run with the results of your automated tests using the TestRail API.

## Automatically updating your TestRail run with the results of your Nightwatch test automation

This package is meant to simplify updating the results of test runs inside Gurock TestRail when using Nightwatch automated tests. This library is a client for the [TestRail API](https://www.gurock.com/testrail/docs/api) and posts to the `add_result_for_case` endpoint after each test case completes within a test class.

## Installation instructions

In your Nightwatch test project 

> npm install nightwatch-testrail-updater --save

In your NightwatchJS `nightwatch.json` configuration file add or append this entry

> "custom_commands_path": ["./node_modules/nightwatch-testrail-updater/commands"]

The nightwatch-testrail-updater package looks in the nightwatch.json file for the values it needs to connect to the TestRail API such as the host and run id. Below is an excerpt of the important parts.

The host would be the host of where you have your TestRail instance deployed to and the run id is the "R" number shown in the upper left of the test run in TestRail when you are viewing the test run details.

```json
"test_settings": {
    "default": {
        "globals": {
            "testRail": {
                "host": "testrail.mycorp.com",
                "runId": "12345"
            }
        }
    }
  }
```

In addition, you must have environment variables set on the system named `TESTRAIL_USERNAME` and `TESTRAIL_API_KEY` that contain the TestRail username and API key information in order to authenticate with the TestRail API.

## Sending Nightwatch test result to TestRail

First, to associate a test case with a test run ensure you have the run id for the TestRail run specified in the browser.globals.testRail.runId value. This can come out of the test_settings in the Nightwatch config file as shown in the example from the previous section or set during runtime.

Next, the test case in Nightwatch needs to be linked to the test case id in TestRail. This is the number prefixed by "C" when viewing the list of test cases in the TestRail Test Cases tab. Once you have that id, add it inside the test case without the C

```js
'descriptive test case name': function (browser) {
        // For test case id C112233
        browser.testId = 112233;

        // Test code here
    }
```

Last, when the test is completed in the afterEach test hook call the browser.updateTestRail(browser) command.

```js
module.exports = {
...
    afterEach: function (browser, done) {
        browser.updateTestRail(browser);
        browser.end();
    }
...
}
```

This will update the TestRail test run with the results of the tests in your suite after the test runs.
