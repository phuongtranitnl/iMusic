package android2.team2.imusic.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import android2.team2.imusic.R;

public class PlaybarView extends ConstraintLayout {
    private View view;

    public PlaybarView(Context context) {
        super(context);
        initView();
    }

    public PlaybarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PlaybarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        view = layoutInflater.inflate(R.layout.playbar_layout, this, false);
    }
}
