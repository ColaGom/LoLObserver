package com.cbstudio.lolobserver.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cbstudio.lolobserver.R;
import com.cbstudio.lolobserver.base.BaseFragment;
import com.cbstudio.lolobserver.net.DataDragonUrlBuilder;
import com.cbstudio.lolobserver.view.PinnedSectionListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Colabear on 2016-04-07.
 */
public class FragmentMain extends BaseFragment {

    @Bind(R.id.lv_main)
    PinnedSectionListView lvMain;

    @Bind(R.id.root_status)
    View rootStatus;

    StatusViewHolder statusViewHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        setStatusView();
        setListView();

        return view;
    }

    private void setStatusView(){
        statusViewHolder = new StatusViewHolder();
        statusViewHolder.bind(rootStatus);

        String iconUrl = new DataDragonUrlBuilder().profileIcons(activity.getSummoner().getProfileIconId()).build();
        Glide.with(this).load(iconUrl).crossFade().fitCenter().into(statusViewHolder.ivIcon);
    }

    private void setListView()
    {

    }

    class StatusViewHolder
    {
        @Bind(R.id.iv_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_level)
        TextView tvLevel;
        @Bind(R.id.tv_win_normal)
        TextView tvWinNormal;
        @Bind(R.id.tv_win_rank)
        TextView tvWinRank;

        public void bind(View rootView)
        {
            ButterKnife.bind(this, rootView);
        }
    }
}
