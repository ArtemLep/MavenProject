package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {
    @FindBy(id="empsearch_id")
    public WebElement idBox;

    @FindBy(id="searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]/a")
    public WebElement idOnTable;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[3]/a")
    public WebElement nameOnTable;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeeNameTextBox;

    public EmployeeListPage(){
        PageFactory.initElements(driver, this);
    }

}