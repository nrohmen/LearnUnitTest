package com.dicoding.unittest;

/**
 * Created by rohmen on 1/5/17.
 */

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public double luas(double panjang, double lebar) {
        return panjang * lebar;
    }

    public void hitungLuas(double panjang, double lebar) {
        double luas = luas(panjang, lebar);
        MainModel model = new MainModel(luas);
        view.tampilLuas(model);
    }


}
