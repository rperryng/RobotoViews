
package com.rperryng.roboto;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rperryng.roboto.common.RobotoFont;
import com.rperryng.roboto.common.RobotoUtils;

/**
 * TextView that uses the desired Roboto font
 * 
 * @author Ryan Perry-Nguyen
 */
public class RobotoTextView extends TextView {

    private RobotoFont mRobotoFont;

    /**
     * Use this constructor when creating a {@link RobotoTextView}
     * programmatically
     * 
     * @param context
     * @param robotoFont
     */
    public RobotoTextView(Context context, RobotoFont robotoFont) {
        super(context);
        mRobotoFont = robotoFont;
        setRoboto();
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RobotoTextView,
                defStyle,
                0);

        int attributeValue = a.getInteger(R.styleable.RobotoTextView_font,
                RobotoFont.DEFAULT_ATTRIBUTE_VALUE);
        mRobotoFont = RobotoFont.getRobotoFontWithAtributeValue(attributeValue);

        a.recycle();
        setRoboto();
    }

    /**
     * Sets the current instance to the desired Roboto font
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
