package com.example.decolaviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.decolaviagens.R;
import com.example.decolaviagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes,Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        @SuppressLint("ViewHolder") View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote,
                parent, false);

        Pacote pacote = getItem(posicao);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_preco_pacote_1);
        String precoFinal = formataPreco(pacote);
        preco.setText(precoFinal);
    }

    @NonNull
    private String formataPreco(Pacote pacote) {
        BigDecimal valorPacote = pacote.getPreco();
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formatoBR
                .format(valorPacote)
                .replace("R$","R$ ");
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_dias_pacote_1);
        String diasEmTexto = formataDiasEmTexto(pacote);
        dias.setText(diasEmTexto);
    }

    @NonNull
    private String formataDiasEmTexto(Pacote pacote) {
        String diasEmTexto;
        int qtdeDias = pacote.getDias();
        if (qtdeDias > 1){
            diasEmTexto = qtdeDias + " dias";
        }else{
            diasEmTexto = qtdeDias + " dia" ;
        }
        return diasEmTexto;
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_imagem_pacote_1);
        Drawable drawableImagemPacote = devolveDrawable(pacote);
        imagem.setImageDrawable(drawableImagemPacote);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private Drawable devolveDrawable(Pacote pacote) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(),"drawable",context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local= viewCriada.findViewById(R.id.item_local_pacote_1);
        local.setText(pacote.getLocal());
    }
}
