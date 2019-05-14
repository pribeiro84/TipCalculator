package com.android.example.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateTip(View v)
    {
        Intent intent = new Intent(this, TipDisplay.class);
        Bundle extras = new Bundle();

        EditText total = findViewById(R.id.edit_total);
        EditText salesTaxRate = findViewById(R.id.edit_sales_tax);
        EditText tipRate = findViewById(R.id.edit_tip_rate);

        extras.putDouble(Keys.Total, Double.parseDouble(total.getText().toString()));
        extras.putDouble(Keys.SalesTax, Double.parseDouble(salesTaxRate.getText().toString()));
        extras.putDouble(Keys.TipRate, Double.parseDouble(tipRate.getText().toString()));

        intent.putExtras(extras);
        startActivity(intent);
    }
}
