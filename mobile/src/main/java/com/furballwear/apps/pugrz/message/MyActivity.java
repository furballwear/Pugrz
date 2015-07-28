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

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.furballwear.apps.pugrz.App;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;
import com.magnet.mmx.client.MMXClient;
import com.magnet.mmx.client.common.GlobalAddress;
import com.magnet.mmx.client.common.MMXErrorMessage;
import com.magnet.mmx.client.common.MMXException;
import com.magnet.mmx.client.common.MMXPayload;
import com.magnet.mmx.client.common.MMXid;
import com.magnet.mmx.client.common.MMXMessage;
import com.magnet.mmx.protocol.MMXTopic;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * The launcher activity for the quickstart application.
 */
public class MyActivity extends AppCompatActivity implements MMXClient.MMXListener {
  private static final String TAG = MyActivity.class.getSimpleName();
  //These are hardcoded credentials for the quickstart application.  This should not be used in production.

  private static final String QUICKSTART_USERNAME = PrefUtil.getString(App.getInstance(), IAppConstants.DISPLAY_NAME);
  private static final byte[] QUICKSTART_PASSWORD = "username".getBytes();

  private MMXClient mClient = null;
  private TextView mStatus = null;
  private ImageButton mSendButton = null;
  private EditText mSendText = null;
  private ListView mMessageListView = null;
  private MessageListAdapter mMessageListAdapter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //Register this activity/listener with the singleton MyMMXListener instance
    //that is used for the connection.  See onDestroy for the unregister call.
    MyMMXListener globalListener = MyMMXListener.getInstance(this);
    globalListener.registerListener(this);
    setContentView(R.layout.activity_my_activity);

