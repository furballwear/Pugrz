/*   Copyright (c) 2015 Magnet Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.furballwear.apps.pugrz.message;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;
import com.magnet.mmx.client.MMXClient;
import com.magnet.mmx.client.MMXClient.MMXWakeupListener;
import com.magnet.mmx.client.MMXTask;
import com.magnet.mmx.client.common.MMXMessage;
import com.magnet.mmx.protocol.MMXTopic;

import java.util.List;

/**
 * This listener is registered during Application.onCreate() to handle GCM and AlarmManager wakeups.
 * See MyApplication.onCreate().  This is only necessary if the application should respond to MMX
 * wake-ups (including GCM wake-ups or timer-based events.
 */
public class MyWakeupListener implements MMXWakeupListener {
  private static final String TAG = MyWakeupListener.class.getSimpleName();

  private static final String KEY_USERNAME = "username";

  private MyProfile mProfile;
  private MMXClient mClient;
  private MMXTopic mTopic;
  private MMXTask<List<MMXMessage>> mTask;
  private List<MMXMessage> mTopicItems;
  private ListView mTopicItemsView;
  private TextView mTopicName;
  private EditText mPublishText;
  public void onWakeupReceived(final Context applicationContext, Intent intent, String username, byte[] password) {
    //TODO: Upon receiving a wakeup, the application may choose to connect.
    MyMMXListener myListener = MyMMXListener.getInstance(applicationContext);
    MMXClient client = MMXClient.getInstance(applicationContext, R.raw.quickstart);
    client.connectWithCredentials(PrefUtil.getString(applicationContext, IAppConstants.DISPLAY_NAME), password, myListener, null);
    client.setGcmWakeUpEnabled(true);
    client.updateLocation();













  }

  @Override
  public void onWakeupReceived(Context context, Intent intent) {

  }
}
