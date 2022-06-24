package com.example.viajesxyz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView jtvciudad,jtviva,jtvtotal;
    EditText jetcantidad;
    RadioButton jrbcartagena,jrbamazonas,jrbpuntacana;
    CheckBox jcbiva;
    Button jbtcalcular,jbtcancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esconder el titulo por defecto
        getSupportActionBar().hide();
        //Asociar objetos Java con objetos Xml
        jtvciudad=findViewById(R.id.tvciudad);
        jtviva=findViewById(R.id.tviva);
        jtvtotal=findViewById(R.id.tvtotal);
        jetcantidad=findViewById(R.id.etcantidad);
        jrbcartagena=findViewById(R.id.rbcartagena);
        jrbamazonas=findViewById(R.id.rbamazonas);
        jrbpuntacana=findViewById(R.id.rbpuntacana);
        jcbiva=findViewById(R.id.cbiva);
        jbtcalcular=findViewById(R.id.btcalcular);
        jbtcancelar=findViewById(R.id.btcancelar);
    }

    public void Calcular_viaje(View view){
        String cantidad;
        cantidad=jetcantidad.getText().toString();
        if (cantidad.isEmpty()){
            Toast.makeText(this, "Digite la cantidad de personas", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
        else{
            int cantidad_personas, valor_ciudad;
            float valor_iva,valor_viaje;
            cantidad_personas=Integer.parseInt(cantidad);
            if (jrbcartagena.isChecked()){
                valor_ciudad=600000;
                jtvciudad.setText("600000");
            }
            else{
                if (jrbamazonas.isChecked()){
                    valor_ciudad=2000000;
                    jtvciudad.setText("2000000");
                }
                else{
                    valor_ciudad=3000000;
                    jtvciudad.setText("3000000");
                }
            }
            if (jcbiva.isChecked()){
                valor_iva=(cantidad_personas * valor_ciudad) * 19/100;
                jtviva.setText(String.valueOf(valor_iva));
            }
            else{
                jtviva.setText("0");
                valor_iva=0;
            }
            valor_viaje=cantidad_personas * valor_ciudad  + valor_iva;
            jtvtotal.setText(String.valueOf(valor_viaje));
        }
    }

    public void Cancelar(View view){
        jetcantidad.setText("");
        jtvtotal.setText("0");
        jtviva.setText("0");
        jtvciudad.setText("600000");
        jrbcartagena.setChecked(true);
        jcbiva.setChecked(false);
        jetcantidad.requestFocus();
    }
}