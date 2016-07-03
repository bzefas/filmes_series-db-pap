package com.zeferino.bruno.pap;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * About fragment used in the about view.
 */
public class About extends Fragment implements View.OnClickListener {

    private Resources res;

    public About() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about, container, false);
        ImageView tmdb = (ImageView) rootView.findViewById(R.id.tmdb);
        tmdb.setOnClickListener(this);
        res = getResources();
        getActivity().getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.aboutBackground));
        return rootView;
    }
    /**
     * Fired when fragment is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.background_material_light));
    }

    @Override
    public void onClick(View v) {
        //TODO

    }
}
