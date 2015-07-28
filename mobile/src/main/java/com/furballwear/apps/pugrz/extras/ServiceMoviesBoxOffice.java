package com.furballwear.apps.pugrz.extras;

import com.furballwear.apps.pugrz.common.logger.Log;
import com.furballwear.apps.pugrz.models.Game;

import java.util.ArrayList;

import com.furballwear.apps.pugrz.fragments.BoxOfficeMoviesLoadedListener;


import com.furballwear.apps.pugrz.extras.TaskLoadMoviesBoxOffice;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;

/**
 * Created by Windows on 23-02-2015.
 */
public class ServiceMoviesBoxOffice extends JobService implements BoxOfficeMoviesLoadedListener {
    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.t(this, "onStartJob");
        this.jobParameters = jobParameters;
        new TaskLoadMoviesBoxOffice(this).execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.t(this, "onStopJob");
        return false;
    }



    @Override
    public void onBoxOfficeMoviesLoaded(ArrayList<Game> listGames) {
        Log.t(this, "onBoxOfficeMoviesLoaded");
        jobFinished(jobParameters, false);
    }
}

