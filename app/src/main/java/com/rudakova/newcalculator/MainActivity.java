package com.rudakova.newcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

interface Calculator {
    interface View {
        void sendText(String text);
        void goNextScreen();
        void ReturnScreen(ArrayList<String> list_result);
        void DeleteText();
    }
    interface Presenter {
        void onCalculatorClicked();
        void onZeroClicked();
        void onOneClicked();
        void onTwoClicked();
        void onThreeClicked();
        void onFourClicked();
        void onFiveClicked();
        void onSixClicked();
        void onSevenClicked();
        void onEightClicked();
        void onNineClicked();
        void onPlusClicked();
        void onPointClicked();
        void onDeleteClicked();
        void onDivisionClicked();
        void onMultiClicked();
        void onBackClicked();
        void onEquallyClicked();
        void onMinusClicked();
    }
    interface Model {
        void Number(int num);
        void Clean();
        void Point();
        void PlusMinus(int sign);
        void MultiDivision(int sign);
        String Equally();
        ArrayList<String> take_list();
        void Delete();
    }
}
