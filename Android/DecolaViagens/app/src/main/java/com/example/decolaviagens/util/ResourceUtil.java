package com.example.decolaviagens.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable devolveDrawable(Context context, String drawableEmTexto ) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE,context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
