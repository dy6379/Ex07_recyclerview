package com.busanit.ex07_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();
//        adapter.addItem(new Person("김민수","010-1000-1000"));
//        adapter.addItem(new Person("김하늘","010-2000-2000"));
//        adapter.addItem(new Person("홍길동","010-3000-3000"));

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("ㄱㄱㄱ","010-1000-1000"));
        people.add(new Person("ㄴㄴㄴ","010-2000-2000"));
        people.add(new Person("ㄷㄷㄷ","010-3000-3000"));
        people.add(new Person("ㄹㄹㄹ","010-4000-4000"));
        people.add(new Person("ㅁㅁㅁ","010-5000-5000"));
        people.add(new Person("ㅂㅂㅂ","010-6000-6000"));
        people.add(new Person("ㅅㅅㅅ","010-7000-7000"));
        people.add(new Person("ㅇㅇㅇ","010-8000-8000"));
        people.add(new Person("ㅈㅈㅈ","010-9000-9000"));
        people.add(new Person("ㅊㅊㅊ","010-0000-0000"));
        adapter.setItems(people);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨 : "+item.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}