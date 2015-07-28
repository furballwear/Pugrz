package com.furballwear.apps.pugrz.extras;

import com.android.volley.RequestQueue;
import com.furballwear.apps.pugrz.App;
import com.furballwear.apps.pugrz.models.Game;

import org.json.JSONObject;

import java.util.ArrayList;


import com.furballwear.apps.pugrz.json.Endpoints;
import com.furballwear.apps.pugrz.json.Parser;
import com.furballwear.apps.pugrz.json.Requestor;



/**
 * Created by Windows on 02-03-2015.
 */
public class MovieUtils {
    public static ArrayList<Game> loadBoxOfficeMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestGamesJSON(requestQueue, Endpoints.getRequestUrlBoxOfficeMovies(30));
        ArrayList<Game> listGames = Parser.parseGamesJSON(response);
      //  App.getWritableDatabase().insertGames(DBGames.BOX_OFFICE, listGames, true);
        return listGames;
    }

    public static ArrayList<Game> loadUpcomingMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestGamesJSON(requestQueue, Endpoints.getRequestUrlUpcomingMovies(30));
        ArrayList<Game> listGames = Parser.parseGamesJSON(response);
      //  App.getWritableDatabase().insertGames(DBGames.UPCOMING, listGames, true);
        return listGames;
    }
}
