package hci.univie.ac.at.yawa;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner citySpinner;
    private Button confirmButton;
    private RequestQueue requestQueue;
    public static final String CITY = "city";
    public static  final String DATE_1 ="day_1";
    public static final String MAX_TEMP_1 = "max_temp_1";
    public static final String MIN_TEMP_1 = "min_temp_1";
    public static final String AVG_TEMP_1 = "avg_temp_1";

    public static  final String DATE_2 ="day_2";
    public static final String MAX_TEMP_2 = "max_temp_2";
    public static final String MIN_TEMP_2 = "min_temp_2";
    public static final String AVG_TEMP_2 = "avg_temp_2";

    public static  final String DATE_3 ="day_3";
    public static final String MAX_TEMP_3 = "max_temp_3";
    public static final String MIN_TEMP_3 = "min_temp_3";
    public static final String AVG_TEMP_3 = "avg_temp_3";

    public static  final String DATE_4 ="day_4";
    public static final String MAX_TEMP_4 = "max_temp_4";
    public static final String MIN_TEMP_4 = "min_temp_4";
    public static final String AVG_TEMP_4 = "avg_temp_4";

    public static  final String DATE_5 ="day_5";
    public static final String MAX_TEMP_5 = "max_temp_5";
    public static final String MIN_TEMP_5 = "min_temp_5";
    public static final String AVG_TEMP_5 = "avg_temp_5";

    private HashMap<String, String> cityURLMap = new HashMap<String, String>() {{
        put("Vienna", "http://api.openweathermap.org/data/2.5/forecast?id=2761369&APPID=08be7b3343a8be3a5afdf176f1c0288b&units=metric");
        put("Amsterdam", "http://api.openweathermap.org/data/2.5/forecast?id=2759794&APPID=08be7b3343a8be3a5afdf176f1c0288b&units=metric");
        put("Barcelona", "http://api.openweathermap.org/data/2.5/forecast?id=6356055&APPID=08be7b3343a8be3a5afdf176f1c0288b&units=metric");
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new ArrayList<String>(cityURLMap.keySet()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner = findViewById(R.id.citySpinner);
        citySpinner.setAdapter(adapter);
        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);
    }

    private void processResult(JSONObject apiResponse, String selectedCity) {// Methode für json parsing
        try {
            double averageTemp_1 = 0;
            double maxTemp_1 = 0;
            double minTemp_1=0;
            String date_1="";
            double averageTemp_2 = 0;
            double maxTemp_2 = 0;
            double minTemp_2=0;
            String date_2="";
            double averageTemp_3 = 0;
            double maxTemp_3 = 0;
            double minTemp_3=0;
            String date_3="";
            double averageTemp_4 = 0;
            double maxTemp_4 = 0;
            double minTemp_4=0;
            String date_4="";
            double averageTemp_5 = 0;
            double maxTemp_5 = 0;
            double minTemp_5=0;
            String date_5="";

            JSONArray list = apiResponse.getJSONArray("list");    // array von jsonobject
            JSONObject objectDay = list.getJSONObject(0);
            date_1 = objectDay.getString("dt_txt").substring(0, 10);// Datum des ersten Tages

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            int count =0;
            double compare_maxTemp = -100;
            double compare_minTemp = 100;
            double avgTemp=0;

            for (int i = 0; i <8; i++) {    // schleife für Jsonarray
                JSONObject object = list.getJSONObject(i);
                JSONObject mainObject = object.getJSONObject("main");
                if (date_1.equals(object.getString("dt_txt").substring(0, 10))){// Vergleicht ob Datunm von ersten Tag gleich zu Datum von nächsten Jsonobjekt
                    ++count;
                        if(mainObject.getDouble("temp_max") > compare_maxTemp){// Vergleicht alle max. Temperaturen von "main" Jsonobekt
                             compare_maxTemp = mainObject.getDouble("temp_max");
                        }
                    maxTemp_1=compare_maxTemp;
                    if(mainObject.getDouble("temp_min") < compare_minTemp){  // Vergleicht alle min. Temperaturen von "main" Jsonobekt
                        compare_minTemp = mainObject.getDouble("temp_min");
                    }
                    minTemp_1=compare_minTemp;
                    avgTemp=avgTemp+mainObject.getDouble("temp"); // durchschnitliche Temperatur
                }
            }
            averageTemp_1=Double.valueOf(decimalFormat.format(avgTemp/count));


            compare_maxTemp = -100;
            compare_minTemp = 100;
             avgTemp=0;
             objectDay = list.getJSONObject((count));
            date_2 = objectDay.getString("dt_txt").substring(0, 10);

            for (int i = count; i <(count+8); i++) {
                JSONObject object = list.getJSONObject(i);
                JSONObject mainObject = object.getJSONObject("main");
                    if(mainObject.getDouble("temp_max") > compare_maxTemp)
                        compare_maxTemp = mainObject.getDouble("temp_max");
                    maxTemp_2=compare_maxTemp;
                    if(mainObject.getDouble("temp_min") < compare_minTemp){
                        compare_minTemp = mainObject.getDouble("temp_min");
                    }
                    minTemp_2=compare_minTemp;
                    avgTemp=avgTemp+mainObject.getDouble("temp");
                }
            averageTemp_2=Double.valueOf(decimalFormat.format(avgTemp/8));
            count=count+8;


            compare_maxTemp = -100;
            compare_minTemp = 100;
            avgTemp=0;
            objectDay = list.getJSONObject((count));
            date_3 = objectDay.getString("dt_txt").substring(0, 10);

            for (int i = count; i <(count+8); i++) {
                JSONObject object = list.getJSONObject(i);
                JSONObject mainObject = object.getJSONObject("main");
                if(mainObject.getDouble("temp_max") > compare_maxTemp)
                    compare_maxTemp = mainObject.getDouble("temp_max");
                maxTemp_3=compare_maxTemp;
                if(mainObject.getDouble("temp_min") < compare_minTemp){
                    compare_minTemp = mainObject.getDouble("temp_min");
                }
                minTemp_3=compare_minTemp;
                avgTemp=avgTemp+mainObject.getDouble("temp");
            }
            averageTemp_3=Double.valueOf(decimalFormat.format(avgTemp/8));
            count=count+8;


            compare_maxTemp = -100;
            compare_minTemp = 100;
            avgTemp=0;
            objectDay = list.getJSONObject((count));
            date_4 = objectDay.getString("dt_txt").substring(0, 10);

            for (int i = count; i <(count+8); i++) {
                JSONObject object = list.getJSONObject(i);
                JSONObject mainObject = object.getJSONObject("main");
                if(mainObject.getDouble("temp_max") > compare_maxTemp)
                    compare_maxTemp = mainObject.getDouble("temp_max");
                maxTemp_4=compare_maxTemp;
                if(mainObject.getDouble("temp_min") < compare_minTemp){
                    compare_minTemp = mainObject.getDouble("temp_min");
                }
                minTemp_4=compare_minTemp;
                avgTemp=avgTemp+mainObject.getDouble("temp");
            }
            averageTemp_4=Double.valueOf(decimalFormat.format(avgTemp/8));
            count=count+8;


            compare_maxTemp = -100;
            compare_minTemp = 100;
            avgTemp=0;
            objectDay = list.getJSONObject((count));
            date_5 = objectDay.getString("dt_txt").substring(0, 10);

            for (int i = count; i <(count+8); i++) {
                JSONObject object = list.getJSONObject(i);
                JSONObject mainObject = object.getJSONObject("main");
                if(mainObject.getDouble("temp_max") > compare_maxTemp)
                    compare_maxTemp = mainObject.getDouble("temp_max");
                maxTemp_5=compare_maxTemp;
                if(mainObject.getDouble("temp_min") < compare_minTemp){
                    compare_minTemp = mainObject.getDouble("temp_min");
                }
                minTemp_5=compare_minTemp;
                avgTemp=avgTemp+mainObject.getDouble("temp");
            }
            averageTemp_5=Double.valueOf(decimalFormat.format(avgTemp/8));
            count=count+8;


            Intent result = new Intent(this, Result.class);
            result.putExtra(CITY, selectedCity);
            result.putExtra(DATE_1, date_1);
            result.putExtra(MAX_TEMP_1, Double.toString(maxTemp_1));
            result.putExtra(MIN_TEMP_1, Double.toString(minTemp_1));
            result.putExtra(AVG_TEMP_1, Double.toString( averageTemp_1));

            result.putExtra(DATE_2, date_2);
            result.putExtra(MAX_TEMP_2, Double.toString(maxTemp_2));
            result.putExtra(MIN_TEMP_2, Double.toString(minTemp_2));
            result.putExtra(AVG_TEMP_2, Double.toString( averageTemp_2));

            result.putExtra(DATE_3, date_3);
            result.putExtra(MAX_TEMP_3, Double.toString(maxTemp_3));
            result.putExtra(MIN_TEMP_3, Double.toString(minTemp_3));
            result.putExtra(AVG_TEMP_3, Double.toString( averageTemp_3));

            result.putExtra(DATE_4, date_4);
            result.putExtra(MAX_TEMP_4, Double.toString(maxTemp_4));
            result.putExtra(MIN_TEMP_4, Double.toString(minTemp_4));
            result.putExtra(AVG_TEMP_4, Double.toString( averageTemp_4));

            result.putExtra(DATE_5, date_5);
            result.putExtra(MAX_TEMP_5, Double.toString(maxTemp_5));
            result.putExtra(MIN_TEMP_5, Double.toString(minTemp_5));
            result.putExtra(AVG_TEMP_5, Double.toString( averageTemp_5));

            startActivity(result);
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this,
                    "Could not parse API response!",
                    Toast.LENGTH_LONG).show();
            Log.e("PARSER_ERROR", e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
        final String selectedCity = citySpinner.getSelectedItem().toString();
        String URL = cityURLMap.get(selectedCity);

        JsonRequest weatherRequest = new JsonObjectRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("API_RESPONSE", response.toString());
                        processResult(response, selectedCity);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,
                                "Please try again!",
                                Toast.LENGTH_LONG).show();
                        Log.e("API_ERROR", error.getMessage());
                    }
                });
        requestQueue.add(weatherRequest);
    }

    }

