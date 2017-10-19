package edu.lautech.student.resistor;

import edu.lautech.orismail.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ColorCalculator extends Activity implements OnClickListener{

	EditText RValue, RTolerance;
	TextView firstColor, secondColor, multiplierColor, toleranceColor;
	ImageButton getColor, home, about;
	double value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_colorcalculator);
		initializeComp();
	}
	private void getFirstSecondBandColor(double a)
	{
		String b = "" + (int)a;
		
		//check if d string is 1 
		
		int first = Integer.parseInt(b.charAt(0) + "");
		int second;
		
		if(b.length() > 1)
		second = Integer.parseInt(b.charAt(1) + "");
		else
			second = 0;
		
		setBandsColor(first, firstColor);
		setBandsColor(second, secondColor);
	}
	private void getMultiplierColor(double a)
	{
		if(a < 1)
		{
			value *= 0.01;
			setBandsColor(11, multiplierColor);
		}
		else if(a < 10)
		{
			value *= 0.1;
			setBandsColor(10, multiplierColor);
		}
		else if(a < 100)
		{
			value /=1 ;
			setBandsColor(0, multiplierColor);
		}
		else if(a < 1000)
		{
			value /= 10;
			setBandsColor(1, multiplierColor);
		}
		else if(a < 10000)
		{
			value /= 100;
			setBandsColor(2, multiplierColor);
		}
		else if(a < 100000)
		{
			value /= 1000;
			setBandsColor(3, multiplierColor);
		}
		else if(a < 1000000)
		{
			value /= 10000;
			setBandsColor(4, multiplierColor);
		}
		else if(a < 10000000)
		{
			value /= 100000;
			setBandsColor(5, multiplierColor);
		}
		else if(a < 100000000)
		{
			value /= 1000000;
			setBandsColor(6, multiplierColor);
		}
		else if(a < 1000000000)
		{
			value /= 10000000;
			setBandsColor(7, multiplierColor);
		}
		else if(a < 10000000000.0)
		{
			value /= 100000000;
			setBandsColor(8, multiplierColor);
		}
		else
		{
			value /= 1000000000;
			setBandsColor(9, multiplierColor);
		}
	}
	private void setBandsColor(int index,TextView view)
	{
		int color;
		switch(index)
		{
		case 0:
		color = Color.BLACK;
		break;
		case 1 :
			color = Color.parseColor("#A52A2A");
			break;
		case 2 :
			color = Color.RED;
			break;
		case 3 :
			color = Color.parseColor("#FFA500");
			break;
		case 4 :
			color = Color.YELLOW;
			break;
		case 5 :
			color = Color.GREEN;
			break;
		case 6 :
			color = Color.BLUE;
			break;
		case 7 :
			color = Color.parseColor("#EE82EE");
			break;
		case 8 :
			color = Color.GRAY;
			break;
		case 9 :
			color = Color.WHITE;
			break;
		case 10 :
			color = Color.parseColor("#FFD700");
			break;
		case 11 :
			color = Color.parseColor("#C0C0C0");
			break;
		default : 
			color = Color.BLACK;
		}
		view.setBackgroundColor(color);
	}
	private void getBandsColor(double a)
	{
		getMultiplierColor(a);
		getFirstSecondBandColor(value);
	}
	private void getToleranceColor(double a)
	{
		int color;
		if(a == 0.05)
			color = Color.GRAY;
		else if(a == 0.10)
			color = Color.parseColor("#EE82EE");
		else if(a == 0.25)
			color = Color.BLUE;
		else if(a == 0.5)
			color = Color.GREEN;
		else if(a == 1)
			color = Color.parseColor("#A52A2A");
		else if(a == 2)
			color = Color.RED;
		else if(a == 5)
			color = Color.parseColor("#FFD700");
		else if(a == 10)
			color = Color.parseColor("#C0C0C0");
		else 
			color = Color.TRANSPARENT;
		
		toleranceColor.setBackgroundColor(color);
	}
	private void initializeComp()
	{
		RValue = (EditText) findViewById(R.id.RValue);
		RTolerance = (EditText) findViewById(R.id.RTolerance);
		
		firstColor = (TextView) findViewById(R.id.firstColor);
		secondColor = (TextView) findViewById(R.id.secondColor);
		multiplierColor = (TextView) findViewById(R.id.multiplierColor);
		toleranceColor = (TextView) findViewById(R.id.toleranceColor);
		
		getColor = (ImageButton) findViewById(R.id.getColor);
		home = (ImageButton) findViewById(R.id.home);
		about = (ImageButton) findViewById(R.id.about);
		
		about.setOnClickListener(this);
		getColor.setOnClickListener(this);
		home.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		if(arg0.getId() == R.id.getColor)
		{
			if(RValue.getText().toString().equals("") || RTolerance.getText().toString().equals(""))
			{
				Toast a = Toast.makeText(this, "Enter Resistor value and/or Tolerance value", 10000);
				a.setGravity(Gravity.TOP, 0, 0);
				a.show();
			}
			
			else
			{
				toleranceColor.requestFocus();
				getToleranceColor(Double.parseDouble(RTolerance.getText().toString()));
				value = Double.parseDouble(RValue.getText().toString());
				getBandsColor(value);
			}
		}
		else if(arg0.getId() == R.id.home)
		{
			startActivity(new Intent(ColorCalculator.this, Home.class));
			
		}
		else if(arg0.getId() == R.id.about)
			startActivity(new Intent(ColorCalculator.this, About.class));
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		startActivity(new Intent(ColorCalculator.this, Home.class));
		ColorCalculator.this.finish();
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
			startActivity(new Intent(ColorCalculator.this, About.class));
			
		}
		else if(item.getItemId() == R.id.help)
		{
			startActivity(new Intent(ColorCalculator.this, Help.class));
		}
		return true;
	}

}
