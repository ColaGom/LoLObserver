package com.cbstudio.lolobserver.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cbstudio.lolobserver.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Colabear on 2016-04-07.
 */
public class FragmentLogin extends Fragment {

    @Bind(R.id.et_name)
    EditText etName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


    @OnClick(R.id.btn_login)
    void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_login:
                break;
        }
    }
}
