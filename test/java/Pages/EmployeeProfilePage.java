package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeProfilePage extends CommonMethods {

    public EmployeeProfilePage() {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//div[@id='content']//li[6]//a[1]")
    public WebElement JobTab;
    @FindBy(id = "btnTerminateEmployement")
    public WebElement TerminateBtn;

    @FindBy(id = "dialogConfirm")
    public WebElement ConfirmBtn;
}
