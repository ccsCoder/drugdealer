package com.neo.drugdealer;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

public class MultipleItemsList extends ExpandableListActivity implements OnChildClickListener{
	
	private List<String> groupItems = new ArrayList<String>();
	private List<Object> childGroupItems = new ArrayList<Object>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_items_list);
		// Show the Up button in the action bar.
		setupActionBar();
		ExpandableListView listView = getExpandableListView();
		listView.setDividerHeight(2);
		listView.setGroupIndicator(null);
		listView.setClickable(true);
		
		Log.i("DEBUG:","onCreate, after setting ListView");
		
		//set parent group data
		setGroupData();
		
		Log.i("DEBUG:","onCreate, after setGroupData()");
		
		//set child group data
		setChildGroupData();
		
		Log.i("DEBUG:","onCreate, after setChildGroupData()");
		
		//Create a new Adapter.
		CustomBaseExapandableListAdapter customAdapter = new CustomBaseExapandableListAdapter(groupItems, childGroupItems);
		
		customAdapter.setInflater((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		getExpandableListView().setAdapter(customAdapter);
		listView.setOnChildClickListener(this);
		
		Log.i("DEBUG:","onCreate, after setting Inflater, and expandableListAdapter click listener.");
		
	}

	

	private void setChildGroupData() {
		// TODO Auto-generated method stub
		this.childGroupItems.add("Treating symptoms of Headache, Nausea and Vertigo.");
		this.childGroupItems.add("Calpol, Metacin");
		this.childGroupItems.add("Liver Damage");
		this.childGroupItems.add("5mg/day");
		this.childGroupItems.add("--- Never eat with Oranges");
		
	}



	private void setGroupData() {
		// TODO Auto-generated method stub
		this.groupItems.add("Used for");
		this.groupItems.add("Brand/Components");
		this.groupItems.add("Side Effects");
		this.groupItems.add("Dosage");
		this.groupItems.add("Additional");
	}
	
	



	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multiple_items_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
			int arg3, long arg4) {
		// TODO Auto-generated method stub
		return false;
	}

}
