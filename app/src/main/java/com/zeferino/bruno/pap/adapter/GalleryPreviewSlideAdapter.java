

package com.zeferino.bruno.pap.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import com.zeferino.bruno.pap.Constants;
import com.zeferino.bruno.pap.R;
import com.zeferino.bruno.pap.controller.GalleryPreviewDetail;


/**
 * The main adapter that backs the ViewPager. A subclass of FragmentStatePagerAdapter as there
 * could be a large number of items in the ViewPager and we don't want to retain them all in
 * memory at once but create/destroy them on the fly.
 */

public class GalleryPreviewSlideAdapter extends FragmentStatePagerAdapter {
    private final int mSize;
    private Resources res;
    private ArrayList<String> galleryList;

    public GalleryPreviewSlideAdapter(FragmentManager fm, Resources res, ArrayList<String> galleryList) {
        super(fm);
        this.res = res;
        this.galleryList = galleryList;
        mSize = galleryList.size();


    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mSize;
    }

    /**
     * Return the Fragment associated with a specified position.
     * @param position Position within this adapter
     * @return Unique identifier for the item at position
     */
    @Override
    public Fragment getItem(int position) {
        return GalleryPreviewDetail.newInstance(Constants.imageUrl + res.getString(R.string.galleryPreviewImgSize) + galleryList.get(position));
    }
}
