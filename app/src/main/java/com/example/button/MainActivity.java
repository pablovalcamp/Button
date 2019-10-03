package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // lo hacemos para cuando queremos cambiar de un punto a otro se muestre al momento que hemos cambiado


        RadioGroup radioGroup = findViewById(R.id.radioGrupEquipos);
        radioGroup.setOnCheckedChangeListener(this);

        // lisener CheckBox
        CheckBox checkBoxLocal = findViewById(R.id.checkBoxLocal);
        checkBoxLocal.setOnCheckedChangeListener(this);

        CheckBox checkBoxCamiseta = findViewById(R.id.checkBoxCamiseta);
        checkBoxCamiseta.setOnCheckedChangeListener(this);


    }
    public void isCheck (View v){
        CheckBox checkBox = findViewById(R.id.checkBoxLocal) ;
        CheckBox checkBox1 = findViewById(R.id.checkBoxCamiseta) ;

        if (checkBox.isChecked() == true)
            Toast.makeText(this, " Ha cambiado camiseta ", Toast.LENGTH_SHORT).show();
            if (checkBox1.isChecked() == true)
                Toast.makeText(this, "nn", Toast.LENGTH_SHORT).show();
        
    }
    public void mostrarValores (View v){
        String texto;
        RadioButton radioButton;
        RadioGroup radioGroup= findViewById(R.id.radioGrupEquipos);
        // para obtener la id del radio buton que ha solucionado el usuario
        int id = radioGroup.getCheckedRadioButtonId();
        // segun lo que quiera el usuario
        switch (id){
            case R.id.radioButton1: // buscar la id de ese radio buton
                Toast.makeText(this, "Hala Zaragoza", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(this, "Hala Huesca", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(this, "Hala Teruel", Toast.LENGTH_SHORT).show();
                break;

        }
    }


    // muestra con un toast el cambio
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) { //una referencia al radiobuton y una id del radio buton
        //
        RadioButton radioButton = findViewById(checkedId);
        Toast.makeText(this, radioButton.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == findViewById(R.id.checkBoxCamiseta))
        Toast.makeText(this, " Ha cambiado camiseta "+isChecked, Toast.LENGTH_SHORT).show();
        else if (buttonView == findViewById(R.id.checkBoxLocal))
            Toast.makeText(this, "Ha cambiado Local "+isChecked, Toast.LENGTH_SHORT).show();
    }

}
