package com.example.viewpageindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ViewPageIndicator extends RadioGroup {
    private int lineWidth;  //画线宽度
    private int visibleCount=3;
    private float mTranslationX = 0;//偏移量

    private Paint mPaint = new Paint();

    public ViewPageIndicator(Context context) {
        this(context, null);
    }
    public ViewPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(15f);

        TypedArray a = context.getResources().obtainAttributes(attrs,R.styleable.ViewPageIndicator);
        visibleCount = a.getInt(R.styleable.ViewPageIndicator_ViewPageIndicator_count,3);
        a.recycle();

        if(visibleCount < 3){
            visibleCount = 3;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        lineWidth = w / visibleCount;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(mTranslationX, getHeight());
        canvas.drawLine(0, 0, lineWidth, 0, mPaint);
        canvas.restore();
    }

    int i = 0;
    public void scroll(int position, float offset) {
        int tabwidth = getWidth()/visibleCount;
        mTranslationX = (int)(tabwidth * (offset + position));


        if(position > (visibleCount - 3) && offset>0 && (getChildCount()-2) > position ){
            if(visibleCount != 1){
                scrollTo((position - (visibleCount - 2)) * tabwidth + (int)(tabwidth * offset),0);
            }else{
                scrollTo(position * tabwidth + (int)(tabwidth * offset),0);
            }
        }

        invalidate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if(childCount == 0){
            return;
        }

        for (int i = 0;i < childCount;i++){
            View view = getChildAt(i);
            LinearLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
            lp.weight = 0;
            lp.width = getScreenWidth()/visibleCount;
            view.setLayoutParams(lp);
        }
    }

    private int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
