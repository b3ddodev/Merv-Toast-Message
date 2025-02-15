package com.merv.toast.library.Utils;


import com.merv.toast.library.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Enum class representing different icons for various toast types.
 * Each enum instance represents an icon with a corresponding drawable resource.
 */
public enum MervIconSelect {

    /**
     * Success toast icon types
     **/
    SUCCESS_BROKEN(R.drawable.ic_success_broken),
    SUCCESS_LINEAR(R.drawable.ic_success_linear),
    SUCCESS_TWO_TONE(R.drawable.ic_success_two_tone),
    SUCCESS_OUTLINE(R.drawable.ic_success_outline),
    SUCCESS_BULK(R.drawable.ic_success_bulk),
    SUCCESS_BOLD(R.drawable.ic_success_bold),

    /**
     * Error toast icon types
     **/
    ERROR_BROKEN(R.drawable.ic_error_broken),
    ERROR_LINEAR(R.drawable.ic_error_linear),
    ERROR_TWO_TONE(R.drawable.ic_error_two_tone),
    ERROR_OUTLINE(R.drawable.ic_error_outline),
    ERROR_BULK(R.drawable.ic_error_bulk),
    ERROR_BOLD(R.drawable.ic_error_bold),

    /**
     * Warning toast icon types
     **/
    WARNING_BROKEN(R.drawable.ic_warning_broken),
    WARNING_LINEAR(R.drawable.ic_warning_linear),
    WARNING_TWO_TONE(R.drawable.ic_warning_two_tone),
    WARNING_OUTLINE(R.drawable.ic_warning_outline),
    WARNING_BULK(R.drawable.ic_warning_bulk),
    WARNING_BOLD(R.drawable.ic_warning_bold),

    /**
     * Info toast icon types
     **/
    INFO_BROKEN(R.drawable.ic_info_broken),
    INFO_LINEAR(R.drawable.ic_info_linear),
    INFO_TWO_TONE(R.drawable.ic_info_two_tone),
    INFO_OUTLINE(R.drawable.ic_info_outline),
    INFO_BULK(R.drawable.ic_info_bulk),
    INFO_BOLD(R.drawable.ic_info_bold);


    /**
     * Resource identification for the icon.
     * This represents the drawable resource ID associated with the icon.
     **/
    private final int mResourcesIdentification;

    /**
     * Constructor for each enum instance that assigns a resource ID.
     *
     * @param mResourcesIdentification The drawable resource ID associated with this icon.
     */
    MervIconSelect(int mResourcesIdentification) {
        this.mResourcesIdentification = mResourcesIdentification;
    }

    /**
     * Returns the resource ID of the icon.
     *
     * @return The resource ID of the icon.
     */
    public int getResourceIdentification() {
        return mResourcesIdentification;
    }

    /**
     * Returns a list of icons that are compatible with the given toast type.
     *
     * @param mToastType The toast type (Success, Error, Warning, Info).
     * @return A list of compatible icons for the specified toast type.
     */
    public static List<MervIconSelect> getIconsForType(MervToastType mToastType) {
        List<MervIconSelect> mIconList = new ArrayList<>();
        switch (mToastType) {
            case MERV_TYPE_SUCCESS:
                mIconList.add(SUCCESS_BROKEN);
                mIconList.add(SUCCESS_LINEAR);
                mIconList.add(SUCCESS_TWO_TONE);
                mIconList.add(SUCCESS_OUTLINE);
                mIconList.add(SUCCESS_BULK);
                mIconList.add(SUCCESS_BOLD);
                break;
            case MERV_TYPE_ERROR:
                mIconList.add(ERROR_BROKEN);
                mIconList.add(ERROR_LINEAR);
                mIconList.add(ERROR_TWO_TONE);
                mIconList.add(ERROR_OUTLINE);
                mIconList.add(ERROR_BULK);
                mIconList.add(ERROR_BOLD);
                break;
            case MERV_TYPE_WARNING:
                mIconList.add(WARNING_BROKEN);
                mIconList.add(WARNING_LINEAR);
                mIconList.add(WARNING_TWO_TONE);
                mIconList.add(WARNING_OUTLINE);
                mIconList.add(WARNING_BULK);
                mIconList.add(WARNING_BOLD);
                break;
            case MERV_TYPE_INFO:
            default:
                mIconList.add(INFO_BROKEN);
                mIconList.add(INFO_LINEAR);
                mIconList.add(INFO_TWO_TONE);
                mIconList.add(INFO_OUTLINE);
                mIconList.add(INFO_BULK);
                mIconList.add(INFO_BOLD);
                break;
        }
        return mIconList;
    }

    /**
     * Determines the appropriate icon for a given toast type and selected icon.
     * If the selected icon is not compatible with the toast type, it throws an exception.
     *
     * @param mToastType The toast type (Success, Error, Warning, Info).
     * @param mSelectedIcon The selected icon for the toast.
     * @return The appropriate icon for the specified toast type.
     * @throws RuntimeException If the selected icon is incompatible with the toast type.
     */
    public static MervIconSelect getIconForType(MervToastType mToastType, MervIconSelect mSelectedIcon) {
        if (mSelectedIcon == null) {
            switch (mToastType) {
                case MERV_TYPE_SUCCESS:
                    return MervIconSelect.SUCCESS_LINEAR;
                case MERV_TYPE_ERROR:
                    return MervIconSelect.ERROR_LINEAR;
                case MERV_TYPE_WARNING:
                    return MervIconSelect.WARNING_LINEAR;
                case MERV_TYPE_INFO:
                default:
                    return MervIconSelect.INFO_LINEAR;
            }
        }

        List<MervIconSelect> mAvailableIcons = getIconsForType(mToastType);
        boolean mIsCompatible = false;
        for (MervIconSelect ignored : mAvailableIcons) {
            if (mSelectedIcon.name().startsWith(mToastType.name().replace("MERV_TYPE_", ""))) {
                mIsCompatible = true;
                break;
            }
        }
        if (!mIsCompatible) {
            throw new RuntimeException("Selected Toast type (" + mToastType + ") is incompatible with icon type: " + mSelectedIcon);
        }
        return mSelectedIcon;
    }
}
