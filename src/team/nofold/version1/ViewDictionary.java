package team.nofold.version1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewDictionary extends Activity 
{
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    //setContentView(R.layout.dictionary_layout);
	    setContentView(R.layout.dictionary_list_layout);
	}
	
	//private void exerciseClicked(String name, String vidstr)
	private void exerciseClicked(String name)
	{
    	Intent i = new Intent(getApplicationContext(),
    							WatchDictionaryVideoActivity.class);
    	Bundle b = new Bundle();
    	b.putString(WatchDictionaryVideoActivity.EXERCISE_NAME, name);
    	//b.putString(WatchDictionaryVideoActivity.VIDEO_STRING, vidstr);
    	i.putExtras(b);
    	startActivity(i);
	}
	
	public void pushUpClicked(View v)
	{
		exerciseClicked("Push Ups");
	}
	public void powerCleanClicked(View v)
	{
		exerciseClicked("Power Cleans");
	}
	
	public void pullUpClicked(View v)
	{
		exerciseClicked("Pull Ups");
	}
	
	public void dbRdlClicked(View v)
	{
		exerciseClicked("Dumbbell RDLs");
	}
	
	public void dbBentRowsClicked(View v)
	{
		exerciseClicked("Dumbbell Bent Over Rows");
	}
	
	public void hangingLegRaisesClicked(View v)
	{
		exerciseClicked("Hanging Leg Raises");
	}
	
	public void bbBackSquatsClicked(View v)
	{
		exerciseClicked("Barbell Back Squats");
	}
	
	public void chinUpsClicked(View v)
	{
		exerciseClicked("Chin Ups");
	}
	
	public void dbStaticLungesClicked(View v)
	{
		exerciseClicked("Dumbbell Static Lunges");
	}
	
	public void bbBentRowsClicked(View v)
	{
		exerciseClicked("Barbell Bent Over Rows");
	}
	
	public void bbBenchPressClicked(View v)
	{
		exerciseClicked("Barbell Bench Press");
	}
	
	public void bbRolloutsClicked(View v)
	{
		exerciseClicked("Barbell Roll Outs");
	}
}