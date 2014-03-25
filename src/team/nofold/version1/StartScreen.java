package team.nofold.version1;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;

public class StartScreen extends Activity
{
	static final String USER_INFO = "user_profile";
	static final String FIRST_TIME = "first_time";
	private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        settings = getSharedPreferences(USER_INFO, 0);
        SharedPreferences.Editor settingsEditor = settings.edit();
        boolean firstTime = settings.getBoolean(FIRST_TIME, true);
        if (firstTime)
        {
        	setContentView(R.layout.activity_first_start_screen);
        	settingsEditor.putBoolean(FIRST_TIME, false);
        }
        else
        {
        	setContentView(R.layout.activity_start_screen);
        }
        
        settingsEditor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    public void editProfile(View v)
    {
    	Intent i = new Intent(getApplicationContext(), EditProfile.class);
    	startActivity(i);
    }
    
    public void viewWorkouts(View v)
    {
    	
    }
    
    public void viewDictionary(View v)
    {
    	Intent i = new Intent(getApplicationContext(), ViewDictionary.class);
    	startActivity(i);
    }
}
