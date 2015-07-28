package com.furballwear.apps.pugrz.extras;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import com.furballwear.apps.pugrz.fragments.BoxOfficeMoviesLoadedListener;
import com.furballwear.apps.pugrz.extras.MovieUtils;
import com.furballwear.apps.pugrz.service.VolleySingleton;
import com.furballwear.apps.pugrz.models.Game;

/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadMoviesBoxOffice extends AsyncTask<Void, Void, ArrayList<Game>> {
    private BoxOfficeMoviesLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadMoviesBoxOffice(BoxOfficeMoviesLoadedListener myComponent) {

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
