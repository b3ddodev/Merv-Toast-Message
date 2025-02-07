package com.merv.toast.library;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;


public class AnimationController {

    public static Animation LeftEnterController(Context mContext, int duration) {
        TranslateAnimation enter = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        enter.setDuration(duration);
        enter.setInterpolator(new DecelerateInterpolator());
        return enter;
    }

    public static Animation RightExitController(Context mContext,int duration) {
        TranslateAnimation exit = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        exit.setDuration(duration);
        exit.setInterpolator(new AccelerateInterpolator());
        return exit;
    }

    public static Animation RightEnterController(Context mContext,int duration) {
        TranslateAnimation enter = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        enter.setDuration(duration);
        enter.setInterpolator(new DecelerateInterpolator());
        return enter;
    }

    public static Animation LeftExitController(Context mContext,int duration) {
        TranslateAnimation exit = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
        exit.setDuration(duration);
        exit.setInterpolator(new AccelerateInterpolator());
        return exit;
    }

    public static Animation FadeEnterController(Context mContext,int duration) {
        AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setDuration(duration);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        return fadeIn;
    }

    public static Animation FadeExitController(Context mContext,int duration) {
        AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setDuration(duration);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        return fadeOut;
    }

    public static Animation TopEnterController(Context mContext,int duration) {
        TranslateAnimation enter = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f);
        enter.setDuration(duration);
        enter.setInterpolator(new DecelerateInterpolator());
        return enter;
    }

    public static Animation TopExitController(Context mContext,int duration) {
        TranslateAnimation exit = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, -1f);
        exit.setDuration(duration);
        exit.setInterpolator(new AccelerateInterpolator());
        return exit;
    }

    public static Animation BottomEnterController(Context mContext,int duration) {
        TranslateAnimation enter = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f);
        enter.setDuration(duration);
        enter.setInterpolator(new DecelerateInterpolator());
        return enter;
    }

    public static Animation BottomExitController(Context mContext,int duration) {
        TranslateAnimation exit = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 1f);
        exit.setDuration(duration);
        exit.setInterpolator(new AccelerateInterpolator());
        return exit;
    }
}
