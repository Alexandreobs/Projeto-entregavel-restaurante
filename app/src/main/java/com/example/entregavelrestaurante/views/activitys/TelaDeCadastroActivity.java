package com.example.entregavelrestaurante.views.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.entregavelrestaurante.R;
import com.google.android.material.textfield.TextInputLayout;

public class TelaDeCadastroActivity extends AppCompatActivity {
    private Button btnResgistroCadastro;

    private TextInputLayout inputNameCadastro;
    private TextInputLayout inputEmailCadastro;
    private TextInputLayout inputSenhaCadastro;
    private TextInputLayout inputRepeteSenhaCadastro;

    public static final String NOME_KEY = "nome";
    public static final String EMAIL_KEY = "email";
    public static final String SENHA_KEY = "password";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);

        initViews();

        getSupportActionBar().hide();

        btnResgistroCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaDados();
            }
        });


    }


    private void validaDados() {
        String nome = inputNameCadastro.getEditText().getText().toString();
        String email = inputEmailCadastro.getEditText().getText().toString();
        String senha = inputSenhaCadastro.getEditText().getText().toString();
        String repeteSenha = inputRepeteSenhaCadastro.getEditText().getText().toString();

        if (nome.isEmpty())  {
            inputNameCadastro.setError("Digite o nome!");

        } if (email.isEmpty()) {
            inputEmailCadastro.setError("Digite um email valido");

        } if(senha.isEmpty()){
            inputSenhaCadastro.setError("Digite uma Senha");

        } if (!senha.equals(repeteSenha)) {
            inputRepeteSenhaCadastro.setError("As senhas não batem");

        }else{
            enviaNomeActivity(nome,email,senha);
        }

    }

    private void initViews() {
        btnResgistroCadastro= findViewById(R.id.buttonCadastroRe);
        inputNameCadastro = findViewById(R.id.NomeCadastro);
        inputEmailCadastro = findViewById(R.id.emailCadastro);
        inputSenhaCadastro = findViewById(R.id.SenhaCadastro);
        inputRepeteSenhaCadastro = findViewById(R.id.SenhaCadastroConfirmar);
    }



    private void enviaNomeActivity(String nome,String email,String senha){
        Intent intent = new Intent(TelaDeCadastroActivity.this, TelaDeLoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NOME_KEY, nome);
        bundle.putString(EMAIL_KEY, email);
        bundle.putString(SENHA_KEY, senha);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
