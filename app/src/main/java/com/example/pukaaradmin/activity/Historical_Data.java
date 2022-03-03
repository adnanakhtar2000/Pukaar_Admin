package com.example.pukaaradmin.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.Fragments.Notifications;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.Historical_Data_Response;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Historical_Data extends AppCompatActivity {
    TextView tvR, tvPython, tvCPP, tvJava, anxiety, confidence , energy, lastnote;
    PieChart pieChart;
    ImageView ebell, eback;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = ApiClient.Companion.create();
        setContentView(R.layout.activity_historical_data);
        Window window  = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            window.setStatusBarColor(getResources().getColor(R.color.Main_color));
        }
        eback = findViewById(R.id.eback_arrow_6);
        ebell = findViewById(R.id.ebell);
        ebell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Historical_Data.this , Notifications.class);
                startActivity(intent);
            }
        });
        eback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);
        anxiety = findViewById(R.id.history_anxiety);
        confidence = findViewById(R.id.history_confidence);
        energy = findViewById(R.id.history_energy_level);
        lastnote = findViewById(R.id.lastNote);

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();
    }

    private void setData()
    {
        Intent intent = getIntent();
       String str =intent.getStringExtra("history_key");
        Toast.makeText(getApplicationContext() ,str.toString() , Toast.LENGTH_SHORT ).show();
Call<Historical_Data_Response> call= apiInterface.getGraphData(CommonFunction.Companion.getToken(getApplicationContext()), Integer.parseInt(str));
call.enqueue(new Callback<Historical_Data_Response>() {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<Historical_Data_Response> call, Response<Historical_Data_Response> response) {
        if (response.body() != null){
            anxiety.setText("Anxiety" + ":" + String.valueOf(response.body().anxiety));
            confidence.setText(String.valueOf("Confidence Level" + ":" +response.body().confidence));
            energy.setText(String.valueOf("Energy Level" + ":" +response.body().energy_level));
            tvR.setText(String.valueOf(response.body().total_mood));
            tvPython.setText(String.valueOf(response.body().positive_entries));
            tvCPP.setText(String.valueOf(response.body().negetive_entries));
            tvJava.setText(String.valueOf(CommonFunction.Companion.changeDateFormat(response.body().first_time , false)));
            lastnote.setText(String.valueOf(CommonFunction.Companion.changeDateFormat(response.body().last_time , false)));
            pieChart.addPieSlice(
                    new PieModel(
                            "Anxiety",
                            Integer.parseInt(String.valueOf(response.body().anxiety)),
                            Color.parseColor("#FFA726")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Confidence Level",
                            Integer.parseInt(String.valueOf(response.body().confidence)),
                            Color.parseColor("#66BB6A")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Energy Level",
                            Integer.parseInt(String.valueOf(response.body().energy_level)),
                            Color.parseColor("#EF5350")));

            // To animate the pie chart
            pieChart.startAnimation();
        }
        else {
            Toast.makeText(getApplicationContext() , "No" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Historical_Data_Response> call, Throwable t) {
        Toast.makeText(getApplicationContext() , t.getMessage(), Toast.LENGTH_SHORT).show();
    }
});
        // Set the percentage of language used


        // Set the data and color to the pie chart

    }
}
