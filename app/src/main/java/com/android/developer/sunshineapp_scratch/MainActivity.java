package com.android.developer.sunshineapp_scratch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ForecastFragment fragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        } else {
            if (id == R.id.pref_location)
                mapPreferedLocation();

        }
        return super.onOptionsItemSelected(item);
    }

    private void mapPreferedLocation() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPreferences.getString(getString(R.string.pref_location_key), getString(R.string.pref_default_value));

        Uri map = Uri.parse("geo:0,0?").buildUpon().appendQueryParameter("q", location).build();
        Intent send_map = new Intent(Intent.ACTION_VIEW);
        send_map.setData(map);

        if (send_map.resolveActivity(getPackageManager()) != null) {
            startActivity(send_map);
        }

    }
}