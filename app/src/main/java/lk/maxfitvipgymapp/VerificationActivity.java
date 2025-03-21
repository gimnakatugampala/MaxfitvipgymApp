package lk.maxfitvipgymapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class VerificationActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4, otp5;
    private MaterialButton verifyButton;
    private TextView resendOtp;
    private String correctOtp = "12345"; // Simulating a real OTP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp5 = findViewById(R.id.otp5);
        verifyButton = findViewById(R.id.verifyButton);
        resendOtp = findViewById(R.id.resendOtp);

        setupOtpInputs();

        verifyButton.setOnClickListener(v -> {
            String enteredOtp = otp1.getText().toString() +
                    otp2.getText().toString() +
                    otp3.getText().toString() +
                    otp4.getText().toString() +
                    otp5.getText().toString();

            if (enteredOtp.equals(correctOtp)) {
                Toast.makeText(VerificationActivity.this, "OTP Verified!", Toast.LENGTH_SHORT).show();
                // Proceed to next screen
                Intent intent = new Intent(VerificationActivity.this, MembershipInputActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(VerificationActivity.this, "Invalid OTP. Try again.", Toast.LENGTH_SHORT).show();
            }
        });

        resendOtp.setOnClickListener(v -> {
            Toast.makeText(VerificationActivity.this, "New OTP Sent!", Toast.LENGTH_SHORT).show();
            // Implement OTP Resend Logic Here
        });
    }

    private void setupOtpInputs() {
        EditText[] otpFields = {otp1, otp2, otp3, otp4, otp5};

        for (int i = 0; i < otpFields.length; i++) {
            int index = i;
            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1 && index < otpFields.length - 1) {
                        otpFields[index + 1].requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }
}
