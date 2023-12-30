//package com.example.somaiyaclassroombookingapp;
//
//import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ViewPagerAdapter {
//
//    private final List<Fragment> fragmentList = new ArrayList<>();
//    private final List<String> fragmentTitleList = new ArrayList<>();
//
//    ViewPagerAdapter(FragmentManager manager) {
//        super(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        return fragmentList.get(position);
//    }
//
//
//    public int getCount() {
//        return fragmentList.size();
//    }
//
//    public void addFragment(Fragment fragment, String title) {
//        fragmentList.add(fragment);
//        fragmentTitleList.add(title);
//    }
//
//    @Nullable
//
//    public CharSequence getPageTitle(int position) {
//        return fragmentTitleList.get(position);
//    }
//}
//
//public static class FragmentOne extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_one, container, false);
//    }
//}
//
//public static class FragmentTwo extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_two, container, false);
//    }
//}
//
