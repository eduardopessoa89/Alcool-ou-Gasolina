package com.example.alcoolougasolina;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText gasolina, alcool;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolina = findViewById(R.id.gasolina);
        alcool = findViewById(R.id.alcool);
        textoResultado = findViewById(R.id.ResultadotextView);
    }

    public void calcularPreco(View view){

        String precoAlcool = alcool.getText().toString();
        String precoGasolina = gasolina.getText().toString();

        Boolean result = validarCampos(precoAlcool, precoGasolina);

        if(result){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            if(fazerCalculo(valorAlcool, valorGasolina)){
                this.textoResultado.setText("Melhor Usar Alcool!!");
            }else{
                this.textoResultado.setText("Melhor Usar Gasolina!!");
            }
        }else{
            textoResultado.setText("Preencha os campos primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidos = true;
        if( pAlcool == null || pAlcool.equals("")){
            camposValidos = false;
        }else if ( pGasolina == null || pGasolina.equals("")){
            camposValidos = false;
        }
        return camposValidos;
    }

    public Boolean fazerCalculo(Double val1, Double val2){
        Double resultado = val1/val2;
        if(resultado <= 0.7){
            return true;
        }else{
            return false;
        }
    }
}
