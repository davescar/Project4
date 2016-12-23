package drsdrs.project4.onboarding;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;



import drsdrs.project4.R;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private OnBoardingPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mViewPager = (ViewPager) findViewById(R.id.first_time_login);
        mPagerAdapter = new OnBoardingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
    }
}
