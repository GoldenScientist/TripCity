package cm.geolocalisation.tripcity;

import cm.geolocalisation.tripcity.entities.Referentiel;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

	private Toolbar _Toolbar;
	private NavigationDrawerFragment _NavigationDrawerFragment;
	Referentiel mReferentiel = null;
	String position_entree = null;
	EditText etPosition;
	
	public final static String EXTRA_POSITION = "cm.geolocalisation.tripcity.POSITION";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPosition = (EditText) findViewById(R.id.edit_position);
        _Toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(_Toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        _NavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_fragment);
        _NavigationDrawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), _Toolbar);
        Intent i = getIntent();
	    mReferentiel = i.getParcelableExtra(LocationActivity.EXTRA_REFERENTIEL);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(mReferentiel != null) {
        	position_entree = mReferentiel.getReferentielNom();
            etPosition.setText(position_entree);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    /* 
	 * Methode à appeler lorsque l'utilisateur clique sur le boutton Search.
	 * */
	
	@SuppressLint("NewApi")
	public void getPosition(View view) {
		Bundle extras = new Bundle();
		Intent intent = new Intent(this, ResultsActivity.class);
		intent.putExtra(EXTRA_POSITION, mReferentiel);
		if(!(etPosition.getText().toString().isEmpty())) {
			startActivity(intent);
		} else if(etPosition.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Please chose a location", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		
	}
	
}
