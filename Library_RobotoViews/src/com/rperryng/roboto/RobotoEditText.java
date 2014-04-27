
package com.rperryng.roboto;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.rperryng.roboto.common.Constants;
import com.rperryng.roboto.common.RobotoFont;
import com.rperryng.roboto.common.RobotoUtils;

/**
 * TextView that uses the desired Roboto font
 * 
 * @author Ryan Perry-Nguyen
 */
public class RobotoEditText extends Button {

    private RobotoFont mRobotoFont;

    /**
     * Use this constructor when creating a {@link RobotoEditText}
     * programmatically
     * 
     * @param context
     * @param robotoFont
     */
    public RobotoEditText(Context context, RobotoFont robotoFont) {
        super(context);
        mRobotoFont = robotoFont;
        setRoboto();
    }

    public RobotoEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RobotoEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RobotoTextView,
                defStyle,
                0);

        mRobotoFont = RobotoFont.values()[a.getInteger(R.styleable.RobotoTextView_font,
                Constants.DEFAULT_ROBOTO_FONT_ORDINAL)];

        a.recycle();
        setRoboto();
    }

    /**
     * Sets the current {@link View} instance to the desired Roboto font
     */
    private void setRoboto() {
        if (!isInEditMode()) {
            setTypeface(RobotoUtils.getTypeface(getContext(), mRobotoFont));
        }
    }

    /**
     * @return The {@link RobotoFont} enum associated with this View
     */
    public RobotoFont getRobotoFamily() {
        return mRobotoFont;
    }
}
