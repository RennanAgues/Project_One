package agues.beeralbum.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import agues.beeralbum.Activities.Base.ActivityBase;
import agues.beeralbum.Adapters.*;
import agues.beeralbum.R;
import agues.beeralbum.Utils.BeerAlbum;
import agues.beeralbum.Utils.Constantes;
import agues.beeralbum.Utils.Helper;
import agues.beeralbum.Utils.TransportData;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

import static agues.beeralbum.R.string.brand;

public class ActivitySelectCollectionByFilter extends ActivityBase {

    private String TAG = "ActivitySelectCollectionByFilter" ;

    //Find Items Layout
    @Bind(R.id.id_list_view_collection_filters)
    ListView listViewCollectionFilters;

    AdapterListView1Title1Image adapterCollectionFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select_collection_by_filter);
            ButterKnife.bind(this);

            // Charge items for create Screen
            ChargeValuesScreen();
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_activity_select_collection_by_filter, menu);
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }

        return super.onOptionsItemSelected(item);
    }

    private void ChargeValuesScreen(){
        try {
            ArrayList<String> itemsTitles = new ArrayList<String>();
            itemsTitles.add(getString(R.string.country));
            itemsTitles.add(getString(R.string.style ));
            itemsTitles.add(getString(brand));

            ArrayList<Integer> itemsImages = new ArrayList<Integer>();
            itemsImages.add(R.drawable.img_globo);
            itemsImages.add(R.drawable.estilos_cervejas);
            itemsImages.add(R.drawable.beer_without_brand);

            adapterCollectionFilters = new AdapterListView1Title1Image(itemsTitles, itemsImages);
            listViewCollectionFilters.setAdapter(adapterCollectionFilters);
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }
    }

    @OnItemClick(R.id.id_list_view_collection_filters)
    public void onClickListViewCollectionFilters(int position) {
        try {
            listTransportData.add(new TransportData(Constantes.TYPE_FILTER, listViewCollectionFilters.getAdapter().getItem(position)));
            Helper.StartActivity(this, new ActivitySelectItemChoose(), listTransportData);
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        try {
            Dialog dialog = CreateDialog(BeerAlbum.getAppContext());

            dialog.show();
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }
    }

    public Dialog CreateDialog(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);

        try {
            builder.setMessage("do you wish to sign out?");
            builder.setTitle("Sign Out");

            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog dialog = builder.create();
        }catch (Exception e){
            Log.i(TAG,e.getMessage());
        }

        return builder.create();
    }
}
