package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends CommonMethods {
    public  DashBoardPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']//b")
    public WebElement PIMTAB;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']//b")
    public WebElement ADMINTAB;



}
