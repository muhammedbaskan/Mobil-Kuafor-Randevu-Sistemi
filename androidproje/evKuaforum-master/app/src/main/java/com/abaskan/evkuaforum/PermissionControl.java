package com.abaskan.evkuaforum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PermissionControl extends AppCompatActivity {
    private int permissionControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_control);

        permissionControl = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if(permissionControl != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PermissionControl.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}
                                              ,1);

        } else {

        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){
            if(grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }else{

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
