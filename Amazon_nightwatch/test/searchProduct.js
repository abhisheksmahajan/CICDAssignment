

const homePage = browser.page.amazon.Homepage();
const ProductPage= browser.page.amazon.Productpage();
describe('Sreach Product', function() {
   
  
    before( () => homePage.navigate());
  
    after((browser) => browser.quit());
  
    it('Verify that User should able to search Product', function(browser) {
      homePage.searchproduct("Poco x2")
       
      .submit()
      homePage.expect.element('@result').text.to.contain('Poco x2');
  
    
    });
    it('Verify that User not should able to search Product Wrong product', function(browser) {
        homePage.setValue('@searchBar', '999999999999')
        .submit();
        browser.assert.urlEquals("https://www.amazon.in/s?k=999999999999&ref=nb_sb_noss");

       
    });
  });

  
 
  