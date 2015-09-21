package agues.beeralbum.Activities.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import agues.beeralbum.Utils.BeerAlbum;
import agues.beeralbum.Utils.TransportData;

/**
 * Created by rennan.agues on 8/16/2015.
 */

public class ActivityBase extends Activity {

    public static Context context;

    public List<TransportData> listTransportData = new ArrayList<TransportData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = BeerAlbum.getAppContext();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
