package com.rperryng.roboto.common;

import java.util.Locale;

import android.text.TextUtils;
import android.util.Log;

import com.rperryng.roboto.R;


/**
 * An enum containing the resource ID's of all the roboto fonts.
 * 
 * @author Ryan Perry-Nguyen
 *
 */
public enum RobotoFont {
    
    REGULAR(R.raw.rv__regular),
    REGULAR_BOLD(R.raw.rv__regular_bold),
    REGULAR_ITALIC(R.raw.rv__regular_italic),
    REGULAR_BOLD_ITALIC(R.raw.rv__regular_bold_italic),
    
    MEDIUM(R.raw.rv__medium),
    MEDIUM_ITALIC(R.raw.rv__medium_italic),
    
    BLACK(R.raw.rv__black),
    BLACK_ITALIC(R.raw.rv__black_italic),
    
    LIGHT(R.raw.rv__light),
    LIGHT_ITALIC(R.raw.rv__light_italic),
    
    THIN(R.raw.rv__thin),
    THIN_ITALIC(R.raw.rv__thin_italic),
    
    CONDENSED_REGULAR(R.raw.rv__condensed_regular),
    CONDENSED_REGULAR_BOLD(R.raw.rv__condensed_regular_bold),
    CONDENSED_REGULAR_ITALIC(R.raw.rv__condensed_regular_italic),
    CONDENSED_REGULAR_BOLD_ITALIC(R.raw.rv__condensed_regular_bold_italic),
    
    CONDENSED_LIGHT(R.raw.rv__condensed_light),
    CONDENSED_LIGHT_ITALIC(R.raw.rv__condensed_light_italic);
    
    
    private int mRawFontResourceId;
    
    private RobotoFont(int rawFontResourceId) {
        mRawFontResourceId = rawFontResourceId;
    }
    
    public int getRawFontResourceId() {
        return mRawFontResourceId;
    }

    @Override 
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitString = TextUtils.split(("Roboto " + this.name().replace("_", " ")), " ");
        Log.d("ryan", ("Roboto " + this.name().replace("_", " ")));
        
        for (String target : splitString) {
            stringBuilder
                    .append(Character.toUpperCase(target.charAt(0)))
                    .append(target.substring(1).toLowerCase(Locale.ENGLISH))
                    .append(" ");
        }
        
        return stringBuilder.toString();
    }

}
