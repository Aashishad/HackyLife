package com.example.hackylife;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hackylife.Adapter.CardFragmentPagerAdapter;
import com.example.hackylife.Adapter.CardItem;
import com.example.hackylife.Adapter.CardPagerAdapter;

public class genius extends AppCompatActivity {

        private CardPagerAdapter mCardAdapter;
        private ShadowTransformer mCardShadowTransformer;
        private CardFragmentPagerAdapter mFragmentCardAdapter;
        private ShadowTransformer mFragmentCardShadowTransformer;
        private boolean mShowingFragments = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_genius);
                ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

                mCardAdapter = new CardPagerAdapter();
                mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.genius_1));
                mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.genius_2));
                mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.genius_3));
                mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.genius_4));
                mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                        dpToPixels(2, this));

                mCardShadowTransformer = new ShadowTransformer(viewPager, mCardAdapter);
                mFragmentCardShadowTransformer = new ShadowTransformer(viewPager, mFragmentCardAdapter);

                viewPager.setAdapter(mCardAdapter);
                viewPager.setPageTransformer(false, mCardShadowTransformer);
                viewPager.setOffscreenPageLimit(3);

                Bundle bundle = getIntent().getExtras();
                if(bundle != null){
                        if(bundle.getString("some") !=null){
                                Toast.makeText(getApplicationContext(),"data"+ bundle.getString("some"),Toast.LENGTH_SHORT).show();
                        }
                }
        }

        public static float dpToPixels(int dp, Context context) {
                return dp * (context.getResources().getDisplayMetrics().density);
        }
}
