package com.example.assignmenttwo;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

    public class ApiConnector {
        private final String base_url = "https://api.openweathermap.org/data/2.5/weather?";
        private final String API_KEY = "0943b8fa242b340d1678bc42fa844afe";
        private Context context;
        private RequestQueue requestQueue;


        public interface ApiResponseCallback {
            void onSuccess(String response);

            void onError(VolleyError error);
        }

        public ApiConnector(Context context) {
            this.context = context;
            requestQueue = Volley.newRequestQueue(context);
        }

        public void getData(String city, String zipCode, final ResponseListener responseListener) {
            String url = String.format("%sq=%s,%s&appid=%s", base_url, city, zipCode, API_KEY);
            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("JSON Response", response.toString());

                    try {
                        responseListener.onActionCompleted(response);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    responseListener.onActionFailed(error);
                }
            });

            requestQueue.add(request);
        }

        public interface ResponseListener {
            void onActionCompleted(String response) throws JSONException;

            void onActionFailed(VolleyError error);
        }
    }


