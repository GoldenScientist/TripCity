package cm.geolocalisation.tripcity;


import cm.geolocalisation.tripcity.entities.Cite;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CityDetailsActivity extends ActionBarActivity {

	private Toolbar _Toolbar;
	private ViewPager viewPager;
	private SlidingTabLayout sTabs;
	public static Cite _cite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_details);
		_Toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar_city_details);
		setSupportActionBar(_Toolbar);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new AdaptateurMaison(getSupportFragmentManager()));
        sTabs = (SlidingTabLayout)  findViewById(R.id.tabs);
        sTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        sTabs.setDistributeEvenly(true);
        sTabs.setBackgroundColor(getResources().getColor(R.color.green_color));
        sTabs.setSelectedIndicatorColors(getResources().getColor(R.color.myTextPrimaryColor));
        sTabs.setViewPager(viewPager); 
        
        Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		int index = extras.getInt("index", 0);
		_cite = 	CityAdapter._result.get(index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.pharmacy_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class AdaptateurMaison extends FragmentPagerAdapter {

		String[ ] tabs;
		public AdaptateurMaison(FragmentManager fm) {
			super(fm);
			tabs = getResources().getStringArray(R.array.tabs);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			if(position == 0) {
				fragment = new InformationsFragment();
			} else if(position == 1) {
				fragment = new LocationFragment();
			} 
			return fragment;
		}
		
		@Override 
		public CharSequence getPageTitle(int position) {
			return tabs[position].toUpperCase();
		}

		@Override
		public int getCount() {
			return 2;
		}
		
	}
	
	public void callThisNumber(View v) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+_cite.getCiteContactConcierge()));
		this.startActivity(intent);
	}
	
}
