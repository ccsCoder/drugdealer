package com.neo.drugdealer;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseExpandableListAdapter;

public class DrugExpandableListViewAdapter extends BaseExpandableListAdapter{
	
	private Context context;
	private List<String> listDataHeader; //for header titles
	//Child Data in format of Header Title , Child Title
	private Map<String,List<String>> listDataChild;
	
	public DrugExpandableListViewAdapter(Context context, List<String> listDataHeader, Map<String,List<String>> listDataChild) {
		this.context=context;
		this.listDataHeader=listDataHeader;
		this.listDataChild=listDataChild;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		// return a new Child View
		final String childText = (String) getChild(groupPosition, childPosition);
		
		if(convertView==null) {
			//get the inflater
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//inflate
			inflater.inflate(R.layout.list_item, null);
		}
		
		//now find that TextView inside this convertview, and set the text within
	 	((TextView) convertView.findViewById(R.id.lblListItem)).setText(childText);
		
		
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// return the child
		return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// get the group
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
