package versionactivity.com.jogilsang.versionactivity;

import android.os.Bundle;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 2017-02-20.
 */

public class VersionActivity extends AppCompatActivity {

    private Button version_update;
    private TextView txt_current_version;
    private TextView txt_device_version;
    private ImageView version_image;
    private Intent playstoreIntent;

    public PackageInfo pi;
    public String versionName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version_activitiy);

        // back button added
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Layout button
        txt_current_version = (TextView)findViewById(R.id.txt_current_version);
        txt_device_version = (TextView)findViewById(R.id.txt_device_version);
        txt_device_version.setText(getVersionName());


        // R.string.invitation_deep_link is Playstore URL.
        version_update = (Button)findViewById(R.id.version_update);
        version_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playstoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.invitation_deep_link)));
                startActivity(playstoreIntent);
                // Button PlayStore connected :: 플레이스토어연결
            }
        });

        version_image = (ImageView)findViewById(R.id.version_image);
        version_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playstoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.invitation_deep_link)));
                startActivity(playstoreIntent);
                // Image PlayStore connected :: 플레이스토어연결
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // backbutton cilck event
        int i = item.getItemId();

        switch(i) {

            case android.R.id.home :

                // Activity Exit
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    // get the version in gradle
    public String getVersionName() {
        try {
            pi = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("PackageManager", "NameNotFoundException e Errer");
        }
        return versionName = pi.versionName;
    }

}

