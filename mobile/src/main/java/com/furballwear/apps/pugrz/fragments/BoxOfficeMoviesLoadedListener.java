package com.furballwear.apps.pugrz.fragments;

import com.furballwear.apps.pugrz.models.Game;

import java.util.ArrayList;



/**
 * Created by Windows on 02-03-2015.
 */
public interface BoxOfficeMoviesLoadedListener {
    public void onBoxOfficeMoviesLoaded(ArrayList<Game> listGames);
}
