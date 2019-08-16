package cm.geolocalisation.tripcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ParticularsFragment extends Fragment {

	private EditText position = null;

	public ParticularsFragment() { }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View particulars = inflater.inflate(R.layout.fragment_particulars, container, false);
		position = (EditText) particulars.findViewById(R.id.edit_position);
		return particulars;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		position.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), LocationActivity.class);
				startActivity(intent);
			}
		});
	}
	
}
