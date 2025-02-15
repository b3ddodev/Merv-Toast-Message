package com.merv.toast.library;

import static com.merv.toast.library.Utils.MervIconSelect.getIconForType;
import static com.merv.toast.library.Utils.MervIconSelect.getIconsForType;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.merv.toast.library.Animation.AnimationIconController;
import com.merv.toast.library.Animation.AnimationToastController;
import com.merv.toast.library.Utils.MervAnimationType;
import com.merv.toast.library.Utils.MervGravityType;
import com.merv.toast.library.Utils.MervIconAnimationType;
import com.merv.toast.library.Utils.MervIconSelect;
import com.merv.toast.library.Utils.MervToastType;

import java.util.List;

/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2025 b3ddo dEV' (github.com/b3ddodev)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * **/

public class MervToastMessage {
    /**
     * The context of the application
     */
    private final Context mContext;

    /**
     * The message text to be displayed in the toast
     */
    private String mText = "b3ddo dEV' All Right Reserved.";

    /**
     * The color of the text in the toast
     */
    private int mTextColor = Color.WHITE;

    /**
     * The size of the text in the toast
     */
    private float mTextSize = 15f;

    /**
     * Controls whether the text should be displayed in all uppercase letters.
     */
    private boolean mTextAllCaps = false;

    /**
     * The font style for the text
     */
    private Typeface mTypeFace;

    /**
     * The icon drawable to be displayed in the toast
     */
    private Drawable mIconDrawable;

    /**
     * The tint color for the icon
     */
    private int mIconTint = 0xFFFFFF;

    /**
     * Holds the type of icon animation to be applied.
     * By default, it is set to the "empty" animation which means no animation is applied to the icon.
     */
    private MervIconAnimationType mIconAnimation = MervIconAnimationType.MERV_ICON_EMPTY_ANIMATION;

    /**
     * The duration for the icon animation in milliseconds.
     * Default is set to 500 milliseconds (0.5 seconds).
     * This value controls how long the icon animation lasts before completing.
     */
    private int mIconAnimationDuration = 500;

    /**
     * The gravity (position) of the toast (top, bottom, or center)
     */
    private MervGravityType mGravity = MervGravityType.MERV_GRAVITY_BOTTOM;

    /**
     * The type of animation for the toast
     */
    private MervAnimationType mToastAnimation = MervAnimationType.MERV_FADE_ANIMATION;


    /**
     * The duration the toast stays on screen (in milliseconds)
     */
    private int mScreenTime = 3000;

    /**
     * The duration of the animation (in milliseconds)
     */
    private int mToastAnimationDuration = 500;

    /**
     * The elevation of the toast view (used for shadows)
     */
    private float mElevation = 50f;

    /**
     * The radius for rounded corners of the toast's background
     */
    private int mRadius = 15;

    /**
     * The width of the stroke (border) around the toast
     */
    private int mStrokeWidth = 0;

    /**
     * The color of the stroke (border)
     */
    private int mStrokeColor = Color.TRANSPARENT;

    /**
     * Default start margin for positioning
     */
    private int mDefMarginStart = 50;

    /**
     * Default top margin for positioning
     */
    private int mDefMarginTop = 50;

    /**
     * Default end margin for positioning
     */
    private int mDefMarginEnd = 50;

    /**
     * Default bottom margin for positioning
     */
    private int mDefMarginBottom = 50;

    /**
     * Layout ID for the custom view to add the toast in
     */
    private int mLayoutIdentification = -1;

    /**
     * The background color of the toast
     */
    private int mBackgroundColor = 0xFFFFFFFF;

    /**
     * The enter animation for the toast
     */
    Animation mEnterAnimation;

    /**
     * The exit animation for the toast
     */
    Animation mExitAnimation;

    /**
     * The current active toast view being displayed
     */
    @SuppressLint("StaticFieldLeak")
    private static View mActiveMervView = null;

    /**
     * Flag to check if the toast type has been set
     */
    boolean mToastTypeFlag = false;

    /**
     * Flag to check if the toast is currently being shown
     */
    boolean mToastShownFlag = false;

