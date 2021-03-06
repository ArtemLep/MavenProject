package com.hrms.utils;

import net.minidev.json.JSONObject;

public class apiPayloadConstants {
    public static String createEmployeeBody() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "moazzam");
        obj.put("emp_lastname", "sadiq");
        obj.put("emp_middle_name", "s");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2021-02-27");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "Cloud Architect");
        return obj.toString();
    }
}
