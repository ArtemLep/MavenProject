package com.hrms.pages;

import com.hrms.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends BaseClass {
    @FindBy(id = "empsearch_id")
    public WebElement idEmployee;
    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    public void EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }
}