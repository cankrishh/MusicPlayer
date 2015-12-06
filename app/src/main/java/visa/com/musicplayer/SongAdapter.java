package visa.com.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vbathula on 06-Dec-15.
 */
public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> songList;
    private LayoutInflater songInflater;

    public SongAdapter(Context c, ArrayList<Song> songList){

        this.songList=songList;
        songInflater=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {

        return songList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout songLayout = (LinearLayout)songInflater.inflate(R.layout.song,parent,false);
        TextView titleView =(TextView)songLayout.findViewById(R.id.song_title);
        TextView artistView=(TextView)songLayout.findViewById(R.id.song_artist);

        Song currSong = songList.get(position);

        titleView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());

        songLayout.setTag(position);

        return songLayout;
    }
}
