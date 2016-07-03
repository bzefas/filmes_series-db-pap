

package com.zeferino.bruno.pap.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.zeferino.bruno.pap.MainActivity;
import com.zeferino.bruno.pap.R;
import com.zeferino.bruno.pap.controller.TVDetailsInfo;
import com.zeferino.bruno.pap.controller.TVDetailsOverview;
import com.zeferino.bruno.pap.controller.TVDetailsCast;

/**
 * TVDetailsSlide adapter used by the TV Details Viewpager.
 * Implementation of PagerAdapter that uses a Fragment to manage each page. This class also handles saving and restoring of fragment's state.
 */
public class TVDetailsSlideAdapter extends FragmentStatePagerAdapter {
    private String[] navMenuTitles;
    /*
     * We use registeredFragments so we can get our active fragments from the app.
     */
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();
    private MainActivity activity;

    public TVDetailsSlideAdapter(FragmentManager fm, Resources res, MainActivity activity) {
        super(fm);
        navMenuTitles = res.getStringArray(R.array.detailTabs);
        this.activity = activity;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position Position within this adapter
     * @return Unique identifier for the item at position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TVDetailsInfo info = new TVDetailsInfo();
                // info.setTitle(res.getString(R.string.moviesTitle));
                return info;
            case 1:
                TVDetailsCast cast = new TVDetailsCast();
                // info.setTitle(res.getString(R.string.moviesTitle));
                return cast;
            case 2:
                TVDetailsOverview overview = new TVDetailsOverview();
                // info.setTitle(res.getString(R.string.moviesTitle));
                return overview;
            default:
                return null;
        }

    }

    /**
     * This method may be called by the ViewPager to obtain a title string to describe the specified page.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return navMenuTitles[0];
            case 1:
                return navMenuTitles[1];
            case 2:
                return navMenuTitles[2];
            default:
                return navMenuTitles[1];
        }
    }

    /**
     * Create the page for the given position. The adapter is responsible for adding the view to the container given here,
     * although it only must ensure this is done by the time it returns from finishUpdate(ViewGroup).
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page. This does not need to be a View, but can be some other container of the page.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    /**
     * Remove a page for the given position. The adapter is responsible for removing the view from its container,
     * although it only must ensure this is done by the time it returns from finishUpdate(ViewGroup)
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position to be removed.
     * @param object    The same object that was returned by instantiateItem(View, int).
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    /**
     * Get the fragment for the current position
     *
     * @param position the fragment from the position.
     */
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    /**
     * We don't restore the state, because we already destroyed our fragments.
     * Else this will result in empty fragments.
     */
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        try {
            if (activity.getRestoreMovieDetailsAdapterState()) {
                super.restoreState(state, loader);
            } else {
                activity.setRestoreMovieDetailsAdapterState(true);
            }
        } catch (java.lang.IllegalStateException e) {

        }
    }

}