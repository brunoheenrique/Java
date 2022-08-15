package com.example.decolaviagens.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.decolaviagens.R;
import com.example.decolaviagens.model.Pacote;
import com.example.decolaviagens.util.DiasUtil;
import com.example.decolaviagens.util.MoedaUtil;
import com.example.decolaviagens.util.ResourceUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraDias(pacoteSaoPaulo);
        mostraPrecoFinal(pacoteSaoPaulo);
        mostraDataViagem(pacoteSaoPaulo);
    }

    private void mostraDataViagem(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_datas_textview);
        String dataFormatadaDaViagem = periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    @NonNull
    private String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoBrasileiro.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta.getTime());
        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }

    private void mostraPrecoFinal(Pacote pacote) {
        TextView precoFinal = findViewById(R.id.resumo_valor_final_textview);
        String moedaBrasileira = MoedaUtil.formataPreco(pacote.getPreco());
        precoFinal.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_dias_textview);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imageview);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this,
                pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_local_textview);
        local.setText(pacote.getLocal());
    }
}