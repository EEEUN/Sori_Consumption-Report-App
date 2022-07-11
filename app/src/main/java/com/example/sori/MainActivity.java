package com.example.sori;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.sori.chart.ChartFragment;
import com.example.sori.list.ListFragment;
import com.example.sori.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout homeLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeLayout = findViewById(R.id.home_ly);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        BottomNavigationListener();
        bottomNavigationView.setSelectedItemId(R.id.tab_list);  //맨 처음 시작할 탭 설정
    }

    // 하단 네비게이션 바의 아이콘을 선택하면 해당 페이지로 이동
    private void BottomNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_list: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_ly, new ListFragment())
                                .commit();
                        return true;
                    }
                    case R.id.tab_chart: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_ly, new ChartFragment())
                                .commit();
                        return true;
                    }
                    case R.id.tab_setting: {
                        PreferenceSettings();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // PreferenceFragment
    private void PreferenceSettings() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_ly, new SettingFragment())
                .commit();

        SharedPreferences setting;
        setting = PreferenceManager.getDefaultSharedPreferences(this);
        setting.registerOnSharedPreferenceChangeListener((sp, key) -> {
            Log.d("tag", "클릭된 Preference의 key는 " + key);

            if (sp.getBoolean(key, false)) {
                Log.d("@@@", key + " on");
            } else {
                Log.d("@@@", key + " off");
            }
        });
    }
}