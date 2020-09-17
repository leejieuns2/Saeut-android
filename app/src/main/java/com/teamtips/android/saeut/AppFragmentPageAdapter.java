package com.teamtips.android.saeut;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.teamtips.android.saeut.func.dashboard.DashboardFragment;
import com.teamtips.android.saeut.func.home.HomeFragment;
import com.teamtips.android.saeut.func.map.MapFragment;
import com.teamtips.android.saeut.func.profile.ProfileFragment;
import com.teamtips.android.saeut.func.timetable.ScheduleFragment;

class AppFragmentPageAdapter extends FragmentPagerAdapter {

  public AppFragmentPageAdapter(FragmentManager fm) {
    super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return HomeFragment.newInstance(1);
      case 1:
        return MapFragment.newInstance();
      case 2:
        return DashboardFragment.newInstance("Dashboard Test");
      case 3:
        return ScheduleFragment.newInstance();
      case 4:
        return ProfileFragment.newInstance();
      default:
        throw new RuntimeException("Not supported");
    }
  }

  @Override
  public int getCount() {
    return 5;
  }
}
