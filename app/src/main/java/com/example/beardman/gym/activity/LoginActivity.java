package com.example.beardman.gym.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beardman.gym.R;
import com.example.beardman.gym.utility.FormValidation;
import com.example.beardman.gym.utility.GlobalConstant;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextUserName, EditTextPassword;
    private String pass, name;
    private String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initControl();
    }

    private void initControl() {
        Log.e(TAG, "initControl: ");
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonSubmit = findViewById(R.id.ButtonSubmit);
        TextView textViewSignUp = findViewById(R.id.TextViewSignUp);
        EditTextPassword = findViewById(R.id.EditTextPassword);
        editTextUserName = findViewById(R.id.EditTextUserName);

        buttonClear.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonClear:
                clearData();
                break;
            case R.id.ButtonSubmit:
                if (loginPageValidation()) {
                    checkUserIsRegistered();
                }
                break;
            case R.id.TextViewSignUp:
                goToSignUpActivity();
                break;
        }
    }

    private void checkUserIsRegistered() {
        if (name == null && pass == null) {
            Toast.makeText(this, "First Sign Up", Toast.LENGTH_SHORT).show();
        } else if (editTextUserName.getText().toString().equals(name) && EditTextPassword.getText().toString().equals(pass)) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

            callNavigationActivity();

        } else
            Toast.makeText(this, "Not Success", Toast.LENGTH_SHORT).show();
    }

    private void callNavigationActivity() {
        Log.e(TAG, "callNavigationActivity: ");
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    private void clearData() {
        EditTextPassword.setText("");
        editTextUserName.setText("");
        editTextUserName.requestFocus();
    }

    private void goToSignUpActivity() {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivityForResult(intent, GlobalConstant.REQUEST_CODE_FOR_SIGNUP);
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GlobalConstant.REQUEST_CODE_FOR_SIGNUP && resultCode == RESULT_OK && data != null) {
            editTextUserName.setText("");
            EditTextPassword.setText("");
            name = data.getStringExtra("name");
            pass = data.getStringExtra("pass");
        }
    }


    /**
     * This function is for login page loginPageValidation
     *
     * @return
     */
    private boolean loginPageValidation() {
        Log.e(TAG, "loginPageValidation: ");
        if (FormValidation.isEditTextEmpty(editTextUserName)) {
            editTextUserName.setError("Please Fill this");
            return false;
        } else if (FormValidation.isEditTextEmpty(EditTextPassword)) {
            EditTextPassword.setError("please Fill This");
            return false;
        }
        return true;
    }
}
