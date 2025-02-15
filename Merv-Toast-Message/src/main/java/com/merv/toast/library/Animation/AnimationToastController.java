package com.merv.toast.library.Animation;

import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class AnimationToastController {

    /**
     * Creates an animation for an object to enter from the left
     */
    public static Animation LeftEnterController(Context mContext, int mDuration) {
        TranslateAnimation mEnter = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        mEnter.setDuration(mDuration);
        mEnter.setInterpolator(new DecelerateInterpolator());
        return mEnter;
    }

    /**
     * Creates an animation for an object to exit to the right
     */
    public static Animation RightExitController(Context mContext, int mDuration) {
        TranslateAnimation mExit = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        mExit.setDuration(mDuration);
        mExit.setInterpolator(new AccelerateInterpolator());
        return mExit;
    }

    /**
     * Creates an animation for an object to enter from the right
     */
    public static Animation RightEnterController(Context mContext, int mDuration) {
        TranslateAnimation mEnter = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        mEnter.setDuration(mDuration);
        mEnter.setInterpolator(new DecelerateInterpolator());
        return mEnter;
    }

    /**
     * Creates an animation for an object to exit to the left
     */
    public static Animation LeftExitController(Context mContext, int mDuration) {
        TranslateAnimation mExit = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        mExit.setDuration(mDuration);
        mExit.setInterpolator(new AccelerateInterpolator());
        return mExit;
    }

    /**
     * Creates an animation for an object to fade in
     */
    public static Animation FadeEnterController(Context mContext, int mDuration) {
        AlphaAnimation mFadeIn = new AlphaAnimation(0f, 1f);
        mFadeIn.setDuration(mDuration);
        mFadeIn.setInterpolator(new DecelerateInterpolator());
        return mFadeIn;
    }

    /**
     * Creates an animation for an object to fade out
     */
    public static Animation FadeExitController(Context mContext, int mDuration) {
        AlphaAnimation mFadeOut = new AlphaAnimation(1f, 0f);
        mFadeOut.setDuration(mDuration);
        mFadeOut.setInterpolator(new AccelerateInterpolator());
        return mFadeOut;
    }

    /**
     * Creates an animation for an object to enter from the top
     */
    public static Animation TopEnterController(Context mContext, int mDuration) {
        TranslateAnimation mEnter = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f);
        mEnter.setDuration(mDuration);
        mEnter.setInterpolator(new DecelerateInterpolator());
        return mEnter;
    }

    /**
     * Creates an animation for an object to exit to the top
     */
    public static Animation TopExitController(Context mContext, int mDuration) {
        TranslateAnimation mExit = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f);
        mExit.setDuration(mDuration);
        mExit.setInterpolator(new AccelerateInterpolator());
        return mExit;
    }

    /**
     * Creates an animation for an object to enter from the bottom
     */
    public static Animation BottomEnterController(Context mContext, int mDuration) {
        TranslateAnimation mEnter = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f);
        mEnter.setDuration(mDuration);
        mEnter.setInterpolator(new DecelerateInterpolator());
        return mEnter;
    }

    /**
     * Creates an animation for an object to exit to the bottom
     */
    public static Animation BottomExitController(Context mContext, int mDuration) {
        TranslateAnimation mExit = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1f);
        mExit.setDuration(mDuration);
        mExit.setInterpolator(new AccelerateInterpolator());
        return mExit;
    }

    /**
     * This function defines the entry animation (flicker effect) where the opacity of the element alternates between 0 and 1.
     * The animation will repeat infinitely with a reverse effect (flickering).
     *
     * @param mContext  The context where the animation is applied.
     * @param mDuration The total duration of the animation.
     * @return The animation set with an alpha animation for the entry effect.
     */
    public static AnimationSet BlinkEnterController(Context mContext, int mDuration) {
        AnimationSet mAnimationSet = new AnimationSet(true);
        AlphaAnimation mAlphaIn = new AlphaAnimation(0f, 1f);
        mAlphaIn.setDuration(mDuration / 18);
        mAlphaIn.setRepeatMode(Animation.REVERSE);
        mAlphaIn.setRepeatCount(Animation.INFINITE);
        mAnimationSet.addAnimation(mAlphaIn);
        mAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return mAnimationSet;
    }

    /**
     * This function defines the exit animation (fade-out effect) where the opacity of the element alternates between 1 and 0.
     * The animation will repeat with a reverse effect (fading out).
     *
     * @param mContext  The context where the animation is applied.
     * @param mDuration The total duration of the animation.
     * @return The animation set with an alpha animation for the exit effect.
     */
    public static AnimationSet BlinkExitController(Context mContext, int mDuration) {
        AnimationSet mAnimationSet = new AnimationSet(true);
        AlphaAnimation mAlphaOut = new AlphaAnimation(1f, 0f);
        mAlphaOut.setDuration(mDuration / 2);
        mAlphaOut.setRepeatMode(Animation.REVERSE);
        mAnimationSet.addAnimation(mAlphaOut);
        mAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return mAnimationSet;
    }


}
