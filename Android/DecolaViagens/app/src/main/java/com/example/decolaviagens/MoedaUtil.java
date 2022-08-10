package com.example.decolaviagens;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    @NonNull
    public static String formataPreco(BigDecimal valor) {
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formatoBR
                .format(valor)
                .replace("R$", "R$ ");
    }

}
