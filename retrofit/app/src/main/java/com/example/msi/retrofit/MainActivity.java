package com.example.msi.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button)findViewById(R.id.bt);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

        final GitHubService service = retrofit.create(GitHubService.class);
        final TextView tv = (TextView)findViewById(R.id.tv);
        final EditText ed = (EditText)findViewById(R.id.ed);
          bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<Repo> yms0606 = service.listRepos(ed.getText() + "");

                yms0606.enqueue(new Callback<Repo>() {
                    @Override
                    public void onResponse(Call<Repo> call, Response<Repo> response) {
                        Log.v("haha", String.valueOf(response.body()));
                        tv.setText(response.body().getName());
                    }

                    @Override
                    public void onFailure(Call<Repo> call, Throwable t) {
                        Log.d("haha", t.getMessage());
                    }
                });
            }
        });
    }
}

