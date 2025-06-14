package com.example.mad_assigment02;

public class Fragment_Student extends Fragment_Table {
    @Override
    protected String getApiEndpoint() {
        return "/student";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"sid", "sname", "semail", "adress"};
    }
}
