package quanticheart.com.buildvariants;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.text)).setText(BuildConfig.BuildMsg);
        ((TextView) findViewById(R.id.text2)).setText(String.valueOf(BuildConfig.isDebug));
        ((TextView) findViewById(R.id.text3)).setText(getApplicationVersionName());

        //==============================================================================================
        //
        // ** For DeepLink URL
        //
        //==============================================================================================
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        //==============================================================================================
        //
        // ** For File Provider
        //
        //==============================================================================================
//        Uri contentUri = FileProvider.getUriForFile(this,
//                getString(R.string.FILES_AUTHORITY),
//                myFile);
//
//        Uri contentUri = FileProvider.getUriForFile(this,
//                BuildConfig.FILES_AUTHORITY,
//                myFile);

    }

    //==============================================================================================
    //
    // ** Get Application Name
    //
    //==============================================================================================

    private String getApplicationVersionName() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception ignored) {
        }
        return "";
    }

    //==============================================================================================
    //
    // ** Create File
    //
    //==============================================================================================
    public File generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
