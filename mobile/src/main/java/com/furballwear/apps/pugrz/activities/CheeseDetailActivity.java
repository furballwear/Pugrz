/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.furballwear.apps.pugrz.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.message.PugrzChatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CheeseDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String EXTRA_NAME = "cheese_name";
    public static final String EXTRA_GLOCATION = "glocation";
    public static final String EXTRA_SHORTDESC = "shortdesc";
    public static final String EXTRA_GAMESTYLE = "gamestyle";
    public static final String EXTRA_GAMEIMAGE = "gameimage";
    public static final String EXTRA_GAMEDATE = "gamedate";
    public static final String EXTRA_GAMETIME = "gametime";
    public static final String EXTRA_GAMEOWNER = "user_id_create";
    public static final String EXTRA_GAMECITY = "gamecity";
    private GoogleMap mMap;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);
        final String glocation = intent.getStringExtra(EXTRA_GLOCATION);
        final String shortdesc = intent.getStringExtra(EXTRA_SHORTDESC);
        final String gamestyle = intent.getStringExtra(EXTRA_GAMESTYLE);
        final String gameimage = intent.getStringExtra(EXTRA_GAMEIMAGE);
        final String gamedate = intent.getStringExtra(EXTRA_GAMEDATE);
        final String gametime = intent.getStringExtra(EXTRA_GAMETIME);
        final String user_id_create = intent.getStringExtra(EXTRA_GAMEOWNER);
        final String gamecity = intent.getStringExtra(EXTRA_GAMECITY);




        FloatingActionButton mapFab = (FloatingActionButton)findViewById(R.id.mapFab);
        mapFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheeseDetailActivity.this, PugrzChatActivity.class);
                intent.putExtra(EXTRA_NAME, cheeseName);
                startActivity(intent);


            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        setUpMapIfNeeded();
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cheeseName);
        TextView descTextView = (TextView)findViewById(R.id.descriptionTextView);
        descTextView.setText(shortdesc);
        TextView gamedatetv = (TextView)findViewById(R.id.gamedateTextView);
        gamedatetv.setText(gamedate);
        TextView gametimev = (TextView)findViewById(R.id.gametimeTextView);
        gametimev.setText(gametime);
        TextView gamecityv = (TextView)findViewById(R.id.gamecityTextView);
        gamecityv.setText(gamecity);
        TextView gameownerv = (TextView)findViewById(R.id.gameownerTextView);
        gameownerv.setText(user_id_create);
        TextView glocationv = (TextView)findViewById(R.id.distanceTextView);
        glocationv.setText(glocation);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch (gamestyle){
            case "Open Public":
                Glide.with(this).load(R.drawable.public_out_doors_events).into(imageView);

                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.public_out_doors_events_toolbar));
                break;
            case "Private parsonal":
            //    Glide.with(this).load(R.drawable.privet_invite_event_pink).into(imageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.privet_invite_event_pink_toolbar));
                break;
            case "Hosted Event":
            //    Glide.with(this).load(R.drawable.open_game).into(imageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.open_game_toolbar));
                break;
            case "Tornament":
             //   Glide.with(this).load(R.drawable.tournament_games_red).into(imageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.tournament_games_red_toolbar));
                break;
            case "Furballwears Secert":
            //    Glide.with(this).load(R.drawable.furballgame).into(imageView);
                collapsingToolbar.setContentScrim(getResources().getDrawable(R.drawable.furballgame));
                break;

        }
        switch (gameimage) {
            case "BOARD GAMES":

                Glide.with(this).load(R.drawable.dnd).into(imageView);
                break;
            case "CARD GAMES":

                Glide.with(this).load(R.drawable.steampunk_dinosaurs).into(imageView);
                break;
            case "TABLETOP":

                Glide.with(this).load(R.drawable.tabletop).into(imageView);
                break;
            case "PEN N PAPER":

                Glide.with(this).load(R.drawable.pugrz).into(imageView);
                break;
            case "FURBALLWEAR":

                Glide.with(this).load(Uri.parse("http://www.furballwear.com/images/nature1.jpg")).into(imageView);
                break;
        }

    }
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    private void setUpMap() {


        LatLng Dallas = new LatLng(32.254,-98.254);
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dallas, 8));
        mMap.addMarker(new MarkerOptions()
                .title(" ")
                .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_myplaces))
                .position(Dallas));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng Dallas = new LatLng(32.254,-98.254);
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dallas, 8));
        googleMap.addMarker(new MarkerOptions()
                .title(EXTRA_NAME)
                .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_myplaces))
                .position(Dallas));

    }
}
