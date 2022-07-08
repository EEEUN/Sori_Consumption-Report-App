package com.example.sori;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_ly, new SettingFragment())
                                .commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
