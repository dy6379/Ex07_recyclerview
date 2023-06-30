package com.busanit.ex07_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener{
    ArrayList<Person> items = new ArrayList<Person>();
    OnPersonItemClickListener listener;

    //2. RecyclerView.Adapter 상속및 메서드 생성
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item,parent,false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.textView.setText(item.getName());
        holder.textView2.setText(item.getMobile());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //3. 아이템 추가, 제거, 선택...
    //아이템 하나 추가하기
    public void addItem(Person item){
        items.add(item);
    }
    //여러 아이템 한번에 등록하기
    public void setItems(ArrayList<Person> items){
        this.items = items;
    }
    //아이템 선택시 해당 객체를 전달하기
    public Person getItem(int position){
        return items.get(position);
    }
    //특정 위치에 아이템 추가
    public void setItem(int position, Person item){
        items.set(position,item);
    }
    //4. implements 메서드 구현
    public void setOnItemClickListener(OnPersonItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(holder, view, position);
        }
    }

    //1. 내부 ViewHolder 클래스
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2;
    // 리스너 연결
        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener!=null){
                        listener.onItemClick(ViewHolder.this,v,position);
                    }
                }
            });
        }
    }
}
