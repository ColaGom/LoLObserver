package com.cbstudio.lolobserver.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.cbstudio.lolobserver.R;
import com.cbstudio.lolobserver.model.Summoner;
import com.cbstudio.lolobserver.view.fragment.FragmentSearch;
import com.cbstudio.lolobserver.view.fragment.FragmentMain;

public class MainActivity extends FragmentActivity {

    enum FRAGMENT
    {
        SEARCH,
        MAIN
    }

    Summoner summoner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(FRAGMENT.SEARCH);
    }

    public void onSuccessLogin(Summoner summoner)
    {
        this.summoner = summoner;
        replaceFragment(FRAGMENT.MAIN);
    }

    public Summoner getSummoner(){
        return summoner;
    }

    private void replaceFragment(FRAGMENT frag)
    {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.root, getFragment(frag));

        transaction.commit();
    }

    private Fragment getFragment(FRAGMENT frag){

        switch (frag)
        {
            case SEARCH:
                return new FragmentSearch();
            case MAIN:
                return new FragmentMain();
        }
        return new FragmentSearch();
    }
}

