package com.merv.toast.library.Utils;

/**
 * Enum class that defines different animation types for MervToastMessage.
 * Each animation type corresponds to a specific direction or effect that will be applied
 * to the toast message when it is displayed or dismissed.
 */
public enum MervAnimationType {
    /**
     * Animation for sliding the toast in from the left.
     * This animation will slide the toast message from the left side of the screen.
     */
    MERV_LEFT_ANIMATION,

    /**
     * Animation for sliding the toast in from the right.
     * This animation will slide the toast message from the right side of the screen.
     */
    MERV_RIGHT_ANIMATION,

    /**
     * Animation for fading the toast in and out.
     * This animation will gradually fade the toast message in and out, giving it a smooth fade effect.
     */
    MERV_FADE_ANIMATION,

    /**
     * Animation for sliding the toast in from the top.
     * This animation will slide the toast message in from the top of the screen.
     */
    MERV_TOP_ANIMATION,

    /**
     * Animation for sliding the toast in from the bottom.
     * This animation will slide the toast message in from the bottom of the screen.
     */
    MERV_BOTTOM_ANIMATION,

    /**
     * Animation for blinking the toast message.
     * This animation will make the toast message blink repeatedly, creating a flashing effect.
     */
    MERV_BLINK_ANIMATION
}