    /**
     * Constructor to initialize the MervToastMessage object with a context.
     *
     * @param mContext Context of the calling activity.
     */
    private MervToastMessage(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Static method to create a new MervToastMessage instance with a context.
     *
     * @param mContext Context of the calling activity.
     * @return A new MervToastMessage instance.
     */
    public static MervToastMessage with(Context mContext) {
        return new MervToastMessage(mContext);
    }

    /**
     * Sets the toast to be shown. If another toast is already displayed, it will be removed first.
     */
    public void setShowToastMessage() {
        if (!mToastTypeFlag) {
            throw new IllegalStateException("setToastType must be called before setMervShow.");
        }

        if (mActiveMervView != null) {
            ToastAnimationController(mActiveMervView);

            mActiveMervView.startAnimation(mExitAnimation);
            mExitAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation mAnimation) {
                }

                @Override
                public void onAnimationEnd(Animation mAnimation) {
                    ((FrameLayout) ((AppCompatActivity) mContext).findViewById(android.R.id.content)).removeView(mActiveMervView);
                    mActiveMervView = null;

                    ShowNewToastMessage();
                }

                @Override
                public void onAnimationRepeat(Animation mAnimation) {
                }
            });
        } else {
            ShowNewToastMessage();
        }
    }

    /**
     * Displays a new toast message with the current settings for text, icon, background, etc.
     * -
     * This method is responsible for creating and displaying a custom toast message on the screen.
     * It allows customization of various aspects such as:
     * - Text content: Set the text message to be displayed.
     * - Text appearance: Customize the text color, size, font (typeface), and whether it should be in all caps.
     * - Icon: Optionally, an icon can be added to the toast with a specified drawable resource, color tint, and visibility.
     * - Background: The background color, corner radius for rounded corners, border stroke width and color, and elevation (shadow effect) can be customized.
     * - Positioning: The toast can be positioned at the top, bottom, or center of the screen with adjustable margins.
     * -
     * The method inflates a custom toast layout, configures the UI elements (TextView, ImageView), applies the given customizations,
     * and then displays the toast at the specified position on the screen.
     */
    private void ShowNewToastMessage() {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        @SuppressLint("InflateParams") View mMervView = mLayoutInflater.inflate(R.layout.custom_merv_toast_message_layout, null);

        LinearLayout mLinear = mMervView.findViewById(R.id.toast_message_merv_linear);
        AppCompatTextView mTitle = mMervView.findViewById(R.id.toast_message_merv_title);
        AppCompatImageView mIcon = mMervView.findViewById(R.id.toast_message_merv_icon);

        mTitle.setText(this.mText);
        mTitle.setTextColor(mTextColor);
        mTitle.setTextSize(mTextSize);
        mTitle.setAllCaps(mTextAllCaps);
        mTitle.setTypeface(mTypeFace);


        mIcon.setScaleType(ImageView.ScaleType.CENTER);

        if (mIconDrawable != null) {
            mIcon.setImageDrawable(this.mIconDrawable);
            mIcon.setColorFilter(mIconTint);
            mIcon.setVisibility(View.VISIBLE);
        } else {
            mIcon.setVisibility(View.GONE);
        }

        IconAnimationController(mIcon);

        GradientDrawable mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(mBackgroundColor);
        mGradientDrawable.setCornerRadius(mRadius);
        mGradientDrawable.setStroke(mStrokeWidth, mStrokeColor);
        mMervView.setElevation(mElevation);
        mLinear.setBackground(mGradientDrawable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mMervView.setOutlineSpotShadowColor(mBackgroundColor);
        }

        View mLayoutView = ((AppCompatActivity) mContext).findViewById(mLayoutIdentification);

        FrameLayout.LayoutParams mParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        if (mLayoutView != null) {
            if (mGravity.getGravityValue() == Gravity.TOP) {
                mParams.gravity = Gravity.TOP;
                mParams.setMargins(mDefMarginStart, mLayoutView.getHeight() + mDefMarginTop, mDefMarginEnd, mDefMarginBottom);
            } else if (mGravity.getGravityValue() == Gravity.BOTTOM) {
                mParams.gravity = Gravity.BOTTOM;
                mParams.setMargins(mDefMarginStart, mDefMarginTop, mDefMarginEnd, mLayoutView.getHeight() + mDefMarginBottom);
            } else {
                mParams.gravity = Gravity.CENTER;
            }
        } else {
            mParams.gravity = mGravity.getGravityValue();
            mParams.setMargins(mDefMarginStart, mDefMarginTop, mDefMarginEnd, mDefMarginBottom);
        }

        ((AppCompatActivity) mContext).addContentView(mMervView, mParams);

        mActiveMervView = mMervView;
        ToastAnimationController(mMervView);
    }

    private void IconAnimationController(AppCompatImageView mIcon) {
        if (mIcon != null && this.mIconAnimation != null && mIcon.getVisibility() == View.VISIBLE) {
            Animation mAnimation = null;
            switch (this.mIconAnimation) {
                case MERV_ICON_SHAKE_ANIMATION:
                    mAnimation = AnimationIconController.ShakeAnimation(mContext, mIconAnimationDuration, mIcon);
                    break;
                case MERV_ICON_BEAT_ANIMATION:
                    mAnimation = AnimationIconController.BeatAnimation(mContext, mIconAnimationDuration);
                    break;
                case MERV_ICON_FADE_ANIMATION:
                    AnimationIconController.FadeAnimation(mContext, mIconAnimationDuration, mIcon);
                    break;
                case MERV_ICON_BEAT_FADE_ANIMATION:
                    AnimationIconController.BeatFadeAnimation(mContext, mIconAnimationDuration, mIcon);
                    break;
                case MERV_ICON_EMPTY_ANIMATION:
                default:
                    mAnimation = AnimationIconController.EmptyAnimation(mContext);
                    break;
            }

            if (mAnimation != null) {
                mIcon.startAnimation(mAnimation);
            }
        }
    }

    /**
     * Sets up the toast animations for showing and dismissing the toast.
     *
     * @param mMervView The view representing the toast message.
     */
    public void ToastAnimationController(@NonNull View mMervView) {
        switch (mToastAnimation) {
            case MERV_LEFT_ANIMATION:
                mEnterAnimation = AnimationToastController.LeftEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.RightExitController(mContext, mToastAnimationDuration);
                break;
            case MERV_RIGHT_ANIMATION:
                mEnterAnimation = AnimationToastController.RightEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.LeftExitController(mContext, mToastAnimationDuration);
                break;
            case MERV_FADE_ANIMATION:
                mEnterAnimation = AnimationToastController.FadeEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.FadeExitController(mContext, mToastAnimationDuration);
                break;
            case MERV_TOP_ANIMATION:
                mEnterAnimation = AnimationToastController.TopEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.TopExitController(mContext, mToastAnimationDuration);
                break;
            case MERV_BOTTOM_ANIMATION:
                mEnterAnimation = AnimationToastController.BottomEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.BottomExitController(mContext, mToastAnimationDuration);
                break;
            case MERV_BLINK_ANIMATION:
                mEnterAnimation = AnimationToastController.BlinkEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.BlinkExitController(mContext, mToastAnimationDuration);
                break;
            default:
                mEnterAnimation = AnimationToastController.LeftEnterController(mContext, mToastAnimationDuration);
                mExitAnimation = AnimationToastController.LeftExitController(mContext, mToastAnimationDuration);
                break;
        }

        mMervView.startAnimation(mEnterAnimation);
        mMervView.postDelayed(() -> {
            mMervView.startAnimation(mExitAnimation);
            mExitAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation mAnimation) {
                }

                @Override
                public void onAnimationEnd(Animation mAnimation) {
                    ((FrameLayout) ((AppCompatActivity) mContext).findViewById(android.R.id.content)).removeView(mMervView);
                    mActiveMervView = null;
                }

                @Override
                public void onAnimationRepeat(Animation mAnimation) {
                }
            });
        }, Math.max(0, mScreenTime - mToastAnimationDuration));
        mToastShownFlag = true;
    }

    /**
     * Sets the toast type and icon for the MervToast message.
     * This method checks if the selected icon is compatible with the toast type,
     * and assigns the appropriate background color and icon tint based on the toast type.
     *
     * @param mToastType    The type of the toast message (SUCCESS, ERROR, WARNING, INFO).
     * @param mSelectedIcon The icon to be used for the toast message.
     * @return The current instance of MervToastMessage for method chaining.
     **/
    public MervToastMessage setToastType(@NonNull MervToastType mToastType, MervIconSelect mSelectedIcon) {
        mToastTypeFlag = true;

        List<MervIconSelect> mAvailableIcons = getIconsForType(mToastType);

        if (mSelectedIcon == null || !mAvailableIcons.contains(mSelectedIcon)) {
            mSelectedIcon = getIconForType(mToastType, mSelectedIcon);
        }

        this.mIconDrawable = ContextCompat.getDrawable(mContext, mSelectedIcon.getResourceIdentification());

        switch (mToastType) {
            case MERV_TYPE_SUCCESS:
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_SUCCESS);
                break;
            case MERV_TYPE_ERROR:
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_RED);
                break;
            case MERV_TYPE_WARNING:
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_YELLOW);
                break;
            case MERV_TYPE_INFO:
            default:
                this.mIconTint = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_WHITE);
                this.mBackgroundColor = ContextCompat.getColor(mContext, R.color.MERV_TOASTER_BLUE);
                break;
        }
        return this;
    }

    /**
     * Sets the text message to be displayed in the toast.
     *
     * @param mText The text of the toast message.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setText(String mText) {
        this.mText = mText;
        return this;
    }

    /**
     * Sets the color of the text in the toast.
     *
     * @param mTextColor The color value of the text.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        return this;
    }

    /**
     * Sets the size of the text in the toast.
     *
     * @param mTextSize The size of the text.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        return this;
    }

    /**
     * Sets whether the text should be displayed in all uppercase letters.
     *
     * @param mTextAllCaps True to display text in uppercase, false otherwise.
     * @return The current instance of MervToastMessage for method chaining.
     */
    public MervToastMessage setTextAllCaps(boolean mTextAllCaps) {
        this.mTextAllCaps = mTextAllCaps;
        return this;
    }

    /**
     * Sets the font of the text in the toast.
     *
     * @param mChooseFont The resource ID for the font.
     * @return The current instance of MervToastMessage.
     */
    @SuppressLint("ObsoleteSdkInt")
    public MervToastMessage setChooseFont(int mChooseFont) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                this.mTypeFace = mContext.getResources().getFont(mChooseFont);
            }
        } catch (Exception mException) {
            mException.printStackTrace();
        }
        return this;
    }

    /**
     * Sets the icon animation type for the toast message.
     * Allows customization of how the icon should animate (e.g., Shake, Zoom, Empty).
     *
     * @param mIconAnimation The type of animation to apply to the icon.
     * @return The current MervToastMessage instance to allow method chaining.
     */
    public MervToastMessage setIconAnimation(MervIconAnimationType mIconAnimation, int mIconAnimationDuration) {
        this.mIconAnimation = mIconAnimation;
        this.mIconAnimationDuration = mIconAnimationDuration;
        return this;
    }

    /**
     * Sets the gravity of the toast message.
     *
     * @param mGravity The gravity setting for positioning the toast.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setGravity(MervGravityType mGravity) {
        this.mGravity = mGravity;
        return this;
    }

    /**
     * Sets the animation type for showing and dismissing the toast.
     *
     * @param mAnimation The animation type.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setAnimation(MervAnimationType mAnimation, int mToastAnimationDuration) {
        this.mToastAnimation = mAnimation;
        this.mToastAnimationDuration = mToastAnimationDuration;
        return this;
    }

    /**
     * Sets the duration for which the toast is displayed.
     *
     * @param mScreenTime The screen time in milliseconds.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setScreenTime(int mScreenTime) {
        this.mScreenTime = mScreenTime;
        return this;
    }

    /**
     * Sets the elevation for the toast to create shadow effects.
     *
     * @param mElevation The elevation in pixels.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setElevation(float mElevation) {
        this.mElevation = mElevation;
        return this;
    }

    /**
     * Sets the corner radius of the toast background.
     *
     * @param mRadius The radius in pixels.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setRadius(int mRadius) {
        this.mRadius = mRadius;
        return this;
    }

    /**
     * Sets the stroke width for the toast background.
     *
     * @param mStrokeWidth The width of the stroke in pixels.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setStrokeWidth(int mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
        return this;
    }

    /**
     * Sets the stroke color for the toast background.
     *
     * @param mStrokeColor The color of the stroke.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setStrokeColor(int mStrokeColor) {
        this.mStrokeColor = mStrokeColor;
        return this;
    }


    /**
     * Sets the margin values for positioning the toast.
     *
     * @param mMarginStart  Left margin in pixels.
     * @param mMarginTop    Top margin in pixels.
     * @param mMarginEnd    Right margin in pixels.
     * @param mMarginBottom Bottom margin in pixels.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setMargin(int mMarginStart, int mMarginTop, int mMarginEnd, int mMarginBottom) {
        this.mDefMarginStart = mMarginStart;
        this.mDefMarginTop = mMarginTop;
        this.mDefMarginEnd = mMarginEnd;
        this.mDefMarginBottom = mMarginBottom;
        return this;
    }

    /**
     * Sets the layout ID to position the toast inside a custom layout.
     *
     * @param mLayoutIdentification The custom layout resource ID.
     * @return The current instance of MervToastMessage.
     */
    public MervToastMessage setLayoutIdentification(int mLayoutIdentification) {
        this.mLayoutIdentification = mLayoutIdentification;
        return this;
    }

}
