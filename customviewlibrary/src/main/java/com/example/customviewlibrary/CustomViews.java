package com.example.customviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public interface CustomViews {

    void processAttributes(final Context context, final AttributeSet attrs);

    void initAttributes(TypedArray attrs);

    void initializeView();

}