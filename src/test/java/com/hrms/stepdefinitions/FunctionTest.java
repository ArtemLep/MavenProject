package com.hrms.stepdefinitions;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DbUtils;

import java.util.List;
import java.util.Map;

public class FunctionTest {

    public static void main(String[] args) {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        String query = "select emp_firstname, emp_lastname from hs_hr_employees";

        List<Map<String, String>> list = DbUtils.getDbDataIntoList(query);

        System.out.println(list);
        System.out.println(list.size());

    }

}