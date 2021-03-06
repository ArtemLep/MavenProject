package com.hrms.api.Testing;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matcher.*;

public class hardCodedExample {
    String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY0NzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTY3NywidXNlcklkIjoiMjQxMSJ9.1C75KxE-KYkhHpqGUUBVPw_DqLKWW0k_cPih3niSCzQ";

    @Test
    public void sampleTest() {
        //RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
        //String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY0NzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTY3NywidXNlcklkIjoiMjQxMSJ9.1C75KxE-KYkhHpqGUUBVPw_DqLKWW0k_cPih3niSCzQ";
        //preparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest =
                given().header("Authorization", token)
                        .header("Content-Type", "Application/json")
                        .queryParam("employee_id", "13001");
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest
                .when().get("/getOneEmployee.php");
        //printing the response
        System.out.println(getOneEmployeeResponse.prettyPrint());

        //Assert that status code is 200
        getOneEmployeeResponse.then().assertThat().statusCode(200);
    }

    @Test
    public void createEmployeeWithPost() {
        RequestSpecification requestSpecification =
                given().
                        header("Content-Type", "application/json").
//                        header("Authorization", token).
        body("{\n" +
        "            \"employee_id\": \"15808A\",\n" +
        "            \"emp_firstname\": \"Jack\",\n" +
        "            \"emp_middle_name\": \"C\",\n" +
        "            \"emp_lastname\": \"Plantin\",\n" +
        "            \"emp_birthday\": \"2021-02-18\",\n" +
        "            \"emp_gender\": \"M\",\n" +
        "            \"emp_job_title\": \"Developer\",\n" +
        "            \"emp_status\": \"Moneer\"\n" +
        "        }");
        Response postResponse = requestSpecification.when().
                post("/createEmployee.php");
        postResponse.prettyPrint();
        String empID = postResponse.jsonPath().getString("Employee[0].employee_id");
        postResponse.then().assertThat().
                body("Message", equalTo("Entry Created"));
        postResponse.then().assertThat().
                body("Message", equalTo("Entry Created"));
    }

    @Test
    public void getOneEmployee() {
        RequestSpecification request =
                given().
//                        header("Authorization", token).
        header("Content-Type", "Application/json").
                        queryParam("employee_id", "15808A");
        Response response =
                request.
                        when().
                        get("/getOneEmployee.php");
        String empID = response.jsonPath().getString("employee[0].employee_id");
        response.then()
                .assertThat().
                body("employee[0].employee_id", equalTo(empID));
    }

    @Test
    public void cUpdateEmployee() {
        RequestSpecification updateEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"16037A\",\n" +
                        "  \"emp_firstname\": \"ABC\",\n" +
                        "  \"emp_lastname\": \"Romaniuk\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");
        Response UpdateEmployeeReponse = updateEmployeeRequest.when().put("/updateEmployee.php");
        UpdateEmployeeReponse.prettyPrint();


    }

    @Test
    public void dPartiallyUpdateEmployee() {
        RequestSpecification partiallyUpdateRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"16037A\",\n" +
                        "  \"emp_firstname\": \"updatedname\"\n" +
                        "}");
        Response PartiallyupdatedEmployeeResponse = partiallyUpdateRequest.when()
                .patch("/updatePartialEmplyeesDetails.php");
        PartiallyupdatedEmployeeResponse.prettyPrint();
        //assert that body contains the Message entery updated
        JsonPath js = PartiallyupdatedEmployeeResponse.jsonPath();
        Object Message = js.get("Message");
        System.out.println(Message);
        assertThat(Message, equalTo("Entry updated"));
        //the other method
        PartiallyupdatedEmployeeResponse.then().body("Message", containsString("Entry updated"));
    }

    @Test
    public void dDeleteEmployeeRequest() {
        RequestSpecification deleteEmployeeRequest = given().header("Authorization", token)
                .header("Content-type", "Application/json")
                .queryParam("employee_id", "16077A");
        Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
        deleteEmployeeResponse.prettyPrint();
        deleteEmployeeResponse.then().assertThat().body("message", containsString("Entry deleted"));
    }
}