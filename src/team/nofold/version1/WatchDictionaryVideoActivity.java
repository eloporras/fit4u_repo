package team.nofold.version1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;

public class WatchDictionaryVideoActivity extends YouTubeBaseActivity
	implements OnInitializedListener
{
	public final static String VIDEO_STRING = "video_string";
	public final static String EXERCISE_NAME = "exercise_name";
	public final static String API_KEY = "AIzaSyDue44pokDEHKFR_rp3JX6MOLIH8OHb-aE";
	
	static public final String PUSH_UPS = "9GZb9szJfdM";
	static public final String PULL_UPS = "Gu-ZvPyQpno";
	static public final String POWER_CLEANS = "nEZ98J1dFPY";
	static public final String DB_RDLS = "LgoylVoTd9E";
	static public final String DB_BENT_OVER_ROWS = "zdpeuA_nffI";
	static public final String HANGING_LEG_RAISES = "fJnuyFnQRa4";
	static public final String BB_BACK_SQUATS = "yOnc_b4ufw8";
	static public final String CHIN_UPS = "U3aoVGBEFjk";
	static public final String DB_STATIC_LUNGES = "kNgmhxmnUsI";
	static public final String BB_BENT_OVER_ROWS = "Na2GdFlbjVw";
	static public final String BB_BENCH_PRESS = "IksWi0ku7VI";
	static public final String BB_ROLLOUTS = "YHtGld9X7l0";

	String vid;
	String ename;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    Intent i = getIntent();
	    Bundle b = i.getExtras();
	    ename = b.getString(EXERCISE_NAME);
	    //vid = b.getString(VIDEO_STRING)
	    vid = getVidString(ename);
	    setContentView(R.layout.exercise_video_viewer_layout);
	    TextView etitle = (TextView)findViewById(R.id.exerciseNameTextView);
	    etitle.setText(ename);
	    YouTubePlayerView youTubeView = 
	    		(YouTubePlayerView)findViewById(R.id.youtube_view);
	    youTubeView.initialize(API_KEY, this);
	}

	@Override
	public void onInitializationFailure(Provider provider,
										YouTubeInitializationResult error) 
	{
		Toast.makeText(this,
					"DAMN SHIT! "+error.toString(),
					Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, 
										YouTubePlayer player,
										boolean wasRestored) 
	{
		player.loadVideo(vid);
	}
	
	private String getVidString(String name)
	{
		//if (name == "Barbell Bench Press")
		if (name.equals("Push Ups"))
		{
			return PUSH_UPS;
		}
		else if (name.equals("Power Cleans"))
		{
			return POWER_CLEANS;
		}
		else if (name.equals("Pull Ups"))
		{
			return PULL_UPS;
		}
		else if (name.equals("Dumbbell RDLs"))
		{
			return DB_RDLS;
		}
		else if (name.equals("Dumbbell Bent Over Rows"))
		{
			return DB_BENT_OVER_ROWS;
		}
		else if (name.equals("Hanging Leg Raises"))
		{
			return HANGING_LEG_RAISES;
		}
		else if (name.equals("Barbell Back Squats"))
		{
			return BB_BACK_SQUATS;
		}
		else if (name.equals("Chin Ups"))
		{
			return CHIN_UPS;
		}
		else if (name.equals("Dumbbell Static Lunges"))
		{
			return DB_STATIC_LUNGES;
		}
		else if (name.equals("Barbell Bent Over Rows"))
		{
			return BB_BENT_OVER_ROWS;
		}
		else if (name.equals("Barbell Bench Press"))
		{
			return BB_BENCH_PRESS;
		}
		else if (name.equals("Barbell Roll Outs"))
		{
			return BB_ROLLOUTS;
		}
		else 
			return "INVALID STRING";
	}
}