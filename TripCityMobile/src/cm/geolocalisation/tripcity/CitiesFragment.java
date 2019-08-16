package cm.geolocalisation.tripcity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.directions.route.Route;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cm.geolocalisation.tripcity.entities.*;
import cm.geolocalisation.tripcity.server.CiteResource;
import android.os.AsyncTask;
import android.util.Log;
import cm.geolocalisation.tripcity.R;

public class CitiesFragment extends Fragment implements OnRefreshListener {
	
	private int _curentPosition = 0;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private String position_entree;
	private String quartier;
	private String departement;
	private int indexRef;
	private Referentiel _referentiel;
	private List<Cite> secondeListeDeCites = new ArrayList<Cite>();
	public static LatLng REFERENTIEL;
	private RecyclerView list;
	private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager listLayoutManager;
    private ProgressBar progress;
    private TextView noCity;
    private LatLng CITE_VISEE;
    private Routing routing = new Routing(Routing.TravelMode.BIKING);
	
	public CitiesFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_cities, container, false);
		list = (RecyclerView) v.findViewById(R.id.city_list);
		noCity = (TextView) v.findViewById(R.id.show_NoCity);
		listLayoutManager = new LinearLayoutManager(getActivity());
		list.setLayoutManager(listLayoutManager);
		list.setHasFixedSize(true);
		progress = (ProgressBar) v.findViewById(R.id.pbEmptyList);
		mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_city_list);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Intent intent = getActivity().getIntent();
		Bundle extras = intent.getExtras();
		_referentiel = intent.getParcelableExtra(MainActivity.EXTRA_POSITION);
		quartier = _referentiel.getReferentielQuartier();
		departement = _referentiel.getReferentielDepartement();
		REFERENTIEL = new LatLng(_referentiel.getReferentielLatitude(), _referentiel.getReferentielLongitude());
	}
	
	@Override
	public void onResume() {
        super.onResume();
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			new getAllCitiesByReferential().execute(quartier, departement);
	    } else {
	    	askUserToOpenNetwork();
	    }
        
    }
	
	private class getAllCitiesByReferential extends AsyncTask<String, Void, List<Cite>> {
		
		private List<Cite> listeDesCites = null;
		
		@Override
		protected void onPostExecute(List<Cite> result) {
			
			if(result.isEmpty()) {
				noCity.setText(getResources().getString(R.string.show_City));
				progress.setVisibility(View.GONE);
			} else {
				for (Cite city : result) {
					secondeListeDeCites.add(city);
		        }
				listAdapter = new CityAdapter(getActivity(), result);
			}
			progress.setVisibility(View.GONE);
			list.setAdapter(listAdapter);
			list.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
				
				@Override
				public void onItemClick(View view, int position) {
					showDetails(position);
				}
			}));
			mSwipeRefreshLayout.setRefreshing(false);
		}

		@Override
		protected List<Cite> doInBackground(String... params) {
			try {
				listeDesCites = new CiteResource().getAllCities(params[0], params[1]); 
			} catch (Exception e) {
				Log.e("Error in activity ", e.toString());
			} 
			return listeDesCites;
		}
	}
	
	public void showDetails(int index) {
		_curentPosition = index;
		Intent intent = new Intent(getActivity(), CityDetailsActivity.class);
		Bundle extras = new Bundle();
		extras.putInt("index", _curentPosition);
		extras.putParcelable("referentiel", _referentiel);
		intent.putExtras(extras);
		startActivity(intent);
	}

	@Override
	public void onRefresh() {
		 ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = cm.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				new getAllCitiesByReferential().execute(quartier, departement);
		    } else {
		    	askUserToOpenNetwork();
		    }
	}
	
	public void askUserToOpenNetwork() {
		AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(getActivity());

		mAlertDialog.setTitle("No results for your search").setMessage("Please chech your internet connection an try again later").setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				
				}
			}).show();
	}
	
	public Boolean isOnline() {
	    try {
	        Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 192.168.41.1");
	        int returnVal = p1.waitFor();
	        boolean reachable = (returnVal==0);
	        return reachable;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
}
