package team.nofold.version1;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;

public class EditProfile extends Activity
{
	static int CUTTING_PROGRAM = -1;
	static int BEGINNING_PROGRAM = 0;
	static int BULKING_PROGRAM = 1;
	static int CHICK = 0;
	static int DUDE = 1;
	static String USER_INFO = "user_profile";
	static String USER_EQUIP = "user_equipment";

	private boolean userEvenLifts;
	private int program;
	private boolean userHasBarbells;
	private boolean userHasEZBar;
	private boolean userHasHeavyDumbbells;
	private boolean userHasLightDumbbells;
	private boolean userHasPullUpBar;
	private boolean userHasDipStation;
	private boolean userHasBenchPress;
	private boolean userHasFlatBench;
	private boolean userHasInclineBench;
	private boolean userHasSquatRack;
	private boolean userHasBumperPlates;
	private boolean userHasPlyoBoxes;
	private boolean userHasMedBalls;
	private boolean userHasTRX;
	private boolean userHasSeatedCalfRaises;
	private boolean userHasPecDeck;
	private boolean userHasCableCrossover;
	private boolean userHasLatPulldown;
	private int gender;
	private int weight;
	private int age;
	private int beginnerPushUps;
	private int beginnerSitUps;
	private int pullUps;
	private int maxBench;
	private int maxSquat;
	private int maxDeadlift;
	private int maxPress;

