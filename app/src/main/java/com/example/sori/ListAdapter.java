package com.example.sori;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private ArrayList<String> dataSet;

    public ListAdapter() {
        dataSet = new ArrayList<>();
    }

    // 데이터를 입력
    public void setArrayData(String strData) {
        dataSet.add(strData);
    }

    //===== 뷰홀더 클래스 =====================================================
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    //========================================================================

    //----- 생성자 --------------------------------------
    // 생성자를 통해서 데이터를 전달받도록 함
    public ListAdapter (ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }
    //--------------------------------------------------

    @NonNull
    @Override   // ViewHolder 객체를 생성하여 리턴한다.
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ListAdapter.ViewHolder viewHolder = new ListAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override   // ViewHolder안의 내용을 position에 해당되는 데이터로 교체한다.
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        String text = dataSet.get(position);
        holder.textView.setText(text);
    }

    @Override   // 전체 데이터의 갯수를 리턴한다.
    public int getItemCount() {
        return dataSet.size();
    }
}
