

package com.zeferino.bruno.pap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

import com.zeferino.bruno.pap.Constants;
import com.zeferino.bruno.pap.MainActivity;
import com.zeferino.bruno.pap.R;
import com.zeferino.bruno.pap.model.TrailerModel;

/**
 * Trailer adapter. Used to load trailer information in the trailer list.
 */
public class TrailerAdapter extends ArrayAdapter<TrailerModel> {
    private ArrayList<TrailerModel> trailerList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;
    private Context mContext;
    private ImageLoader imageLoader;

    public TrailerAdapter(Context context, int resource, ArrayList<TrailerModel> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        trailerList = objects;
        mContext = context;
        imageLoader = ImageLoader.getInstance();
    }


    /**
     * Get a View that displays the data at the specified position in the data set.
     * @param position The position of the item within the adapter's data set of the item whose view we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using.
     * @param parent The parent that this view will eventually be attached to.
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.filePath = (ImageView) v.findViewById(R.id.filePath);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        if (imageLoader.getDiskCache().get(Constants.trailerImageUrl + trailerList.get(position).getFilePath() + "/hqdefault.jpg").exists())
            imageLoader.displayImage(Constants.trailerImageUrl + trailerList.get(position).getFilePath() + "/hqdefault.jpg", holder.filePath, ((MainActivity) mContext).getOptionsWithoutFade());
        else
            imageLoader.displayImage(Constants.trailerImageUrl + trailerList.get(position).getFilePath() + "/hqdefault.jpg", holder.filePath, ((MainActivity) mContext).getOptionsWithFade());


        return v;

    }

    /**
     * Defines trailer list row elements.
     */
    static class ViewHolder {
        public ImageView filePath;
    }


}