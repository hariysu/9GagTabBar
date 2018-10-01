package com.example.abdurahmanaydin.a9gagtabbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setupPager metodunu kullanarak herşeyi birbirine bağlayacağız.

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setupPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher); //Hot yazısının yanına klasik android ikonu ekledik.


        //SectionsPageAdapter class'ında daha önceden oluşturduğumuz fragmentlarla bir liste oluşturmuştuk. Ki bu
        //fragmentlerı liste içine ekleyebilelim. Burada ise fragmentlerı aslında bir adaptöre ekledik. Ve bu adaptörü
        //de daha önce create ettiğimiz SectionsPageAdapter class'ını kullarak create ettik. O yüzden aslında biraz
        // önce yazdığımız kodlar gibi bunlar aldı listenin içine bizim create ettiğimiz fragmentlerı tek tek ekledi.
        //Ondan sonra kendi viewPager ve sectionsPageAdapter'ımızı kullandık ve en sonunda tablayout dediğimiz obje yi
        //create etmeyi başardık. tablayout objesi MainActivity açıldığında onCreate'de çağrılacak ve fresh,hot,trending
        //xml'lerinde ne dizayn yaptıysak onlar karşımıza çıkacak

        //MainActivity to SectionsPageAdapter to Fragment(Fresh,Hot,Trending)


    }

    private void setupPager(ViewPager viewPager){

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentHot(),"Hot");
        adapter.addFragment(new FragmentFresh(),"Fresh");
        adapter.addFragment(new FragmentTrending(),"Trending");
        viewPager.setAdapter(adapter);
    }
}
