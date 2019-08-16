package cm.geolocalisation.tripcity;

import cm.geolocalisation.tripcity.entities.Referentiel;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LocationActivity extends ActionBarActivity {

	private String _QueryHint = "Search referential";
	Referentiel _Referentiel;
	private Toolbar _Toolbar;
	private SearchView searchView;
	String srtReferentiel;
	private ReferentialFragment _ReferentialFragment;
	public final static String EXTRA_REFERENTIEL = "cm.geolocalisation.tripcity.REFERENTIAL";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		_Toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar_location);
        setSupportActionBar(_Toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _ReferentialFragment = (ReferentialFragment) getSupportFragmentManager().findFragmentById(R.id.referentials);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.location, menu);
		
		final MenuItem itemSearch = menu.findItem(R.id.action_search_location);
		searchView = (SearchView) MenuItemCompat.getActionView(itemSearch);
		searchView.setIconifiedByDefault(false);
		searchView.setBackgroundColor(getResources().getColor(R.color.green_color));
		searchView.setQueryHint(_QueryHint);
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String query) {
				Intent intent = new Intent(LocationActivity.this, MainActivity.class);
				intent.putExtra(EXTRA_REFERENTIEL, _Referentiel);
				startActivity(intent);
				return true;
			}
			
			@SuppressLint("NewApi")
			@Override
			public boolean onQueryTextChange(String newText) {
				if(!newText.isEmpty()) {
					_ReferentialFragment.setUp(newText);
				} else {
					//_ReferentialFragment.setUp("nothing");
				}
				_ReferentialFragment.list.addOnItemTouchListener(new RecyclerItemClickListener(LocationActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
					
					@Override
					public void onItemClick(View view, int position) {
						_Referentiel = SearchAdapter._referentiel.get(position);
						srtReferentiel = _Referentiel.getReferentielNom();
						searchView.setQuery(srtReferentiel, false);
					}
				}));
				return true;
			}
		});
		
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
	
}
