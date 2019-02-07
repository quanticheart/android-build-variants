package quanticheart.com.buildvariants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.text)).setText(BuildConfig.BuildMsg);
        ((TextView) findViewById(R.id.text2)).setText(String.valueOf(BuildConfig.isDebug));

        //==============================================================================================
        //
        // ** For DeepLink URL
        //
        //==============================================================================================
        // Intent intent = getIntent();
        // String action = intent.getAction();
        // Uri data = intent.getData();

        //==============================================================================================
        //
        // ** For File Provider
        //
        //==============================================================================================
        //  Uri contentUri = FileProvider.getUriForFile(getContext(),
        //          BuildConfig.FILES_AUTHORITY,
        //          myFile);

    }
}
