package com.example.decolaviagens;

import androidx.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int qtdeDias) {
        if (qtdeDias > 1){
            return qtdeDias + PLURAL;
        }
        return  qtdeDias + SINGULAR;
    }
}
