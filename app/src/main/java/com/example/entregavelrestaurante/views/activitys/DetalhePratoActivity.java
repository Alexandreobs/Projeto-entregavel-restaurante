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
            descricaoDetgalhe.setText("\"Vencedor do Prêmio Bom Gourmet em 2014 e 2015, a Conchiglia di gamberi com molho San Marino entra na categoria Melhor Massa em 2016 como hors-concours. A receita foi criada pelo proprietário Arnaldo Zanon há mais de dez anos. A massa em formato de concha é recheada com uma pasta de camarão e queijo. Já o molho San Marino é feito a base de queijo, creme e camarões médios");
        }


    }

    public void initViews(){
        fotoDetalhe = findViewById(R.id.imagemDetalhePrato);
        nomeDrtalhe = findViewById(R.id.NomeDetalhePrato);
        descricaoDetgalhe = findViewById(R.id.textDescricaoPrato);
    }


    }
