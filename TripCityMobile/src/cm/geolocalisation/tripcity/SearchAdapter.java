package cm.geolocalisation.tripcity;

import java.util.ArrayList;
import java.util.List;

import cm.geolocalisation.tripcity.entities.Referentiel;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ReferentialViewHolder> {
	
	public static List<Referentiel> _referentiel = new ArrayList<Referentiel>();
	private Context _context;
	
	public static class ReferentialViewHolder extends RecyclerView.ViewHolder  {

        TextView referntiel;
       
        ReferentialViewHolder(View itemView) {
            super(itemView);
            referntiel = (TextView) itemView.findViewById(R.id.tv_referential);
        }

    }
	
	public SearchAdapter(Context context, List<Referentiel> result) {
		super();
		_context = context;
		_referentiel = result;
	}
	

	@Override
	public int getItemCount() {
		return _referentiel.size();
	}

	@Override
	public void onBindViewHolder(ReferentialViewHolder referentialViewHolder, int position) {
		referentialViewHolder.referntiel.setText(_referentiel.get(position).getReferentielNom());
	}

	@Override
	public ReferentialViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View rowView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.referential_row, viewGroup, false);
		ReferentialViewHolder pvh = new ReferentialViewHolder(rowView);
        return pvh;
	}

}
