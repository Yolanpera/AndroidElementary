package com.example.androidelementary.languageDetect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidelementary.R;

import java.util.Locale;

public class LanguageDetectActivity extends AppCompatActivity {

    private TextView mTitleView;
    private EditText editText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_detect);
        mTitleView = findViewById(R.id.title);
        editText = (EditText) findViewById(R.id.input);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        String title = "TIKTOKERLERYARISIYOK";
        mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onGlobalLayout() {
                if (mTitleView.getWidth() > 0) {
                    mTitleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int desWidth = 208;
                StaticLayout staticLayout =
                        StaticLayout.Builder
                                .obtain(title, 0, title.length(), mTitleView.getPaint(), mTitleView.getWidth())
                                .setMaxLines(mTitleView.getMaxLines())
                                .setBreakStrategy(mTitleView.getBreakStrategy())
                                .setEllipsize(mTitleView.getEllipsize())
                                .setHyphenationFrequency(mTitleView.getHyphenationFrequency())
                                .setIncludePad(mTitleView.getIncludeFontPadding())
                                .setJustificationMode(mTitleView.getJustificationMode())
                                .build();
                if(staticLayout.getLineCount() <= 1){
                    float line1 = staticLayout.getLineWidth(0);
                    int end = staticLayout.getLineEnd(0);
                    if (line1 <= desWidth){
                        mTitleView.setText(title);
                    }else {
                        int desEnd = (int) ((desWidth / line1) * end);
                        String result = title.substring(0, desEnd) + "...";
                        mTitleView.setText(result);
                    }
                }else {
                    float line2 = staticLayout.getLineWidth(1);
                    if (line2 <= desWidth) {
                        mTitleView.setText(title);
                    }else {
                        int start = staticLayout.getLineStart(1);
                        int end = staticLayout.getLineEnd(1);
                        int desEnd = (int) ((desWidth / line2) * (end - start)) + start;
                        String result = title.substring(0, desEnd) + "...";
                        mTitleView.setText(result);
                    }
                }
            }
        });

        String language = getKeyboardLanguage();
        boolean isRTL = isRTL(new Locale(language));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    String language = getKeyboardLanguage();
                    Log.d("language is", language);
                    Log.d("isRTL is", String.valueOf(isRTL));
                }
            }
        });
        button.setOnClickListener(v -> {
            if(stringStartIsRtlCharacter(textView.getText().toString())){
                Toast.makeText(getBaseContext(),"yes", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getBaseContext(),"no", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private String getKeyboardLanguage() {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        InputMethodSubtype inputMethodSubtype = inputMethodManager.getCurrentInputMethodSubtype();
        return inputMethodSubtype.getLocale();
    }

    private boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }

    public static boolean stringStartIsRtlCharacter(String string) {
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        char c = string.charAt(0);
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(c);
        return unicodeBlock == Character.UnicodeBlock.ARABIC
                || unicodeBlock == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A
                || unicodeBlock == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B
                || unicodeBlock == Character.UnicodeBlock.ARABIC_SUPPLEMENT
                || unicodeBlock == Character.UnicodeBlock.OLD_PERSIAN || unicodeBlock == Character.UnicodeBlock.HEBREW;
    }
}