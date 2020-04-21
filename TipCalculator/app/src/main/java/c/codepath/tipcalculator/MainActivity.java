package c.codepath.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etBill, etPartySize;
    TextView tvTip, tvTipPer, tvTipAmount, tvTotalAmount, tvSplitedAmount;
    Button calculate, tipMinus, tipPlus;

    int tipPercent = 0;
    double billInIt = 100.00;
    double tipOutput =  0;
    double totalOutput = 0;
    int peopleCount = 1;
    //int partySize = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = findViewById(R.id.etBill);
        etPartySize = findViewById(R.id.etPartySize);

        //tvBill = findViewById(R.id.tvBill);
        tvTip = findViewById(R.id.tvTip);
        tvTipPer = findViewById(R.id.tvTipPer);
        tvTipAmount = findViewById(R.id.tvTipAmount);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        tvSplitedAmount = findViewById(R.id.tvSplitedAmount);

        calculate = findViewById(R.id.calculate);
        tipMinus = findViewById(R.id.tipMinus);
        tipPlus = findViewById(R.id.tipPlus);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String billString = etBill.getText().toString();
                String partySize = etPartySize.getText().toString();

                if (!billString.equals("")) {
                    //Bill without tip
                    billInIt = Double.valueOf(billString);
                    billInIt = billInIt * 100;
                    billInIt = Math.round(billInIt);
                    billInIt = billInIt / 100;

                    etBill.setText(String.format(Locale.getDefault(), "%.2f", billInIt));

                    peopleCount = Integer.valueOf(partySize);
                    //  et.setText(String.format(Locale.getDefault(), "%.2f", billInIt));


                    //Tip Calculation
                    tipOutput = (billInIt * tipPercent) / 100;
                    tipOutput = tipOutput * 100;
                    tipOutput = Math.round(tipOutput);
                    tipOutput = tipOutput / 100;


                    if (peopleCount == 1) {

                        //Total Tip
                        tvTipAmount.setText("Tip Amount : $" + String.format(Locale.getDefault(), "%.2f", tipOutput));

                        //Total Bill with Tip
                        totalOutput = billInIt + tipOutput;
                        tvTotalAmount.setText("Sub Total : $" + String.format(Locale.getDefault(), "%.2f", totalOutput));

                    } else {

                        //Total Bill with Tip
                        tvTipAmount.setText("Tip Amount : $" + String.format(Locale.getDefault(), "%.2f", tipOutput));

                        totalOutput = billInIt + tipOutput;
                        tvTotalAmount.setText("Sub Total : $" + String.format(Locale.getDefault(), "%.2f", totalOutput));

                        totalOutput = (billInIt + tipOutput) / peopleCount;
                        totalOutput = Math.round(totalOutput);
                        tvSplitedAmount.setText("Each Person Pays : $" + String.format(Locale.getDefault(), "%.2f", totalOutput));

                    }

                }else {
                    Toast.makeText(MainActivity.this, "Please Enter The Amount", Toast.LENGTH_SHORT).show();
                }
            }//onClick ends
        });//calculate ends

        tipMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tipPercent > 0) {
                    tipPercent--;
                    tvTipPer.setText(tipPercent + "%");
                    }
            }
        });//tipMinus end

        tipPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercent++;
                tvTipPer.setText(tipPercent + "%");

            }
        });//tipplus end







    }

}