package com.teamtips.android.saeut.func.login.join.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.teamtips.android.saeut.R;
import com.teamtips.android.saeut.func.login.join.ui.generalLogin.LoginActivity;

public class JoinFragment_additional extends Fragment {

    private JoinViewModel mViewModel = new JoinViewModel();
    private final static String Tag = "JoinFragment_additional";

    private FragmentManager fragmentManager;

    public JoinFragment_additional(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sign_up_additional, container, false);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
