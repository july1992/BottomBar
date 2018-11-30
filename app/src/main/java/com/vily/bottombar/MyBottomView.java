package com.vily.bottombar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * description :
 * Author : Vily
 * Date : 2018/11/30
 * Time : 12:05
 */

public class MyBottomView extends LinearLayoutCompat {

    private View mView;
    private ImageView mIv_icon;
    private TextView mTv_title;
    private Drawable mIcon;
    private LinearLayout mLly_bottom;

    // 第一个是new 一个对象的时候调用。
    public MyBottomView(Context context) {
        this(context,null);
    }

    // 第二个是在XML文件声明的时候调用。
    public MyBottomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    // 系统默认只会调用前两个构造函数,至于第三个构造函数的调用,通常是我们自己在构造函数中主动调用的。
    @SuppressLint("RestrictedApi")
    public MyBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.MyBottomView, defStyleAttr, 0);

            Drawable icon = a.getDrawable(R.styleable.MyBottomView_icon);

            if (icon != null) {
                setIcon(icon);
            }


            String title = a.getString(R.styleable.MyBottomView_title);
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            }

            a.recycle();
        }


    }

    public void setTitle(String title) {
        if(mTv_title!=null ){
            mTv_title.setText(title);
        }
    }

    public void setIcon(Drawable icon) {
        if(mIv_icon!=null ){

            mIv_icon.setImageDrawable(icon);
        }
    }


    private void init() {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        if(mView==null){
            mView = inflater.inflate(R.layout.layout_bottomview, this, true);

            mIv_icon = mView.findViewById(R.id.iv_icon);
            mTv_title = mView.findViewById(R.id.tv_title);
            mLly_bottom = mView.findViewById(R.id.lly_bottom);


        }

    }


}
