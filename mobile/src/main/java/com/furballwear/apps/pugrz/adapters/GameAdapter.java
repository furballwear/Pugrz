package com.furballwear.apps.pugrz.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.furballwear.apps.pugrz.api.DbApi;
import com.furballwear.apps.pugrz.client.ApiException;
import com.furballwear.apps.pugrz.model.RecordRequest;
import com.furballwear.apps.pugrz.model.RecordResponse;
import com.furballwear.apps.pugrz.R;

import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

import java.util.List;

public class GameAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private Context context;
	private GameHolder holder=  null;
	private ProgressDialog progressDialog;
	private List<RecordResponse> records;
	private String session_id;
	private String dsp_url;
	private static final String EXTRA_ATTRACTION = "attraction";


	public GameAdapter(Context context, List<RecordResponse> records) {
		this.records = records;
		this.context = context;
		this.session_id = PrefUtil.getString(context, IAppConstants.SESSION_ID, "");
		this.dsp_url =  PrefUtil.getString(context, IAppConstants.DSP_URL, "");
		this.dsp_url += IAppConstants.DSP_URL_SUFIX;
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(context.getString((R.string.loading_message)));
		inflater = LayoutInflater.from(this.context);
	}

	public void addTask(RecordResponse record){
		records.add(record);
	}


	@Override
	public int getCount() {
		return records.size();
	}
	@Override
	public Object getItem(int position) {
		return records.get(position);
	}
	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {		

		holder = new GameHolder();
		RecordResponse record = records.get(position);
		if (convertView == null){

			convertView = inflater.inflate(R.layout.list_item_card_bigo, null);
			holder.iv_icon2 = (ImageView) convertView.findViewById(R.id.icon2);
			holder.iv_icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.tv_task = (TextView) convertView.findViewById(R.id.text1);
			holder.tv_glocation = (TextView)convertView.findViewById(R.id.text5);
			holder.tv_shortdes = (TextView)convertView.findViewById(R.id.text2);
            holder.tv_gamedate = (TextView)convertView.findViewById(R.id.text7);
            holder.tv_gametime = (TextView)convertView.findViewById(R.id.text8);
			holder.tb_fav = (ToggleButton)convertView.findViewById(R.id.fav);

			convertView.setTag(holder);
		}
		else {
			holder = (GameHolder) convertView.getTag();
		}

		holder.tv_task.setId(position);
		holder.tv_task.setText(record.getTittle());
		holder.tv_task.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = v.getId();
				new UpdateRecordTask().execute(records.get(pos));
			}
		});


		//holder.tv_glocation.setId(position);
		holder.tv_glocation.setTag("gloc" + position);
		holder.tv_glocation.setText(record.getGlocation());

	//	holder.tv_shortdes.setId(position);
		holder.tv_shortdes.setTag("sd" + position);
		holder.tv_shortdes.setText(record.getShortdes());

	//	holder.tv_gamedate.setId(position);
		holder.tv_gamedate.setTag("gdate" + position);
		holder.tv_gamedate.setText(record.getGamedate());
		holder.tv_gamedate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = v.getId();
				new DeleteRecordTask().execute(records.get(pos));
			}
		});

		switch (String.valueOf(record.iscomplete())) {
			case "true":
				holder.tv_task.setPaintFlags(holder.tv_task.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
				holder.tb_fav.setChecked(true);
				break;

			case "false":

				holder.tv_task.setPaintFlags((holder.tv_task.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG)));
				holder.tb_fav.setChecked(false);
		}
		switch (String.valueOf(record.getGamestyle())) {
			case "Open Public":
				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png")).into(holder.iv_icon2);

				break;
			case "Private parsonal":
				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png")).into(holder.iv_icon2);

				break;
			case "Tornament":
				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/tournament_games_red.png")).into(holder.iv_icon2);

				break;
			case "Hosted Event":
				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/open_game.png")).into(holder.iv_icon2);

				break;
			case "Furballwears Secert":
				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/furballgame.png")).into(holder.iv_icon2);

				break;
		}
		switch (String.valueOf(record.getGametype())) {
			case "BOARD GAMES":

				Glide.with(context).load(R.drawable.dnd).into(holder.iv_icon);
				break;
			case "CARD GAMES":

				Glide.with(context).load(R.drawable.steampunk_dinosaurs).into(holder.iv_icon);
				break;
			case "TABLETOP":

				Glide.with(context).load(R.drawable.tabletop).into(holder.iv_icon);
				break;
			case "PEN N PAPER":

				Glide.with(context).load(R.drawable.pugrz).into(holder.iv_icon);
				break;
			case "FURBALLWEAR":

				Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/nature1.jpg")).into(holder.iv_icon);
				break;
		}









		return convertView;



	}

	private class GameHolder extends RecyclerView.Adapter{
		ImageView iv_icon;
		ImageView iv_icon2;
		TextView tv_task;
		ToggleButton tb_fav;
		TextView tv_glocation;
		TextView tv_shortdes;
        TextView tv_gamedate;
        TextView tv_gametime;

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			return null;
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

		}

		@Override
		public int getItemCount() {
			return 0;
		}
	}

	class DeleteRecordTask extends AsyncTask<Object, String, String>{

		@Override
		protected String doInBackground(Object... params) {
			RecordResponse record = (RecordResponse)params[0];
			int pos = (Integer)params[1];
			DbApi dbApi = new DbApi();
			dbApi.setBasePath(dsp_url);
			dbApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
			dbApi.addHeader("X-DreamFactory-Session-Token", session_id);
			try {
				//				dbApi.deleteRecord(IAppConstants.TABLE_NAME, record.getId(), null, null, null);
				dbApi.deleteRecord(IAppConstants.TABLE_TODO, record.getId(), null, null, null,null);
				records.remove(pos);
			} catch (ApiException e) {
				return e.getMessage();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			progressDialog.cancel();
			if(result == null){ // success
				notifyDataSetChanged();
			}else{
				Toast.makeText(context, result, Toast.LENGTH_LONG).show();
			}
		}

		@Override
		protected void onPreExecute() {
			progressDialog.show();
		}

	}
	class DetailRecordTask extends AsyncTask<Void, Void, Void>{

		protected void onPostExecute() {
			progressDialog.cancel();

		}


		@Override
		protected Void doInBackground(Void... params) {


			return null;
		}

		@Override
		protected void onPreExecute() {
			progressDialog.show();
		}

	}

	class UpdateRecordTask extends AsyncTask<Object, String, String>{

		@Override
		protected String doInBackground(Object... params) {
			RecordResponse recordResponse = (RecordResponse)params[0];
			recordResponse.setComplete(!recordResponse.iscomplete());

			RecordRequest recordRequest = new RecordRequest();
			recordRequest.setComplete(recordResponse.iscomplete());
			recordRequest.set_field_(recordResponse.get_field_());
			recordRequest.setId(recordResponse.getId());
			recordRequest.setTittle(recordResponse.getTittle());
			recordRequest.setGamedate(recordResponse.getGamedate());
			recordRequest.setGametime(recordResponse.getGametime());
			recordRequest.setGamestyle(recordResponse.getGamestyle());
			recordRequest.setGlocation(recordResponse.getGlocation());
			recordRequest.setGametype(recordResponse.getGametype());


			DbApi dbApi = new DbApi();
			dbApi.setBasePath(dsp_url);
			dbApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
			dbApi.addHeader("X-DreamFactory-Session-Token", PrefUtil.getString(context, IAppConstants.SESSION_ID, ""));

			try {
			//	Record result = dbApi.updateRecord(IAppConstants.TABLE_TODO, record.getId(), null, record, null, null);
			RecordResponse result = dbApi.updateRecord(IAppConstants.TABLE_TODO, recordRequest.getId(),recordRequest, null, null,null, null);
				System.out.println("UpdateRecord Result " + result.toString());
			} catch (ApiException e) {
				return e.getMessage();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			progressDialog.cancel();
			if(result == null){ // success
				notifyDataSetChanged();
			}else{
				Toast.makeText(context, result, Toast.LENGTH_LONG).show();
			}
		}

		@Override
		protected void onPreExecute() {
			progressDialog.show();
		}

	}
}
