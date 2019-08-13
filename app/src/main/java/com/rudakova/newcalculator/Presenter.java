package com.rudakova.newcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Presenter implements Calculator.Presenter {
    private final Calculator.Model model;
    private final Calculator.View view;

    public Presenter(Calculator.View view) {
        this.view = view;
        model = new Model();
    }

    @Override
    public void onZeroClicked() {
        model.Number(0);
        view.sendText("0");
    }
    @Override
    public void onOneClicked() {
        model.Number(1);
        view.sendText("1");
    }
    @Override
    public void onTwoClicked() {
        model.Number(2);
        view.sendText("2");
    }
    @Override
    public void onThreeClicked() {
        model.Number(3);
        view.sendText("3");
    }
    @Override
    public void onFourClicked() {
        model.Number(4);
        view.sendText("4");
    }
    @Override
    public void onFiveClicked() {
        model.Number(5);
        view.sendText("5");
    }
    @Override
    public void onSixClicked() {
        model.Number(6);
        view.sendText("6");
    }
    @Override
    public void onSevenClicked() {
        model.Number(7);
        view.sendText("7");
    }
    @Override
    public void onEightClicked() {
        model.Number(8);
        view.sendText("8");
    }
    @Override
    public void onNineClicked() {
        model.Number(9);
        view.sendText("9");
    }
    @Override
    public void onPointClicked() {
        model.Point();
        view.sendText(",");
    }
    @Override
    public void onPlusClicked() {
        model.PlusMinus(1);
        view.sendText("+");
    }
    @Override
    public void onMinusClicked() {
        model.PlusMinus(2);
        view.sendText("-");
    }
    @Override
    public void onMultiClicked() {
        model.MultiDivision(3);
        view.sendText("x");
    }
    @Override
    public void onDivisionClicked() {
        model.MultiDivision(4);
        view.sendText("/");
    }
    @Override
    public void onCalculatorClicked() {
        view.goNextScreen();
    }
    @Override
    public void onBackClicked() {
        ArrayList<String> list_result = model.take_list();
        view.ReturnScreen(list_result);
    }
    @Override
    public void onDeleteClicked() {
        model.Delete();
        view.DeleteText();
    }
    @Override
    public void onEquallyClicked() {
        view.sendText("=");
        view.sendText(model.Equally());
    }
}
