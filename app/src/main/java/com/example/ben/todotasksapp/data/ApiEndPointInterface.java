package com.example.ben.todotasksapp.data;

import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiEndPointInterface {
    @GET("getty/?")
    Observable<List<TaskDetails>> getData(@Query("limit")String limit);
}
