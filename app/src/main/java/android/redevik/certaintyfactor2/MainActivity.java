package android.redevik.certaintyfactor2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double cfKulitNormal = 0;
    private double cfKulitBerminyak = 0;
    private double cfKulitKering = 0;

    // Normal Question
    private RadioGroup Qnormal1;
    private RadioGroup Qnormal2;
    private RadioGroup Qnormal3;
    private RadioGroup Qnormal4;
    private RadioGroup Qnormal5;
    private RadioGroup Qnormal6;
    private RadioGroup Qnormal7;

    // Minyak Question
    private RadioGroup Qminyak1;
    private RadioGroup Qminyak2;
    private RadioGroup Qminyak3;
    private RadioGroup Qminyak4;

    // Kering Question
    private RadioGroup Qkering1;
    private RadioGroup Qkering2;
    private RadioGroup Qkering3;
    private RadioGroup Qkering4;
    private RadioGroup Qkering5;

    private final double[] expertWeights = {
            0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, // Gejala kulit normal
            0.8, 0.8, 0.8, 0.8, // Gejala kulit berminyak
            0.6, 0.6, 0.8, 0.6, 0.6 // Gejala kulit kering
    };

    private void calculateNormal() {
        // CF untuk kulit normal //
        // Pertanyaan 1
        double hasil1 = 0;
        int selectedRadioButtonId1 = Qnormal1.getCheckedRadioButtonId();
        if (selectedRadioButtonId1 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId1);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil1 = expertWeights[0] * selectedValue;
        }

        // Pertanyaan 2
        double hasil2 = 0;
        int selectedRadioButtonId2 = Qnormal2.getCheckedRadioButtonId();
        if (selectedRadioButtonId2 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId2);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil2 = expertWeights[1] * selectedValue;
        }

        // Pertanyaan 3
        double hasil3 = 0;
        int selectedRadioButtonId3 = Qnormal3.getCheckedRadioButtonId();
        if (selectedRadioButtonId3 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId3);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil3 = expertWeights[2] * selectedValue;
        }

        // Pertanyaan 4
        double hasil4 = 0;
        int selectedRadioButtonId4 = Qnormal4.getCheckedRadioButtonId();
        if (selectedRadioButtonId4 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId4);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil4 = expertWeights[3] * selectedValue;
        }

        // Pertanyaan 5
        double hasil5 = 0;
        int selectedRadioButtonId5 = Qnormal5.getCheckedRadioButtonId();
        if (selectedRadioButtonId5 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId5);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil5 = expertWeights[4] * selectedValue;
        }

        // Pertanyaan 6
        double hasil6 = 0;
        int selectedRadioButtonId6 = Qnormal6.getCheckedRadioButtonId();
        if (selectedRadioButtonId6 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId6);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil6 = expertWeights[5] * selectedValue;
        }

        // Pertanyaan 7
        double hasil7 = 0;
        int selectedRadioButtonId7 = Qnormal7.getCheckedRadioButtonId();
        if (selectedRadioButtonId7 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId7);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil7 = expertWeights[6] * selectedValue;
        }

        double cfCombine1 = hasil1 + hasil2 * (1-hasil1);
        double cfcombine2 = cfCombine1 + hasil3 * (1-cfCombine1);
        double cfCombine3 = cfcombine2 + hasil4 * (1-cfcombine2);
        double cfCombine4 = cfCombine3 + hasil5 * (1-cfCombine3);
        double cfCombine5 = cfCombine4 + hasil6 * (1-cfCombine4);
        cfKulitNormal  = cfCombine5 + hasil7 * (1-cfCombine5);

    }

    private void calculateMinyak() {
        // Pertanyaan 1
        double hasil1 = 0;
        int selectedRadioButtonId1 = Qminyak1.getCheckedRadioButtonId();
        if (selectedRadioButtonId1 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId1);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil1 = expertWeights[7] * selectedValue;
        }

        // Pertanyaan 2
        double hasil2 = 0;
        int selectedRadioButtonId2 = Qminyak2.getCheckedRadioButtonId();
        if (selectedRadioButtonId2 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId2);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil2 = expertWeights[8] * selectedValue;
        }

        // Pertanyaan 3
        double hasil3 = 0;
        int selectedRadioButtonId3 = Qminyak3.getCheckedRadioButtonId();
        if (selectedRadioButtonId3 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId3);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil3 = expertWeights[9] * selectedValue;
        }

        // Pertanyaan 4
        double hasil4 = 0;
        int selectedRadioButtonId4 = Qminyak4.getCheckedRadioButtonId();
        if (selectedRadioButtonId4 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId4);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil4 = expertWeights[10] * selectedValue;
        }

        double cfCombine1 = hasil1 + hasil2 * (1-hasil1);
        double cfcombine2 = cfCombine1 + hasil3 * (1-cfCombine1);
        cfKulitBerminyak = cfcombine2 + hasil4 * (1-cfcombine2);
    }

    private void calculateKering() {
        // Pertanyaan 1
        double hasil1 = 0;
        int selectedRadioButtonId1 = Qkering1.getCheckedRadioButtonId();
        if (selectedRadioButtonId1 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId1);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil1 = expertWeights[11] * selectedValue;
        }

        // Pertanyaan 2
        double hasil2 = 0;
        int selectedRadioButtonId2 = Qkering2.getCheckedRadioButtonId();
        if (selectedRadioButtonId2 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId2);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil2 = expertWeights[12] * selectedValue;
        }

        // Pertanyaan 3
        double hasil3 = 0;
        int selectedRadioButtonId3 = Qkering3.getCheckedRadioButtonId();
        if (selectedRadioButtonId3 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId3);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil3 = expertWeights[13] * selectedValue;
        }

        // Pertanyaan 4
        double hasil4 = 0;
        int selectedRadioButtonId4 = Qkering4.getCheckedRadioButtonId();
        if (selectedRadioButtonId4 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId4);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil4 = expertWeights[14] * selectedValue;
        }

        // Pertanyaan 5
        double hasil5 = 0;
        int selectedRadioButtonId5 = Qkering5.getCheckedRadioButtonId();
        if (selectedRadioButtonId5 != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId5);
            double selectedValue = Double.parseDouble(selectedRadioButton.getText().toString());
            hasil5 = expertWeights[15] * selectedValue;
        }

        double cfCombine1 = hasil1 + hasil2 * (1-hasil1);
        double cfcombine2 = cfCombine1 + hasil3 * (1-cfCombine1);
        double cfcombine3 = cfcombine2 + hasil4 * (1-cfcombine2);
        cfKulitKering = cfcombine3 + hasil5 * (1-cfcombine3);
    }

    @SuppressLint("SetTextI18n")
    private void findBiggest(){

        TextView text_result = findViewById(R.id.text_result);

        if(cfKulitNormal > cfKulitBerminyak && cfKulitNormal > cfKulitKering){
            text_result.setText("Hasil Akhir: Kulit Normal");
        }
        else if(cfKulitBerminyak > cfKulitNormal && cfKulitBerminyak > cfKulitKering){
            text_result.setText("Hasil Akhir: Kulit Berminyak");
        }
        else if(cfKulitKering > cfKulitNormal && cfKulitKering > cfKulitBerminyak){
            text_result.setText("Hasil Akhir: Kulit Kering");
        }
        else{
            text_result.setText("Hasil Akhir: None");
        }
    }

    @SuppressLint("SetTextI18n")
    private void calculateResult() {

        TextView hasilNormal = findViewById(R.id.text_result_normal);
        String cfKulitNormalString = String.valueOf(cfKulitNormal);
        hasilNormal.setText("Persentase Kulit Normal: " + cfKulitNormalString);

        TextView hasilMinyak = findViewById(R.id.text_result_berminyak);
        String cfKulitMinyakString = String.valueOf(cfKulitBerminyak);
        hasilMinyak.setText("Persentase Kulit Minyak: " + cfKulitMinyakString);

        TextView hasilKering = findViewById(R.id.text_result_kering);
        String cfKulitKeringString = String.valueOf(cfKulitKering);
        hasilKering.setText("Persentase Kulit Kering: " + cfKulitKeringString);

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalculate = findViewById(R.id.button_calculate);

        // Normal
        Qnormal1 = findViewById(R.id.Qnormal1);
        Qnormal2 = findViewById(R.id.Qnormal2);
        Qnormal3 = findViewById(R.id.Qnormal3);
        Qnormal4 = findViewById(R.id.Qnormal4);
        Qnormal5 = findViewById(R.id.Qnormal5);
        Qnormal6 = findViewById(R.id.Qnormal6);
        Qnormal7 = findViewById(R.id.Qnormal7);

        // Minyak
        Qminyak1 = findViewById(R.id.Qminyak1);
        Qminyak2 = findViewById(R.id.Qminyak2);
        Qminyak3 = findViewById(R.id.Qminyak3);
        Qminyak4 = findViewById(R.id.Qminyak4);

        // Minyak
        Qkering1 = findViewById(R.id.Qkering1);
        Qkering2 = findViewById(R.id.Qkering2);
        Qkering3 = findViewById(R.id.Qkering3);
        Qkering4 = findViewById(R.id.Qkering4);
        Qkering5 = findViewById(R.id.Qkering5);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateNormal();
                calculateMinyak();
                calculateKering();
                calculateResult();
                findBiggest();
            }
        });
    }
}