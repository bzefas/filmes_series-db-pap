

package com.zeferino.bruno.pap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

import com.zeferino.bruno.pap.MainActivity;
import com.zeferino.bruno.pap.R;
import com.zeferino.bruno.pap.model.GalleryModel;


/**
 * Gallery adapter. Used to load gallery images in the gallery list.
 */
public class GalleryAdapter extends ArrayAdapter<GalleryModel> {
    private ArrayList<GalleryModel> galleryList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;
    private Context mContext;
    private ImageLoader imageLoader;

    public GalleryAdapter(Context context, int resource, ArrayList<GalleryModel> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        galleryList = objects;
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

        if (imageLoader.getDiskCache().get(galleryList.get(position).getFilePath()).exists())
            imageLoader.displayImage(galleryList.get(position).getFilePath(), holder.filePath, ((MainActivity) mContext).getOptionsWithoutFade());
        else
            imageLoader.displayImage(galleryList.get(position).getFilePath(), holder.filePath, ((MainActivity) mContext).getOptionsWithFade());


        return v;

    }

    /**
     * Defines gallery list row elements.
     */
    static class ViewHolder {
        public ImageView filePath;
    }


}