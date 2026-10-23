package com.example.practical5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Municipality extends AppCompatActivity {

    private TextView tvMuniName;
    private TextView tvMuniInfo;
    private ImageView ivMuniPic;
    private Button btnVisitSite;

    private String validatedMuniName;
    private String[] muniSummaries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        // Link UI elements
        tvMuniName = findViewById(R.id.tv_muni_name);
        tvMuniInfo = findViewById(R.id.tv_muni_info);
        ivMuniPic = findViewById(R.id.iv_muni_pic);
        btnVisitSite = findViewById(R.id.btn_open_web);

        // Get name passed from MainActivity
        Intent incomingIntent = getIntent();
        String rawReceivedName = incomingIntent.getStringExtra("city");

        validatedMuniName = TextProcessor.processMunicipality(rawReceivedName);

        // Safely handle corrupted / missing intent data
        if (validatedMuniName == null) {
            finish();
            return;
        }

        // Configure UI based on validated municipality name (PDF Step9)
        setupMunicipalityContent();

        // Visit-site button, implicit intent open website PDF Step10
        btnVisitSite.setOnClickListener(v -> openOfficialWebsite());
    }

    private void setupMunicipalityContent() {
        muniSummaries = getResources().getStringArray(R.array.municipalities_array);
        switch (validatedMuniName) {
            case "Beijing":
                tvMuniName.setText("Beijing");
                tvMuniInfo.setText(muniSummaries[0]);
                ivMuniPic.setImageResource(R.drawable.beijing);
                break;
            case "Shanghai":
                tvMuniName.setText("Shanghai");
                tvMuniInfo.setText(muniSummaries[1]);
                ivMuniPic.setImageResource(R.drawable.shanghai);
                break;
            case "Tianjin":
                tvMuniName.setText("Tianjin");
                tvMuniInfo.setText(muniSummaries[2]);
                ivMuniPic.setImageResource(R.drawable.tianjin);
                break;
            case "Chongqing":
                tvMuniName.setText("Chongqing");
                tvMuniInfo.setText(muniSummaries[3]);
                ivMuniPic.setImageResource(R.drawable.chongqing);
                break;
        }
    }

    private void openOfficialWebsite() {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        switch (validatedMuniName) {
            case "Beijing":
                webIntent.setData(android.net.Uri.parse("https://www.beijing.gov.cn"));
                break;
            case "Shanghai":
                webIntent.setData(android.net.Uri.parse("https://www.shanghai.gov.cn"));
                break;
            case "Tianjin":
                webIntent.setData(android.net.Uri.parse("https://www.tj.gov.cn"));
                break;
            case "Chongqing":
                webIntent.setData(android.net.Uri.parse("https://www.cq.gov.cn"));
                break;
        }
        startActivity(webIntent);
    }
}
