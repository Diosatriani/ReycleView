package com.dio.satriani.reycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NOOB extends AppCompatActivity {
    private TextView apaya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noob);
        apaya = (TextView) findViewById(R.id.tvNamaAPAYA);

        Bundle bundle = getIntent().getExtras();
        apaya.setText(bundle.getString("nama"));
    }
}
