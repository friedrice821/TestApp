package com.example.testapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.testapp.dummy.DummyContent;
import com.example.testapp.dummy.DummyContent.DummyItem;

/**
 * An activity representing a list of Hosts. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link HostDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link HostListFragment} and the item details (if present) is a
 * {@link HostDetailFragment}.
 * <p>
 * This activity also implements the required {@link HostListFragment.Callbacks}
 * interface to listen for item selections.
 */
public class HostListActivity extends FragmentActivity implements

HostListFragment.Callbacks {
	public Vector<String> hostlist = new Vector<String>();
	public Vector<String> onehost = new Vector<String>();
	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_host_list);

		try {

			InputStream in = openFileInput("hosts");
			if (in != null) {
				InputStreamReader tmp=new InputStreamReader(in);
				BufferedReader reader=new BufferedReader(tmp);

				String str;
				str = reader.readLine();

				StringBuilder buf=new StringBuilder();

				while(str != null) {
					hostlist.add(str);
					str = reader.readLine();

				}
				in.close();
			}

		} catch (java.io.FileNotFoundException e) {

		}
		catch (Exception e) {}

		for (int i = 0; i < hostlist.size(); i++) {
			try {

				InputStream in = openFileInput(hostlist.get(i));
				if (in != null) {
					InputStreamReader tmp=new InputStreamReader(in);
					BufferedReader reader=new BufferedReader(tmp);

					String str;
					str = reader.readLine();
					str = reader.readLine();
					str = reader.readLine();
					onehost.add(hostlist.get(i));

					StringBuilder buf=new StringBuilder();

					while(str != null) {
						onehost.add(str);
						str = reader.readLine();

					}
					in.close();
				}

			} catch (java.io.FileNotFoundException e) {
			}
			catch (Exception e) {}
			DummyContent.ITEMS.add(new DummyItem(onehost.get(0),onehost.get(1),onehost.get(2),onehost.get(3),onehost.get(4),
					onehost.get(5),onehost.get(6),onehost.get(7),onehost.get(8),onehost.get(9)));
		}
		
		
		
		
		
		
		if (findViewById(R.id.host_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((HostListFragment) getSupportFragmentManager().findFragmentById(
					R.id.host_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link HostListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(HostDetailFragment.ARG_ITEM_ID, id);
			HostDetailFragment fragment = new HostDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.host_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, HostDetailActivity.class);
			detailIntent.putExtra(HostDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
