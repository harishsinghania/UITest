package com.harish.uidesign.activiies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.harish.uidesign.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtBtnSeeOffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();
    }

    private void init(){
        txtBtnSeeOffer = findViewById(R.id.txt_see_offer);
    }

    private void addListener(){
        txtBtnSeeOffer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_see_offer:
                openOfferActivity();
                break;
        }
    }

    private void openOfferActivity(){
        Intent offerActivity = new Intent(MainActivity.this,TestTwoActivity.class);
        startActivity(offerActivity);
    }
}
