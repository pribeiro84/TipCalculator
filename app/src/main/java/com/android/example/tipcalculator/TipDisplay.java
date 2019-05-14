package com.android.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TipDisplay extends AppCompatActivity {

    TextView amountDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_display);

        amountDisplay = findViewById(R.id.amount_display);

        Bundle extras = getIntent().getExtras();

        double total = extras.getDouble(Keys.Total);
        double salesTaxRate = extras.getDouble(Keys.SalesTax);
        double tipRate = extras.getDouble(Keys.TipRate);

        amountDisplay.append("\nTotal: " + total);
        double salesTax = salesTax(total, salesTaxRate);
        amountDisplay.append("\nSales Tax: " + salesTax);
        double tip = calculateTip(total, tipRate);
        amountDisplay.append("\nTip: " + tip);

        double grandtotal = total + tip + salesTax;
        amountDisplay.append("\nGrand Total: " + grandtotal);
    }

    private double calculateTip(double total, double tipRate)
    {
        return total * tipRate;
    }

    private double salesTax(double total, double salesTaxRate)
    {
        return total * salesTaxRate;
    }
}
