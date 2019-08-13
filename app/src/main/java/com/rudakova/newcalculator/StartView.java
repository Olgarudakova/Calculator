package com.rudakova.newcalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StartView extends AppCompatActivity implements Calculator.View {
    private Calculator.Presenter presenter;
    RecyclerView recyclerView;
    ArrayList<String> list_result = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        presenter = new Presenter(this);
        recyclerView = findViewById(R.id.list);
        MyObject myObj = (MyObject) getIntent().getParcelableExtra(
                MyObject.class.getCanonicalName());
        MyAdapter adapter = new MyAdapter(StartView.this, myObj.list_result);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        findViewById(R.id.bt_calculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCalculatorClicked();
            }
        });
    }

    @Override
    public void goNextScreen() {
        finish();
    }
    @Override
    public void ReturnScreen(ArrayList<String> list_result) { }
    @Override
    public void sendText(String text) { }
    @Override
    public void DeleteText() { }
}
