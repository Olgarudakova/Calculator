package com.rudakova.newcalculator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainView extends AppCompatActivity implements Calculator.View {
    private Calculator.Presenter presenter;
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        presenter = new Presenter(this);
        text = findViewById(R.id.text);

        findViewById(R.id.bt_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onZeroClicked();
            }
        });
        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOneClicked();
            }
        });
        findViewById(R.id.bt_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTwoClicked();
            }
        });
        findViewById(R.id.bt_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onThreeClicked();
            }
        });
        findViewById(R.id.bt_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFourClicked();
            }
        });
        findViewById(R.id.bt_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFiveClicked();
            }
        });
        findViewById(R.id.bt_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSixClicked();
            }
        });
        findViewById(R.id.bt_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSevenClicked();
            }
        });
        findViewById(R.id.bt_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEightClicked();
            }
        });
        findViewById(R.id.bt_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNineClicked();
            }
        });
        findViewById(R.id.bt_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPointClicked();
            }
        });
        findViewById(R.id.bt_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPlusClicked();
            }
        });
        findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDeleteClicked();
            }
        });
        findViewById(R.id.bt_division).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDivisionClicked();
            }
        });
        findViewById(R.id.bt_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMinusClicked();
            }
        });
        findViewById(R.id.bt_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMultiClicked();
            }
        });
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });
        findViewById(R.id.bt_equally).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEquallyClicked();
            }
        });

        ArrayList<String> list_result = new ArrayList<>();
        MyObject myObj = new MyObject(list_result);
        Intent intent = new Intent(MainView.this, StartView.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObj);
        startActivity(intent);
    }

    @Override
    public void sendText(String text) {
        this.text.setText(this.text.getText().toString() + text);
    }
    @Override
    public void DeleteText() {
        this.text.setText("");
    }
    @Override
    public void ReturnScreen(ArrayList<String> list_result) {
        MyObject myObj = new MyObject(list_result);
        Intent intent = new Intent(MainView.this, StartView.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObj);
        startActivity(intent);
    }
    @Override
    public void goNextScreen() { }
}
