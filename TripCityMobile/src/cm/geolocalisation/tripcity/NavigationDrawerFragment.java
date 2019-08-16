package cm.geolocalisation.tripcity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavigationDrawerFragment extends Fragment {

	private ActionBarDrawerToggle _DrawerToggle;
	private DrawerLayout _DrawerLayout;
	private boolean _UserLearnedDrawer;
	private boolean _FromSaveInstanceState;
	public static final String PREF_FILE_NAME = "testpref";
	public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
	
	public NavigationDrawerFragment() { }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_UserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
		if(savedInstanceState != null) {
			_FromSaveInstanceState = true;
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View navigation_drawer = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
		return navigation_drawer;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		_DrawerToggle.syncState();
	}
	
	public void setUp(DrawerLayout drawerLayout,Toolbar toolbar) {
		_DrawerLayout = drawerLayout; 
		_DrawerToggle = new ActionBarDrawerToggle(getActivity(),_DrawerLayout, toolbar, R.string.show_Open, R.string.show_Close) {
			
			@Override
			public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
			
			@Override
			public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
		};
		_DrawerLayout.setDrawerListener(_DrawerToggle);
	} 
	
	@SuppressLint("NewApi") public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(preferenceName, preferenceValue);
		editor.apply();
	}
	
	public static String readFromPreferences(Context context, String preferenceName, String preferenceValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getString(preferenceName, preferenceValue);
	}
	

}
