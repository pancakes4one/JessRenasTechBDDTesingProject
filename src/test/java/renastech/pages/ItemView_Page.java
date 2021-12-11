package renastech.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import renastech.util.CommonUtils;
import renastech.util.Driver;

public class ItemView_Page {

    private static final Logger log = Logger.getLogger(ItemView_Page.class);

    public ItemView_Page(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//strong[.='Guru99 Payment Gateway']")
    private WebElement payGateHeader;
    @FindBy(xpath = "//h2[.='Mother Elephant With Babies Soft Toy']")
    private WebElement itemHeader;
    @FindBy(name = "quantity")
    private WebElement quantity;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNowBtn;
    @FindBy(xpath = "//h3[contains(text(), 'Price:')]")
    private WebElement priceShown;

    public void verifyPayGateHeaderisDisplayed() { Assert.assertTrue(payGateHeader.isDisplayed()); }

    public void verifyExpectedItemHeader(String expected) {
        Assert.assertEquals(expected, itemHeader.getText()); }

    public void verifyItemPriceDisplayed() {
        Assert.assertTrue("Toy Price is Displayed", itemHeader.isDisplayed());
    }
    public String verifyItemPriceAs (String price){
        Assert.assertTrue(priceShown.getText().contains(price));
        return "Item Price Displayed: \""+priceShown.getText()+"\"";
    }

    public String verifyURLcontains(String urlSegment){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(urlSegment));
        return "Current URL: "+Driver.getDriver().getCurrentUrl();
    }

    public String setQuantity(String qty){
        CommonUtils.selectFromDropdown(quantity,qty);
        log.info("Quantity Set");
        return "Quantity selected: \""+qty+"\"";
    }

    public void clickBuyNowBtn (){
        CommonUtils.moveToElement(buyNowBtn);
        CommonUtils.clickWithWait(buyNowBtn);
        log.info("Buy Now Button Clicked");
    }



}
