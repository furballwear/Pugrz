package com.furballwear.apps.pugrz.models;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;



import com.furballwear.apps.pugrz.extras.GamesListener;
import com.furballwear.apps.pugrz.extras.MovieUtils;
import com.furballwear.apps.pugrz.service.VolleySingleton;
import com.furballwear.apps.pugrz.models.Game;

/**
 * Created by Windows on 02-03-2015.
 */
public class GameTask extends AsyncTask<Void, Void, ArrayList<Game>> {
    private GamesListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public GameTask(GamesListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }


    @Override
    protected ArrayList<Game> doInBackground(Void... params) {

        ArrayList<Game> listGames = MovieUtils.loadBoxOfficeMovies(requestQueue);
        return listGames;
    }

    @Override
    protected void onPostExecute(ArrayList<Game> listGames) {
        if (myComponent != null) {
            myComponent.onBoxOfficeMoviesLoaded(listGames);
        }
    }


}
