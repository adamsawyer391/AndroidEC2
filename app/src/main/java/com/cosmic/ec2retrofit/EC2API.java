package com.cosmic.ec2retrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EC2API {

    @GET("/")
    Call<Post> getPost();

    @GET("star-trek")
    Call<List<StarTrek>> getStarTreks();

}
