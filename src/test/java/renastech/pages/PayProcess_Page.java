package renastech.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import renastech.util.CommonUtils;
import renastech.util.Driver;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.Map;


public class PayProcess_Page {

    private static final Logger log = Logger.getLogger(PayProcess_Page.class);

    public PayProcess_Page() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy (id = "card_nmuber")
    private WebElement cardNmber;
    @FindBy (id = "month")
    private WebElement dropdown_expMth;
    @FindBy (id = "year")
    private WebElement dropdown_expYear;
    @FindBy (id = "cvv_code")
    private WebElement cardCVVcode;
    @FindBy (name = "submit")
    private WebElement payBtn;

    //faker method for CC
    Faker faker = new Faker();

    public void setCardNmberWithFaker() {
     cardNmber.sendKeys(faker.business().creditCardNumber().replaceAll("-",""));
    }

    public void setExpMthDropRandomSelect() {
        Select mthOptions = new Select(dropdown_expMth);
        List<WebElement> allMonths = mthOptions.getOptions();
        int selectMax = allMonths.size()-1;
        allMonths.get(CommonUtils.getRandomNumBetween(1,selectMax)).click();
    }

    public void setexpYearDropRandomSelect(){
        Select mthOptions = new Select(dropdown_expYear);
        List<WebElement> allMonths = mthOptions.getOptions();
        int selectMax = allMonths.size()-1;
        allMonths.get(CommonUtils.getRandomNumBetween(1,selectMax)).click();
    }

    public void setCardCVVcode() {
        cardCVVcode.sendKeys(CommonUtils.getRandomThreeNumberString());
    }

    public void setAllCardInfoWithDatatable(Map<String,String> userPayInfo){
        cardNmber.sendKeys(userPayInfo.get("CNumber"));

        Select dropMth =new Select(dropdown_expMth);
        dropMth.selectByVisibleText(userPayInfo.get("EMonth"));

        Select dropYr =new Select (dropdown_expYear);
        dropYr.selectByVisibleText(userPayInfo.get("EYear"));

        cardCVVcode.sendKeys(userPayInfo.get("CVVCode"));
    }

    public void clickPayBtn(){
        CommonUtils.clickWithWait(payBtn);
        log.info("Pay Button Clicked");
    }


}
