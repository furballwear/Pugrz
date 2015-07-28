package com.furballwear.apps.pugrz.fragments;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.service.VolleySingleton;

/**
 * Created by furballadmin on 7/22/2015.
 */
public class MyFragment extends Fragment {
private static String myurl = "http://primetruckinginc.com:8080/rest/pugrzdata/todo?app_name=pugrz?format=xml";
    private TextView textView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static String getRequestUrl(int limit){
        return myurl +"&limit="+limit;
    };


    public static MyFragment newInstance(String mParam1,String mParam2) {
        MyFragment myFragment = new MyFragment ();
        Bundle args = new Bundle();
      //  private OnFragmentInteractionListener mListener;
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        myFragment.setArguments(args);

        return myFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstance){

        View layout = inflater.inflate(R.layout.myfragment, container,false);

        textView = (TextView)layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        if(bundle != null){

        }

        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        StringRequest request= new StringRequest(Request.Method.GET, getRequestUrl(50), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // Toast.makeText(getActivity(),"My Fragmant Response"+response,Toast.LENGTH_LONG).show();
                textView.setText("" + response + ("position"));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity()," ERROR Response"+error,Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);


        return layout;

    }





}
