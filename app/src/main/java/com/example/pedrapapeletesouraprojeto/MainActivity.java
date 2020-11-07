package com.example.pedrapapeletesouraprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void selecionadoPedra(View view){

        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){

        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){

        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        //Escolha do app
        int numero = new Random().nextInt(3); //0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        //App ganhador
        if(
           (escolhaApp == "tesoura" && escolhaUsuario =="papel") ||
           (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
           (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) {
            textoResultado.setText("Você perdeu... :(");

        }//Usuario Ganhador
        else if(
            (escolhaApp == "tesoura" && escolhaUsuario == "pedra") ||
            (escolhaApp == "papel" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "pedra" && escolhaUsuario == "papel")
        ){
            textoResultado.setText("Você ganhou!! :)");
        } else { //Empate
            textoResultado.setText("EMPATE");
        }

        System.out.println(escolhaUsuario);
    }
}
