package com.example.entregavelrestaurante.views.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregavelrestaurante.R;
import com.example.entregavelrestaurante.model.Prato;

public class DetalhePratoActivity extends AppCompatActivity {
    private ImageView fotoDetalhe;
    private TextView nomeDrtalhe;
    private TextView descricaoDetgalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);
        getSupportActionBar().hide();

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){
            Prato prato = getIntent().getExtras().getParcelable("RESTAURANTE");

            Drawable drawable = getResources().getDrawable(prato.getFotoPrato());
            fotoDetalhe.setImageDrawable((drawable));
            nomeDrtalhe.setText(prato.getNomePrato());
            descricaoDetgalhe.setText(prato.getDetalhePrato());
        }


    }

    public void initViews(){
        fotoDetalhe = findViewById(R.id.imagemDetalhePrato);
        nomeDrtalhe = findViewById(R.id.NomeDetalhePrato);
        descricaoDetgalhe = findViewById(R.id.textDescricaoPrato);
    }


}
