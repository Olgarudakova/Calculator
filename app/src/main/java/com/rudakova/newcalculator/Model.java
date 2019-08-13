package com.rudakova.newcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Model implements Calculator.Model {
    private boolean point = false;
    private double number = 0;
    private double fraction = 0;
    private double first = 0;
    private int operation = 0;
    private int operation1 = 0;
    private double result = 0;
    private double second = 0;
    private String result_end;
    private ArrayList<String> list_result = new ArrayList<>();

    @Override
    public void Number(int num) {
        if (point) {
            fraction = fraction * 10 + num;
            number++;
        } else {
            first = first * 10 + num;
        }
    }
    @Override
    public void Point() {
        point = true;
    }
    @Override
    public void Clean() {
        first = 0;
        fraction = 0;
        point = false;
        number = 0;
    }
    @Override
    public void PlusMinus(int sign) {
        if (operation == 0 || (operation == 1 && operation1 == 0)) {
            result = result + first + fraction / Math.pow(10.0, number);
            Clean();
            operation = sign;
        } else if (operation == 1 && operation1 == 3) {
            result = result + second * (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
            operation1 = 0;
        } else if (operation == 1 && operation1 == 4) {
            result = result + second / (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
            operation1 = 0;
        } else if (operation == 2 && operation1 == 0) {
            result = result - (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
            operation1 = 0;
        } else if (operation == 2 && operation1 == 3) {
            result = result - second * (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
            operation1 = 0;
        } else if (operation == 2 && operation1 == 4) {
            result = result - second / (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
            operation1 = 0;
        } else if (operation == 3) {
            result = result * (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
        } else if (operation == 4) {
            result = result / (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
        }
    }
    @Override
    public void MultiDivision(int sign) {
        if (operation == 0) {
            result = result + first + fraction / Math.pow(10.0, number);
            Clean();
            operation = sign;
        } else if (operation1 == 3) {
            second = second * (first + fraction / Math.pow(10.0, number));
            Clean();
            operation1 = sign;
        } else if (operation1 == 4) {
            second = second / (first + fraction / Math.pow(10.0, number));
            Clean();
            operation1 = sign;
        } else if (operation == 3) {
            result = result * (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
        } else if (operation == 4) {
            result = result / (first + fraction / Math.pow(10.0, number));
            Clean();
            operation = sign;
        } else if (operation == 2 || operation == 1) {
            second = first + fraction / Math.pow(10.0, number);
            Clean();
            operation1 = sign;
        }
    }
    @Override
    public String Equally() {
        if (operation == 1 && operation1 == 0) {
            result = result + first + fraction/Math.pow(10.0, number);
        }
        if (operation == 1 && operation1 == 3) {
            result = result + second * (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 1 && operation1 == 4) {
            result = result + second / (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 2 && operation1 == 0) {
            result = result - (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 2 && operation1 == 3) {
            result = result - second * (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 2 && operation1 == 4) {
            result = result - second / (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 3) {
            result = result * (first + fraction/Math.pow(10.0, number));
        }
        if (operation == 4) {
            result = result / (first + fraction/Math.pow(10.0, number));
        }

        result_end = Double.toString(result);
        list_result.add(result_end);

        second = 0;
        Clean();
        operation1 = 0;
        operation = 0;

        return(result_end);
    }

    @Override
    public void Delete() {
        Clean();
        operation = 0;
        operation1 = 0;
        second = 0;
        result = 0;
    }
    @Override
    public ArrayList<String> take_list () {
        return (list_result);
    }
}
