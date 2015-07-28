/*
 * Copyright 2013 The Android Open Source Project
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

package com.furballwear.apps.pugrz.basicsyncadapter.net;

import android.text.format.Time;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class parses generic Atom feeds.
 *
 * <p>Given an InputStream representation of a feed, it returns a List of entries,
 * where each list element represents a single entry (post) in the XML feed.
 *
 * <p>An example of an Atom feed can be found at:
 * http://en.wikipedia.org/w/index.php?title=Atom_(standard)&oldid=560239173#Example_of_an_Atom_1.0_feed
 */
public class FeedParser {

    // Constants indicting XML element names that we're interested in
    private static final int TAG_ID = 1;
    private static final int TAG_TITLE = 2;

    private static final int TAG_SHORTDES = 3;
    private static final int TAG_GAMEDATE = 4;
    private static final int TAG_GAMETIME = 5;
    private static final int TAG_GAMETYPE = 6;
    private static final int TAG_GAMESTYLE = 7;
    private static final int TAG_GLOCATION = 8;
    private static final int TAG_USER_ID_CREATE = 9;
    private static final int TAG_GAMECITY = 10;


    // We don't use XML namespaces
    private static final String ns = null;

    /** Parse an Atom feed, returning a collection of Entry objects.
     *
     * @param in Atom feed, as a stream.
     * @return List of {@link com.furballwear.apps.pugrz.basicsyncadapter.net.FeedParser.Entry} objects.
     * @throws XmlPullParserException on error parsing feed.
     * @throws IOException on I/O error.
     */
    public List<Entry> parse(InputStream in)
            throws XmlPullParserException, IOException, ParseException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    /**
     * Decode a feed attached to an XmlPullParser.
     *
     * @param parser Incoming XMl
     * @return List of {@link com.furballwear.apps.pugrz.basicsyncadapter.net.FeedParser.Entry} objects.
     * @throws XmlPullParserException on error parsing feed.
     * @throws IOException on I/O error.
     */
    private List<Entry> readFeed(XmlPullParser parser)
            throws XmlPullParserException, IOException, ParseException {
        List<Entry> entries = new ArrayList<Entry>();

        // Search for <feed> tags. These wrap the beginning/end of an Atom document.
        //
        // Example:
        // <?xml version="1.0" encoding="utf-8"?>
        // <feed xmlns="http://www.w3.org/2005/Atom">
        // ...
        // </feed>
        parser.require(XmlPullParser.START_TAG, ns, "dfapi");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the <entry> tag. This tag repeates inside of <feed> for each
            // article in the feed.
            //
            // Example:
            // <entry>
            //   <title>Article title</title>
            //   <link rel="alternate" type="text/html" href="http://example.com/article/1234"/>
            //   <link rel="edit" href="http://example.com/admin/article/1234"/>
            //   <id>urn:uuid:218AC159-7F68-4CC6-873F-22AE6017390D</id>
            //   <published>2003-06-27T12:00:00Z</published>
            //   <updated>2003-06-28T12:00:00Z</updated>
            //   <summary>Article summary goes here.</summary>
            //   <author>
            //     <name>Rick Deckard</name>
            //     <email>deckard@example.com</email>
            //   </author>
            // </entry>
            if (name.equals("record")) {
                entries.add(readEntry(parser));
            } else {
                skip(parser);
            }
        }
        return entries;
    }

    /**
     * Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them
     * off to their respective "read" methods for processing. Otherwise, skips the tag.
     */
    private Entry readEntry(XmlPullParser parser)
            throws XmlPullParserException, IOException, ParseException {
        parser.require(XmlPullParser.START_TAG, ns, "record");
        String id = null;
        String gtitle = null;
        String shortdes = null;
        String gametype = null;
        String gamestyle = null;
        String gamedate = null;
        String gametime = null;
        String glocation = null;
        String user_id_create = null;
        String gamecity = null;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("id")) {
                // Example: <id>urn:uuid:218AC159-7F68-4CC6-873F-22AE6017390D</id>
                id = readTag(parser, TAG_ID);
            } else if (name.equals("title")) {

                gtitle = readTag(parser, TAG_TITLE);
            } else if (name.equals("shortdes")) {

                shortdes = readTag(parser, TAG_SHORTDES);

            } else if (name.equals("gamedate")) {

                gamedate = readTag(parser, TAG_GAMEDATE);

            } else if (name.equals("gametime")) {

                gametime = readTag(parser, TAG_GAMETIME);

            } else if (name.equals("gametype")) {

                gametype = readTag(parser, TAG_GAMETYPE);

            }  else if (name.equals("user_id_create")) {

                user_id_create = readTag(parser, TAG_USER_ID_CREATE);

            } else if (name.equals("gamecity")) {

                gamecity = readTag(parser, TAG_GAMECITY);

            }  else if (name.equals("gamestyle")) {
                // Example: <link rel="alternate" type="text/html" href="http://example.com/article/1234"/>
                //
                // Multiple link types can be included. readAlternateLink() will only return
                // non-null when reading an "alternate"-type link. Ignore other responses.
                gamestyle = readTag(parser, TAG_GAMESTYLE);

            } else if (name.equals("glocation")) {
                // Example: <link rel="alternate" type="text/html" href="http://example.com/article/1234"/>
                //
                // Multiple link types can be included. readAlternateLink() will only return
                // non-null when reading an "alternate"-type link. Ignore other responses.
                glocation = readTag(parser, TAG_GLOCATION);

            } else {
                skip(parser);
            }
        }
        return new Entry(id, gtitle, shortdes, gamedate , gametime, gametype, gamestyle, glocation, user_id_create, gamecity);
    }

    /**
     * Process an incoming tag and read the selected value from it.
     */
    private String readTag(XmlPullParser parser, int tagType)
            throws IOException, XmlPullParserException {
        String tag = null;
        String endTag = null;

        switch (tagType) {
            case TAG_ID:
                return readBasicTag(parser, "id");
            case TAG_TITLE:
                return readBasicTag(parser, "gtitle");
            case TAG_SHORTDES:
                return readBasicTag(parser, "shortdes");
            case TAG_GAMEDATE:
                return readBasicTag(parser, "gamedate");
            case TAG_GAMETIME:
                return readBasicTag(parser, "gametime");
            case TAG_GAMETYPE:
                return readBasicTag(parser, "gametype");
            case TAG_GAMESTYLE:
                return readBasicTag(parser, "gamestyle");
            case TAG_GLOCATION:
                return readBasicTag(parser, "glocation");
            case TAG_USER_ID_CREATE:
                return readBasicTag(parser, "user_id_create");
            case TAG_GAMECITY:
                return readBasicTag(parser, "gamecity");
            default:
                throw new IllegalArgumentException("Unknown tag type: " + tagType);
        }
    }

    /**
     * Reads the body of a basic XML tag, which is guaranteed not to contain any nested elements.
     *
     * <p>You probably want to call readTag().
     *
     * @param parser Current parser object
     * @param tag XML element tag name to parse
     * @return Body of the specified tag
     * @throws IOException
     * @throws XmlPullParserException
     */
    private String readBasicTag(XmlPullParser parser, String tag)
            throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        String result = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, tag);
        return result;
    }

    /**
     * Processes link tags in the feed.
     */
    private String readAlternateLink(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        String link = null;
        parser.require(XmlPullParser.START_TAG, ns, "link");
        String tag = parser.getName();
        String relType = parser.getAttributeValue(null, "rel");
        if (relType.equals("alternate")) {
            link = parser.getAttributeValue(null, "href");
        }
        while (true) {
            if (parser.nextTag() == XmlPullParser.END_TAG) break;
            // Intentionally break; consumes any remaining sub-tags.
        }
        return link;
    }

    /**
     * For the tags title and summary, extracts their text values.
     */
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = null;
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    /**
     * Skips tags the parser isn't interested in. Uses depth to handle nested tags. i.e.,
     * if the next tag after a START_TAG isn't a matching END_TAG, it keeps going until it
     * finds the matching END_TAG (as indicated by the value of "depth" being 0).
     */
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    /**
     * This class represents a single entry (post) in the XML feed.
     *
     * <p>It includes the data members "title," "link," and "summary."
     */
    public static class Entry {
        public final String id;
        public final String title;
        public final String shortdes;
        public final String gamedate;
        public final String gametime;
        public final String gamestyle;
        public final String gametype;
        public final String glocation;
        public final String gamecity;
        public final String user_id_create;

        Entry(String id, String title, String shortdes,String gamedate,String gametime,String gamestyle,String gametype, String glocation,String gamecity,String user_id_create) {
            this.id = id;
            this.title = title;
            this.shortdes = shortdes;
            this.gamedate = gamedate;
            this.gametime = gametime;
            this.gametype = gametype;
            this.gamestyle = gamestyle;
            this.glocation = glocation;
            this.gamecity = gamecity;
            this.user_id_create = user_id_create;
        }
    }
}
