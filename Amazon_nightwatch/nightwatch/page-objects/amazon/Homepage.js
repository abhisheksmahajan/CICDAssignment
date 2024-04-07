const searchCommands = {
    submit() {
      return this
      .waitForElementVisible('@submitButton', 1000)
      .click('@submitButton');
  
    },
    // verifyresult(Result){
    //   return this
    //   .assert.containsText('@errorResult',Result)
    //   .pause(1000);
      
    // },
    searchproduct(product){
      
      return this.waitForElementVisible('@searchBar', 1000)
      .setValue('@searchBar',product)
    },
    // verifyresult1(Result){
    //   return this
    //   .assert.urlContains
    //   .assert.containsText('@result',Result)
    //   .pause(1000);
      
    // }
  

  };
  
  module.exports = {
    url: 'https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=2421633899598524716&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302964&hvtargid=kwd-10573980&hydadcr=14453_2316415&gad_source=1',
  
  commands: [
     searchCommands
    ],
  
    elements: {
      searchBar: {
        selector: '#twotabsearchtextbox'
      },
  
      submitButton: {
        selector: '#nav-search-submit-button'
      },
      result:{
        selector: '.a-color-state.a-text-bold'
      },
      errorResult:{
        selector:'div[id="search"] div[class="a-row"] span:nth-child(1)'
      }
    }
  };
