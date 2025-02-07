package com.merv.toast.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/*
Created by b3ddo dev. (BERDAN ÇAKIR)
Date: 2025-02-07
Time: 19:21 UTC
*/
public class MervToastMessage {

    /* Toast Type */
    public static final int MERV_TYPE_INFO = 0;
    public static final int MERV_TYPE_ERROR = 1;
    public static final int MERV_TYPE_SUCCESS = 2;
    public static final int MERV__TYPE_WARNING = 3;

    /* Gravity position*/
    public static final int MERV__GRAVITY_CENTER = Gravity.CENTER;
    public static final int MERV__GRAVITY_BOTTOM = Gravity.BOTTOM;
    public static final int MERV__GRAVITY_TOP = Gravity.TOP;

    /* Animation type: */
    public static final int MERV_LEFT_ANIMATION = 0;
    public static final int MERV_RIGHT_ANIMATION = 1;
    public static final int MERV_FADE_ANIMATION = 2;
    public static final int MERV_TOP_ANIMATION = 3;
    public static final int MERV_BOTTOM_ANIMATION = 4;

    /* The context of the application */
    private final Context mContext;

    /* The message to be displayed on the toast */
    private String mText;
    /* The text color of the toast */
    private int mTextColor = 0xFFFFFF;
    /* The size of the text */
    private float mTextSize = 15f;
    /* The font type for the text */
    private Typeface mTypeFace;

    /* The icon displayed on the toast */
    private Drawable mIcon;
    /* The tint color applied to the icon */
    private int mIconTint = 0xFFFFFF;

    /* The gravity (position) of the toast */
    private int mGravity = MERV__GRAVITY_BOTTOM;
    /* The animation effect applied to the toast */
    private int mAnimation = MERV_FADE_ANIMATION;

    /* The duration for which the toast is shown */
    private int mScreenTime = 1000;
    /* The duration of the animation */
    private int mAnimationDuration = 500;

    /* The elevation (shadow) of the toast */
    private float mElevation = 0f;
    /* The corner radius of the toast background */
    private int mRadius = 10;

    /* Default margin values for the toast */ int mDefMarginStart = 50;
    int mDefMarginTop = 50;
    int mDefMarginEnd = 50;
    int mDefMarginBottom = 50;

    /* Layout ID used for custom positioning */ int mLayoutID = -1;

    /* Background color of the toast */
    private int mBackgroundColor = 0xFFFFFFFF;

    @SuppressLint("StaticFieldLeak")
    /* Reference to the currently active toast view */ private static View mActiveMervView = null;

    /* Flag to check if the necessary methods are called */
    boolean mToastTypeFlag = false;
    boolean mToastShownFlag = false;

    /* Initialize the context */
    private MervToastMessage(Context mContext) {
        this.mContext = mContext;
    }

    /* Create an instance with the given context */
    public static MervToastMessage with(Context mContext) {
        return new MervToastMessage(mContext);
    }

