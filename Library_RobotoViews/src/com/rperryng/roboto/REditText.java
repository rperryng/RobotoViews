package com.rperryng.roboto;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.rperryng.roboto.common.RobotoAsset;
import com.rperryng.roboto.common.RobotoUtils;

public class REditText extends EditText {

    /**
     * The ordinal value of the associated {@link RobotoAsset} enum instance
     * used with this View
     */
    private int mFontOrdinal = 0;

    /**
     * Use this constructor if you want to instantiate a new view with the
     * passed in font.
     * 
     * @param context Context to build the view
     * @param assetFontName The desired font to use with this View
     */
    public REditText(Context context, RobotoAsset assetFontName) {
        super(context);
        mFontOrdinal = assetFontName.ordinal();
        setRoboto(context);
    }

    /**
     * Constructor used by the framework when inflating a view defined in XML.
     */
    public REditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFontOrdinal = RobotoUtils.getValueForStyleable(context, attrs);
        setRoboto(context);
    }

    /**
     * Sets the Typeface for this view
     * 
     * @param context
     */
    private void setRoboto(Context context) {
        // Cannot apply the Typeface when using the graphical XML editor
        if (!isInEditMode()) {
            setTypeface(RobotoUtils.getTypeface(context, RobotoAsset.values()[mFontOrdinal]));
        }
    }

    /**
     * @return The name of the font this view instance is using
     */
    public String getFont() {
        return RobotoAsset.values()[mFontOrdinal].getAssetFontName();
    }
}

