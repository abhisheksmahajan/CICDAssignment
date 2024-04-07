const { assert } = require("nightwatch");

const homePage = browser.page.amazon.Homepage();
const ProductPage= browser.page.amazon.Productpage();
describe('Add Cart', function() {
   
  
    before( () => homePage.navigate()
                  .searchproduct("Poco x2")
                  .submit()
                             
    );
  
    after((browser) => browser.quit());
  
    it('Verify that ', async(browser)=> {
        ProductPage.clickonSearchproduct();
        browser.windowHandles(function(result) {
          const originalHandle = result.value[0];
          const handle = result.value[1]; 
          this.switchWindow(handle)
           
      })
      browser.getTitle(function(title) {
        console.log('Page title is: ' + title);
      })
      browser.assert.titleContains("POCO X2 (Atlantis Blue, 8GB RAM, 256GB Storage) : Amazon.in: Electronics")
        browser.getTitle(function(title) {
          console.log('Page title is: ' + title);
        })
        ProductPage.clickonAddcart()
        browser.pause(10000);
        ProductPage.expect.element('@successfullyaddcart').to.be.visible;

    });

  });