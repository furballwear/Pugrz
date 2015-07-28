package com.furballwear.apps.pugrz.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.furballwear.apps.pugrz.models.Game;

/**
 * Created by Windows on 18-02-2015.
 */
public class GameSorter {
    public void sortMoviesByName(ArrayList<Game> games){
        Collections.sort(games, new Comparator<Game>() {
            @Override
            public int compare(Game lhs, Game rhs) {
                return lhs.getGamedate().compareTo(rhs.getGamedate());
            }
        });
    }
    public void sortMoviesByDate(ArrayList<Game> games){
        Collections.sort(games, new Comparator<Game>() {
            @Override
            public int compare(Game lhs, Game rhs) {
                return lhs.getGamedate().compareTo(rhs.getGamedate());
            }
        });
    }
    public void sortMoviesByRating(ArrayList<Game> games){
        Collections.sort(games, new Comparator<Game>() {
            @Override
            public int compare(Game lhs, Game rhs) {
                return lhs.getGamedate().compareTo(rhs.getGamedate());
            }
        });
    }
}
