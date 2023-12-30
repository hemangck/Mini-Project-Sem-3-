package com.example.somaiyaclassroombookingapp;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class adminBmgmt extends AppCompatActivity {

//    private ListView penLV;
//    private CustomAdapter adapter;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bmgmt);

        logoutBtn = findViewById(R.id.logoutBtn);

        ViewPager viewPager = findViewById(R.id.viewPagerA);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabLayoutA);
        tabLayout.setupWithViewPager(viewPager);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent2 = new Intent(adminBmgmt.this,loginF.class);
//                startActivity(intent2);
            }
        });

    }



//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_one, container, false);
//
//        penLV = view.findViewById(R.id.penLV);
//        adapter = new CustomAdapter(getApplicationContext(), getSampleData());
//        penLV.setAdapter(adapter);
//
//        return view;
//    }
//
//
//
//    public class CustomAdapter extends ArrayAdapter<com.example.somaiyaclassroombookingapp.SampleData> {
//
//        Button approveBtn,cancelBtn;
//        TextView detailsLink,roleTVa,nameTVa,idTVa;
//        public CustomAdapter(Context context, ArrayList<com.example.somaiyaclassroombookingapp.SampleData> data) {
//            super(context, 0, data);
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(getContext()).inflate(R.layout.admin_lv_layout, parent, false);
//            }
//
//            // Get the data item for this position
//            com.example.somaiyaclassroombookingapp.SampleData item = getItem(position);
//
//            // Find and set the text for TextViews and Buttons
//            TextView detailsLink = convertView.findViewById(R.id.detailsLink);
//            detailsLink.setText(item.getText1());
//
//            TextView roleTVa = convertView.findViewById(R.id.roleTVa);
//            roleTVa.setText(item.getText2());
//
//            TextView nameTVa = convertView.findViewById(R.id.nameTVa);
//            nameTVa.setText(item.getText3());
//
//            TextView idTVa = convertView.findViewById(R.id.idTVa);
//            idTVa.setText(item.getText4());
//
//            Button approveBtn = convertView.findViewById(R.id.approveBtn);
//            approveBtn.setText(item.getButtonLabel1());
//
//            Button cancelBtn = convertView.findViewById(R.id.cancelBtn);
//            cancelBtn.setText(item.getButtonLabel2());
//
//            return convertView;
//        }
//    }
//
//    private static class SampleData {
//        private String text1, text2, text3, text4;
//        private String buttonLabel1, buttonLabel2;
//
//        public SampleData(String text1, String text2, String text3, String text4, String buttonLabel1, String buttonLabe2) {
//            this.text1 = text1;
//            this.text2 = text2;
//            this.text3 = text3;
//            this.text4 = text4;
//            this.buttonLabel1 = buttonLabel1;
//            this.buttonLabel2 = buttonLabe2;
//        }
//
//        public String getText1() {
//            return text1;
//        }
//
//        public String getText2() {
//            return text2;
//        }
//
//        public String getText3() {
//            return text3;
//        }
//
//        public String getText4() {
//            return text4;
//        }
//
//        public String getButtonLabel1() {
//            return buttonLabel1;
//        }
//
//        public String getButtonLabel2() {
//            return buttonLabel2;
//        }
//    }
//
//    private ArrayList<SampleData> getSampleData() {
//        ArrayList<SampleData> data = new ArrayList<>();
//        // Add your data here
//        data.add(new SampleData("text1", "text2","text3","text4","buttonLabel1","buttonLabel2"));
//        data.add(new SampleData("Item 2", "Button 2"));
//        data.add(new SampleData("Item 3", "Button 3"));
//        // Add more items as needed
//        return data;
//    }




    private void setupViewPager(ViewPager viewPager) {
        bookingMgmt.ViewPagerAdapter adapter = new bookingMgmt.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new bookingMgmt.FragmentOne(), "Today");
        adapter.addFragment(new bookingMgmt.FragmentTwo(), "Week");
        adapter.addFragment(new bookingMgmt.FragmentTwo(), "Month");
        viewPager.setAdapter(adapter);
    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }

    public static class FragmentOne extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_one, container, false);
        }
    }

    public static class FragmentTwo extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_two, container, false);
        }
    }

    public static class FragmentThree extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_three, container, false);
        }
    }
}
