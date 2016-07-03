

package com.zeferino.bruno.pap.adapter;

import com.zeferino.bruno.pap.model.GenresModel;
import com.zeferino.bruno.pap.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Genres adapter. Used to load genres information in the genres list.
 */
public class GenresAdapter extends ArrayAdapter<GenresModel> {
    private ArrayList<GenresModel> genresList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;

    public GenresAdapter(Context context, int resource, ArrayList<GenresModel> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        genresList = objects;
    }

    /**
     * Get a View that displays the data at the specified position in the data set.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using.
     * @param parent      The parent that this view will eventually be attached to.
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.name = (TextView) v.findViewById(R.id.name);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.name.setText(genresList.get(position).getName());


        return v;

    }

    /**
     * Defines genres list row elements.
     */
    static class ViewHolder {
        public TextView name;
    }

}