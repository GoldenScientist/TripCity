package cm.geolocalisation.tripcity;

import java.util.List;

import cm.geolocalisation.tripcity.entities.Referentiel;
import cm.geolocalisation.tripcity.server.ReferentialResource;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReferentialFragment extends Fragment {
	
	public static RecyclerView list;
	private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager listLayoutManager;
    private TextView noReferential;
	
	public ReferentialFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_referential, container, false);
		list = (RecyclerView)  v.findViewById(R.id.referentials_list);
		noReferential = (TextView) v.findViewById(R.id.show_NoReferential);
		listLayoutManager = new LinearLayoutManager(getActivity());
		list.setLayoutManager(listLayoutManager);
		list.setHasFixedSize(true);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	 
	@Override
	public void onStart() {
	    super.onStart();
	}
	
	public void setUp(String query) {
		ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			new getReferences().execute(query);
	    } else {
	    	askUserToOpenNetwork();
	    }
		
	}
	
	private class getReferences extends AsyncTask<String, Void, List<Referentiel>> {

		private List<Referentiel> listeDesReferentiels= null;
		
		@Override
		protected List<Referentiel> doInBackground(String... params) {
			try {
				listeDesReferentiels = new ReferentialResource().getAllReferentials(params[0]);
			} catch (Exception e) {
				Log.e("Error in activity ", e.toString());
			} 
			return listeDesReferentiels;
		}
		
		@Override
		protected void onPostExecute(List<Referentiel> result) {
			
			if(result.isEmpty()) {
				noReferential.setText(getResources().getString(R.string.show_NoReferential));
			} else {
				noReferential.setVisibility(View.GONE);
				listAdapter = new SearchAdapter(getActivity(), result);
				list.setAdapter(listAdapter);
			}
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
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
}
