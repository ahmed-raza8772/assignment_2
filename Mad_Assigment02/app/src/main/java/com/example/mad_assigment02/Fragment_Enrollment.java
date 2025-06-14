package com.example.mad_assigment02;

public class Fragment_Enrollment extends Fragment_Table {
    @Override
    protected String getApiEndpoint() {
        return "/enrollment";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"course_code", "sid"};
    }
}
