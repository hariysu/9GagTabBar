package com.example.abdurahmanaydin.a9gagtabbar;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

// 2 işlem yapıyoruz. 1 fragment bulma 2 fragmentın title ı ne? addFragment metodunu MainActivity içinde kullanacağız.
// FragmentFresh/Hot/Trending fragmentları alıcam bu metot yardımıyla ekleyeceğim. Eklerken de onlara birer title vereceğiz.
// Böylece tabbarın üzerinde çıkan title'ları burada seçeceğim ve onları fragmentlerle bağlayacağım.
// MainActivity ile Fragment classları arasındaki geçiş sınıfı SectionsPageAdapter

public class SectionsPageAdapter extends FragmentPagerAdapter{

    private final List<Fragment> mFragmentList = new ArrayList <>();
    private final List<String> mFragmentTitleList = new ArrayList<>(); //Bu iki değişkeni alttaki metotlarla bağlıyoruz.


    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
