package com.example.customviewlibrary;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;

class CustomDrawableHelper {

    private Builder mBuilder;

    private CustomDrawableHelper(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    static class Builder {

        private int radius = 0;

        private int borderWidth = 0;

        private Drawable backgroundImage;

        @ColorInt
        private int borderColor = Color.parseColor("#00000000");

        @ColorInt
        private int backgroundColor = Color.parseColor("#00000000");;

        int getRadius() {
            return radius;
        }

        Builder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        int getBorderWidth() {
            return borderWidth;
        }

        Builder setBorderWidth(int borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }

        int getBackgroundColor() {
            return backgroundColor;
        }

        Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        int getBorderColor() {
            return borderColor;
        }

        Builder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        Drawable getBackgroundImage() {
            return backgroundImage;
        }

        Builder setBackgroundImage(Drawable backgroundImage) {
            this.backgroundImage = backgroundImage;
            return this;
        }

        CustomDrawableHelper build() {
            return new CustomDrawableHelper(this);
        }
    }

    private Drawable setupBackground() {
        Drawable drawable = new GradientDrawable();
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(mBuilder.getBackgroundColor());

            if (mBuilder.getBorderWidth() > 0) {
                gradientDrawable.setStroke(mBuilder.getBorderWidth(), mBuilder.getBorderColor());
            }

            gradientDrawable.setCornerRadius(mBuilder.getRadius());

            if (mBuilder.getBackgroundImage() != null) {

                Drawable[] drawables = {gradientDrawable, mBuilder.getBackgroundImage()};

                LayerDrawable layerDrawable = new LayerDrawable(drawables);
                layerDrawable.setLayerInset(1, mBuilder.getBorderWidth(), mBuilder.getBorderWidth(), mBuilder.getBorderWidth(), mBuilder.getBorderWidth());
                drawable = layerDrawable;
            } else {
                drawable = gradientDrawable;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return drawable;

    }

    void setBackground(View view) {
        Drawable drawable = setupBackground();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }
}