package com.example.decolaviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decolaviagens.util.DiasUtil;
import com.example.decolaviagens.util.MoedaUtil;
import com.example.decolaviagens.R;
import com.example.decolaviagens.util.ResourceUtil;
import com.example.decolaviagens.model.Pacote;

import java.util.List;

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
        String precoFinal = MoedaUtil.formataPreco(pacote.getPreco());
        preco.setText(precoFinal);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_dias_pacote_1);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_imagem_pacote_1);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context,pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local= viewCriada.findViewById(R.id.item_local_pacote_1);
        local.setText(pacote.getLocal());
    }
}
