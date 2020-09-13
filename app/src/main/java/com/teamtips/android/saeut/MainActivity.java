package com.teamtips.android.saeut;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.teamtips.android.saeut.func.dashboard.CreatePostActivity;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_search) {
            showSearch();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSearch() {
        Snackbar.make(navigation, "Go to Search", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.view_pager);
        AppFragmentPageAdapter adapter = new AppFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        navigation = findViewById(R.id.navigation);
        BottomNavItemSelectedListener listener = new BottomNavItemSelectedListener(viewPager, toolbar);
        navigation.setOnNavigationItemSelectedListener(listener);
        bindNavigationDrawer();
        initTitle();
//        getAppKeyHash(); 해시키 알아내는 함수는 당분간 필요없음

    }

    private void initTitle() {
        toolbar.post(() -> toolbar.setTitle(navigation.getMenu().getItem(0).getTitle()));
    }

    private void bindNavigationDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(
                        this,
                        drawer,
                        toolbar,
                        R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        SideNavItemSelectedListener listener = new SideNavItemSelectedListener(drawer, navigation, getApplicationContext());
        navigationView.setNavigationItemSelectedListener(listener);
    }

    public void onFabClicked(View view) {
        Intent intent = new Intent(MainActivity.this, CreatePostActivity.class);
        startActivity(intent);
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
//                Log.e("Hash key", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (Exception e) {
            Log.e("name not found", e.toString());
        }
    }
}
