package com.dio.satriani.reycleview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ArrayList<InstansiModel> instansiModels;
    RecyclerView rv;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_home, container, false);
         rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager=
                new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);

        instansiModels = new ArrayList<>();

        String URl ="https://script.googleusercontent.com/macros/echo?user_content_key=V7-3fu-bAoDqaThentspz294-UsgsaSd5LqMDF4nw70SBus1QQa2i-hiOWh9o-DFcbaaBmi5Y6qd3TxtY9f3m_aS2oZvHvOZOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuB6lHT6qnqYcmFWggwoSVQQXTsQ1HqKa1CgDXQROm1OeNR5ibYVAaRxAeOtzLmbRZcVjrce7Uveb8iU1s-L39A_CLDTUaq6azCNVhRMhi1rsPEMUK-CH6pys1RvMr_dgaGkoVsMt9XllB7kFByHUCzY&lib=M-tpZm-Fm1QX9Yr80nZn_p-WXe3zpGnIr";
        loaddata();


//        StringRequest stringRequest = new StringRequest(Request.Method.GET,
//                URl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//

//
////                try {
////                    JSONObject jsonObject = new JSONObject(response);
////                    JSONArray jsonArray = jsonObject.getJSONArray("data");
////                    Toast.makeText(getActivity(), "" + jsonArray, Toast.LENGTH_SHORT).show();
////                    Toast.makeText(getActivity(), "" + jsonArray, Toast.LENGTH_SHORT).show();
////                    Toast.makeText(getActivity(), "" + jsonArray, Toast.LENGTH_SHORT).show();
////                    Toast.makeText(getActivity(), "" + jsonArray, Toast.LENGTH_SHORT).show();
////                    for (int i = 0; i < jsonArray.length(); i++) {
////                        JSONObject data = jsonArray.getJSONObject(i);
////                        String instansi = data.getString("instansi");
////
////
////                        InstansiModel instansiModel = new InstansiModel(instansi);
////                        instansiModels.add(instansiModel);
////                    }
////
////
////
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
//

//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                Toast.makeText(getActivity(), "" +error, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//        requestQueue.add(stringRequest);
         return view;
    }

    private void loaddata() {
        String URl ="https://script.googleusercontent.com/macros/echo?user_content_key=V7-3fu-bAoDqaThentspz294-UsgsaSd5LqMDF4nw70SBus1QQa2i-hiOWh9o-DFcbaaBmi5Y6qd3TxtY9f3m_aS2oZvHvOZOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuB6lHT6qnqYcmFWggwoSVQQXTsQ1HqKa1CgDXQROm1OeNR5ibYVAaRxAeOtzLmbRZcVjrce7Uveb8iU1s-L39A_CLDTUaq6azCNVhRMhi1rsPEMUK-CH6pys1RvMr_dgaGkoVsMt9XllB7kFByHUCzY&lib=M-tpZm-Fm1QX9Yr80nZn_p-WXe3zpGnIr";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(getActivity(), "" + response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);
                                String instansi = data.getString("instansi");
                                String alamat = data.getString("alamat");
                                String jam = data.getString("jam");
                                String donor = data.getString("rencana_donor");
//                                Toast.makeText(getActivity(), "" + instansi, Toast.LENGTH_SHORT).show();

                                InstansiModel instansiModel = new InstansiModel(instansi, alamat, jam, donor);
                                instansiModels.add(instansiModel);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        InstansiAdapter instansiAdapter = new InstansiAdapter(getActivity(), instansiModels);
                        rv.setAdapter(instansiAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}
