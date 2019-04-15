package android2.team2.imusic.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import android2.team2.imusic.R;
import android2.team2.imusic.models.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songArrayList;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private MediaPlayer mediaPlayer;
    static int position = -1;

    public SongAdapter(List<Song> songArrayList, Context context) {
        this.songArrayList = songArrayList;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Song song, int i);
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_song, viewGroup, false);
        final SongViewHolder songViewHolder = new SongViewHolder(view);
        songViewHolder.songInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mediaPlayer && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    position = -1;
                }
                if (songViewHolder.getAdapterPosition() != position) {
                    mediaPlayer = MediaPlayer.create(context, songArrayList.get(songViewHolder.getAdapterPosition()).getSongFile());
                    position = songViewHolder.getAdapterPosition();
                    mediaPlayer.start();
                }
            }
        });

        songViewHolder.songMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                PopupMenu popupMenu = new PopupMenu(context, v);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(context, "Menu " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.inflate(R.menu.menu_song_more_item);
                popupMenu.show();

                */
                Toast.makeText(context, "More " + String.valueOf(songViewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder, final int i) {
        Song song = this.songArrayList.get(i);
        songViewHolder.songImage.setImageResource(song.getSongImage());
        songViewHolder.songName.setText(song.getSongName());
        songViewHolder.songArtist.setText(song.getSongArtist());
    }

    @Override
    public int getItemCount() {
        return this.songArrayList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        ImageView songImage;
        LinearLayout songInfo;
        TextView songName;
        TextView songArtist;
        ImageView songPlayIcon;
        ImageView songMore;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songImage = itemView.findViewById(R.id.songImage);
            songInfo = itemView.findViewById(R.id.songInfo);
            songName = itemView.findViewById(R.id.songName);
            songArtist = itemView.findViewById(R.id.songArtist);
            songPlayIcon = itemView.findViewById(R.id.songPlayIcon);
            songMore = itemView.findViewById(R.id.songMore);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
