package com.example.tolbill.app;

import static com.example.tolbill.api.ApiService.apiService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tolbill.R;
import com.example.tolbill.model.LoginResult;
import com.example.tolbill.model.Account;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLogin;
    private TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.email);
        edtPass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.btnSignup);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SingupActivity.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (!email.equals("") && !pass.equals("")){
                    Account account = new Account(email,pass);
                    apiService.login(account)
                            .enqueue(new  Callback<LoginResult>() {
                                @Override
                                public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                                    if (response.body()!=null && response.body().getStatus().equals("true")){
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("jwt",response.body().getAuth_token()));
                                            }
                                        },700);
//
                                    }
                                    else{
                                        Toast.makeText(LoginActivity.this,"????ng nh???p kh??ng th??nh c??ng",Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<LoginResult> call, Throwable t) {
                                    Toast.makeText(LoginActivity.this,"L???i m???ng vui l??ng th??? l???i sau!",Toast.LENGTH_LONG).show();
                                }
                            });
                }
                else{
                    Toast.makeText(LoginActivity.this,"Vui l??ng nh???p email v?? password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}