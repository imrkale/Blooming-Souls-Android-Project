package com.BloomingSouls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UOptionAcademicMentoring extends AppCompatActivity {
    NightModeSharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new NightModeSharedPref(this);
        if (sharedpref.loadNightModeState()) {
            setTheme(R.style.DarkTheme);
        } else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.uo_academic_mentoring);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout l1, l2;

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UOptionAcademicMentoring.this, UOptionAcademicMentoringDisplayVideo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UOptionAcademicMentoring.this, UOptionAcademicMentoringDisplayPdf.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.PostFrameContainer, new UOptionAcademicMentoringDisplayFrag()).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
