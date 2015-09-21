package agues.beeralbum.Utils;

import android.app.Activity;
import android.content.Intent;

import java.util.List;

import agues.beeralbum.Activities.ActivitySelectCollectionByFilter;

/**
 * Created by rennan.agues on 8/17/2015.
 */
public class Helper {


    public static void StartActivity(final Activity currentActivity, final Activity sendActivity, List<TransportData> listTransportData){
        Intent intent = new Intent(currentActivity, sendActivity.getClass());

        if(listTransportData != null){
            for(TransportData transportData : listTransportData ){
                if(transportData.getValue() instanceof String){
                    intent.putExtra(transportData.getKey(), (String)transportData.getValue());
                }else if(transportData.getValue() instanceof Boolean){
                    intent.putExtra(transportData.getKey(), (Boolean)transportData.getValue());
                }else if(transportData.getValue() instanceof Integer){
                    intent.putExtra( transportData.getKey(), (Integer)transportData.getValue());
                }
            }
        }

        currentActivity.startActivity(intent);
    }
}
