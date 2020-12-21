package com.only.aquahack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.only.aquahack.Adapters.DeviceRecyclerViewAdapter;
import com.only.aquahack.Models.Device;
import com.only.aquahack.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DeviceRecyclerViewAdapter movieRecyclerViewAdapter;
    private List<Device> deviceList;
    private   Animation text_anim;


    private final String Url = "http://imirza.pythonanywhere.com/devices/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        recyclerView =  findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        deviceList = new ArrayList<>();

        deviceList = getList();

        movieRecyclerViewAdapter = new DeviceRecyclerViewAdapter(this, deviceList);
        recyclerView.setAdapter(movieRecyclerViewAdapter);
        movieRecyclerViewAdapter.notifyDataSetChanged();


        animSetUp();

    }


    private List<Device> getList(){

        Intent intent = getIntent();
        final String token =  intent.getStringExtra("key");        //tokeni evvelki activity den gotur


        Log.d("Response Main : ", token);



        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET ,
                Url ,null,

                new Response.Listener<JSONArray>()
                {@Override
                public void onResponse(JSONArray response) {

                    Log.d("Response : ", response.toString());
                    try{

                        JSONArray deviceArray = response;

                        for (int i = 0; i < deviceArray.length(); i++) {

                            JSONObject dObj = deviceArray.getJSONObject(i);

                            Device device = new Device();
                            device.setLocation(dObj.getString("location"));
                            device.setCode(dObj.getString("code"));
                            device.setType(dObj.getString("type"));
                            device.setDebt(dObj.getDouble("debt"));
                            device.setLast_sync(dObj.getString("sync"));


                            // Log.d("Movies: ", movie.getTitle());
                            deviceList.add(device);


                        }
                        /**
                         * Very important!! Otherwise, we wont see anything being displayed.
                         */
                        movieRecyclerViewAdapter.notifyDataSetChanged();//Important!!


                    }catch (JSONException e) {
                        e.printStackTrace();
                    }




                }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        VolleyLog.d("Error", error.getMessage());
                    }


                })

        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }





            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization",  "Token "+token);
                return headers;
            }
        };



        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d("azerbaycan  : ", arrayRequest.toString());
        queue.add(arrayRequest);



        return deviceList;
    }


    public   void animSetUp(){


        text_anim = AnimationUtils.loadAnimation(this , R.anim.text_anim);
        recyclerView.setAnimation(text_anim);
    }

}
