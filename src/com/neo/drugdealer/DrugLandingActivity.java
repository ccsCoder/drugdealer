package com.neo.drugdealer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DrugLandingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drug_landing);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drug_landing, menu);
		return true;
	}

}
