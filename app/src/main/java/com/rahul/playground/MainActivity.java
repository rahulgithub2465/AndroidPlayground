package com.rahul.playground;

import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rahul.playground.permissionCheck.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions();
        isPermissionsGranted.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (isPermissionsGranted.get()) {
                    isPermissionsGranted.set(false);
                    Toast.makeText(MainActivity.this, "Permissions Granted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

