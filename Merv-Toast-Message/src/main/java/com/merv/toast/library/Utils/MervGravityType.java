package com.merv.toast.library.Utils;

import android.view.Gravity;

/**
 * Enum class that defines different gravity types (positioning) for MervToastMessage.
 * The gravity determines where the toast will appear on the screen (center, top, or bottom).
 */
public enum MervGravityType {
    /**
     * Toast message will appear in the center of the screen.
     */
    MERV_GRAVITY_CENTER(Gravity.CENTER),

    /**
     * Toast message will appear at the bottom of the screen.
     */
    MERV_GRAVITY_BOTTOM(Gravity.BOTTOM),

    /**
     * Toast message will appear at the top of the screen.
     */
    MERV_GRAVITY_TOP(Gravity.TOP);

    /**
     * The gravity value determines the position of the toast message on the screen.
     * It specifies the direction (center, bottom, top) where the toast will be positioned.
     * The value is typically set to a constant representing a specific gravity position, such as
     * Gravity.CENTER, Gravity.BOTTOM, Gravity.TOP.
     */
    private final int mGravityValue;

    /**
     * Constructor that assigns the gravity value to the enum type.
     *
     * @param mGravityValue The gravity value for this enum type (e.g., CENTER, TOP, BOTTOM).
     */
    MervGravityType(int mGravityValue) {
        this.mGravityValue = mGravityValue;
    }

    /**
     * Returns the gravity value corresponding to the enum type.
     *
     * @return The gravity value (e.g., Gravity.CENTER, Gravity.TOP, Gravity.BOTTOM).
     */
    public int getGravityValue() {
        return mGravityValue;
    }
}