	private SharedPreferences userInfo;
	private SharedPreferences.Editor userInfoEditor;
	private SharedPreferences userEquipment;
	private SharedPreferences.Editor userEquipmentEditor;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.do_you_even_layout);
	    gender = -1;
	    userInfo = getSharedPreferences(USER_INFO, 0);
	    userInfoEditor = userInfo.edit();
	    userEquipment = getSharedPreferences(USER_EQUIP, 0);
	    userEquipmentEditor = userEquipment.edit();
	}
	
	public void setExperienced(View v)
	{
		userEvenLifts = true;
		setContentView(R.layout.choose_program_layout);
	}
	
	public void setNonExperienced(View v)
	{
		userEvenLifts = false;
		program = BEGINNING_PROGRAM;
	    setContentView(R.layout.equipment_list_layout);
	}

	public void setProgramCut(View v)
	{
		program = CUTTING_PROGRAM; 
	    setContentView(R.layout.equipment_list_layout);
	}
	
	public void setProgramBulk(View v)
	{
		program = BULKING_PROGRAM;
	    setContentView(R.layout.equipment_list_layout);
	}
	
	public void submitEquipment(View v)
	{
		userHasBarbells = ((CheckBox)findViewById(R.id.barbell)).isChecked();
		userHasEZBar = ((CheckBox)findViewById(R.id.EZcurlBar)).isChecked();
		userHasHeavyDumbbells = ((CheckBox)findViewById(R.id.heavyDumbbells)).isChecked();
		userHasLightDumbbells = ((CheckBox)findViewById(R.id.lightDumbbells)).isChecked();
		userHasPullUpBar = ((CheckBox)findViewById(R.id.pullUpBar)).isChecked();
		userHasDipStation = ((CheckBox)findViewById(R.id.dipStation)).isChecked();
		userHasBenchPress = ((CheckBox)findViewById(R.id.benchPress)).isChecked();
		userHasFlatBench = ((CheckBox)findViewById(R.id.flatBench)).isChecked();
		userHasInclineBench = ((CheckBox)findViewById(R.id.inclineBench)).isChecked();
		userHasSquatRack = ((CheckBox)findViewById(R.id.squatRack)).isChecked();
		userHasBumperPlates = ((CheckBox)findViewById(R.id.bumperPlates)).isChecked();
		userHasPlyoBoxes = ((CheckBox)findViewById(R.id.plyoBoxes)).isChecked();
		userHasMedBalls = ((CheckBox)findViewById(R.id.medBalls)).isChecked();
		userHasTRX = ((CheckBox)findViewById(R.id.trx)).isChecked();
		userHasSeatedCalfRaises= ((CheckBox)findViewById(R.id.seatedCalfRaise)).isChecked();
		userHasPecDeck = ((CheckBox)findViewById(R.id.pecDeck)).isChecked();
		userHasCableCrossover = ((CheckBox)findViewById(R.id.cableCrossover)).isChecked();
		userHasLatPulldown = ((CheckBox)findViewById(R.id.latPullDown)).isChecked();
		
		if (userHasBarbells || userHasHeavyDumbbells || userHasLightDumbbells)
		{
			setContentView(R.layout.personal_info_layout);
		}
		else
		{
			//	TO-DO:	resubmit, you can't do this with no weights broh code
		}
	}
	
	public void submitPersonalInfo(View v)
	{
		weight = Integer.parseInt(((EditText)findViewById(R.id.weight)).getText().toString());
		age = ((NumberPicker)findViewById(R.id.age)).getValue();
		if (weight >= 90 && age >= 12 && gender != -1)
		{
			if (userEvenLifts)
			{
				setContentView(R.layout.beginner_max_layout);
			}
			else
			{
				setContentView(R.layout.nonbeginner_max_layout);
			}
		}
		else
		{
			if (weight < 90)
			{
			//	TO-DO	enter valid weight broh	code
			}
			if (age < 12)
			{
			//	TO-DO	enter valid age broh code	
			}
			if (gender == -1)
			{
			//	TO-DO	...but are you a dude or chick broh code
			}
		}
	}
	
	public void genderClicked(View v)
	{
		boolean checked = ((RadioButton)v).isChecked();
		switch (v.getId())
		{
		case R.id.dude:
			if (checked) gender = DUDE;
			break;	
		case R.id.chick:
			if (checked) gender = CHICK;
			break;
		default: break;
		}
	}
	
	
	public void submitMaxes(View v)
	{
		if (userEvenLifts)
		{
			maxBench = Integer.parseInt(((EditText)findViewById(R.id.benchMax)).getText().toString());
			maxSquat = Integer.parseInt(((EditText)findViewById(R.id.squatMax)).getText().toString());
			maxDeadlift = Integer.parseInt(((EditText)findViewById(R.id.deadliftMax)).getText().toString());
			pullUps = Integer.parseInt(((EditText)findViewById(R.id.pullUps)).getText().toString());

			setContentView(R.layout.confirmation_layout);
		}
		else
		{
			beginnerPushUps = Integer.parseInt(((EditText)findViewById(R.id.pushUps)).getText().toString());
			beginnerSitUps = Integer.parseInt(((EditText)findViewById(R.id.sitUps)).getText().toString());
			pullUps = Integer.parseInt(((EditText)findViewById(R.id.beginnerPullUps)).getText().toString());

			setContentView(R.layout.confirmation_layout);
		}
	}
	
	public void finishEditProfile(View v)
	{
		userInfoEditor.putBoolean("userEvenLifts", userEvenLifts);
		userInfoEditor.putInt("program", program);
		userInfoEditor.putInt("gender", gender);
		userInfoEditor.putInt("weight", weight);
		userInfoEditor.putInt("age", age);
		
		if (!userEvenLifts)
		{
			userInfoEditor.putInt("pushUps", beginnerPushUps);
			userInfoEditor.putInt("sitUps", beginnerSitUps);
			userInfoEditor.putInt("pullUps", pullUps);
			userInfoEditor.putInt("maxBench", -1);
			userInfoEditor.putInt("maxSquat", -1);
			userInfoEditor.putInt("maxDeadlift", -1);
			userInfoEditor.putInt("maxPress", -1);
		}
		else
		{
			userInfoEditor.putInt("pushUps", -1);
			userInfoEditor.putInt("sitUps", -1);
			userInfoEditor.putInt("pullUps", pullUps);
			userInfoEditor.putInt("maxBench", maxBench);
			userInfoEditor.putInt("maxSquat", maxSquat);
			userInfoEditor.putInt("maxDeadlift", maxDeadlift);
			userInfoEditor.putInt("maxPress", maxPress);
		}
		userInfoEditor.commit();
		
		userEquipmentEditor.putBoolean("barbells", userHasBarbells);
		userEquipmentEditor.putBoolean("ezbar", userHasEZBar);
		userEquipmentEditor.putBoolean("heavyDumbbells", userHasHeavyDumbbells);
		userEquipmentEditor.putBoolean("lightDumbbells", userHasLightDumbbells);
		userEquipmentEditor.putBoolean("pullUpBar", userHasPullUpBar);
		userEquipmentEditor.putBoolean("dipStation", userHasDipStation);
		userEquipmentEditor.putBoolean("benchPress", userHasBenchPress);
		userEquipmentEditor.putBoolean("flatBench", userHasFlatBench);
		userEquipmentEditor.putBoolean("inclineBench", userHasInclineBench);
		userEquipmentEditor.putBoolean("squatRack", userHasSquatRack);
		userEquipmentEditor.putBoolean("bumperPlates", userHasBumperPlates);
		userEquipmentEditor.putBoolean("plyoBoxes", userHasPlyoBoxes);
		userEquipmentEditor.putBoolean("medBalls", userHasMedBalls);
		userEquipmentEditor.putBoolean("trx", userHasTRX);
		userEquipmentEditor.putBoolean("seatedCalfRaises", userHasSeatedCalfRaises);
		userEquipmentEditor.putBoolean("pecDeck", userHasPecDeck);
		userEquipmentEditor.putBoolean("cableCrossover", userHasCableCrossover);
		userEquipmentEditor.putBoolean("latPullDown", userHasLatPulldown);
		userEquipmentEditor.commit();
		
		Intent i = new Intent(getApplicationContext(), StartScreen.class);
		startActivity(i);
	}
}
