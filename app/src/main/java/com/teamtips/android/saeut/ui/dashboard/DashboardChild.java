package com.teamtips.android.saeut.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.teamtips.android.saeut.R;
import com.teamtips.android.saeut.ui.dashboard.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class DashboardChild extends Fragment {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.

    private DashboardViewModel dashboardViewModel;
    private DashboardChildAdapter dashboardChildAdapter;
    private ListView listView;
    private ArrayList<Post> postArrayList;

    int position; // taglayout 구별하기 위한 일종의 flag라고 이해함

    public DashboardChild(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard_child, container, false);

        TextView textView = root.findViewById(R.id.tv_child);

        postArrayList = new ArrayList<Post>();

        Calendar cal = Calendar.getInstance();
        Date nowDate = cal.getTime();

        postArrayList.add(new Post(1234, 1234, "title1", nowDate, "서울시 서대문구 북가좌동"));
        postArrayList.add(new Post(1434, 1214, "title2", nowDate, "서울시 서대문구 북가좌동"));
        postArrayList.add(new Post(1334, 1224, "title3", nowDate, "서울시 서대문구 북가좌동"));
        postArrayList.add(new Post(1534, 1254, "title4", nowDate, "서울시 서대문구 북가좌동"));
        postArrayList.add(new Post(1734, 1264, "title5", nowDate, "서울시 서대문구 북가좌동"));

        dashboardChildAdapter = new DashboardChildAdapter(root.getContext(), R.layout.adapter_dashboard, postArrayList);
        listView = root.findViewById(R.id.lv_child);

        listView.setAdapter(dashboardChildAdapter);

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s + position);
            }
        });

        // view 클릭 시 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 상세 페이지 뜨도록 정의해야 함.
                // 이 때 로그인 여부 체크
                // 기타 등등 ...
            }
        });

        return root;
    }
}
