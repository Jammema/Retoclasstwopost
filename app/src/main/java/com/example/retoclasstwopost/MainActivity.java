package com.example.retoclasstwopost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retoclasstwopost.interfaces.ApiInterface;
import com.example.retoclasstwopost.model.ProfileInfo;
import com.example.retoclasstwopost.model.ProfileResponse;
import com.example.retoclasstwopost.wepapi.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private List<ProfileInfo> profileInfoList = new ArrayList<>();
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data posted successfully", Toast.LENGTH_SHORT).show();
                final ProfileInfo profileInfo = new ProfileInfo();
                profileInfo.setName("Farzana");
                profileInfo.setJob("Developer");
                apiInterface.getProfileResponse(profileInfo).enqueue(new Callback<ProfileResponse>() {
                    @Override
                    public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                        ProfileResponse profileResponse = response.body();
                        Toast.makeText(MainActivity.this, "" + profileInfo.getName() + " " + profileInfo.getJob(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ProfileResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                });
            }
        });
    }
}

