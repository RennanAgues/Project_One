package agues.beeralbum.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import agues.beeralbum.Activities.Base.ActivityBase;
import agues.beeralbum.R;
import agues.beeralbum.Utils.BeerAlbum;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rennan.agues on 8/16/2015.
 */
public class AdapterListView1Title1Image extends BaseAdapter  {

    ArrayList<String> Title;
    ArrayList<Integer> Image;

    AdapterListView1Title1Image() {
        Title = null;
        Image = null;
    }

    public AdapterListView1Title1Image(ArrayList<String> text1, ArrayList<Integer> image) {
        Title =  text1;
        Image = image;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.size();
    }

    public Object getItem(int position) {
       return Title.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) BeerAlbum.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderAdapterListView1Title1Image holder;

        if (convertView != null) {
            holder = (ViewHolderAdapterListView1Title1Image) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.list_view_1_title_1_image, parent, false);
            holder = new ViewHolderAdapterListView1Title1Image(convertView);
            convertView.setTag(holder);
        }

        holder.title.setText(Title.get(position));
        holder.imageView.setImageResource(Image.get(position));

        return (convertView);
    }

    static class ViewHolderAdapterListView1Title1Image {
        @Bind(R.id.id_title_list_view)
        TextView title;

        @Bind(R.id.id_image_list_view)
        ImageView imageView;

        public ViewHolderAdapterListView1Title1Image(View view) {
            ButterKnife.bind(this, view);
        }
    }
}


