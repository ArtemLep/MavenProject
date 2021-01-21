package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewEmployeePage extends CommonMethods {
    @FindBy(xpath = "//input[@name = 'empsearch[id]']")
    public WebElement idSearchField;

    @FindBy(xpath = "//input[@id ='empsearch_employee_name_empName']")
    public WebElement searchNameField;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr[1]/td[3]")
    public WebElement firstNameCell;

    @FindBy(xpath = "//table[@id ='resultTable']/tbody/tr[1]/td[4]")
    public WebElement lastNameCell;
    @FindBy(xpath = "//table[@id ='resultTable']/tbody/tr[1]/td[2]")
    public WebElement idCell;

    public String getIDText() {
        return idCell.getText();
    }

    public String getFirstNameText() {
        return firstNameCell.getText();
    }

    public String getLastNameText() {
        return lastNameCell.getText();
    }


    public ViewEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
