package com.example.mb_huy_bt3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        ImageView imgDetail = findViewById(R.id.imgDetail);
        Button btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        int iconRes = getIntent().getIntExtra("iconRes", 0);

        tvName.setText(name);
        tvDescription.setText(description);
        imgDetail.setImageResource(iconRes);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
