package com.example.habersitesirestfulrestkavram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=4cc6da67a29246dd81649aa7532b58dd

    private TextView tv;
    private Button b ;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        b = findViewById(R.id.button);
        mQueue = Volley.newRequestQueue(MainActivity.this);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url="http://localhost:3000";
               JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                   @Override
                   public void onResponse(JSONObject response) {
                       try {

                           tv.setText(response.getString("title"));
                           Toast.makeText(MainActivity.this, "calıstı", Toast.LENGTH_SHORT).show();
                       } catch (JSONException e) {
                           e.printStackTrace();
                           Toast.makeText(MainActivity.this, "hata", Toast.LENGTH_SHORT).show();
                       }
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               });


                       mQueue.add(request);
            }
        });

    }
}