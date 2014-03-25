package team.nofold.version1;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;

public class ViewDictionary extends YouTubeBaseActivity 
	implements YouTubePlayer.OnInitializedListener
{
	static private final String DEVELOPER_KEY = "AIzaSyDue44pokDEHKFR_rp3JX6MOLIH8OHb-aE";
	static private final String PULL_UPS = "9sjhLkBppU4";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.dictionary_layout);
	    YouTubePlayerView youTubeView = 
	    		(YouTubePlayerView)findViewById(R.id.youtube_view);
	    youTubeView.initialize(DEVELOPER_KEY, this);
	}

	@Override
	public void onInitializationFailure(Provider provider, 
										YouTubeInitializationResult error)
	{
		Toast.makeText(this, "DAMN SHIT!"+error.toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, 
										YouTubePlayer player,
										boolean wasRestored)
	{
		//player.loadVideo(PULL_UPS);
		player.cueVideo(PULL_UPS);
	}
}