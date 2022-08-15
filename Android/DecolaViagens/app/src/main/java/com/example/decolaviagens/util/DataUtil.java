package com.example.decolaviagens.util;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String dataIdaFormatada = formatoBrasileiro.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta.getTime());
        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }



}
