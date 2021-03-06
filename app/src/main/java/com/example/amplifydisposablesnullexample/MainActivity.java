package com.example.amplifydisposablesnullexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.logging.AndroidLoggingPlugin;
import com.amplifyframework.logging.LogLevel;

public class MainActivity extends AppCompatActivity {

    static boolean initd = false;
    static final String TAG = "amplifydisposablesnullexample:MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate started");
        if(!initd) {
            try {
                Amplify.addPlugin(new AndroidLoggingPlugin(LogLevel.VERBOSE));
                Amplify.addPlugin(new AWSCognitoAuthPlugin());
                Amplify.addPlugin(new AWSDataStorePlugin());
                Amplify.addPlugin(new AWSApiPlugin());
                Amplify.configure(AmplifyConfiguration.builder(this).devMenuEnabled(false).build(), this);
                Log.d(TAG, "Amplify configured.");
            } catch (AmplifyException e) {
                Log.e(TAG, "Amplify Failed to Configure; this is likely caused by a duplicate call to Amplify.configure().", e);
            }
            initd = true;
        }
        Log.d(TAG, "onCreate finished");
    }
}
