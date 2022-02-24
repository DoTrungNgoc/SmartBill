package com.example.tolbill.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tolbill.R;
import com.example.tolbill.api.ApiService;
import com.example.tolbill.model.SignupResult;
import com.example.tolbill.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingupActivity extends AppCompatActivity {
    private EditText edtFirst;
    private EditText edtLast;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnSign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        edtFirst = findViewById(R.id.first);
        edtLast = findViewById(R.id.last);
        edtEmail = findViewById(R.id.Email);
        edtPass = findViewById(R.id.pass);
        btnSign = findViewById(R.id.btnSignup);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = edtFirst.getText().toString().trim();
                String last = edtLast.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();

                if (!first.equals("") && !last.equals("") && !email.equals("") && !pass.equals("")){
                    User user = new User(first,last,email,pass);
                    ApiService.apiService.signup(user).enqueue(new Callback<SignupResult>() {
                        @Override
                        public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
                            SignupResult rs = response.body();
                            if (rs!=null && rs.getStatus().equals("true")){
                                Toast.makeText(SingupActivity.this,"Sign up success", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(SingupActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                },2000);


                            }
                            else{

                                if (rs!=null){
                                    Toast.makeText(SingupActivity.this,rs.getError(), Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(SingupActivity.this,"Connect error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<SignupResult> call, Throwable t) {
                            Toast.makeText(SingupActivity.this,"System error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(SingupActivity.this, "Please fill out the application form completely", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}