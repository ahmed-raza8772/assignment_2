package com.example.mad_assigment02;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public abstract class Fragment_Table extends Fragment {
    protected RecyclerView recyclerView;
    protected List<String[]> dataList;
    protected Adapter_For_Table adapter;
    protected abstract String getApiEndpoint();
    protected abstract String[] getColumnNames();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_for_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataList = new ArrayList<>();
        adapter = new Adapter_For_Table(dataList, getColumnNames());
        recyclerView.setAdapter(adapter);

        loadDataFromApi();
        return view;
    }

    private void loadDataFromApi() {
        String baseUrl = "https://super-duper-computing-machine-699j6jw5x5w7249r4-5000.app.github.dev";
        String fullUrl = baseUrl + getApiEndpoint();
        Log.d("API_URL", "Requesting: " + fullUrl);
        RequestQueue queue = Volley.newRequestQueue(requireContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                baseUrl + getApiEndpoint(),
                response -> {
                    try {
                        Log.d("API", "Response received: " + response);
                        JSONArray jsonArray = new JSONArray(response);
                        dataList.clear();
                        String[] columnNames = getColumnNames();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            String[] rowData = new String[columnNames.length];

                            for (int j = 0; j < columnNames.length; j++) {
                                String value = obj.getString(columnNames[j]);
                                rowData[j] = value;
                            }
                            dataList.add(rowData);
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("API", "Error: " + e.getMessage());
                        if (getContext() != null) {
                            Toast.makeText(getContext(), "Error loading data: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                },
                error -> {
                    error.printStackTrace();
                    Log.e("API", "Network Error: " + error.getMessage());
                    if (getContext() != null) {
                        Toast.makeText(getContext(), "Network error: " + error.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
        queue.add(stringRequest);
        stringRequest.setShouldCache(false);
        queue.add(stringRequest);
    }

}
