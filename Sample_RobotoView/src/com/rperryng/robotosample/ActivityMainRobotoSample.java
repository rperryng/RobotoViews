
package com.rperryng.robotosample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.rperryng.roboto.RobotoButton;
import com.rperryng.roboto.RobotoCheckBox;
import com.rperryng.roboto.RobotoCheckedTextView;
import com.rperryng.roboto.RobotoEditText;
import com.rperryng.roboto.RobotoRadioButton;
import com.rperryng.roboto.RobotoTextView;
import com.rperryng.roboto.common.RobotoFont;

public class ActivityMainRobotoSample extends Activity {
    
    private static final String KEY_CURRENT_FONT = "keyCurrentFont";
    private static final String KEY_CYCLE_FONTS = "keyCycleFonts";

    private RobotoCheckedTextView mCheckedTextView;
    private RobotoCheckBox mCheckBox;
    private RobotoButton mButton;
    private RobotoTextView mTextView;
    private RobotoRadioButton mRadioButton;
    private RobotoEditText mEditText;

    private RobotoButton mButtonShowcase;
    private GridView mGridView;

    private int mCurrentFont;
    private boolean mIsShowcase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roboto_sample);

        mCheckedTextView = (RobotoCheckedTextView) findViewById(R.id.checkedTextView);
        mCheckBox = (RobotoCheckBox) findViewById(R.id.checkBox);
        mButton = (RobotoButton) findViewById(R.id.button);
        mTextView = (RobotoTextView) findViewById(R.id.textView);
        mRadioButton = (RobotoRadioButton) findViewById(R.id.radioButton);
        mEditText = (RobotoEditText) findViewById(R.id.editText);

        mButtonShowcase = (RobotoButton) findViewById(R.id.buttonShowcase);
        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setAdapter(new FontGridAdapter());

        if (savedInstanceState != null) {
            mCurrentFont = savedInstanceState.getInt(KEY_CURRENT_FONT);
            mIsShowcase = savedInstanceState.getBoolean(KEY_CYCLE_FONTS);
            setAllViewsToFont();
        } else {
            mCurrentFont = 0;
            mIsShowcase = true;
        }
        
        // Hide the keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mButtonShowcase.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsShowcase = true;
            }
        });

        // Cycle through all the Roboto fonts, change once per second.
        new Runnable() {
            @Override
            public void run() {
                if (mIsShowcase) {
                    setAllViewsToFont();

                    mCurrentFont++;

                    if (mCurrentFont == RobotoFont.values().length) {
                        mCurrentFont = 0;
                    }
                }

                new Handler().postDelayed(this, 1000);
            }
        }.run();
    }

    private void setAllViewsToFont() {
        RobotoFont newRobotoFont = RobotoFont.values()[mCurrentFont];
        String text = newRobotoFont.toString();

        mCheckedTextView.setRobotoFont(newRobotoFont);
        mCheckedTextView.setText(text);

        mCheckBox.setRobotoFont(newRobotoFont);
        mCheckBox.setText(text);

        mButton.setRobotoFont(newRobotoFont);
        mButton.setText(text);

        mTextView.setRobotoFont(newRobotoFont);
        mTextView.setText(text);

        mRadioButton.setRobotoFont(newRobotoFont);
        mRadioButton.setText(text);

        mEditText.setRobotoFont(newRobotoFont);
        mEditText.setText(text);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_CURRENT_FONT, mCurrentFont);
        outState.putBoolean(KEY_CYCLE_FONTS, mIsShowcase);
        super.onSaveInstanceState(outState);
    }

    private class FontGridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return RobotoFont.values().length;
        }

        @Override
        public RobotoFont getItem(int position) {
            return RobotoFont.values()[position];
        }

        @Override
        public long getItemId(int position) {
            // No implementation. Not used by android framework.
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            
            // Creating RobotoViews programmatically
            final RobotoFont currentRobotoFont = getItem(position);
            RobotoButton robotoButton = new RobotoButton(ActivityMainRobotoSample.this,
                    currentRobotoFont);
            robotoButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            
            
            robotoButton.setText(currentRobotoFont.toString());
            robotoButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCurrentFont = position;
                    mIsShowcase = false;
                    setAllViewsToFont();
                }
            });

            return robotoButton;
        }
    }
}
