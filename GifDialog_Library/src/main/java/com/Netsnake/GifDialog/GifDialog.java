package com.Netsnake.GifDialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Netsnake on 23/04/2021
 */

public class GifDialog {
    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText;
        private int pBtnColor, nBtnColor, titleColor,messageColor;
        private Typeface font;
        private Activity activity;
        private GifDialogListener pListener, nListener;
        private boolean cancel;
        int gifImageResource;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setFont(Typeface font){
            this.font = font;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setColorTitle(int titleColor){
            this.titleColor = titleColor;
            return this;
        }

        public Builder setMessageColor(int messageColor){
            this.messageColor = messageColor;
            return this;
        }

        public Builder setPositiveBtnBackground(int pBtnColor) {
            this.pBtnColor = pBtnColor;
            return this;
        }


        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnBackground(int nBtnColor) {
            this.nBtnColor = nBtnColor;
            return this;
        }

        //set Positive listener
        public Builder OnPositiveClicked(GifDialogListener pListener) {
            this.pListener = pListener;
            return this;
        }

        //set Negative listener
        public Builder OnNegativeClicked(GifDialogListener nListener) {
            this.nListener = nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder setGifResource(int gifImageResource) {
            this.gifImageResource = gifImageResource;
            return this;
        }

        public void build() {
            TextView message1, title1;
            Button nBtn, pBtn;
            GifImageView gifImageView;
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(dialog.getWindow())
                    .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.gifdialog);

            //getting resources
            title1 = dialog.findViewById(R.id.title);
            message1 = dialog.findViewById(R.id.message);
            nBtn = dialog.findViewById(R.id.negativeBtn);
            pBtn = dialog.findViewById(R.id.positiveBtn);
            gifImageView = dialog.findViewById(R.id.gifImageView);
            gifImageView.setImageResource(gifImageResource);

            title1.setText(title);
            title1.setTypeface(font);

            if (titleColor != 0){
                int tcolor = titleColor;
                title1.setTextColor(tcolor);
            }
            message1.setText(message);
            message1.setTypeface(font);

            if (messageColor != 0){
                int mcolor = messageColor;
                message1.setTextColor(mcolor);
            }

            if (positiveBtnText != null) {
                pBtn.setText(positiveBtnText);
                pBtn.setTypeface(font);

                if (pBtnColor != 0) {
                    GradientDrawable bgShape = (GradientDrawable) pBtn.getBackground();
                    bgShape.setColor(pBtnColor);
                }

                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pListener != null) pListener.OnClick();
                        dialog.dismiss();
                    }

                });
            } else {
                pBtn.setVisibility(View.GONE);
            }

            if (negativeBtnText != null) {
                nBtn.setText(negativeBtnText);
                nBtn.setTypeface(font);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (nListener != null) nListener.OnClick();
                        dialog.dismiss();
                    }
                });

                if (nBtnColor != 0) {
                    GradientDrawable bgShape = (GradientDrawable) nBtn.getBackground();
                    bgShape.setColor(nBtnColor);
                }
            } else {
                nBtn.setVisibility(View.GONE);
            }

            dialog.show();

            new GifDialog();

        }
    }
}
