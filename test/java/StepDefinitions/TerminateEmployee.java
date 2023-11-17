package StepDefinitions;

import Pages.DashBoardPage;
import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TerminateEmployee extends CommonMethods {
    @Given("Admin user log in to the system using valid credentials.")
    public void admin_user_log_in_to_the_system_using_valid_credentials() {
        sendText(loginPage.UsernameTxtBox, "Admin");
        sendText(loginPage.PasswordBox, "Hum@nhrm123");
    }

    @When("user accesses the list of employees in the system.")
    public void user_accesses_the_list_of_employees_in_the_system() {
        doClick(DashBoardPage.dashBoardPage.PIMTAB);
    }

    @When("select a specified employee from the list.")
    public void select_a_specified_employee_from_the_list() {
        sendText(pimTabPage.IDSearch, "84673052");
        doClick(pimTabPage.SearchBttn);


    }

    @When("navigate to the employee's job page.")
    public void navigate_to_the_employee_s_job_page() {
        boolean isFound = false;

        while (!isFound) {
            List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td"));
            for (WebElement value : cells) {
                System.out.println(value.getText());
                String valuetxt = value.getText();
                if (valuetxt.equalsIgnoreCase("84673052")) {
                    System.out.println("Employee has been found");
                    value.click();

                    isFound = true;

                    break;
                }


            }
        }

        doClick(employeeProfilePage.JobTab);

    }


    @When("select the option to terminate the employment of the specified employee.")
    public void select_the_option_to_terminate_the_employment_of_the_specified_employee() {
        doClick(employeeProfilePage.TerminateBtn);
        doClick(employeeProfilePage.ConfirmBtn);
    }

    @Then("specified employee is terminated")
    public void specified_employee_is_terminated() {

        doClick(dashBoardPage.PIMTAB);
        sendText(pimTabPage.IDSearch,"84673052" );
        doClick(pimTabPage.SearchBttn);

        String expectedMessage="No Records Found";
        String actualMessage=pimTabPage.NoRecordMsg.getText();

        Assert.assertEquals(expectedMessage,actualMessage);



    }

}
