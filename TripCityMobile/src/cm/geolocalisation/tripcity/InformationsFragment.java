package cm.geolocalisation.tripcity;

import com.squareup.picasso.Picasso;

import cm.geolocalisation.tripcity.entities.Cite;
import cm.geolocalisation.tripcity.server.EngineConfiguration;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationsFragment extends Fragment {

	private TextView nom;
	private ImageView extended_image;
	private Cite _cite;
	private TextView showNbreStudios = null;
	private TextView nbreStudios = null;
	private TextView description = null;
	private TextView contact = null;
	private Button telephone = null;
	private TextView contactAAppeler = null;
	
	public InformationsFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_informations, container, false);
		_cite = CityDetailsActivity._cite;
		nom = (TextView) view.findViewById(R.id.tv_nom);
		showNbreStudios = (TextView) view.findViewById(R.id.showNbreStudios);
		nbreStudios = (TextView) view.findViewById(R.id.tv_nbreStudios);
		description = (TextView) view.findViewById(R.id.tv_description);
		contact = (TextView) view.findViewById(R.id.tv_contact);
		telephone = (Button) view.findViewById(R.id.bt_telephone);
		contactAAppeler = (TextView) view.findViewById(R.id.tv_contactToCall);
		extended_image = (ImageView) view.findViewById(R.id.extended_image);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		nom.setText(_cite.getCiteNom());
		nom.setTextSize(20);
		nom.setTextColor(getResources().getColor(R.color.myTextPrimaryColor));
		nbreStudios.setText(String.valueOf(_cite.getCiteNbreStudios()));
		description.setText("La Mini-cité "+_cite.getCiteNom()+" est située au quartier "+_cite.getCiteQuartier()+", "+_cite.getCiteLocalisation()+".");
		contact.setTextSize(17);
		contact.setTextColor(getResources().getColor(R.color.peru_color));
		nbreStudios.setTextSize(17);
		nbreStudios.setTextColor(getResources().getColor(R.color.peru_color));
		contactAAppeler.setText(getResources().getString(R.string.show_Call));
		telephone.setBackgroundColor(getActivity().getResources().getColor(R.color.myTextPrimaryColor));
		telephone.setText(_cite.getCiteContactConcierge());
		Picasso.with(getActivity()).load(EngineConfiguration.tripcity_path +"/fichiers/" + _cite.getCiteAvatar()).into(extended_image);
	}

}
