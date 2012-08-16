/*
 * Copyright (C) 2011 The CyanogenMod Project
 * Copyright (C) 2012 Rashed Abdel-Tawab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.multipleandroidcoding.catapult.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import net.multipleandroidcoding.catapult.R;

public class Preferences extends PreferenceActivity {

    private static final String TAG = "Launcher.Preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences prefs =
            getSharedPreferences(PreferencesProvider.PREFERENCES_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PreferencesProvider.PREFERENCES_CHANGED, true);
                editor.commit();

        //Preference version = findPreference("application_version");
        //version.setTitle(getString(R.string.application_name) + " " + getString(R.string.application_version));
                
        Preference githubbutton = (Preference)findPreference("lang_help_us");
        githubbutton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference arg0) { 
            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LG-Android-Coding/android_packages_apps_Catapult#readme"));
            	startActivity(browserIntent);   
                return true;
            }
        });
    }
}
