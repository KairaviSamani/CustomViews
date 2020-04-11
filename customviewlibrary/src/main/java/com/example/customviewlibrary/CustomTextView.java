package com.example.customviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView implements CustomViews {

    private int borderWidth = 0;

    private float radius = 0;

    @ColorInt
    private int borderColor = Color.parseColor("#00000000");

    @ColorInt
    private int backgroundColor = Color.parseColor("#00000000");

    private Drawable backgroundImage;

    public CustomTextView(Context context) {
        super(context);
        initializeView();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        processAttributes(context, attrs);
        initializeView();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        processAttributes(context, attrs);
        initializeView();
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        initializeView();
    }

    public int getBorderWidth() {
        return borderWidth;
    }


    public void setBorderColor(int color) {
        this.borderColor = color;
        initializeView();
    }

    public int getBorderColor() {
        return this.borderColor;
    }


    public void setRadius(float size) {
        this.radius = size;
        initializeView();
    }

    public float getRadius() {
        return radius;
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
        initializeView();
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundImage(Drawable imageDrawable) {
        this.backgroundImage = imageDrawable;
        initializeView();
    }

    public Drawable getBackgroundImage() {
        return this.backgroundImage;
    }

    @Override
    public void processAttributes(final Context context, final AttributeSet attrs) {
        TypedArray attrsArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0);
        initAttributes(attrsArray);
        attrsArray.recycle();
    }

    @Override
    public void initAttributes(TypedArray attrs) {
        try {
            radius = attrs.getDimension(R.styleable.CustomTextView_custom_radius, radius);
            borderColor = attrs.getColor(R.styleable.CustomTextView_custom_borderColor, borderColor);
            borderWidth = (int) attrs.getDimension(R.styleable.CustomTextView_custom_borderWidth, borderWidth);
            backgroundImage = attrs.getDrawable(R.styleable.CustomTextView_custom_background);
            backgroundColor = attrs.getColor(R.styleable.CustomTextView_custom_background, backgroundColor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initializeView() {
        CustomDrawableHelper helper = new CustomDrawableHelper.Builder()
                .setBackgroundColor(backgroundColor)
                .setBorderWidth(borderWidth)
                .setBorderColor(borderColor)
                .setRadius((int) radius)
                .setBackgroundImage(backgroundImage)
                .build();
        helper.setBackground(this);
    }

}