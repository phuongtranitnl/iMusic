package android2.team2.imusic.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import android2.team2.imusic.R;
import android2.team2.imusic.models.Empty;

public class EmptyPageFragment extends Fragment {

    private View view;
    private ImageView imgEmptyImage;
    private TextView txtEmptyTitle;
    private TextView txtEmptyContent;
    private List<Empty> emptyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_empty_item, container, false);
        this.imgEmptyImage = view.findViewById(R.id.imgEmptyImage);
        this.txtEmptyTitle = view.findViewById(R.id.txtEmptyTitle);
        this.txtEmptyContent = view.findViewById(R.id.txtEmptyContent);
        return view;
    }
}
