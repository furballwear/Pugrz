package com.furballwear.apps.pugrz.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Paint;
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

import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.api.DbApi;
import com.furballwear.apps.pugrz.client.ApiException;
import com.furballwear.apps.pugrz.model.RecordRequest;
import com.furballwear.apps.pugrz.model.RecordResponse;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

import java.util.List;

public class ToDoAdapterCard{ //extends RecyclerView.Adapter<ToDoAdapterCard.ToDoHolder> {
	private LayoutInflater inflater;
	private Context context;
	//private ToDoHolder holder = null;
	private ProgressDialog progressDialog;
	private List<RecordResponse> records;
	private String session_id;
	private String dsp_url;
}

	/*public ToDoAdapterCard(Context context, List<RecordResponse> records) {
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
	public ToDoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		return null;
	}

	@Override
	public void onBindViewHolder(ToDoHolder viewHolder, int i) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	class ToDoHolder extends RecyclerView.ViewHolder{
		public ToDoHolder(View itemView) {
			super(itemView);
		}
	}

	public int getCount() {
		return records.size();
	}

	public Object getItem(int position) {
		return records.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}


	/*public View getView(int position, View convertView, ViewGroup parent) {

		holder = new ToDoHolder();
		RecordResponse record = records.get(position);
		if (convertView == null){

			convertView = inflater.inflate(R.layout.list_item_card_bigo, null);
			holder.iv_icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.tv_task = (TextView) convertView.findViewById(R.id.text1);
			holder.tv_time = (TextView) convertView.findViewById(R.id.text6);
			holder.tv_gametype = (TextView)convertView.findViewById(R.id.text3);
			holder.tv_gamestyle = (TextView)convertView.findViewById(R.id.text4);
			holder.tv_glocation = (TextView)convertView.findViewById(R.id.text5);
			holder.tv_shortdes = (TextView)convertView.findViewById(R.id.text2);
            holder.tv_gamedate = (TextView)convertView.findViewById(R.id.text7);
            holder.tv_gametime = (TextView)convertView.findViewById(R.id.text8);

			convertView.setTag(holder);
		}
		else {
			holder = (ToDoHolder) convertView.getTag();
		}


		holder.iv_icon.setTag( ""+position);

		holder.iv_icon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int pos = Integer.parseInt((String)v.getTag());
				new DeleteRecordTask().execute(records.get(pos), Integer.valueOf(pos));
			}
		});

		holder.tv_time.setTag("timestamp" + position);
		holder.tv_time.setText(record.getPTimeStamp());

		holder.tv_gametype.setText(record.getGameType());
		holder.tv_gametype.setTag("gtype" + position);
		if(String.valueOf(holder.tv_gametype).equals("BOARD GAME"))



		holder.tv_glocation.setText(record.getGlocation());
		holder.tv_glocation.setTag("" + position);

		holder.tv_task.setId(position);
		holder.tv_task.setText(record.getName());
		holder.tv_task.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = v.getId();
				new UpdateRecordTask().execute(records.get(pos));
			}
		});
		if (record.iscomplete()){
			holder.tv_task.setPaintFlags(holder.tv_task.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
		}
		else {
			holder.tv_task.setPaintFlags((holder.tv_task.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG)));
		}

		holder.tv_gamestyle.setText(record.getGameStyle());
		holder.tv_gamestyle.setTag(position);

		holder.tv_shortdes.setTag(position);
		holder.tv_shortdes.setText(record.getShortdes());
        holder.tv_gamedate.setText(record.getGameDate());
        holder.tv_gametime.setText(record.getGameTime());
		return convertView;



	}

	/*private class ToDoHolder{
		ImageView iv_icon;
		TextView tv_task;
		TextView tv_time;
		TextView tv_gametype;
		TextView tv_gamestyle;
		TextView tv_glocation;
		TextView tv_shortdes;
        TextView tv_gamedate;
        TextView tv_gametime;
	}


}*/
