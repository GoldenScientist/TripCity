package cm.geolocalisation.tripcity;

import java.util.ArrayList;
import java.util.List;

import com.directions.route.Route;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import cm.geolocalisation.tripcity.*;
import cm.geolocalisation.tripcity.entities.Cite;
import cm.geolocalisation.tripcity.entities.Referentiel;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class LocationFragment extends Fragment implements RoutingListener {

	private List<Cite> _cite = new ArrayList<Cite>();
	private Referentiel _referentiel;
	private GoogleMap map;
	private LatLng CITE;
	private LatLng CITE_VISEE;
	private LatLng REFERENTIEL;
	private Bundle extras;
	
	public LocationFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_location, container, false);
		/*
		 * Récupération de la lste de cites.
		 * */
		Intent intent = getActivity().getIntent();
		extras = intent.getExtras();
		int index = extras.getInt("index", 0);
		_cite = CityAdapter._result;
		/*
		 * Récupération de la carte.
		 * */
		map = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
		// Ajout des marqueurs sur la carte précédement récupérée.
		for(int i=0; i<_cite.size(); i++) {
			CITE = new LatLng(_cite.get(i).getCiteLatitude(), _cite.get(i).getCiteLongitude());
			Marker mMarker = map.addMarker(new MarkerOptions()
			.position(CITE)
			.title(_cite.get(i).getCiteNom()));
		}
		CITE_VISEE = new LatLng(CityDetailsActivity._cite.getCiteLatitude(), CityDetailsActivity._cite.getCiteLongitude());
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(CITE_VISEE, 10));
		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Routing routing = new Routing(Routing.TravelMode.BIKING);
		routing.registerListener(this);
		_referentiel = extras.getParcelable("referentiel");
		REFERENTIEL = new LatLng(_referentiel.getReferentielLatitude(), _referentiel.getReferentielLongitude());
		routing.execute(REFERENTIEL, CITE_VISEE);
	}

	@Override
	public void onRoutingFailure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRoutingStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route) {
		PolylineOptions polyoptions = new PolylineOptions();
	    polyoptions.color(Color.BLUE);
	    polyoptions.width(10);
	    polyoptions.addAll(mPolyOptions.getPoints());
	    map.addPolyline(polyoptions);
	    float distance = Float.valueOf(route.getDistanceText().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
	    Toast.makeText(getActivity().getApplicationContext(), ""+distance+" km to the referential", Toast.LENGTH_LONG).show();
	    
	    // Start marker
	    MarkerOptions options = new MarkerOptions();
	    options.position(REFERENTIEL).title(_referentiel.getReferentielNom());
	    options.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
	    map.addMarker(options);

	    // End marker
	    options = new MarkerOptions();
	    options.position(CITE_VISEE);
	    //options.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));  
	    map.addMarker(options);
	}
	
	

}
