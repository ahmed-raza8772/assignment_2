package com.example.mad_assigment02;

public class Fragment_Course extends Fragment_Table {
    @Override
    protected String getApiEndpoint() {
        return "/course";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"course_code", "cname"};
    }
}