package com.example.decolaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.decolaviagens.R;
import com.example.decolaviagens.model.Pacote;
import com.example.decolaviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        TextView preco = findViewById(R.id.pagamento_valor_final_textview);
        String moedaBrasileira = MoedaUtil.formataPreco(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);


    }
}