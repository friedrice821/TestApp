package com.example.testapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.dummy.DummyContent;

/**
 * A fragment representing a single Host detail screen. This fragment is either
 * contained in a {@link HostListActivity} in two-pane mode (on tablets) or a
 * {@link HostDetailActivity} on handsets.
 */
public class HostDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public HostDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_host_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.hostDetail))
					.setText(mItem.email);
			((TextView) rootView.findViewById(R.id.textView2))
			.setText(mItem.name);
			((TextView) rootView.findViewById(R.id.textView4))
			.setText(mItem.address);
			((TextView) rootView.findViewById(R.id.textView5))
			.setText(mItem.phone);
			((TextView) rootView.findViewById(R.id.textView6))
			.setText(mItem.smoking);
			((TextView) rootView.findViewById(R.id.pets))
			.setText(mItem.pets);
			((TextView) rootView.findViewById(R.id.cats))
			.setText(mItem.pets);
			((TextView) rootView.findViewById(R.id.birds))
			.setText(mItem.pets);			
			((TextView) rootView.findViewById(R.id.other))
			.setText(mItem.pets);
//			((TextView) rootView.findViewById(R.id.distance))
//			.setText(mItem.distance);
			((TextView) rootView.findViewById(R.id.start))
			.setText(mItem.start);
			((TextView) rootView.findViewById(R.id.end))
			.setText(mItem.end);
//			((TextView) rootView.findViewById(R.id.blurbb))
//			.setText(mItem.blurb);
		}

		return rootView;
	}
}
