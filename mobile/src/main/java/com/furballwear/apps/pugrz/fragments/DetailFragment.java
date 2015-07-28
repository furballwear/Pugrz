/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.furballwear.apps.pugrz.fragments;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.activities.DetailActivity;
import com.furballwear.apps.pugrz.common.Attraction;
import com.furballwear.apps.pugrz.common.Constants;
import com.furballwear.apps.pugrz.common.Utils;
import com.furballwear.apps.pugrz.message.MyActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Map;

import static com.furballwear.apps.pugrz.provider.TouristAttractions.ATTRACTIONS;

/**
 * The tourist attraction detail fragment which contains the details of a
 * a single attraction (contained inside
 * {@link DetailActivity}).
 */
public class DetailFragment extends Fragment implements OnMapReadyCallback {

    private static final String EXTRA_ATTRACTION = "attraction";
    private Attraction mAttraction;
    private GoogleMap mMap;
    private Toolbar toolbar;
    public static DetailFragment createInstance(String attractionName) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_ATTRACTION, attractionName);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    public DetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_detail, container, false);
        final String attractionName = getArguments().getString(EXTRA_ATTRACTION);
        mAttraction = findAttraction(attractionName);

        if (mAttraction == null) {
            getActivity().finish();
            return null;
        }

      //  ImageView gamestyleImageView = (ImageView)view.findViewById(R.id.ivgamestyle);
        TextView gamedateTextView = (TextView)view.findViewById(R.id.gamedateTextView);
        TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        TextView descTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        TextView distanceTextView = (TextView) view.findViewById(R.id.distanceTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        FloatingActionButton mapFab = (FloatingActionButton) view.findViewById(R.id.mapFab);

        LatLng location = Utils.getLocation(getActivity());
        String distance = Utils.formatDistanceBetween(location, mAttraction.location);
        if (TextUtils.isEmpty(distance)) {
            distanceTextView.setVisibility(View.GONE);
        }
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(attractionName);



        switch (mAttraction.gamestyle){
            case "Open Public":
           //    Glide.with(getActivity()).load(R.drawable.public_out_doors_events).into(gamestyleImageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.public_out_doors_events_toolbar));
                break;
            case "Private parsonal":
       //         Glide.with(getActivity()).load(R.drawable.privet_invite_event_pink).into(gamestyleImageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.privet_invite_event_pink_toolbar));
                break;
            case "Hosted Event":
    //            Glide.with(getActivity()).load(R.drawable.open_game).into(gamestyleImageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.open_game_toolbar));
                break;
            case "Tornament":
     //           Glide.with(getActivity()).load(R.drawable.tournament_games_red).into(gamestyleImageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.tournament_games_red_toolbar));
                break;
            case "Furballwears Secert":
     //           Glide.with(getActivity()).load(R.drawable.furballgame).into(gamestyleImageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.furballgame));
                break;

        }
     //   nameTextView.setText(attractionName);
        gamedateTextView.setText(mAttraction.gamedate);
        distanceTextView.setText(distance);
        descTextView.setText(mAttraction.longDescription);

        int imageSize = getResources().getDimensionPixelSize(R.dimen.image_size)
                * Constants.IMAGE_ANIM_MULTIPLIER;
        Glide.with(getActivity())
                .load(mAttraction.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.lighter_gray)
                .override(imageSize, imageSize)
                .into(imageView);

        mapFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MyActivity.class);
                intent.putExtra(EXTRA_ATTRACTION, attractionName);
               startActivity(intent);


            }
        });
        setUpMapIfNeeded();
        return view;
    }
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    private void setUpMap() {
        LatLng Dallas = mAttraction.location;
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dallas, 8));
        mMap.addMarker(new MarkerOptions()
                .title(mAttraction.name)
                .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_myplaces))
                .position(Dallas));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Some small additions to handle "up" navigation correctly
                Intent upIntent = NavUtils.getParentActivityIntent(getActivity());
                upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // Check if up activity needs to be created (usually when
                // detail screen is opened from a notification or from the
                // Wearable app
                if (NavUtils.shouldUpRecreateTask(getActivity(), upIntent)
                        || getActivity().isTaskRoot()) {

                    // Synthesize parent stack
                    TaskStackBuilder.create(getActivity())
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // On Lollipop+ we finish so to run the nice animation
                    getActivity().finishAfterTransition();
                    return true;
                }

                // Otherwise let the system handle navigating "up"
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Really hacky loop for finding attraction in our static content provider.
     * Obviously would not be used in a production app.
     */
    private Attraction findAttraction(String attractionName) {
        for (Map.Entry<String, List<Attraction>> attractionsList : ATTRACTIONS.entrySet()) {
            List<Attraction> attractions = attractionsList.getValue();
            for (Attraction attraction : attractions) {
                if (attractionName.equals(attraction.name)) {
                    return attraction;
                }
            }
        }
        return null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng Dallas = mAttraction.location;
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dallas, 8));
        googleMap.addMarker(new MarkerOptions()
                .title(mAttraction.name)
                .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_myplaces))
                .position(Dallas));

    }
}
