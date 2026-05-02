package com.example.mb_huy_bt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    List<Item> doiDungList;
    List<Item> linhKienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        doiDungList = new ArrayList<>();
        doiDungList.add(new Item("Sách", "Sách học tập", R.drawable.ic_item));
        doiDungList.add(new Item("Thước kẻ", "Thước kẻ 30cm", R.drawable.ic_item));
        doiDungList.add(new Item("Bút chì", "Bút chì 2B", R.drawable.ic_item));
        doiDungList.add(new Item("Tẩy", "Tẩy trắng", R.drawable.ic_item));

        linhKienList = new ArrayList<>();
        linhKienList.add(new Item("Tai nghe", "Tai nghe bluetooth", R.drawable.ic_item));
        linhKienList.add(new Item("Ốp lưng", "Ốp lưng điện thoại", R.drawable.ic_item));
        linhKienList.add(new Item("Chuột", "Chuột không dây", R.drawable.ic_item));
        linhKienList.add(new Item("USB", "USB 32GB", R.drawable.ic_item));
        linhKienList.add(new Item("Bàn phím không dây", "Bàn phím bluetooth", R.drawable.ic_item));

        String[] categories = {"Đồ dùng", "Linh kiện"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    showItems(doiDungList);
                } else {
                    showItems(linhKienList);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = (Item) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", selectedItem.getName());
                intent.putExtra("description", selectedItem.getDescription());
                intent.putExtra("iconRes", selectedItem.getIconRes());
                startActivity(intent);
            }
        });
    }

    private void showItems(List<Item> items) {
        ItemAdapter adapter = new ItemAdapter(this, items);
        listView.setAdapter(adapter);
    }
}