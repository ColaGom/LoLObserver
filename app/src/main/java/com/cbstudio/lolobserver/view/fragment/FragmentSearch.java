package com.cbstudio.lolobserver.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cbstudio.lolobserver.R;
import com.cbstudio.lolobserver.base.BaseFragment;
import com.cbstudio.lolobserver.model.ResponseTo;
import com.cbstudio.lolobserver.model.Summoner;
import com.cbstudio.lolobserver.net.LOLClient;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-07.
 */
public class FragmentSearch extends BaseFragment {

    @Bind(R.id.et_name)
    EditText etName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_search)
    void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_search:
                final String userName = etName.getText().toString();

                if(TextUtils.isEmpty(userName))
                {
                    Toast.makeText(getContext(), R.string.msg_input_name, Toast.LENGTH_SHORT).show();
                    return;
                }

                LOLClient.getSummonerByName(userName, new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Summoner summoner = ResponseTo.summoner(response, userName);
                            Logger.d(summoner.toString());
                            summoner.setSummonerName(userName);
                            activity.onSuccessLogin(summoner);
                        } catch (IOException e) {
                            Toast.makeText(getContext(), R.string.msg_fail_search, Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        } catch (NullPointerException e)
                        {
                            Toast.makeText(getContext(), R.string.msg_fail_search, Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Logger.d("onFailure");
                    }
                });
                break;
        }
    }
}
