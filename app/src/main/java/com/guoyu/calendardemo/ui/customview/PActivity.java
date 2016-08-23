package com.guoyu.calendardemo.ui.customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.guoyu.calendardemo.R;

/**
 * Created by gyz on 2016/8/22.
 */
public class PActivity extends AppCompatActivity{


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);

        myView.loadLogo();

        setContentView(myView);

    }



    private class MyView extends View {

        public MyView(Context context) {

            super(context);

        }

        Bitmap bLogo;

        private final Paint mPaint = new Paint();

        /**

         * 装在logo

         */

        public void loadLogo() {

            Resources r = this.getContext().getResources();

            Drawable logo = r.getDrawable(R.drawable.ic_launcher);

            Bitmap bitmap = Bitmap.createBitmap(200, 100,

                    Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(bitmap);

            logo.setBounds(0, 0, 200, 100);

            logo.draw(canvas);

            bLogo = bitmap;

        }

        protected void onDraw(Canvas canvas) {

            if(bLogo != null){

                canvas.drawBitmap(bLogo, 0, 0, mPaint);

            }

        }

    }

}
