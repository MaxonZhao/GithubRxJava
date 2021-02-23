package com.example.githubrxjava;

import java.util.List;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {
    @GET("users/{users}/starred")
    Observable<List<GithubRepo>> getStarredRepositories(@Path("users") String userName);
}
