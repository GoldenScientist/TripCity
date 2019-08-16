package cm.geolocalisation.tripcity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

	private OnItemClickListener _listener;
	public interface OnItemClickListener {
		public void onItemClick(View view, int position);
	}
	
	GestureDetector _gestureDetector;
	
	public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
		_listener = listener;
		_gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				return true;
			}
		});
	}
	@Override
	public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent motion) {
		View childView = view.findChildViewUnder(motion.getX(), motion.getY());
		if (childView != null && _listener != null && _gestureDetector.onTouchEvent(motion)) {
			_listener.onItemClick(childView, view.getChildPosition(childView));
		      return true;
		    }
		    return false;
	}

	@Override
	public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}

}
