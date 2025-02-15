package com.merv.toast.library.Animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class AnimationIconController {


    /**
     * Creates an empty animation with no transformation.
     * This animation does not apply any visual effects and runs instantly with zero duration.
     * It can be used as a placeholder or to stop any ongoing animation.
     *
     * @param mContext The context from which the animation is being created.
     * @return The created empty animation.
     */
    public static Animation EmptyAnimation(Context mContext) {
        Animation mAnimation = new Animation() {
            @Contract(pure = true)
            @Override
            protected void applyTransformation(float mInterpolatedTime, Transformation mT) {
            }
        };
        mAnimation.setDuration(0);
        return mAnimation;
    }

    /**
     * Creates a shake animation for the icon that moves it left and right.
     * The animation shakes the icon back and forth for a given duration.
     * After the animation ends, it will restart after a 1-second delay.
     *
     * @param mContext  The context from which the animation is being created.
     * @param mDuration The duration of the shake animation.
     * @param mIcon The ImageView to which the animation will be applied.
     * @return The created shake animation.
     */
    public static Animation ShakeAnimation(Context mContext, int mDuration, final ImageView mIcon) {
        final Animation mShake = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -0.02f, Animation.RELATIVE_TO_SELF, 0.02f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        mShake.setDuration(mDuration);
        mShake.setInterpolator(new CycleInterpolator(2));
        mShake.setRepeatCount(0);
        mShake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation mAnimation) {
            }

            @Override
            public void onAnimationRepeat(Animation mAnimation) {
            }

            @Override
            public void onAnimationEnd(Animation mAnimation) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIcon.startAnimation(mShake);
                    }
                }, 1000);
            }
        });

        return mShake;
    }

    /**
     * Creates a beat animation that makes the icon scale up and down.
     * The icon continuously grows and shrinks between a scale of 1.0 and 1.1.
     *
     * @param mContext  The context from which the animation is being created.
     * @param mDuration The duration of each cycle of the beat animation.
     * @return The created beat animation.
     */
    public static Animation BeatAnimation(Context mContext, int mDuration) {
        Animation mBeat = new ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mBeat.setDuration(mDuration);
        mBeat.setRepeatCount(Animation.INFINITE);
        mBeat.setRepeatMode(Animation.REVERSE);
        return mBeat;
    }

    /**
     * Creates a fade animation that changes the opacity of the icon.
     * The icon fades in and out between an opacity of 0.5 and 1.0.
     *
     * @param mContext  The context from which the animation is being created.
     * @param mDuration The duration of each cycle of the fade animation.
     * @param mIcon     The ImageView to which the fade animation will be applied.
     */
    public static void FadeAnimation(Context mContext, int mDuration, ImageView mIcon) {
        ValueAnimator mFade = ValueAnimator.ofFloat(0.5f, 1f);
        mFade.setDuration(mDuration);
        mFade.setRepeatCount(ValueAnimator.INFINITE);  // Repeat indefinitely
        mFade.setRepeatMode(ValueAnimator.REVERSE);    // Reverse each cycle (fade in-out)
        mFade.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                float mFadeValue = (float) animation.getAnimatedValue();
                mIcon.setAlpha(mFadeValue);  // Update the alpha value of the icon
            }
        });

        mFade.start();
    }

    /**
     * Creates a combination of a beat and fade animation.
     * The icon will scale up and down while fading in and out between 0.5 and 1.
     *
     * @param mContext  The context from which the animation is being created.
     * @param mDuration The duration of each cycle of the combined beat and fade animation.
     * @param mIcon     The ImageView to which the beat and fade animation will be applied.
     */
    public static void BeatFadeAnimation(Context mContext, int mDuration, final ImageView mIcon) {
        ScaleAnimation mBeat = new ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mBeat.setDuration(mDuration);
        mBeat.setRepeatCount(Animation.INFINITE);
        mBeat.setRepeatMode(Animation.REVERSE);
        ValueAnimator mFadeValue = ValueAnimator.ofFloat(0.5f, 1f);
        mFadeValue.setDuration(mDuration);
        mFadeValue.setRepeatCount(ValueAnimator.INFINITE);
        mFadeValue.setRepeatMode(ValueAnimator.REVERSE);
        mFadeValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator mAnimation) {
                float mAlphaValue = (float) mAnimation.getAnimatedValue();
                mIcon.setAlpha(mAlphaValue);
            }
        });
        mIcon.startAnimation(mBeat);
        mFadeValue.start();
    }

}
