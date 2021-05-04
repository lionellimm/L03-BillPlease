package sg.edu.rp.c346.id20015553.l03_billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton btnNOSVS;
    ToggleButton btnGST;
    Button btnSplit;
    Button btnReset;
    RadioButton radioCash;
    RadioButton radioPaynow;
    EditText inputAmount;
    EditText inputNumber;
    EditText inputDiscount;
    TextView billResult;
    TextView eachBillResult;
    RadioGroup radioGroup;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNOSVS = findViewById(R.id.btnNOSVS);
        btnGST = findViewById(R.id.btnGST);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);

        radioCash = findViewById(R.id.radioCash);
        radioPaynow = findViewById(R.id.radioPaynow);

        inputAmount = findViewById(R.id.inputAmount);
        inputNumber = findViewById(R.id.inputNumber);
        inputDiscount = findViewById(R.id.inputDiscount);

        billResult = findViewById(R.id.billResult);
        eachBillResult = findViewById(R.id.eachBillResult);

        radioGroup = findViewById(R.id.radioGroup);




        btnSplit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = inputAmount.getText().toString();
                String b = inputNumber.getText().toString();
                String c = inputDiscount.getText().toString();
                int checkRadio = radioGroup.getCheckedRadioButtonId();
                double aa = Double.parseDouble(a);
                double bb = Double.parseDouble(b);
                double cc = Double.parseDouble(c);
                double percentage = 0.0;
                double total = 0;
                double each = 0;

                if(a.isEmpty() || b.isEmpty() || c.isEmpty() ){
                    billResult.setText("Missing Information!");
                    eachBillResult.setText("Missing Information!");

                    Toast.makeText(MainActivity.this, "Missing Information!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(btnNOSVS.isChecked() == true){
                        percentage += 0.1;
                    }

                    if(btnGST.isChecked() == true){

                        percentage += 0.07;
                    }

                    total = (aa * (1 + percentage))  * (1-(cc/100));
                    each = total / bb;
                    String totaltotal = Double.toString(total);
                    String eacheach = Double.toString(each);
                    if(checkRadio == R.id.radioCash){
                        billResult.setText(totaltotal);
                        eachBillResult.setText(eacheach + " in Cash");
                    }
                    else{
                        billResult.setText(totaltotal);
                        eachBillResult.setText(eacheach + " via Paynow");

                    }


                }



            }
        }));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAmount.setText("");
                inputDiscount.setText("");
                inputNumber.setText("");
                btnNOSVS.setChecked(false);
                btnGST.setChecked(false);
                radioCash.setChecked(false);
                radioPaynow.setChecked(false);
            }
        });



    }
}