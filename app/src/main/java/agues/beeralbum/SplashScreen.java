package agues.beeralbum;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import agues.beeralbum.Activities.*;
import agues.beeralbum.Activities.Base.ActivityBase;
import agues.beeralbum.Utils.BeerAlbum;

public class SplashScreen extends ActivityBase {

    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();

    void CallCollectionByFilterOnTime3Seconds() {
        Runnable task = new Runnable() {
            public void run() {
                try {
                    startActivity(new Intent(BeerAlbum.getAppContext(), ActivitySelectCollectionByFilter.class));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        };
        worker.schedule(task, 3, TimeUnit.SECONDS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        CallCollectionByFilterOnTime3Seconds();

        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT == 14 || Build.VERSION.SDK_INT == 15){
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            decorView.setSystemUiVisibility(uiOptions);
        } else if (Build.VERSION.SDK_INT >= 16) {
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
