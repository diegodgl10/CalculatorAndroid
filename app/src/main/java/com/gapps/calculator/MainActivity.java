package com.gapps.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResultado;
    DigitalCalculator calculator = new DigitalCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
    }

    public void escribeCero(View view) {
        calculator.enterZero();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeUno(View view) {
        calculator.enterOne();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeDos(View view) {
        calculator.enterTwo();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeTres(View view) {
        calculator.enterThree();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeCuatro(View view) {
        calculator.enterFour();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeCinco(View view) {
        calculator.enterFive();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeSeis(View view) {
        calculator.enterSix();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeSiete(View view) {
        calculator.enterSeven();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeOcho(View view) {
        calculator.enterEight();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribeNueve(View view) {
        calculator.enterNine();
        tvResultado.setText(calculator.getOperation());
    }

    public void escribePunto(View view) {
        calculator.enterPoint();
        tvResultado.setText(calculator.getOperation());
    }

    public void limpiar(View view) {
        calculator.clearData();
        tvResultado.setText(calculator.getOperation());
    }

    public void operacionSuma(View view) {
        if (calculator.getMemory() != 0) {
            calculator.addMemory();
        }
        calculator.enterAdd();
        tvResultado.setText(calculator.getOperation());
    }

    public void operacionResta(View view) {
        if (calculator.getMemory() != 0) {
            calculator.addMemory();
        }
        calculator.enterSubtraction();
        tvResultado.setText(calculator.getOperation());
    }

    public void operacionProducto(View view) {
        if (calculator.getMemory() != 0) {
            calculator.addMemory();
        }
        calculator.enterProduct();
        tvResultado.setText(calculator.getOperation());
    }

    public void operacionDividir(View view) {
        if (calculator.getMemory() != 0) {
            calculator.addMemory();
        }
        calculator.enterDivide();
        tvResultado.setText(calculator.getOperation());
    }

    public void operacionResultado(View view) {
        if (!(calculator.isClean())) {
            try {
                double resultado;
                resultado = calculator.enterEqual();
                tvResultado.setText(Double.toString(resultado));
            } catch (ArithmeticException e) {
                tvResultado.setText("Error");
                calculator.clearData();
            }
        }
    }
}