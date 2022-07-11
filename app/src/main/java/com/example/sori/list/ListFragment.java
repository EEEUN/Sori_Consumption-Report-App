package com.example.sori.list;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sori.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private TextView viewPopup, datePopup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        viewPopup = view.findViewById(R.id.view_form_popup);
        datePopup = view.findViewById(R.id.date_popup);
        recyclerView = view.findViewById(R.id.list_recyceler_view);

        // about RecyclerView
        recyclerView.setHasFixedSize(true);
        listAdapter = new ListAdapter(buildItemList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setRecycledViewPool(viewPool);

        viewPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(viewPopup);
            }
        });

        datePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(datePopup);
            }
        });

        return view;
    }

    // 상위아이템 큰박스 아이템을 10개 만듭니다. (내역추가 기능 추가 시 삭제 예정)
    private List<ListItem> buildItemList() {
        List<ListItem> itemList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ListItem listItem = new ListItem(i + "번째 아이템", buildSubItemList());
            itemList.add(listItem);
        }
        return itemList;
    }
    // 그안에 존재하는 하위 아이템 박스(3개씩 보이는 아이템들) (내역추가 기능 추가 시 삭제 예정)
    private List<ListSubItem> buildSubItemList() {
        List<ListSubItem> subItemList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ListSubItem listSubItem = new ListSubItem("Sub Item "+i, "Description "+i);
            subItemList.add(listSubItem);
        }
        return subItemList;
    }


    private void showPopupMenu(View view) {
        final PopupMenu popupMenu = new PopupMenu(getActivity().getApplicationContext(), view);
        if(view == viewPopup) {
            popupMenu.getMenuInflater().inflate(R.menu.list_viewform_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.popup_list) {
                        Toast.makeText(getActivity().getApplicationContext(), "리스트", Toast.LENGTH_SHORT).show();
                        // 리스트뷰로 전환
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "캘린더", Toast.LENGTH_SHORT).show();
                        // 캘린더뷰로 전환
                    }
                    return false;
                }
            });
        } else {
            popupMenu.getMenuInflater().inflate(R.menu.list_date_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch(menuItem.getItemId()) {
                        case R.id.popup_full:
                            Toast.makeText(getActivity().getApplicationContext(), "전체", Toast.LENGTH_SHORT).show();
                            // 전체 날짜 보기 전환
                            return true;

                        case R.id.popup_month:
                            Toast.makeText(getActivity().getApplicationContext(), "이번 달", Toast.LENGTH_SHORT).show();
                            // 이번 달 보기 전환
                            return true;

                        case R.id.popup_year:
                            Toast.makeText(getActivity().getApplicationContext(), "이번 연도", Toast.LENGTH_SHORT).show();
                            // 이번 연도 보기 전환
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        popupMenu.show();
    }
}