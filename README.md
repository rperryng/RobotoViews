#RobotoViews
Style your android views with Google's very own [Roboto][1] font and/or its [Condensed][2] variant.

![RobotoView Sample Pictures][3]

All `Typface`s created are lazily loaded and stored in a cache.  If a `Typeface` is called more than once, it will be pulled from the cache instead.

##Setup

Import RobotoViews and add it as a dependency to your project.

##Usage

*A fully working example is included in the `sample` folder*
###Via XML layout

1. Include one of the widgets into your layout file.  The `font` attribute can be any of the values listed further below

```xml
<com.rperryng.roboto.RobotoTextView
    ...
    roboto:font="regularItalic" />
```

2. If you haven't already, include the namespace for the library in your layout's parent view

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:roboto="http://schemas.android.com/apk/res-auto"
    ...>
  
```

That's it.  The view once inflated will have the typeface specified in the `font` attribute.

###Via Java code

RobotoViews can be instantiated at runtime by calling the constructor `new RobotoButton(Context, RobotoFont)`.  The `RobotoFont` class is an enum containing all the possible RobotoFonts for you to use, simply pass in one of its instances.

```java
RobotoButton robotoButton = new RobotoButton(ActivityMainRobotoSample.this, RobotoFont.LIGHT);
robotoButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
```

All of the RobotoViews have a method named `setRobotoFont(RobotoFont)` so you can change the font of the `RobotoView` at any time

```java
RobotoTextView text = (RobotoTextView) findViewById(R.id.my_text_view);
...
text.setRobotoFont(RobotoFont.CONDENSED_REGULAR);
```

###Usage on standard Android Views
*This can be done in java code only.*
If you don't want to use the custom views, that's fine too.  If your view has a `setTypeface(Typeface)` method, the library exposes a method for you to grab (and cache) any of the fonts that come with this library

e.g.
```java
Button button = (Button) findViewById(R.id.my_button);
button.setTypeface(RobotoUtils.getTypeface(context, RobotoFont.LIGHT_ITALIC));
``` 

### Picking the right font
If you are using XML, you can use any of the following classes
`com.rperryng.roboto.RobotoButton`
`com.rperryng.roboto.RobotoCheckBox`
`com.rperryng.roboto.RobotoCheckedTextView`
`com.rperryng.roboto.RobotoEditText`
`com.rperryng.roboto.RobotoRadioButton`
`com.rperryng.roboto.RobotoTextView`

with any of the following values for the `font` attribute

`regular`
`regularBold`
`regularItalic`
`regularBoldItalic`
`medium`
`mediumItalic`
`black`
`blackItalic`
`light`
`lightItalic`
`thin`
`thinItalic`
`condensedRegular`
`condensedRegularBold`
`condensedRegularItalic`
`condensedRegularBoldItalic`
`condensedLight`
`condensedLightItalic`

The `RobotoFont` class exposes the following instances for you to use where necessary.

`REGULAR`
`REGULAR_BOLD`
`REGULAR_ITALIC`
`REGULAR_BOLD_ITALIC`
`MEDIUM`
`MEDIUM_ITALIC`
`BLACK`
`BLACK_ITALIC`
`LIGHT`
`LIGHT_ITALIC`
`THIN`
`THIN_ITALIC`
`CONDENSED_REGULAR`
`CONDENSED_REGULAR_BOLD`
`CONDENSED_REGULAR_ITALIC`
`CONDENSED_REGULAR_BOLD_ITALIC`
`CONDENSED_LIGHT`
`CONDENSED_LIGHT_ITALIC`

## Omitting unneeded .ttf files
In order to save previous KB in your app, you may wish to remove unused .ttf files.  

1.  In your downloaded copy of the library, navigate to `res/raw` and remove any of the `.ttf` files you dont need. 

2.  Navigate to `com.rperryng.roboto.common.RobotoFont` enum class and remove the corresponding enum value.

3.  (optional) open the `res/attrs.xml` file and remove the corresponding enum value for the `font` attribute

[1]: http://developer.android.com/design/style/typography.html
[2]: http://www.google.com/fonts/specimen/Roboto+Condensed
[3]: http://i.imgur.com/MP4Q0mz.png
