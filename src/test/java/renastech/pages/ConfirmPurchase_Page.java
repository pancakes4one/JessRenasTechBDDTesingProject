package renastech.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import renastech.util.Driver;

public class ConfirmPurchase_Page {

    private static final Logger log = Logger.getLogger(ConfirmPurchase_Page.class);

    public ConfirmPurchase_Page(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//h2[contains(text(),'Payment successfull!')]")
    private WebElement paySuccessHeader;

    public String verifyPaySuccessMsg(String paySuccessMsg) {
        Assert.assertEquals(paySuccessMsg, paySuccessHeader.getText());
        return "Confirm Message: "+paySuccessHeader.getText();
    }
}
