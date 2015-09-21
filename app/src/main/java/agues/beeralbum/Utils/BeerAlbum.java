package agues.beeralbum.Utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by rennan.agues on 8/16/2015.
 */
public class BeerAlbum extends Application {

    private static Context contextBase;

    public void onCreate(){
        super.onCreate();
        contextBase = getApplicationContext();
    }

    public static Context getAppContext() {
        return contextBase;
    }
}
