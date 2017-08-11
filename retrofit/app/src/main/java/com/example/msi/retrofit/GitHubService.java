package com.example.msi.retrofit;



import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by msi on 2017-08-09.
 */

public interface GitHubService {
    @GET("/user/{user}/repos")
    Call<Repo> listRepos(@Path("user")String user);

}
