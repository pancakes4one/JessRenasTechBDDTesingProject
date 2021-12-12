package renastech.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import renastech.pages.Pages;
import org.apache.log4j.Logger;
import java.util.Map;

public class PayGate_Steps extends Pages{

    Pages pages = new Pages();

    @Then("The user wants to verify they are at beginning of Payment Gateway")
    public void the_user_wants_to_verify_they_are_at_beginning_of_payment_gateway() {
        pages.item().verifyPayGateHeaderisDisplayed();
    }

    @Then("The user wants to see item header as {string}")
    public void the_user_wants_to_see_item_header_as(String header) {
        pages.item().verifyExpectedItemHeader(header);
    }

    @When("The user verifies the displayed price is shown")
    public void the_user_verifies_the_displayed_price_is_shown() {
        pages.item().verifyItemPriceDisplayed();
    }

    @Then("The user wants to verify toy price is {string}")
    public void the_user_wants_to_verify_toy_price_is(String price) {
        pages.item().verifyItemPriceAs(price);
    }

    @Then("The user wants to verify the URL should contain {string}")
    public void the_user_wants_to_verify_the_url_should_contain(String urlSegment) {
        pages.item().verifyURLcontains(urlSegment);
    }

    @Then("The user wants to make the quantity {string}")
    public void the_user_wants_to_make_the_quantity(String quantity) {
        pages.item().setQuantity(quantity);
    }

    @Then("The user wants to click Buy Now")
    public void the_user_wants_to_click_buy_now() {
        pages.item().clickBuyNowBtn();
    }

    @Then("The user wants to enter payment information as")
    public void the_user_wants_to_enter_payment_information_as(Map<String,String> userPayInfo) {
        pages.pay().setAllCardInfoWithDatatable(userPayInfo);
    }

    @Then("The user wants to click Pay")
    public void the_user_wants_to_click_pay() {
        pages.pay().clickPayBtn();
    }

    @Then("The user wants to verify message as {string}")
    public void the_user_wants_to_verify_message_as(String paySuccessMsg) {
        pages.confirm().verifyPaySuccessMsg(paySuccessMsg);
    }

    @When("The user wants to select quantity of {string}")
    public void the_user_wants_to_select_quantity_of(String quantity) {
        pages.item().setQuantity(quantity);
    }

    @Then("The user wants to enter credit card number")
    public void the_user_wants_to_enter_credit_card_number() {
        pages.pay().setCardNumWithFaker();
    }

    @Then("The user wants to select expiration month")
    public void the_user_wants_to_select_expiration_month() {
        pages.pay().setExpMthDropRandomSelect();
    }

    @Then("The user wants to select expiration year")
    public void the_user_wants_to_select_expiration_year() {
        pages.pay().setExpYearDropRandomSelect();
    }

    @Then("The user wants to select CVV code")
    public void the_user_wants_to_select_cvv_code() {
        pages.pay().setCVVcode();
    }



}
