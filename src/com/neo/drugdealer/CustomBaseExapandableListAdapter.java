package com.neo.drugdealer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomBaseExapandableListAdapter extends BaseExpandableListAdapter {
	
	private List<String> groupItems;
	private List<String> childItems;
	private List<Object> children = new ArrayList<Object>();
	private LayoutInflater inflater;
	private Activity activity;
	
	public CustomBaseExapandableListAdapter(List<String> groupList, List<Object> children) {
		this.groupItems=groupList;
		this.children =children;
		
	}
	
	public void setInflater(LayoutInflater inflater, Activity activity) {
		this.inflater=inflater;
		this.activity=activity;
	}
	
		
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView,ViewGroup parent) {
		//this.childItems = (List<String>) this.children.get(groupPosition);
		//this.childItems = (List<String>) this.children;
		Log.i("DEBUG:", "ChildPosition:"+childPosition+" corresponding string:"+this.children.get(childPosition).toString());
		TextView tv = null;
		if(convertView == null) {
			convertView = this.inflater.inflate(R.layout.childrow,null);
		}
		tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(this.children.get(childPosition).toString());
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(activity, children.get(childPosition).toString(), Toast.LENGTH_SHORT).show();
				
			}
		});
		
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		Log.i("DEBUG:","GroupPosition:"+groupPosition);
		return groupPosition;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return this.groupItems.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	 public void onGroupCollapsed(int groupPosition) {
	  super.onGroupCollapsed(groupPosition);
	 }

	 @Override
	 public void onGroupExpanded(int groupPosition) {
	  super.onGroupExpanded(groupPosition);
	 }

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null) {
			convertView= this.inflater.inflate(R.layout.grouprow,null);
		}
		((CheckedTextView) convertView).setText(this.groupItems.get(groupPosition));
		((CheckedTextView) convertView).setChecked(isExpanded);	
		return convertView;
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
