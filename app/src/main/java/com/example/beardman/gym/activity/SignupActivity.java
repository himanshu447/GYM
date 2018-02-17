package com.example.beardman.gym.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.beardman.gym.R;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonClear,buttonSignUp;
    private EditText editTextUserName,editTextAddress,editTextphoneNo,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initControl();
    }
    private void initControl() {
        editTextUserName=findViewById(R.id.editTextUserName);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextAddress=findViewById(R.id.editTextAddress);
        editTextphoneNo=findViewById(R.id.editTextphoneNo);
        buttonClear=findViewById(R.id.buttonClear);
        buttonSignUp=findViewById(R.id.buttonSignUp);

        buttonClear.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId())
        {
            case R.id.buttonClear:
                clearData();
                break;
            
            case R.id.buttonSignUp:
                goToLoginActivity();
                break;
        }
    }

    private void goToLoginActivity() {
        Intent intent=new Intent();
        intent.putExtra("name",editTextUserName.getText().toString());
        intent.putExtra("pass",editTextPassword.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    private void clearData() {
    
    
        editTextAddress.setText("");
        editTextPassword.setText("");
        editTextphoneNo.setText("");
        editTextUserName.setText("");
        editTextUserName.requestFocus();
    }
}
