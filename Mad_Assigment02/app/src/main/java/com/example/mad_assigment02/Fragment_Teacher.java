package com.example.mad_assigment02;

public class Fragment_Teacher extends Fragment_Table {
    @Override
    protected String getApiEndpoint() {
        return "/teacher";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"tid", "tname"};
    }
}
