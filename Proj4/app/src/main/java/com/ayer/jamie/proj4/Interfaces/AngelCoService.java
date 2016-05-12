package com.ayer.jamie.proj4.Interfaces;

import com.ayer.jamie.proj4.Models.User;

import java.util.List;

/**
 * Created by JamieAyer on 5/12/16.
 */
public interface AngelCoService {

    @GET("/tracks?client_id=" + Config.CLIENT_ID)
    public void getRecentTracks(@Query("created_at[from]") String date, Callback<List<User>> cb);

    @GET("/tracks?client_id=" + Config.CLIENT_ID)
    public void getArtistTracks(@Query("q") String artist, Callback<List<User>> cb);
}
