package com.example.entregavelrestaurante.views.activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregavelrestaurante.R;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.entregavelrestaurante.views.activitys.TelaDeCadastroActivity.EMAIL_KEY;
import static com.example.entregavelrestaurante.views.activitys.TelaDeCadastroActivity.SENHA_KEY;

public class TelaDeLoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegistrar;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_login);

        getSupportActionBar().hide();



        initViews();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                String emailDigitado = textInputLayoutEmail.getEditText().getText().toString();
                String senhaDigitada = textInputLayoutSenha.getEditText().getText().toString();

                recebeBundleEValida(emailDigitado,senhaDigitada);

            }


        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaDeLoginActivity.this, TelaDeCadastroActivity.class));
            }
        });


    }


    private void recebeBundleEValida(String emailDigitado,String senhaDigitada) {
        String email = "";
        String password = "";
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            email = bundle.getString(EMAIL_KEY);
            password = bundle.getString(SENHA_KEY);

            assert password != null;
            assert email != null;
            if (email.equals(emailDigitado) &&
                    (password.equals(senhaDigitada))) {

                startActivity(new Intent(TelaDeLoginActivity.this, MainActivity.class));
            }  else {
                alert("Login ou senha incorretos");


            }
        }
    }



    private String validaDado(String dadoRecebido, String dadoDigitado) {
        if (!dadoDigitado.equals(dadoRecebido)) {

        }
        return dadoDigitado;
    }

    private void alert(String frase) {
        Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
    }

    private void initViews() {
        btnLogin = findViewById(R.id.buttonLogar);
        btnRegistrar = findViewById(R.id.buttonRegistar);
        textInputLayoutEmail = findViewById(R.id.EmailLogin);
        textInputLayoutSenha = findViewById(R.id.Senhalogin);
    }
}