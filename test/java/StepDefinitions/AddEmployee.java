package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AddEmployee extends CommonMethods {

    public static String empId;
    @Given("User clicks pimtab")
    public void user_clicks_pimtab() {
        doClick(dashBoardPage.PIMTAB);
    }

    @Then("user clicks on add and enters new employee information")
    public void user_clicks_on_add_and_enters_new_employee_information() {
        doClick(pimTabPage.btnAdd);

        sendText(addEmployeePage.AddEmployeeFirst, ConfigReader.getProperties("EmpName"));
        sendText(addEmployeePage.AddEmployeeMiddle, ConfigReader.getProperties("EmpMiddle"));
        sendText(addEmployeePage.AddEmployeeLast, ConfigReader.getProperties("EmpLast"));
        empId = addEmployeePage.employeeId.getAttribute("value");


    }

    @Then("user clicks on save")
    public void user_clicks_on_save() {
        doClick(addEmployeePage.Savebtn);
        doClick(dashBoardPage.PIMTAB);
        sendText(pimTabPage.IDSearch, empId);
        doClick(pimTabPage.SearchBttn);
        


    }

    @Then("verify employee is stored in database")
    public void verify_employee_is_stored_in_database() {


        String query = "select emp_firstName,emp_middle_name,emp_lastname from hs_hr_employees where employee_id=" +empId+ ";";
        System.out.println(query);
        List<Map<String, String>> matchlist = DBUtils.fetch(query);

        Map<String, String> firstRow = matchlist.get(0);
        String dbfirstname = firstRow.get("emp_firstName");
        String dbmiddlename = firstRow.get("emp_middle_name");
        String dblastname = firstRow.get("emp_lastname");

        System.out.println(dbfirstname+" "+dbmiddlename+" "+dblastname);

        Assert.assertEquals("FirstName in frontbase does not equal Firstname in Database",ConfigReader.getProperties("EmpName"),dbfirstname);
        Assert.assertEquals("MiddleName in frontbase does not equal MiddleName in Database",ConfigReader.getProperties("EmpMiddle"),dbmiddlename);
        Assert.assertEquals("LastName in frontbase does not equal LastName in Database",ConfigReader.getProperties("EmpLast"),dblastname);

    }

}
