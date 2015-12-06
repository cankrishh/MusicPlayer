package visa.com.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import android.net.Uri;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.ListView;


public class Player extends Activity {

    private ArrayList<Song> songList;
    private ListView songView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        songView = (ListView)findViewById(R.id.song_list);
        songList=new ArrayList<Song>();

        getSongList();

        Collections.sort(songList, new Comparator<Song>() {
            @Override
            public int compare(Song a, Song b) {

                return a.getTitle().compareTo(b.getTitle());
            }
        });

        SongAdapter songAdapter = new SongAdapter(this,songList);
        songView.setAdapter(songAdapter);


    }

    public void getSongList(){

        ContentResolver musicResolver =getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor =musicResolver.query(musicUri,null,null,null,null);

        if(musicCursor!=null && musicCursor.moveToFirst()){

            int titleColumn =musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int albumColumn =musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int idColumn =musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artistColumn =musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

            do {
                long id =musicCursor.getLong(idColumn);
                String title =musicCursor.getString(titleColumn);
                String artist =musicCursor.getString(artistColumn);
                String album =musicCursor.getString(albumColumn);

                songList.add(new Song(id,title,artist,album));
            }while(musicCursor.moveToNext());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