    //Setup the views
    mClient = MMXClient.getInstance(this, R.raw.quickstart);
    mStatus = (TextView) findViewById(R.id.status_field);
    mSendText = (EditText) findViewById(R.id.message_text);
    mSendButton = (ImageButton) findViewById(R.id.btn_send);
    mMessageListView = (ListView) findViewById(R.id.message_list_view);
    mMessageListAdapter = new MessageListAdapter(this, MyMessageStore.getMessageList(), QUICKSTART_USERNAME);
    mMessageListView.setAdapter(mMessageListAdapter);
    mSendText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (event != null
                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE) {
          doSendMessage(v);
        }
        return false;
      }
    });
    doConnect();
    updateViewState();
  }

  @Override
  public void onDestroy() {
    //Very important to unregister this activity to prevent a memory leak.
    MyMMXListener.getInstance(this).unregisterListener(this);
    super.onDestroy();
  }

  @Override
  public void onResume() {
    //Update the view state upon resume, just in case anything changed.
    updateViewState();
    super.onResume();
  }

  /**
   * This can be called from anywhere to make sure that the view is updated.
   */
  private void updateViewState() {
    runOnUiThread(new Runnable() {
      public void run() {
        if (mClient.isConnected()) {
          String username = mClient.getConnectionInfo().username;
          String status = getString(R.string.status_connected) +
                  (username != null ? " as " + username : " " + getString(R.string.user_anonymously));
          mStatus.setText(status);
          mSendButton.setEnabled(true);
        } else {
          mStatus.setText(R.string.status_disconnected);
          mSendButton.setEnabled(false);
        }

        List<MyMessageStore.Message> messageList = MyMessageStore.getMessageList();
        mMessageListAdapter.setMessageList(messageList);
        mMessageListView.smoothScrollToPosition(mMessageListAdapter.getCount());
      }
    });
  }

  public void onConnectionEvent(MMXClient mmxClient, MMXClient.ConnectionEvent connectionEvent) {
    if (connectionEvent == MMXClient.ConnectionEvent.DISCONNECTED) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this)
              .setPositiveButton(R.string.reconnect, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  doConnect();
                }
              })
              .setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                  MyActivity.this.finish();
                }
              })
              .setMessage(R.string.event_disconnected);
      builder.show();
    }
    updateViewState();
  }

  public void onMessageReceived(MMXClient mmxClient, MMXMessage mmxMessage, String deliveryReceiptId) {
    updateViewState();
  }

  public void onSendFailed(MMXClient mmxClient, String messageId) {

  }

  public void onMessageDelivered(MMXClient mmxClient, MMXid recipient, String messageId) {
    updateViewState();
  }

  public void onPubsubItemReceived(MMXClient mmxClient, MMXTopic mmxTopic, MMXMessage mmxMessage) {
    updateViewState();
  }

  public void onErrorReceived(MMXClient mmxClient, MMXErrorMessage error) {
    updateViewState();
  }

  /**
   * Connect to the MMX server using the pre-defined username/password.
   */
  private void doConnect() {
    if (!mClient.isConnected()) {
      mClient.connectWithCredentials(QUICKSTART_USERNAME, QUICKSTART_PASSWORD,
              MyMMXListener.getInstance(this), new MMXClient.ConnectionOptions().setAutoCreate(true));
    }
  }

  private static class MessageListAdapter extends BaseAdapter {
    private static final int[] COLOR_IDS = {R.color.chat_1, R.color.chat_2, R.color.chat_3, R.color.chat_4, R.color.chat_5, R.color.chat_6};
    private static final int TYPE_ME = 0;
    private static final int TYPE_THEM = 1;
    private String mUsername;
    private List<MyMessageStore.Message> mMessageList = null;
    private LayoutInflater mInflater;
    private DateFormat mFormatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);

    public MessageListAdapter(Context context, List<MyMessageStore.Message> messageList, String username) {
      mUsername = username;
      mMessageList = messageList;
      mInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
      int type = getItemViewType(position);
      int colorResId = 0;
      String datePostedStr = null;
      String messageStr = null;
      MyMessageStore.Message message = (MyMessageStore.Message)getItem(position);
      switch (type) {
        case TYPE_ME:
          if (convertView == null) {
            convertView = mInflater.inflate(R.layout.message_list_item_me, null);
          }
          colorResId = R.color.chat_me;
          datePostedStr = mFormatter.format(message.getTimestamp());
          messageStr = message.getSentText();
          break;
        case TYPE_THEM:
          if (convertView == null) {
            convertView = mInflater.inflate(R.layout.message_list_item_them, null);
          }
          //set author and color
          MMXMessage msg = message.getMessage();
          String authorStr = msg.getFrom().getUserId();
          if (mUsername.equalsIgnoreCase(authorStr)) {
            colorResId = R.color.chat_me;
          } else {
            colorResId = COLOR_IDS[Math.abs(authorStr.hashCode() % COLOR_IDS.length)];
          }

          TextView author = (TextView) convertView.findViewById(R.id.author);
          author.setText(authorStr + " - ");
          datePostedStr = mFormatter.format(msg.getPayload().getSentTime());
          messageStr = msg.getPayload().getDataAsText().toString();
          break;
      }
      TextView datePosted = (TextView) convertView.findViewById(R.id.datePosted);
      datePosted.setText(datePostedStr);
      TextView messageText = (TextView) convertView.findViewById(R.id.messageText);
      messageText.setBackgroundResource(colorResId);
      messageText.setText(messageStr);
      return convertView;
    }

    @Override
    public int getViewTypeCount() {
      return 2;
    }

    @Override
    public int getItemViewType(int position) {
      MyMessageStore.Message message = (MyMessageStore.Message)getItem(position);
      if (!message.isIncoming()) {
        //me
        return TYPE_ME;
      } else {
        //them
        return TYPE_THEM;
      }
    }

    private void setMessageList(List<MyMessageStore.Message> messageList) {
      mMessageList = messageList;
      notifyDataSetChanged();
    }

    @Override
    public int getCount() {
      return mMessageList.size();
    }

    @Override
    public Object getItem(int position) {
      return mMessageList.get(position);
    }

    @Override
    public long getItemId(int position) {
      return 0;
    }
  }

  public void doSendMessage(View view) {
    String messageText = mSendText.getText().toString();
    if (messageText.isEmpty()) {
      //don't send an empty message
      return;
    }
    MMXPayload payload = new MMXPayload(messageText);
    String result;
    try {
      String messageID = mClient.getMessageManager().sendPayload(new MMXid(QUICKSTART_USERNAME), payload, null);
      MyMessageStore.addMessage(null, messageText, new Date(), false);
      mSendText.setText(null);
      result = "Message sent.";
    } catch (MMXException e) {
      Log.e(TAG, "doSendMessage() exception caught", e);
      result = "Exception: " + e.getMessage();
    }
    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    updateViewState();
  }
}
