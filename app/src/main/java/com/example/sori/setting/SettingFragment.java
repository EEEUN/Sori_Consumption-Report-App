package com.example.sori.setting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sori.R;

/*
 * !! preference 사용해서 구현, 다크모드 구현 중요!(앱 종료 시 설정 유지)
 * 백업/복원은 가능하면 하고 안 되고 말고 -> 만들어야 함(데베 사용) : 파이어베이스 이용? SQL Lite - 설정에서 마지막 단계
 * 오픈소스 라이센스, 개인정보처리방침 : 누르면 조항 설명 뜨게
 * 개발자 소개: 닉네임, 메일(출시를 하면 욕을 많이 먹을 예정이므로 최소한의 개인정보만 공개하는 걸로~)
 */

public class SettingFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preference_screen, rootKey);
    }
}