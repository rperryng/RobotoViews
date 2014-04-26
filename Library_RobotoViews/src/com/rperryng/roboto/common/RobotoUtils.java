
package com.rperryng.roboto.common;

import java.util.Hashtable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.rperryng.roboto.R;

/**
 * A helper class containing the methods all the extended views in this library
 * use to set the TypeFace to Roboto.
 * 
 * @author Ryan Perry-Nguyen
 */
public class RobotoUtils {

    /**
     * A Hashtable holding which fonts have already been retrieved from the
     * Application's Assets. This is necessary to avoid memory leaks, as Android
     * does not cache Typefaces retrieved from assets pre-ICS,
     */
    private static final Hashtable<String, Typeface> mCache = new Hashtable<String, Typeface>();

    /**
     * Grabs an instance of the desired Typeface. If this method is called more
     * than once for the same Typeface, the same instance of that Typeface will
     * be returned
     * 
     * @param context A context used to access the Application's assets.
     * @param assetName One of the AssetFontName's as defined in the
     *            {@link RobotoAsset} enum. Used to grab the corresponding
     *            Typeface in the assets folder
     * @return The desired Typeface. Use {@code setTypeface()}
     */
    public static Typeface getTypeface(Context context, RobotoAsset assetName) {
        String fontName = assetName.getAssetFontName();

        synchronized (fontName) {
            if (!mCache.containsKey(fontName)) {

                try {
                    Typeface typeface = Typeface.createFromAsset(context.getAssets(),
                            String.format("fonts/%s.ttf", fontName));
                    mCache.put(fontName, typeface);
                } catch (RuntimeException e) {
                    throw new RuntimeException("Couldn't find font with name: " + fontName
                            + ".  Is the .ttf file in the assets/fonts folder?");
                }
            }
            return mCache.get(fontName);
        }
    }

    /**
     * @param context A Context in order to grab the styled attribute
     * @param attrs The attribute set associated with this instance
     * @return The integer representing the ordinal value of one of the
     *         instances in the {@link RobotoAsset} enum. Use
     *         {@link RobotoAsset}'s {@code getFontName()} to retrieve
     *         corresponding asset name
     */
    public static int getValueForStyleable(Context context, AttributeSet attrs) {

        // Obtain the Roboto Styleable TypedArray
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Roboto, 0, 0);

        int fontOrdinal;
        try {
            // Retrieve the assigned value for the Roboto_font attribute
            fontOrdinal = a.getInteger(R.styleable.Roboto_font, 0);
        } finally {
            // Recycle the resource for later-reuse
            a.recycle();
        }

        return fontOrdinal;
    }

}
