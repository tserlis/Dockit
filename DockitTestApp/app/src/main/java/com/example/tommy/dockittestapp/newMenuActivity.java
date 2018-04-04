package com.example.tommy.dockittestapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class newMenuActivity extends AppCompatActivity implements SeatNumDialog.SeatNumDialogListener {

    //Initialising Menu buttons (s = starters, m = mains, d = desserts, o = orders)

    int seatNumber;
    TextView txtOrderConfirm;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //getting Order data
        final Order order = (Order) getIntent().getParcelableExtra("order");
        Bundle bundle = new Bundle();
        bundle.putParcelable("order", order);
       // MenuTab1Starters.setArguments(bundle);

        //Linking onscreen elements to variables

        txtOrderConfirm = findViewById(R.id.txtConfirmation);


        //Order confirmation text
        int numOfPeople = order.currentPerson();

        String orderConfirm ="";
        //Filling out order confirmation text fields
        for (int i = 0; i<numOfPeople; i++) {
            for (int j = 0; j<8; j++) {
                orderConfirm += "Seat " +(i+1) + " " + order.getFood(i, j) + "\n";
            }
        }
        txtOrderConfirm.setText(orderConfirm);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Applies user entered text from popup dialog box
    @Override
    public void applyText(int seatNum) {
        seatNumber = seatNum;
    }

    //Deleted placeholderFragment class from here

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           switch (position) {
               case 0:
                   MenuTab1Starters tab1 = new MenuTab1Starters();
                   return tab1;
               case 1:
                   MenuTab2Mains tab2 = new MenuTab2Mains();
                   return tab2;
               case 2:
                   MenuTab3Desserts tab3 = new MenuTab3Desserts();
                   return tab3;
               case 3:
                   MenuTab4Order tab4 = new MenuTab4Order();
                   return tab4;
               default:
                   return null;

           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Starters";
                case 1:
                    return "Mains";
                case 2:
                    return "Desserts";
                case 3:
                    return "Order";
            }
            return null;
        }
    }
}
