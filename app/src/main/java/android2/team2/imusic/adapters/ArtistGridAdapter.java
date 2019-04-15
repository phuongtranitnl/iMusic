package android2.team2.imusic.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import android2.team2.imusic.models.Artist;

public class ArtistGridAdapter extends BaseAdapter {

    private List<Artist> artistList;
    private Context context;

    public ArtistGridAdapter(List<Artist> artistList, Context context) {
        this.artistList = artistList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return artistList.size();
    }

    @Override
    public Object getItem(int position) {
        return artistList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


    static class ViewHolder {
        ImageView imgArtistImage;
        TextView txtArtistName;
        TextView txtArtistTotal;
    }
}
