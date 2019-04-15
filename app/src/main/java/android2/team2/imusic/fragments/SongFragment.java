package android2.team2.imusic.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import android2.team2.imusic.R;
import android2.team2.imusic.adapters.SongAdapter;
import android2.team2.imusic.models.Song;

public class SongFragment extends Fragment {
    private View view;
    private RecyclerView songRecyclerView;
    private List<Song> songList;
    private MediaPlayer mediaPlayer;
    int position = 0;

    public SongFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recycler_view_layout, container, false);
        this.songRecyclerView = view.findViewById(R.id.recyclerView);

        SongAdapter songAdapter = new SongAdapter(songList, getContext());
        songRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        songRecyclerView.setHasFixedSize(true);
        songRecyclerView.setAdapter(songAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        songList = new ArrayList<>();
        songList.add(new Song(R.drawable.image_1, "cam_giac_luc_ay_se_ra_sao", "cam_giac_luc_ay_se_ra_sao", false, R.raw.cam_giac_luc_ay_se_ra_sao));
        songList.add(new Song(R.drawable.image_2, "co_nhan_tinh", "co_nhan_tinh", false, R.raw.co_nhan_tinh));
        songList.add(new Song(R.drawable.image_3, "cuoc_vui_co_don", "cuoc_vui_co_don", false, R.raw.cuoc_vui_co_don));
        songList.add(new Song(R.drawable.image_4, "em_da_thay_anh_cung_nguoi_ay", "em_da_thay_anh_cung_nguoi_ay", false, R.raw.em_da_thay_anh_cung_nguoi_ay));
        songList.add(new Song(R.drawable.image_5, "hong_nhan", "hong_nhan", false, R.raw.hong_nhan));
        songList.add(new Song(R.drawable.image_6, "mot_buo_yeu_van_dam_dau", "mot_buo_yeu_van_dam_dau", false, R.raw.mot_buo_yeu_van_dam_dau));
    }
}
