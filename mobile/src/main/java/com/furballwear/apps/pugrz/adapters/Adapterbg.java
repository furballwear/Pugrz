package com.furballwear.apps.pugrz.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.activities.CheeseDetailActivity;
import com.furballwear.apps.pugrz.activities.DetailActivity;
import com.furballwear.apps.pugrz.activities.Profile;
import com.furballwear.apps.pugrz.models.Game;
import com.furballwear.apps.pugrz.service.VolleySingleton;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by furballadmin on 7/23/2015.
 */
public class Adapterbg extends RecyclerView.Adapter<Adapterbg.ViewHolderBG> implements ItemClickListener {
private ArrayList<Game> mListGames = new ArrayList<>();
    private LayoutInflater mInflater;
private ClickListner clickListner;
    private Context context;

private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;
    public Adapterbg(Context context) {
        mInflater = LayoutInflater.from(context);
        mVolleySingleton = VolleySingleton.getInstance();
        mImageLoader = mVolleySingleton.getImageLoader();
        this.context = context;

    }
public void setClickListner(ClickListner clickListner){
    this.clickListner = clickListner;
}
    public void setGames(ArrayList<Game> mListGames) {
        this.context = context;
        this.mListGames = mListGames;
        //update the adapter to reflect the new set of movies
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderBG onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_card_bigo, parent, false);
        ViewHolderBG viewHolder = new ViewHolderBG(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderBG holder,int position) {
        final Game currentGame = mListGames.get(position);
        //one or more fields of the Movie object may be null since they are fetched from the web
        holder.gametitle.setText(currentGame.getTittle());
        holder.gamedate.setText(currentGame.getGamedate());
        holder.shortdes.setText(currentGame.getShortdes());
        holder.gametype.setText(currentGame.getGametype());
        holder.gametime.setText(currentGame.getGametime());
        holder.gamestyle.setText(currentGame.getGamestyle());
        holder.glocation.setText(currentGame.getGlocation());

        holder.movieThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CheeseDetailActivity.class);
                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, currentGame.getTittle());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMESTYLE,currentGame.getGamestyle());
                intent.putExtra(CheeseDetailActivity.EXTRA_SHORTDESC,currentGame.getShortdes());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMEIMAGE,currentGame.getGametype());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMEOWNER,currentGame.getUser_id_create());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMECITY,currentGame.getGamecity());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMEDATE,currentGame.getGamedate());
                intent.putExtra(CheeseDetailActivity.EXTRA_GAMETIME,currentGame.getGametime());
                intent.putExtra(CheeseDetailActivity.EXTRA_GLOCATION,currentGame.getGlocation());

                context.startActivity(intent);

            }
        });
        switch (String.valueOf(currentGame.getGamestyle())) {
            case "Open Public":
                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/public_out_doors_events.png")).into(holder.movieThumbnail2);

                break;
            case "Private parsonal":
                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/privet_invite_event_pink.png")).into(holder.movieThumbnail2);

                break;
            case "Tornament":
                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/tournament_games_red.png")).into(holder.movieThumbnail2);

                break;
            case "Hosted Event":
                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/open_game.png")).into(holder.movieThumbnail2);

                break;
            case "Furballwears Secert":
                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/furballgame.png")).into(holder.movieThumbnail2);

                break;
        }
        switch (String.valueOf(currentGame.getGametype())) {
            case "BOARD GAMES":

                Glide.with(context).load(R.drawable.dnd).into(holder.movieThumbnail);
                break;
            case "CARD GAMES":

                Glide.with(context).load(R.drawable.steampunk_dinosaurs).into(holder.movieThumbnail);
                break;
            case "TABLETOP":

                Glide.with(context).load(R.drawable.tabletop).into(holder.movieThumbnail);
                break;
            case "PEN N PAPER":

                Glide.with(context).load(R.drawable.pugrz).into(holder.movieThumbnail);
                break;
            case "FURBALLWEAR":

                Glide.with(context).load(Uri.parse("http://www.furballwear.com/images/nature1.jpg")).into(holder.movieThumbnail);
                break;
        }

    }


    private void loadImages(String urlThumbnail, final ViewHolderBG holder) {

    }

    @Override
    public int getItemCount() {
        return mListGames.size();
    }

static class ViewHolderBG extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView movieThumbnail2;
    ImageView movieThumbnail;
    TextView gametitle;
    TextView gamedate;
    TextView shortdes;
    TextView gametime;
    TextView gamestyle;
    TextView gametype;
    TextView glocation;
    TextView gameowner;
    TextView gamecity;


    public ViewHolderBG(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        movieThumbnail = (ImageView) itemView.findViewById(R.id.icon);
        movieThumbnail2 = (ImageView) itemView.findViewById(R.id.icon2);
        gametitle = (TextView) itemView.findViewById(R.id.text1);
        gamedate = (TextView) itemView.findViewById(R.id.text6);
        shortdes = (TextView) itemView.findViewById(R.id.text2);
        gamestyle = (TextView) itemView.findViewById(R.id.text3);
        gametime = (TextView) itemView.findViewById(R.id.text4);
        gametype = (TextView) itemView.findViewById(R.id.text5);
        glocation = (TextView) itemView.findViewById(R.id.text7);

    }

    @Override
    public void onClick(View v) {
    }
}
public interface ClickListner{
    public void itemclicked(View view, int position);
}


}