    /* Remove any active toast view before showing the new one */
    public void setMervShow() {
        if (!mToastTypeFlag) {
            throw new IllegalStateException("setToastType must be called before setMervShow.");
        }

        if (mActiveMervView != null) {
            ((FrameLayout) ((AppCompatActivity) mContext).findViewById(android.R.id.content)).removeView(mActiveMervView);
        }

        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        @SuppressLint("InflateParams") View mMervView = mLayoutInflater.inflate(R.layout.custom_merv_toast_message_layout, null); /* Inflate custom toast layout */

        LinearLayout mLinear = mMervView.findViewById(R.id.toast_message_merv_linear);
        TextView mTitle = mMervView.findViewById(R.id.toast_message_merv_title);
        ImageView mIcon = mMervView.findViewById(R.id.toast_message_merv_icon);

        mTitle.setText(this.mText);
        mTitle.setTypeface(mTypeFace);
        mTitle.setTextColor(mTextColor);
        mTitle.setTextSize(mTextSize);

        if (this.mIcon != null) {
            mIcon.setImageDrawable(this.mIcon);
            mIcon.setColorFilter(mIconTint);
            mIcon.setVisibility(View.VISIBLE);
        } else {
            mIcon.setVisibility(View.GONE);
        }

        GradientDrawable mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(mBackgroundColor);
        mGradientDrawable.setCornerRadius(mRadius);
        mLinear.setBackground(mGradientDrawable);
        mMervView.setElevation(mElevation);

        View mLayoutView = ((AppCompatActivity) mContext).findViewById(mLayoutID);

        /* Set layout parameters (position, margins) */
        FrameLayout.LayoutParams mParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (mLayoutView != null) {
            if (mGravity == MERV__GRAVITY_TOP) {
                mParams.gravity = Gravity.TOP;
                mParams.setMargins(mDefMarginStart, mLayoutView.getHeight() + mDefMarginTop, mDefMarginEnd, mDefMarginBottom);
            } else if (mGravity == MERV__GRAVITY_BOTTOM) {
                mParams.gravity = Gravity.BOTTOM;
                mParams.setMargins(mDefMarginStart, mDefMarginTop, mDefMarginEnd, mLayoutView.getHeight() + mDefMarginBottom);
            } else {
                mParams.gravity = Gravity.CENTER;
            }
        } else {
            mParams.gravity = mGravity;
            mParams.setMargins(mDefMarginStart, mDefMarginTop, mDefMarginEnd, mDefMarginBottom);
        }

        ((AppCompatActivity) mContext).addContentView(mMervView, mParams);

        mActiveMervView = mMervView;

        Animation mEnterAnimation;
        Animation mExitAnimation;

        /* Set animation based on the selected animation type */
        switch (mAnimation) {
            case MERV_LEFT_ANIMATION:
                mEnterAnimation = AnimationController.LeftEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.RightExitController(mContext, mAnimationDuration);
                break;
            case MERV_RIGHT_ANIMATION:
                mEnterAnimation = AnimationController.RightEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.LeftExitController(mContext, mAnimationDuration);
                break;
            case MERV_FADE_ANIMATION:
                mEnterAnimation = AnimationController.FadeEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.FadeExitController(mContext, mAnimationDuration);
                break;
            case MERV_TOP_ANIMATION:
                mEnterAnimation = AnimationController.TopEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.TopExitController(mContext, mAnimationDuration);
                break;
            case MERV_BOTTOM_ANIMATION:
                mEnterAnimation = AnimationController.BottomEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.BottomExitController(mContext, mAnimationDuration);
                break;
            default:
                mEnterAnimation = AnimationController.LeftEnterController(mContext, mAnimationDuration);
                mExitAnimation = AnimationController.LeftExitController(mContext, mAnimationDuration);
                break;
        }

        /* Start the animation */
        mMervView.startAnimation(mEnterAnimation);
        mMervView.postDelayed(() -> {
            mMervView.startAnimation(mExitAnimation);
            mExitAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation mAnimation) {
                }

                @Override
                public void onAnimationEnd(Animation mAnimation) {
                    /* Remove the toast view after the animation ends */
                    ((FrameLayout) ((AppCompatActivity) mContext).findViewById(android.R.id.content)).removeView(mMervView);
                    mActiveMervView = null;
                }

                @Override
                public void onAnimationRepeat(Animation mAnimation) {
                }
            });
        }, Math.max(0, mScreenTime - mAnimationDuration));
        mToastShownFlag = true;
    }

    /* Setter methods for customizing the toast */
    public MervToastMessage setToastType(int mSetToastType) {
        mToastTypeFlag = true;
        switch (mSetToastType) {
            case MERV_TYPE_SUCCESS:
                this.mIcon = ContextCompat.getDrawable(mContext, R.drawable.ic_success_circle);
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_SUCCESS);
                break;
            case MERV_TYPE_ERROR:
                this.mIcon = ContextCompat.getDrawable(mContext, R.drawable.ic_error_circle);
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_RED);
                break;
            case MERV__TYPE_WARNING:
                this.mIcon = ContextCompat.getDrawable(mContext, R.drawable.ic_warning_triangle);
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_YELLOW);
                break;
            case MERV_TYPE_INFO:
            default:
                this.mIcon = ContextCompat.getDrawable(mContext, R.drawable.ic_info_circle);
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_BLUE);
                break;
        }
        return this;
    }

    public MervToastMessage setText(String mText) {
        this.mText = mText;
        return this;
    }

    public MervToastMessage setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        return this;
    }

    public MervToastMessage setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        return this;
    }

    public MervToastMessage setFont(int mSetFont) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                this.mTypeFace = mContext.getResources().getFont(mSetFont);
            }
        } catch (Exception mException) {
            mException.printStackTrace();
        }
        return this;
    }

    public MervToastMessage setGravity(int mGravity) {
        this.mGravity = mGravity;
        return this;
    }

    public MervToastMessage setAnimation(int mAnimation) {
        this.mAnimation = mAnimation;
        return this;
    }

    public MervToastMessage setScreenTime(int mScreenTime) {
        this.mScreenTime = mScreenTime;
        return this;
    }

    public MervToastMessage setAnimationDuration(int mDuration) {
        this.mAnimationDuration = mDuration;
        return this;
    }

    public MervToastMessage setRadius(int mRadius) {
        this.mRadius = mRadius;
        return this;
    }

    public MervToastMessage mSetLayoutID(int mSetLayoutID) {
        this.mLayoutID = mSetLayoutID;
        return this;
    }

    public MervToastMessage setElevation(float mElevation) {
        this.mElevation = mElevation;
        return this;
    }

    public MervToastMessage setMargin(int mMarginStart, int mMarginTop, int mMarginEnd, int mMarginBottom) {
        this.mDefMarginStart = mMarginStart;
        this.mDefMarginTop = mMarginTop;
        this.mDefMarginEnd = mMarginEnd;
        this.mDefMarginBottom = mMarginBottom;
        return this;
    }
}