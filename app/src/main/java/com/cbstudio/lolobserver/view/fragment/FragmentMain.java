package com.cbstudio.lolobserver.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cbstudio.lolobserver.Const;
import com.cbstudio.lolobserver.R;
import com.cbstudio.lolobserver.base.BaseFragment;
import com.cbstudio.lolobserver.model.ResponseTo;
import com.cbstudio.lolobserver.model.StatSummary;
import com.cbstudio.lolobserver.model.Summoner;
import com.cbstudio.lolobserver.net.DataDragonUrlBuilder;
import com.cbstudio.lolobserver.net.LOLClient;
import com.cbstudio.lolobserver.view.PinnedSectionListView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Summoner summoner = activity.getSummoner();
        statusViewHolder = new StatusViewHolder();
        statusViewHolder.bind(rootStatus);

        String iconUrl = new DataDragonUrlBuilder().profileIcons(summoner.getProfileIconId()).build();
        Glide.with(this).load(iconUrl).crossFade().fitCenter().into(statusViewHolder.ivIcon);
        statusViewHolder.tvName.setText(summoner.getSummonerName());
        statusViewHolder.tvLevel.setText(summoner.getSummonerLevel());

        LOLClient.getStatsSummary(summoner.getId(), new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    StatSummary statSummary = ResponseTo.statSummary(response);
                    statusViewHolder.setView(statSummary);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
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

        @Bind(R.id.tv_unrank_win)
        TextView tvUnrankWin;
        @Bind(R.id.tv_unrank_championkill)
        TextView tvUnrankChampionKill;
        @Bind(R.id.tv_unrank_neutralkill)
        TextView tvUnrankNeutralKill;
        @Bind(R.id.tv_unrank_minionkill)
        TextView tvUnrankMinionKill;
        @Bind(R.id.tv_unrank_assists)
        TextView tvUnrankAssists;
        @Bind(R.id.tv_unrank_turretskill)
        TextView tvUnrankTurretsKill;

        @Bind(R.id.tv_rank_win)
        TextView tvRankWin;
        @Bind(R.id.tv_rank_lose)
        TextView tvRankLose;
        @Bind(R.id.tv_rank_championkill)
        TextView tvRankChampionKill;
        @Bind(R.id.tv_rank_neutralkill)
        TextView tvRankNeutralKill;
        @Bind(R.id.tv_rank_minionkill)
        TextView tvRankMinionKill;
        @Bind(R.id.tv_rank_assists)
        TextView tvRankAssists;
        @Bind(R.id.tv_rank_turretskill)
        TextView tvRankTurretsKill;

        public void bind(View rootView)
        {
            ButterKnife.bind(this, rootView);
        }

        public void setView(StatSummary statSummary){
            StatSummary.AggregatedStat unrankStat = statSummary.getUnrankedStat().getAggregatedStats();
            StatSummary.AggregatedStat rankStat = statSummary.getRankedStat().getAggregatedStats();
            statusViewHolder.tvUnrankWin.setText(getString(R.string.prefix_win) + Const.NEW_LINE + statSummary.getUnrankedStat().getWins());
            statusViewHolder.tvUnrankAssists.setText(getString(R.string.prefix_assist) + Const.NEW_LINE + unrankStat.getTotalAssists());
            statusViewHolder.tvUnrankChampionKill.setText(getString(R.string.prefix_kill_camp) + Const.NEW_LINE + unrankStat.getTotalChampionKills());
            statusViewHolder.tvUnrankMinionKill.setText(getString(R.string.prefix_kill_minion) + Const.NEW_LINE + unrankStat.getTotalMinionKills());
            statusViewHolder.tvUnrankNeutralKill.setText(getString(R.string.prefix_kill_neutral) + Const.NEW_LINE+ unrankStat.getTotalNeutralMinionsKilled());
            statusViewHolder.tvUnrankTurretsKill.setText(getString(R.string.prefix_kill_turret) + Const.NEW_LINE + unrankStat.getTotalTurretsKilled());

            statusViewHolder.tvRankWin.setText(getString(R.string.prefix_win) + Const.NEW_LINE + statSummary.getRankedStat().getWins());
            statusViewHolder.tvRankLose.setText(getString(R.string.prefix_lose) + Const.NEW_LINE + statSummary.getRankedStat().getLosses());
            statusViewHolder.tvRankTurretsKill.setText(getString(R.string.prefix_kill_turret) + Const.NEW_LINE + rankStat.getTotalTurretsKilled());
            statusViewHolder.tvRankAssists.setText(getString(R.string.prefix_assist) + Const.NEW_LINE + rankStat.getTotalAssists());
            statusViewHolder.tvRankNeutralKill.setText(getString(R.string.prefix_kill_neutral) + Const.NEW_LINE + rankStat.getTotalNeutralMinionsKilled());
            statusViewHolder.tvRankMinionKill.setText(getString(R.string.prefix_kill_minion) + Const.NEW_LINE + rankStat.getTotalMinionKills());
            statusViewHolder.tvRankChampionKill.setText(getString(R.string.prefix_kill_camp) + Const.NEW_LINE + rankStat.getTotalChampionKills());
        }
    }
}
