package cm.geolocalisation.tripcity;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;

import cm.geolocalisation.tripcity.entities.*;
import cm.geolocalisation.tripcity.server.EngineConfiguration;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
	
	String _photoNom = null;
	public static List<Cite> _result = new ArrayList<Cite>();
	private Context _context;
	
	public static class CityViewHolder extends RecyclerView.ViewHolder  {

        CardView cv_city_row;
        TextView nom_cite;
        ImageView photo_cite;

        CityViewHolder(View itemView) {
            super(itemView);
            cv_city_row = (CardView) itemView.findViewById(R.id.cv_city_row);
            photo_cite = (ImageView) itemView.findViewById(R.id.photo);
            nom_cite = (TextView) itemView.findViewById(R.id.label);
        }

    }
	
	public CityAdapter(Context context, List<Cite> result) {
		super();
		_context = context;
		_result = result;
	}
	

	@Override
	public int getItemCount() {
		return _result.size();
	}

	@Override
	public void onBindViewHolder(CityViewHolder cityViewHolder, int position) {
		cityViewHolder.nom_cite.setText(_result.get(position).getCiteNom());
		_photoNom = _result.get(position).getCiteAvatar();
		Picasso.with(_context).load(EngineConfiguration.tripcity_path +"/fichiers/" +_photoNom).fit().centerCrop().into(cityViewHolder.photo_cite);
	}

	@Override
	public CityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View rowView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_row, viewGroup, false);
		CityViewHolder pvh = new CityViewHolder(rowView);
        return pvh;
	}

}
