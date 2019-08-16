package cm.geolocalisation.tripcity;

import java.util.List;

import com.squareup.picasso.Picasso;

import cm.geolocalisation.tripcity.entities.ArchitectureAppartement;
import cm.geolocalisation.tripcity.entities.Cite;
import cm.geolocalisation.tripcity.server.AppartmentResource;
import cm.geolocalisation.tripcity.server.CiteResource;
import cm.geolocalisation.tripcity.server.EngineConfiguration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OthersFragment extends Fragment {

	private TextView showNbreChambres = null;
	private TextView description = null;
	private ImageView extended_image;
	private Cite _cite;
	private ArchitectureAppartement _archt;
	private LinearLayout ll_appart;
	private LinearLayout ll_studio;
	private LinearLayout ll_chambre;

	
	public OthersFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View others = inflater.inflate(R.layout.fragment_others, container, false);
		_cite = CityDetailsActivity._cite;
		showNbreChambres = (TextView) others.findViewById(R.id.showNbreChambres);
		description = (TextView) others.findViewById(R.id.tv_description);
		ll_appart = (LinearLayout) others.findViewById(R.id.ll_appartement);
		ll_studio = (LinearLayout) others.findViewById(R.id.ll_studio);
		ll_chambre = (LinearLayout) others.findViewById(R.id.ll_chambre);
		extended_image = (ImageView) others.findViewById(R.id.extended_appartement_image);
		return others;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		new getAppartment().execute(_cite.getCiteId());
		
	}
	
	private class getAppartment extends AsyncTask<Long, Void, ArchitectureAppartement> {
		
		private ArchitectureAppartement Appartement = new ArchitectureAppartement();
		
		@Override
		protected void onPostExecute(ArchitectureAppartement result) {
			Picasso.with(getActivity()).load(EngineConfiguration.tripcity_path +"/fichiers/"+result.getArchitectureAppartementPhoto()).into(extended_image);
			description.setText(result.getArchitectureAppartementDescription());
		}

		@Override
		protected ArchitectureAppartement doInBackground(Long... params) {
			try {
				Appartement = new AppartmentResource().getArchitectureAppartement(params[0]); 
			} catch (Exception e) {
				Log.e("Error ", e.toString());
				e.printStackTrace();
			} 
			return Appartement;
		}
	}

}
