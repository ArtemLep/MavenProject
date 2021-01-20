package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddEmployeeStepDefinition extends CommonMethods {

    @When("click on PIM")
    public void click_on_PIM() {
        dashboardPage.clickOnPIM();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashboardPage.clickOnAddEmployeeBtn();
    }

    @Then("enter first and last name")
    public void enter_first_and_last_name() {
        addEmployeePage.enterFirstAndLastName("Thor", "Potter");
    }
    @Then("click on save button")
    public void click_on_save_button() {
        addEmployeePage.clickOnSaveBtn();
    }
    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", "Thor Potter", actualProfileName);
    }

    @Then("enter first name {string}, middle name {string} and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName,
                                                           String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) {
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify {string}, {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
        String fullName = firstName + " " + middleName + " " + lastName;
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

}