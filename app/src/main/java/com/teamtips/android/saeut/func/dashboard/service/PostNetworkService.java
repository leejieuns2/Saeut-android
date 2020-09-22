package com.teamtips.android.saeut.func.dashboard.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamtips.android.saeut.func.dashboard.model.Apply;
import com.teamtips.android.saeut.func.dashboard.model.Post;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostNetworkService {

    private static String TAG = "PostNetworkService";
    private static String BASE_URL = "http://49.50.173.180:8080/saeut/";

    private Call<String> mCallAddPost;
    private Call<String> mCallModPost;
    private Call<Integer> mCallApplyCount;
    private Call<String> mCallDeletePost;
    private Call<String> mCallAddApply;

    Gson gson = new GsonBuilder().setLenient().create();
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    OkHttpClient client = builder.build();
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private PostNetwork postNetwork = retrofit.create(PostNetwork.class);

    // Add Post
    public void addPost(Post post) {
        Gson gson = new Gson();
        String obj1 = gson.toJson(post);
        // Bring session id that Sign on this app
        mCallAddPost = postNetwork.addPost(post);
        mCallAddPost.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "성공  : " + call.request().body());
                    Log.d(TAG, "성공  : " + obj1.toString());
                } else {
                    Log.d(TAG, "실패  : " + response.code());
                    Log.d(TAG, "실패  : " + post.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "여기여기 : " + t.getMessage());
            }
        });
    }

    public void modPost(Post post) {
        Gson gson = new Gson();
        String obj2 = gson.toJson(post);
        // Bring session id that Sign on this app
        mCallModPost = postNetwork.modPost(post);
        mCallModPost.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "성공  : " + response.code());
                    Log.d(TAG, "실패  : " + obj2.toString());
                } else {
                    Log.d(TAG, "실패  : " + response.code());
                    Log.d(TAG, "실패  : " + obj2.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "여기여기 : " + t.getMessage());
            }
        });
    }

    public void deletePost(int post_id, Context context) {
        mCallDeletePost = postNetwork.deletePost(post_id);
        mCallDeletePost.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    Log.d(TAG, response.body());
                    Toast.makeText(context, "돌봄 게시물이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, response.body());
                    Toast.makeText(context, "삭제 실패 !! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(context, "삭제 에러 발생 !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getApplyCount(int post_id) throws IOException {
        mCallApplyCount = postNetwork.getApplyCount(post_id);
        mCallApplyCount.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {

                    Log.d(TAG, "성공  : " + call.request().body());
                } else {
                    Log.d(TAG, "실패  : " + response.code());
                    Log.d(TAG, "실패  : " + response.toString());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.d(TAG, "여기여기 : " + t.getMessage());
            }
        });
    }

    public void addApply(Apply apply) {
        mCallAddApply = postNetwork.addApply(apply);
        mCallAddApply.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    Log.d(TAG, "성공  : " + call.request().body());
                } else {
                    Log.d(TAG, "실패  : " + response.code());
                    Log.d(TAG, "실패  : " + response.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "여기여기 : " + t.getMessage());
            }
        });
    }
}