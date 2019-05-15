package br.com.jonathangomes.poccamera.home.activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.jonathangomes.poccamera.R;
import br.com.jonathangomes.poccamera.camera.fragment.CameraFragment;
import br.com.jonathangomes.poccamera.settings.fragment.SettingsFragment;

public class HomeActivity extends AppCompatActivity implements
        CameraFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener {

    FrameLayout fragmentContainer;
    BottomNavigationView bottomNavigationMenu;

    public void onCreate(Bundle savedInstanceState) {
        final CameraFragment cameraFragment = new CameraFragment();
        SettingsFragment settingsFragment = new SettingsFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentContainer = findViewById(R.id.fragmentContainer);
        bottomNavigationMenu = findViewById(R.id.bottomNavigationMenu);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.menu_camera:
                    showFragment(cameraFragment);
                    break;
                case R.id.menu_preferences:
                    showFragment(settingsFragment);
                    break;
            }
            return true;
        });
        bottomNavigationMenu.setSelectedItemId(R.id.menu_camera);
    }

    private void showFragment(Fragment homeFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, homeFragment).commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
