package drsdrs.project4.onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ds on 12/18/16.
 */

public class OnBoardingPagerAdapter extends FragmentPagerAdapter {

    public OnBoardingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OnBoardingWelcomeFragment.newInstance();
            case 1:
                return OnBoarding2ndFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
