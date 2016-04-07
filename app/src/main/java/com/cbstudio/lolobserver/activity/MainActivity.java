package com.cbstudio.lolobserver.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.cbstudio.lolobserver.R;
import com.cbstudio.lolobserver.fragment.FragmentLogin;

public class MainActivity extends FragmentActivity {

    private final int FRAG_LOGIN = 1;
    private final int FRAG_MAIN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(FRAG_LOGIN);
    }

    private void replaceFragment(int idx)
    {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.root, getFragment(idx));

        transaction.commit();
    }


    private Fragment getFragment(int idx){

        switch (idx)
        {
            case FRAG_LOGIN:
                return new FragmentLogin();
            case FRAG_MAIN:
                break;
        }
        return new FragmentLogin();
    }
}

