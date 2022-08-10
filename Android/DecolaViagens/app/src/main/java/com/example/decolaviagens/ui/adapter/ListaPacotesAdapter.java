package com.example.decolaviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decolaviagens.R;
import com.example.decolaviagens.dao.PacoteDAO;
import com.example.decolaviagens.model.Pacote;

import org.w3c.dom.Text;

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
    };

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
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(posicao);

        TextView local= viewCriada.findViewById(R.id.item_local_pacote_1);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_imagem_pacote_1);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(),"drawable",context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_dias_pacote_1);
        String diasEmTexto="";
        int qtdeDias = pacote.getDias();
        if (qtdeDias > 1){
            diasEmTexto = qtdeDias + " dias";
        }else{
            diasEmTexto = qtdeDias + " dia" ;
        }
        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.item_preco_pacote_1);
        BigDecimal valorPacote = pacote.getPreco();
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String precoFinal = formatoBR
                .format(valorPacote)
                .replace("R$","R$ ");
        preco.setText(precoFinal);

        return viewCriada;
    }
}
