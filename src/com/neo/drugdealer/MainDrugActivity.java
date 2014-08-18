package com.neo.drugdealer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainDrugActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_drug);
		//Add button event.
		final Button searchButton = (Button) findViewById(R.id.searchButton);
		searchButton.setOnClickListener(new View.OnClickListener(	) {
			
			@Override
			public void onClick(View v) {
				
//			EditText textview= (EditText) findViewById(R.id.multiLineText);
//				//scrView.set
//			textview.setText("Clicked Man");
			Intent intent = new Intent(MainDrugActivity.this, MultipleItemsList.class);
			startActivity(intent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_drug, menu);
		return true;
	}

}
