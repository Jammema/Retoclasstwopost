package com.example.retoclasstwopost.interfaces;

import com.example.retoclasstwopost.model.ProfileInfo;
import com.example.retoclasstwopost.model.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("api/users")
    Call<ProfileResponse> getProfileResponse(@Body ProfileInfo profileInfo);
}
