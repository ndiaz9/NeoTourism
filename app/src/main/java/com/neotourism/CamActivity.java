package com.neotourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class CamActivity extends AppCompatActivity {
    private ImageSurfaceView mImageSurfaceView;
    private Camera camera;
    private FrameLayout cameraPreviewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        cameraPreviewLayout = (FrameLayout)findViewById(R.id.camera_preview);

        camera = checkDeviceCamera();
        mImageSurfaceView = new ImageSurfaceView(CamActivity.this, camera);
        if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            camera.setDisplayOrientation(90);
        } else {
            camera.setDisplayOrientation(0);
        }
        cameraPreviewLayout.addView(mImageSurfaceView);

    }

    private Camera checkDeviceCamera(){
        Camera mCamera = null;
        try {
            mCamera = Camera.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mCamera;
    }
    public void onClickBack(View view){
        super.onBackPressed();
    }
}