package com.example.decolaviagens;

import androidx.annotation.NonNull;

public class DiasUtil {

    @NonNull
    public static String formataDiasEmTexto(int qtdeDias) {
        if (qtdeDias > 1){
            return qtdeDias + " dias";
        }
        return  qtdeDias + " dia" ;
    }
}
