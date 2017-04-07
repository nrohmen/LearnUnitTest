package com.dicoding.unittest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText edtPanjang, edtLebar;
    private TextView txtLuas;
    private Button btnHitung;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");
        renderView();
        presenter = new MainPresenter(this);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String panjang = edtPanjang.getText().toString().trim();
                    String lebar = edtLebar.getText().toString().trim();
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    presenter.hitungLuas(p, l);
                } catch (Exception e){
                    new AlertDialog.Builder(MainActivity.this).setTitle("Error").setMessage("Mohon isikan pnilai panjang dan lebar").show();
                }
            }
        });
    }

    public void renderView(){
        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);
    }

    @Override
    public void tampilLuas(MainModel model) {
        txtLuas.setText("Luas : " + model.getLuas());
    }
}