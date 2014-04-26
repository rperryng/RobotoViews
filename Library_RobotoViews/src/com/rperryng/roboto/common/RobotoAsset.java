package com.rperryng.roboto.common;

/**
 * An enum holding the names of all the Roboto font names. use
 * {@code getAssetFontName()} off one of the enum values to grab the
 * corresponding asset file-name (without the .ttf suffix).
 * 
 * @author Ryan Perry-Nguyen
 */
public enum RobotoAsset {
    
    REGULAR("Roboto-Regular"),
    REGULAR_BOLD("Roboto-Bold"),
    REGULAR_ITALIC("Roboto-Italic"),
    REGULAR_BOLD_ITALIC("Roboto-BoldItalic"),
    
    MEDIUM("Roboto-Medium"),
    MEDIUM_ITALIC("Roboto-Medium"),
    
    BLACK("Roboto-Black"),
    BLACK_ITALIC("Roboto-BlackItalic"),
    
    LIGHT("Roboto-Light"),
    LIGHT_ITALIC("Roboto-LightItalic"),
    
    THIN("Roboto-Thin"),
    THIN_ITALIC("Roboto-ThinItalic");
    
    /**
     * The name of the asset file, without the .ttf suffix
     */
    private String mAssetFontName;
    
    /**
     * @param assetFontName The name of the asset file, without the .ttf suffix
     */
    private RobotoAsset(String assetFontName) {
        mAssetFontName = assetFontName;
    }
    
    /**
     * @return The name of the asset file, without the .ttx suffix
     */
    public String getAssetFontName() {
        return mAssetFontName;
    }
}
