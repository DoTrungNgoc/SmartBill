package com.example.tolbill.api;

import com.example.tolbill.model.LoginResult;
import com.example.tolbill.model.SignupResult;
import com.example.tolbill.model.UploadResult;
import com.example.tolbill.model.Account;
import com.example.tolbill.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://6005-2402-800-63f1-bf40-bc48-91c4-7780-1beb.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @Headers({
            "Content-Type: application/json"
    })

    @POST("api/account/login")
    Call<LoginResult> login(@Body Account account);

    @POST("api/account/register")
    Call<SignupResult> signup(@Body User user);

    @Multipart
    @POST("api/bill/store")
    Call<UploadResult> uploadAttachment(@Header("auth-token") String jwt, @Part MultipartBody.Part filePart);
}
