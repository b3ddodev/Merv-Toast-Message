package com.merv.toast.library.Utils;

/**
 * Enum class that defines different icon animation types for MervToastMessage.
 * The enum types define various animations that can be applied to the icon in the toast.
 */
public enum MervIconAnimationType {

    /**
     * No animation applied to the icon.
     * This is the default state where the icon remains static.
     */
    MERV_ICON_EMPTY_ANIMATION,

    /**
     * The icon shakes when the toast is shown.
     * This animation makes the icon move slightly left and right, simulating a shake effect.
     */
    MERV_ICON_SHAKE_ANIMATION,

    /**
     * The icon pulses (scales in and out) when the toast is shown.
     * The icon will grow larger and then shrink back to its original size, creating a "pulsing" effect.
     */
    MERV_ICON_BEAT_ANIMATION,

    /**
     * The icon fades in and out when the toast is shown.
     * The icon will smoothly change its opacity from 0 to 1 and back, creating a fading effect.
     */
    MERV_ICON_FADE_ANIMATION,

    /**
     * The icon pulses and fades at the same time when the toast is shown.
     * This combines the pulsing and fading effects together, making the icon both grow/shrink and change opacity simultaneously.
     */
    MERV_ICON_BEAT_FADE_ANIMATION
}
