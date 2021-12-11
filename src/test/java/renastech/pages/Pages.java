package renastech.pages;

import org.openqa.selenium.support.PageFactory;
import renastech.util.Driver;

public class Pages {

    private ItemView_Page item;
    private PayProcess_Page pay;
    private ConfirmPurchase_Page confirm;

    public Pages() { PageFactory.initElements(Driver.getDriver(),this); }

    public ItemView_Page item() {
        if (item==null) {
            item = new ItemView_Page(); }
        return item; }

    public PayProcess_Page pay(){
        if (pay==null){
            pay = new PayProcess_Page(); }
        return pay; }

    public ConfirmPurchase_Page confirm() {
        if (confirm==null){
            confirm = new ConfirmPurchase_Page(); }
        return confirm; }

}
