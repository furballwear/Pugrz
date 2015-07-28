package com.furballwear.apps.pugrz.extras;

import com.furballwear.apps.pugrz.models.Game;

import java.util.ArrayList;



/**
 * Created by Windows on 02-03-2015.
 */
public interface GamesListener {
    public void onBoxOfficeMoviesLoaded(ArrayList<Game> listGames);
}
