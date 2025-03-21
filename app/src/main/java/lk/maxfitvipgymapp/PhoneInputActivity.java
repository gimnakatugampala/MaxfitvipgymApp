package lk.maxfitvipgymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.hbb20.CountryCodePicker;



public class PhoneInputActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private EditText phoneEditText;
    private MaterialButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        countryCodePicker = findViewById(R.id.country_code);
        phoneEditText = findViewById(R.id.phoneEditText);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneEditText.getText().toString().trim();
                String fullNumber = countryCodePicker.getSelectedCountryCodeWithPlus() + phoneNumber;

                if (phoneNumber.isEmpty() || phoneNumber.length() < 9) {
                    Toast.makeText(PhoneInputActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed to next screen
//                    Intent intent = new Intent(PhoneInputActivity.this, NextActivity.class);
//                    intent.putExtra("PHONE_NUMBER", fullNumber);
//                    startActivity(intent);
                }
            }
        });
    }
}
