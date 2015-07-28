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

package com.furballwear.apps.pugrz.common;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

/**
 * A simple shared tourist attraction class to easily pass data around. Used
 * in both the mobile app and wearable app.
 */
public class Games {
    public String name;
    public String shortdes;
    public String longDescription;
    public Uri imageUrl;
    public Uri secondaryImageUrl;
    public String glocation;
    public String city;
    public String gametype;
    public String gamestyle;
    public String gamedate;
    public String gametime;

    public Bitmap image;
    public Bitmap secondaryImage;
    public String distance;

    public Games() {}

    public Games(String name, String shortdes, String longDescription, Uri imageUrl,
                 Uri secondaryImageUrl, String glocation, String city, String gamedate, String gamestyle, String gametype,String gametime) {
        this.name = name;
        this.shortdes = shortdes;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
        this.secondaryImageUrl = secondaryImageUrl;
        this.glocation = glocation;
        this.city = city;
        this.gamedate = gamedate;
        this.gamestyle = gamestyle;
        this.gametype = gametype;
        this.gametime = gametime;
    }
}