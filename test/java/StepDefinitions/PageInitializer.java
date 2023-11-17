package StepDefinitions;

import Pages.*;

import javax.swing.plaf.PanelUI;

public class PageInitializer {
public static LoginPage loginPage;
public static DashBoardPage dashBoardPage;

public static PimTabPage pimTabPage;

public static EmployeeProfilePage employeeProfilePage;

public static AddEmployeePage addEmployeePage;


public static void initializeElements(){
    loginPage=new LoginPage();
    dashBoardPage=new DashBoardPage();
    pimTabPage=new PimTabPage();
    employeeProfilePage=new EmployeeProfilePage();
    addEmployeePage=new AddEmployeePage();

}
}
