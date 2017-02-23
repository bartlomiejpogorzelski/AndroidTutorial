package com.example.bartek.androidtutorial;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Bartek on 2017-02-23.
 */

public class SettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
