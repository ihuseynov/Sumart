package com.only.aquahack.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.only.aquahack.Models.User;
import com.only.aquahack.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private Animation text_anim;
    private TextView quote;
    private Button but;
    private final String url = "http://imirza.pythonanywhere.com/auth/login/";  // url should change
    private final int minLength = 1;

    private EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        animSetUp();  // animations

        buttonSetUp();

    }

    public void sendJsonObj(User user){

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        Map<String, String> params = new HashMap<String, String>();
        params.put("username", user.getUserId() );
        params.put("password", user.getPassword());
        Log.d("Response : ", params.toString());

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response : ", response.toString());

                        try {
                            String key = response.get("key").toString();

                            Log.d("Response : ", key);

                            Intent send = new Intent(LoginActivity.this, MainActivity.class);
                            send.putExtra("key", key);
                            startActivity(send);
                            finish();

                        } catch (JSONException e) {

                            Log.d("Response : ", e.toString());

                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),
                        "Daxil etdiyiniz kod səhvdir",Toast.LENGTH_SHORT).show();

                Log.d("Response : ", error.toString());
            }
        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };

        // Adding request to request queue
        requestQueue.add(jsonObjReq);
    }

    public  void buttonSetUp(){

         but = findViewById(R.id.bIreli);
         userName = findViewById(R.id.userName);
         password = findViewById(R.id.password);



         if( isNetworkAvailable() ) {


             but.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     String uN = userName.getText().toString();

                     if (uN.length() >= minLength) {

                         User user = new User(uN, password.getText().toString());

                         sendJsonObj(user);

                     } else {
                         Toast.makeText(getApplicationContext(),
                                 "Daxil etdiyiniz kod qısadır", Toast.LENGTH_SHORT).show();
                     }

                 }
             });

         }
         else { Toast.makeText(getApplicationContext(),
                 "Internetinizi yoxlayin ",Toast.LENGTH_SHORT).show();}

    }

    private  boolean isNetworkAvailable( ) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        Log.d("hasConnection ?", activeNetworkInfo.toString());


        return (activeNetworkInfo.isConnected());
    }

    public void animSetUp(){

        quote = findViewById(R.id.quote);
        quote.setText(getQuote());
        text_anim = AnimationUtils.loadAnimation(this , R.anim.text_anim);
        quote.setAnimation(text_anim);
    }

    public static  String getQuote(){

        // Can get various quotes from API; when API ready

        return String.valueOf(R.string.quote1);
    }

}
