package edu.lautech.student.resistor;

import edu.lautech.orismail.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends Activity implements OnClickListener{

	ImageButton value, color, about ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initializeComp();
	}
	private void initializeComp()
	{
		value = (ImageButton) findViewById(R.id.valuePage);
		color = (ImageButton) findViewById(R.id.colorPage);
		about = (ImageButton) findViewById(R.id.about);
		
		//add event
		value.setOnClickListener(this);
		color.setOnClickListener(this);
		about.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() ==R.id.valuePage)
				startActivity(new Intent(Home.this, ValueCalculator.class));
		else if(arg0.getId() == R.id.colorPage)
			startActivity(new Intent(Home.this, ColorCalculator.class));
		else if(arg0.getId() == R.id.about)
			startActivity(new Intent(Home.this, About.class));
		}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.about)
		{
			startActivity(new Intent(Home.this, About.class));
			
		}
		else if(item.getItemId() == R.id.help)
		{
			startActivity(new Intent(Home.this, Help.class));
		}
		return true;
	}
		
	}

