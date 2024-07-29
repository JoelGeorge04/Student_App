package com.jspace.studentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    AppCompatButton b1;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    String apiUrl = "https://courseapplogix.onrender.com/addstudents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=(AppCompatButton)findViewById(R.id.ddd);
        e1=(EditText)findViewById(R.id.fname);
        e2=(EditText)findViewById(R.id.lnam);
        e3=(EditText)findViewById(R.id.colgnam);
        e5=(EditText)findViewById(R.id.dob);
        e6=(EditText)findViewById(R.id.coursnam);
        e7=(EditText)findViewById(R.id.ph);
        e8=(EditText)findViewById(R.id.email);
        e9=(EditText)findViewById(R.id.addr);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = e1.getText().toString();
                String lName = e2.getText().toString();
                String collg = e3.getText().toString();
                String dob = e4.getText().toString();
                String cors = e5.getText().toString();
                String pho = e6.getText().toString();
                String ema = e7.getText().toString();
                String addr = e8.getText().toString();


                JSONObject stud=new JSONObject();
                try {
                    stud.put("firstname",fname);
                    stud.put("lastame",lName);
                    stud.put("college",collg);
                    stud.put("dob",dob);
                    stud.put("course",cors);
                    stud.put("mobile",pho);
                    stud.put("email",ema);
                    stud.put("address",addr);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        stud,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                Toast.makeText(getApplicationContext(), "API successfull", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Toast.makeText(getApplicationContext(), "API unsuccessfull", Toast.LENGTH_LONG).show();
                            }
                        }
                );
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}