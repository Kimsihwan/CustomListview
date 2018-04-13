package com.example.test.customlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);



        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image01), "첫번째사진", "첫번째내용");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image02), "2번째사진", "2번째내용");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.image03), "3번째사진", "3번째내용");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          ListViewItem item = (ListViewItem) adapterView.getItemAtPosition(i);


          String titleStr = item.getTitleStr();
          String descStr = item.getDescStr();
                Drawable iconDrawable = item.getIconDrawable();
                Toast.makeText(MainActivity.this, titleStr, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
