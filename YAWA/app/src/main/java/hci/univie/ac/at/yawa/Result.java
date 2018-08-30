package hci.univie.ac.at.yawa;

/**
 * Created by Zhanat on 25/03/2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Result extends AppCompatActivity {
    private TextView cityView;
    private TextView max_1;
    private TextView min_1;
    private TextView avg_1;
    private TextView date_1;

    private TextView max_2;
    private TextView min_2;
    private TextView avg_2;
    private TextView date_2;

    private TextView max_3;
    private TextView min_3;
    private TextView avg_3;
    private TextView date_3;

    private TextView max_4;
    private TextView min_4;
    private TextView avg_4;
    private TextView date_4;

    private TextView max_5;
    private TextView min_5;
    private TextView avg_5;
    private TextView date_5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        cityView = findViewById(R.id.city);
        max_1 = findViewById(R.id.max_1);
        min_1 = findViewById(R.id.min_1);
        avg_1 = findViewById(R.id.avg_1);
        date_1=findViewById(R.id.date_1);

        max_2 = findViewById(R.id.max_2);
        min_2 = findViewById(R.id.min_2);
        avg_2 = findViewById(R.id.avg_2);
        date_2=findViewById(R.id.date_2);

        max_3 = findViewById(R.id.max_3);
        min_3 = findViewById(R.id.min_3);
        avg_3 = findViewById(R.id.avg_3);
        date_3=findViewById(R.id.date_3);

        max_4 = findViewById(R.id.max_4);
        min_4 = findViewById(R.id.min_4);
        avg_4 = findViewById(R.id.avg_4);
        date_4=findViewById(R.id.date_4);

        max_5 = findViewById(R.id.max_5);
        min_5 = findViewById(R.id.min_5);
        avg_5 = findViewById(R.id.avg_5);
        date_5=findViewById(R.id.date_5);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String cityText = intent.getStringExtra(MainActivity.CITY);
        String maxTemp_1 = intent.getStringExtra(MainActivity.MAX_TEMP_1);
        String minTemp_1 = intent.getStringExtra(MainActivity.MIN_TEMP_1);
        String avgTemp_1 = intent.getStringExtra(MainActivity.AVG_TEMP_1);
        String dateDay_1 = intent.getStringExtra(MainActivity.DATE_1);

        String maxTemp_2 = intent.getStringExtra(MainActivity.MAX_TEMP_2);
        String minTemp_2 = intent.getStringExtra(MainActivity.MIN_TEMP_2);
        String avgTemp_2 = intent.getStringExtra(MainActivity.AVG_TEMP_2);
        String dateDay_2 = intent.getStringExtra(MainActivity.DATE_2);

        String maxTemp_3 = intent.getStringExtra(MainActivity.MAX_TEMP_3);
        String minTemp_3 = intent.getStringExtra(MainActivity.MIN_TEMP_3);
        String avgTemp_3 = intent.getStringExtra(MainActivity.AVG_TEMP_3);
        String dateDay_3 = intent.getStringExtra(MainActivity.DATE_3);

        String maxTemp_4 = intent.getStringExtra(MainActivity.MAX_TEMP_4);
        String minTemp_4 = intent.getStringExtra(MainActivity.MIN_TEMP_4);
        String avgTemp_4 = intent.getStringExtra(MainActivity.AVG_TEMP_4);
        String dateDay_4 = intent.getStringExtra(MainActivity.DATE_4);

        String maxTemp_5 = intent.getStringExtra(MainActivity.MAX_TEMP_5);
        String minTemp_5 = intent.getStringExtra(MainActivity.MIN_TEMP_5);
        String avgTemp_5 = intent.getStringExtra(MainActivity.AVG_TEMP_5);
        String dateDay_5 = intent.getStringExtra(MainActivity.DATE_5);

        cityView.setText(cityText);
        max_1.setText(maxTemp_1);
        date_1.setText(dateDay_1);
        min_1.setText(minTemp_1);
        avg_1.setText(avgTemp_1);

        max_2.setText(maxTemp_2);
        date_2.setText(dateDay_2);
        min_2.setText(minTemp_2);
        avg_2.setText(avgTemp_2);

        max_3.setText(maxTemp_3);
        date_3.setText(dateDay_3);
        min_3.setText(minTemp_3);
        avg_3.setText(avgTemp_3);

        max_4.setText(maxTemp_4);
        date_4.setText(dateDay_4);
        min_4.setText(minTemp_4);
        avg_4.setText(avgTemp_4);

        max_5.setText(maxTemp_5);
        date_5.setText(dateDay_5);
        min_5.setText(minTemp_5);
        avg_5.setText(avgTemp_5);

    }
}
