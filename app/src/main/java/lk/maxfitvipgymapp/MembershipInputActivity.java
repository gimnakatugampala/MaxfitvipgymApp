package lk.maxfitvipgymapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MembershipInputActivity extends AppCompatActivity {

    private TextInputEditText membershipIdInput, firstNameInput, lastNameInput;
    private MaterialButton finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_signup_details);

        // Initialize UI elements
        membershipIdInput = findViewById(R.id.membershipIdInput);
        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        finishButton = findViewById(R.id.finishButton);

        // Handle button click
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndProceed();
            }
        });
    }

    private void validateAndProceed() {
        String membershipId = membershipIdInput.getText().toString().trim();
        String firstName = firstNameInput.getText().toString().trim();
        String lastName = lastNameInput.getText().toString().trim();

        // Validation checks
        if (TextUtils.isEmpty(membershipId)) {
            membershipIdInput.setError("Membership ID is required");
            return;
        }

        if (TextUtils.isEmpty(firstName)) {
            firstNameInput.setError("First Name is required");
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            lastNameInput.setError("Last Name is required");
            return;
        }

        // Proceed to next step (e.g., Dashboard or Confirmation Screen)
        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();

        // Example intent to navigate to another activity
//        Intent intent = new Intent(MembershipInputActivity.this, DashboardActivity.class);
//        intent.putExtra("MEMBERSHIP_ID", membershipId);
//        intent.putExtra("FIRST_NAME", firstName);
//        intent.putExtra("LAST_NAME", lastName);
//        startActivity(intent);
//        finish();
    }
}
