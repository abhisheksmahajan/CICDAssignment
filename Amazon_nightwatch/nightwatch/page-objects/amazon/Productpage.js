const productCommands = {
    
    verifyresult(){
      return this
      .getText('@errorResult')
      .pause(1000);
      
    },
    verifyresult1(){
      return this
      .getText('@result');
      
    },
    clickonSearchproduct(){
        return this.waitForElementVisible('@firstProduct')
        .click('@firstProduct');
    },
    clickonAddcart(){
      return this.waitForElementVisible('@addCartButton')
      .click('@addCartButton');
    }
  

  };
    
  module.exports = {
    url: 'https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=2421633899598524716&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302964&hvtargid=kwd-10573980&hydadcr=14453_2316415&gad_source=1',
  
    commands: [
        productCommands
    ],
  
    elements: {
      result:{
        selector: '.a-color-state.a-text-bold'
      },
      errorResult:{
        selector:'div[id="search"] div[class="a-row"] span:nth-child(1)'
      },
      firstProduct:{
        selector:'//div[@class="s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1"]//h2[@class="a-size-mini a-spacing-none a-color-base s-line-clamp-2"]//span[1]',
        locateStrategy: 'xpath' 
      },
      addCartButton:{
        selector:'div>.celwidget>.a-button-stack>#atc-declarative>span[id="submit.add-to-cart"]>.a-button-inner>input[name="submit.add-to-cart"]'
      },
      successfullyaddcart:{
        selector:'div:nth-of-type(1)>div:nth-of-type(1)>div>div>div>.a-alert-heading'
      }



      
    }
  };
