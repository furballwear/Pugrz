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

package com.furballwear.apps.pugrz.provider;

import android.net.Uri;

import com.furballwear.apps.pugrz.BuildConfig;
import com.furballwear.apps.pugrz.common.Attraction;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Static data content provider.
 */
public class TouristAttractions {

    public static final String CITY_DALLAS = "Dallas";

    public static final String TEST_CITY = CITY_DALLAS;

    private static final float TRIGGER_RADIUS = 2000;
    private static final int TRIGGER_TRANSITION = Geofence.GEOFENCE_TRANSITION_ENTER |
            Geofence.GEOFENCE_TRANSITION_EXIT;
    private static final long EXPIRATION_DURATION = Geofence.NEVER_EXPIRE;

    public static final Map<String, LatLng> CITY_LOCATIONS = new HashMap<String, LatLng>() {{
        put(CITY_DALLAS, new LatLng(32.8126178, -96.8088537));
    }};

    /**
     * All photos used with permission under the Creative Commons Attribution-ShareAlike License.
     */
   public static final HashMap<String, List<Attraction>> ATTRACTIONS =
            new HashMap<String, List<Attraction>>() {{

        put(CITY_DALLAS, new ArrayList<Attraction>() {{
            add(new Attraction(
                    "Furball Gaming Lair",
                    "Main Programmer \n Tourments and  Kicking it old school",
                    "Contcact info: \n       admin@furballwear.com,\n I am working Night and Day to get this out. It will be awesome when its done. And a big Fan of Easter.....",
                    Uri.parse("http://www.furballwear.com/images/nature1.jpg"),
                    Uri.parse("http://www.furballwear.com/images/furballgame.png"),
                    new LatLng(32.8127599, -96.8090568),
                    CITY_DALLAS,"2015-08-02","Furballwears Secert","CARD GAMES"
            ));

            add(new Attraction(
                    "Game Stop 20895",
                    "Lorem ipsum dolor sit amet,",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ut nulla neque. Morbi nec felis vel neque rhoncus malesuada. Mauris non nisi est. Nunc in ipsum euismod, suscipit dolor eget, efficitur nisi. Integer venenatis mauris mauris, quis ",
                    Uri.parse("http://www.furballwear.com/images/ct.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(31.8226178, -97.7048537),
                    CITY_DALLAS,"2015-07-31","Private parsonal","PEN N PAPER"
            ));

            add(new Attraction(
                    "EB Games 87654",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n Aliquam ut dui in ipsum suscipit aliquet pretium aliquet odio.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut dui in ipsum suscipit aliquet pretium aliquet odio. Nam posuere nunc sed risus molestie varius. Suspendisse posuere faucibus urna, id vestibulum ante iaculis et. Vivamus placerat suscipit sem, a tempor nunc vehicula ac. Ut libero velit, dapibus sit amet euismod vel, dignissim a nisl.\n\nDonec non dui non felis laoreet malesuada. Fusce ac metus ultrices, fermentum felis quis, varius velit. Donec ac felis semper, scelerisque diam sed, dignissim risus. Maecenas vel semper sapien. Fusce euismod justo posuere, efficitur risus tincidunt, congue tellus. In hac habitasse platea dictumst. Sed lobortis risus consequat vehicula facilisis.\n\nIn hendrerit, neque in gravida rutrum, purus enim aliquet lectus, sit amet vulputate tortor lacus at sem. Aenean lorem metus, finibus rhoncus eros at, ullamcorper fringilla velit. Nulla vitae porttitor metus, quis gravida lectus. In rhoncus, diam a elementum luctus, erat nisi tempus ex, in porta est.",
                    Uri.parse("http://www.furballwear.com/images/mindgames.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(35.2126178, -90.28058537),
                    CITY_DALLAS,"2015-09-01","Private parsonal","TABLETOP"
            ));

            add(new Attraction(
                    "Micheal Crib 77",
                    "Bad ass Grafix Designer, \n and Gamer",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et nunc in leo laoreet placerat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin vestibulum laoreet odio nec posuere. Quisque ante arcu, malesuada vitae velit a, auctor tincidunt ante. Mauris varius eros eros, eget scelerisque mi scelerisque ut. Donec vehicula vitae urna ac hendrerit. Phasellus egestas risus nec euismod auctor.\n\nInteger fermentum velit et dolor varius sagittis. Proin et viverra sapien. Nulla aliquet ante et hendrerit egestas. Duis vulputate libero in nisi gravida cursus. Praesent laoreet nec dolor non iaculis. Aliquam eleifend ultricies ipsum, eu pellentesque libero rutrum non. Mauris et purus erat. Nullam semper mi id tincidunt viverra. Ut porta sem congue lectus luctus ultricies. Suspendisse iaculis lacinia nibh, eu accumsan magna volutpat vel. Sed id interdum mi, vel sollicitudin elit. Fusce facilisis elementum gravida. Duis at volutpat odio. Integer porta convallis tincidunt. Donec aliquam, leo ut.",
                    Uri.parse("http://www.furballwear.com/images/home.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(38.8526178, -95.8588537),
                    CITY_DALLAS,"2015-07-25","Open Public","PEN N PAPER"
            ));

            add(new Attraction(
                    "Middle Earth",
                    "Lord of the Rings 000 ",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/wookie.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(32.9426178, -95.6388537),
                    CITY_DALLAS,"2015-12-01","Open Public","BOARD GAMES"
            ));
            add(new Attraction(
                    "Geek World",
                    "Dongon and Dragons 555",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/ccgrageob.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(31.6126178, -95.6688537),
                    CITY_DALLAS,"2016-01-01","Private parsonal","PEN N PAPER"
            ));
            add(new Attraction(
                    " Sindarin Endor 123",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/tabletop.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(33.7123478, -96.6084737),
                    CITY_DALLAS,"2015-07-29","Open Public","TABLETOP"
            ));
            add(new Attraction(
                    "Some where 999",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/meeting.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(32.71589878, -86.6088537),
                    CITY_DALLAS,"2015-11-11","Private parsonal","PEN N PAPER"
            ));
            add(new Attraction(
                    "Lord of the ring 234",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/mindgames.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(32.7226178, -95.6088537),
                    CITY_DALLAS,"2015-08-19","Open Public","PEN N PAPER"
            ));
            add(new Attraction(
                    "Magic 4987",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/ccgrageob.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(30.7126178, -96.6058537),
                    CITY_DALLAS,"2015-08-09","Open Public","PEN N PAPER"
            ));
            add(new Attraction(
                    "EB Games 876",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n Aliquam ut dui in ipsum suscipit aliquet pretium aliquet odio.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut dui in ipsum suscipit aliquet pretium aliquet odio. Nam posuere nunc sed risus molestie varius. Suspendisse posuere faucibus urna, id vestibulum ante iaculis et. Vivamus placerat suscipit sem, a tempor nunc vehicula ac. Ut libero velit, dapibus sit amet euismod vel, dignissim a nisl.\n\nDonec non dui non felis laoreet malesuada. Fusce ac metus ultrices, fermentum felis quis, varius velit. Donec ac felis semper, scelerisque diam sed, dignissim risus. Maecenas vel semper sapien. Fusce euismod justo posuere, efficitur risus tincidunt, congue tellus. In hac habitasse platea dictumst. Sed lobortis risus consequat vehicula facilisis.\n\nIn hendrerit, neque in gravida rutrum, purus enim aliquet lectus, sit amet vulputate tortor lacus at sem. Aenean lorem metus, finibus rhoncus eros at, ullamcorper fringilla velit. Nulla vitae porttitor metus, quis gravida lectus. In rhoncus, diam a elementum luctus, erat nisi tempus ex, in porta est.",
                    Uri.parse("http://www.furballwear.com/images/mindgames.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(34.2126178, -94.28058537),
                    CITY_DALLAS,"2015-10-01","Open Public","PEN N PAPER"
            ));

            add(new Attraction(
                    "Micheal Crib 789",
                    "Bad ass Grafix Designer, \n and Gamer",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et nunc in leo laoreet placerat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin vestibulum laoreet odio nec posuere. Quisque ante arcu, malesuada vitae velit a, auctor tincidunt ante. Mauris varius eros eros, eget scelerisque mi scelerisque ut. Donec vehicula vitae urna ac hendrerit. Phasellus egestas risus nec euismod auctor.\n\nInteger fermentum velit et dolor varius sagittis. Proin et viverra sapien. Nulla aliquet ante et hendrerit egestas. Duis vulputate libero in nisi gravida cursus. Praesent laoreet nec dolor non iaculis. Aliquam eleifend ultricies ipsum, eu pellentesque libero rutrum non. Mauris et purus erat. Nullam semper mi id tincidunt viverra. Ut porta sem congue lectus luctus ultricies. Suspendisse iaculis lacinia nibh, eu accumsan magna volutpat vel. Sed id interdum mi, vel sollicitudin elit. Fusce facilisis elementum gravida. Duis at volutpat odio. Integer porta convallis tincidunt. Donec aliquam, leo ut.",
                    Uri.parse("http://www.furballwear.com/images/home.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(31.8526178, -93.8588537),
                    CITY_DALLAS,"2015-09-01","Hosted Event","BOARD GAMES"
            ));

            add(new Attraction(
                    "Middle Earth 88",
                    "Lord of the Rings",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/wookie.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(38.7426178, -95.6388537),
                    CITY_DALLAS,"2016-01-04","Hosted Event","TABLETOP"
            ));
            add(new Attraction(
                    "Geek World 99",
                    "Dongon and Dragons",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/ccgrageob.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(32.6126178, -96.6688537),
                    CITY_DALLAS,"2015-08-01","Open Public","BOARD GAMES"
            ));
            add(new Attraction(
                    " Sindarin Endor 9",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/tabletop.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(32.0123478, -96.6084737),
                    CITY_DALLAS,"2015-07-29","Hosted Event","TABLETOP"
            ));
            add(new Attraction(
                    "Some where over there",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/meeting.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(32.74589878, -86.6028537),
                    CITY_DALLAS,"2016-05-08","Tornament","BOARD GAMES"
            ));
            add(new Attraction(
                    "Lord of the ring gold",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/mindgames.jpg"),
                    Uri.parse("http://www.furballwear.com/images/tournament_games_red.png"),
                    new LatLng(32.7326178, -96.8088537),
                    CITY_DALLAS,"2015-08-08","Tornament","BOARD GAMES"
            ));
            add(new Attraction(
                    "Magic 6",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/ccgrageob.jpg"),
                    Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png"),
                    new LatLng(33.7126178, -96.6058537),
                    CITY_DALLAS,"2015-08-15","Tornament","TABLETOP"
            ));
            add(new Attraction(
                    "another place 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing \n elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eros velit, faucibus in mi in, accumsan eleifend magna. Fusce efficitur volutpat leo nec finibus. Vivamus luctus quis dolor ac interdum. Donec iaculis, orci quis semper vulputate, tortor nisi porttitor tortor, at pretium ante quam ut odio. Donec fringilla sapien et dolor pharetra ultrices. Aenean faucibus felis non vulputate iaculis.\n\nEtiam eget dapibus ligula. Nunc facilisis dignissim tortor et elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam condimentum pellentesque mollis. Aliquam finibus urna ipsum, sed accumsan ante blandit quis. Vestibulum vel lacinia ligula. Nunc justo ex, volutpat nec justo ut, efficitur gravida lectus. Mauris cursus dui libero, vel tristique purus laoreet non.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ultrices ullamcorper est, at consequat massa. Nam egestas at urna at pellentesque. Quisque lacus quam, efficitur vel erat eget, placerat feugiat eros. Mauris.",
                    Uri.parse("http://www.furballwear.com/images/ct.jpg"),
                    Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png"),
                    new LatLng(31.7126178, -95.6088537),
                    CITY_DALLAS,"2015-08-09","Open Public","PEN N PAPER"
            ));
        }});

    }};

    /**
     * Creates a list of geofences based on the city locations
     */
    public static List<Geofence> getGeofenceList() {
        List<Geofence> geofenceList = new ArrayList<Geofence>();
        for (String city : CITY_LOCATIONS.keySet()) {
            LatLng cityLatLng = CITY_LOCATIONS.get(city);
            geofenceList.add(new Geofence.Builder()
                    .setCircularRegion(cityLatLng.latitude, cityLatLng.longitude, TRIGGER_RADIUS)
                    .setRequestId(city)
                    .setTransitionTypes(TRIGGER_TRANSITION)
                    .setExpirationDuration(EXPIRATION_DURATION)
                    .build());
        }
        return geofenceList;
    }

    public static String getClosestCity(LatLng curLatLng) {
        if (curLatLng == null) {
            // In debug build still return a city so some data is displayed
            if (BuildConfig.DEBUG) {
                return TEST_CITY;
            }
            return null;
        }

        double minDistance = 0;
        String closestCity = null;
        for (Map.Entry<String, LatLng> entry: CITY_LOCATIONS.entrySet()) {
            double distance = SphericalUtil.computeDistanceBetween(curLatLng, entry.getValue());
            if (minDistance == 0 || distance < minDistance) {
                minDistance = distance;
                closestCity = entry.getKey();
            }
        }
        return closestCity;
    }
}
