package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimTabPage extends CommonMethods {
    public PimTabPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement EmpNameSearchBar;

    @FindBy (id="searchBtn")
    public WebElement SearchBttn;

    @FindBy (xpath="//div[@id='search-results']//div//div[1]//ul[1]//li[6]//a[1]")
    public WebElement NextBtn;

    @FindBy (id="empsearch_id")
    public WebElement IDSearch;

@FindBy(xpath ="//tbody//tr//td")
    public WebElement NoRecordMsg;

    @FindBy(id ="btnAdd")
    public WebElement btnAdd;

    @FindBy(xpath = "//tbody/tr/td[2]/a[1]")
    public WebElement IdFound;
}
