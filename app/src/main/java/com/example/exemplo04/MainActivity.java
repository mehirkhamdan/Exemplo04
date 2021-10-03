package com.example.exemplo04;

import static android.graphics.Typeface.ITALIC;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText edtTexto;
    private Button bntInput;
    private TextView txtTexto;
    private SeekBar skbLetra;
    private TextView txtValue;
    private CheckBox ckbNegrito;
    private CheckBox ckbItalico;
    private CheckBox ckbMaiusculo;
    private RadioButton rdbVermelho;
    private RadioButton rdbAzul;
    private RadioButton rdbVerde;
    private RadioGroup rdgColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = findViewById(R.id.edtTexto);
        bntInput = findViewById(R.id.bntInput);
        txtTexto = findViewById(R.id.txtTexto);
        skbLetra = findViewById(R.id.skbLetra);
        txtValue = findViewById(R.id.txtValue);
        ckbItalico = findViewById(R.id.ckbItalico);
        ckbMaiusculo = findViewById(R.id.ckbMaiusculo);
        ckbNegrito = findViewById(R.id.ckbNegrito);
        rdbAzul = findViewById(R.id.rdbAzul);
        rdbVerde = findViewById(R.id.rdbVerde);
        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdgColor = findViewById(R.id.rdgColor);


        bntInput.setOnClickListener(this);
        rdgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                boolean vermChecked;
                if ((rdbVermelho).isChecked()) vermChecked = true;
                else vermChecked = false;

                boolean azulChecked = (rdbAzul).isChecked();

                boolean verdeChecked = (rdbVerde).isChecked();

                if (vermChecked) {
                    txtTexto.setTextColor(Color.RED);
                } else if (azulChecked) {
                    txtTexto.setTextColor(Color.BLUE);
                } else if (verdeChecked) {
                    txtTexto.setTextColor(Color.GREEN);
                }

            }


        });

        skbLetra.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar skbSeekBar, int progress, boolean fromUser) {
                txtTexto.setTextSize(progress);
                skbLetra.setMax(80);
                txtValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar skbSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar skSeekBar) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bntInput) {
            txtTexto.setText(edtTexto.getText());

        }
    }

    public void onCheckBoxClicked(View view) {

        if (ckbItalico.isChecked() && ckbNegrito.isChecked() && ckbMaiusculo.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), Typeface.BOLD_ITALIC);
            txtTexto.setText(txtTexto.getText().toString().toUpperCase());

        } else if (ckbItalico.isChecked() && ckbNegrito.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), Typeface.BOLD_ITALIC);
            txtTexto.setText(txtTexto.getText().toString().toLowerCase());

        } else if (ckbItalico.isChecked() && ckbMaiusculo.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), ITALIC);
            txtTexto.setText(txtTexto.getText().toString().toUpperCase());

        } else if (ckbNegrito.isChecked() && ckbMaiusculo.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), Typeface.BOLD);
            txtTexto.setText(txtTexto.getText().toString().toUpperCase());

        } else if (ckbItalico.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), ITALIC);
            txtTexto.setText(txtTexto.getText().toString().toLowerCase());


        } else if (ckbNegrito.isChecked()) {
            txtTexto.setTypeface(txtTexto.getTypeface(), Typeface.BOLD);
            txtTexto.setText(txtTexto.getText().toString().toLowerCase());

        } else if (ckbMaiusculo.isChecked()) {
            txtTexto.setText(txtTexto.getText().toString().toUpperCase());

        } else {
            ckbItalico.setTypeface(null, Typeface.NORMAL);
            txtTexto.setTypeface(null, Typeface.NORMAL);
            ckbNegrito.setTypeface(null, Typeface.NORMAL);
            txtTexto.setTypeface(null, Typeface.NORMAL);
            txtTexto.setText(txtTexto.getText().toString().toLowerCase());
        }

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}