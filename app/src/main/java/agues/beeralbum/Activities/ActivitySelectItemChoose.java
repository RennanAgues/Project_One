package agues.beeralbum.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import agues.beeralbum.Activities.Base.ActivityBase;
import agues.beeralbum.Adapters.AdapterListView1Title1Image;
import agues.beeralbum.R;
import agues.beeralbum.Utils.Constantes;
import butterknife.Bind;
import butterknife.ButterKnife;

import static agues.beeralbum.R.string.brand;

public class ActivitySelectItemChoose extends ActivityBase {

    //Find Items Layout
    @Bind(R.id.id_list_view_collection_choose)
    ListView listViewCollectionChoose;

    AdapterListView1Title1Image adapterCollectionChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_select_item_choose);
        ButterKnife.bind(this);

        amountScreenByFilter(getIntent().getExtras().getString(Constantes.TYPE_FILTER));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_select_item_choose, menu);
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

    private void amountScreenByFilter(String filter){
        //TODO Montar a busca na base de dados

        ArrayList<String> itemsTitles = new ArrayList<String>();
        ArrayList<Integer> itemsImages = new ArrayList<Integer>();

        adapterCollectionChoose = new AdapterListView1Title1Image(itemsTitles, itemsImages);
        listViewCollectionChoose.setAdapter(adapterCollectionChoose);

        if(filter.equals(getString(R.string.country))){
            itemsTitles.add("Brasil");
            itemsImages.add(R.drawable.img_globo);
            itemsTitles.add("Alemanha");
            itemsImages.add(R.drawable.img_globo);
            itemsTitles.add("Irlanda");
            itemsImages.add(R.drawable.img_globo);
        }else if (filter.equals(getString(R.string.brand))){
            itemsTitles.add("Itaipava");
            itemsImages.add(R.drawable.img_globo);
            itemsTitles.add("SKOL");
            itemsImages.add(R.drawable.img_globo);
        }else if(filter.equals(getString(R.string.style))){
            itemsTitles.add("Blond");
            itemsImages.add(R.drawable.img_globo);
        }
    }
}
