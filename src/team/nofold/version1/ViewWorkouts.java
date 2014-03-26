package team.nofold.version1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


public class ViewWorkouts extends Activity 
{
	private ExpandableListView programXLV;	//program eXpandableListView

	private final String BULKWEEK04_MAIN_SETREP = " 3 sets of 5";
	private final String BULKWEEK15_MAIN_SETREP = " 5 sets of 5 (same weight as last week)";
	private final String BULKWEEK26_MAIN_SETREP = " 5 sets of 3 (up the weight from last week)";
	private final String BULKWEEK37_MAIN_SETREP = " 3 sets of 3 (up the weight from last week)";

	private final String CUTWEEK04_MAIN_SETREP = " 3 sets of 12";
	private final String CUTWEEK15_MAIN_SETREP = " 3 sets of 10 (up the weight from last week)";
	private final String CUTWEEK26_MAIN_SETREP = " 4 sets of 10 (same weight as last week)";
	private final String CUTWEEK37_MAIN_SETREP = " 4 sets of 8 (up the weight from last week)";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.workout_base_layout);
	    programXLV = (ExpandableListView) findViewById(R.id.weeks_lv);
	    programXLV.setAdapter(new WeeksLevel(this, getBeginnerWorkout()));
	}
	
	private ArrayList<ArrayList<List<String>>> getBeginnerWorkout()
	{
		ArrayList<ArrayList<List<String>>> workoutProgram = 
				new ArrayList<ArrayList<List<String>>>();
		
		// first make 6 weeks of workout for BEGINNERs
		for (int i = 0; i < 6; ++i)
		{
			workoutProgram.add(new ArrayList<List<String>>());
		// BEGINNERs have 3 days of workout each week
			for (int j = 0; j < 3; ++j)
			{
				workoutProgram.get(i).add(new ArrayList<String>());
			}
		// BEGINNER workout does not change week to week
			// filling in the exercises and sets and reps
		
			// day0
			//workoutProgram.get(0).get(0).add("POWER EXERCISE 3 sets of 10");
			workoutProgram.get(0).get(0).add("Power Cleans 3 sets of 10");
			//workoutProgram.get(0).get(0).add("HORIZONTAL PUSH 3 sets of 10");
			workoutProgram.get(0).get(0).add("Push Ups 3 sets of 10");
			//workoutProgram.get(0).get(0).add("HORIZONTAL PULL 3 sets of 10");
			workoutProgram.get(0).get(0).add("Dumbbell Bent Over Rows 3 sets of 10");
			workoutProgram.get(0).get(0).add("BICEP ISOLATION 3 sets of 10");
			workoutProgram.get(0).get(0).add("TRICEPS ISOLATION 3 sets of 10");
			//workoutProgram.get(0).get(0).add("ABDOMINAL EXERCISE 3 sets of 10");
			workoutProgram.get(0).get(0).add("Hanging Leg Raises 3 sets of 10");
			
			// day1
			workoutProgram.get(0).get(1).add("POWER EXERCISE 3 sets of 10");
			//workoutProgram.get(0).get(1).add("SQUAT VARIATION 3 sets of 10");
			workoutProgram.get(0).get(1).add("Barbell Back Squats 3 sets of 10");
			//workoutProgram.get(0).get(1).add("STEP UP OR LUNGE 3 sets of 10");
			workoutProgram.get(0).get(1).add("Dumbbell Static Lunges 3 sets of 10");
			workoutProgram.get(0).get(1).add("CALF EXERCISE 3 sets of 10");
			//workoutProgram.get(0).get(1).add("ABDOMINAL EXERCISE 3 sets of 10");
			workoutProgram.get(0).get(1).add("Barbell Roll Outs 3 sets of 10");
			
			// day2
			workoutProgram.get(0).get(2).add("POWER EXERCISE 3 sets of 10");
			workoutProgram.get(0).get(2).add("VERTICAL PUSH 3 sets of 10");
			//workoutProgram.get(0).get(2).add("DEADLIFT VARIATION 3 sets of 10");
			workoutProgram.get(0).get(2).add("Dumbbell RDLs 3 sets of 10");
			//workoutProgram.get(0).get(2).add("VERTICAL PULL 3 sets of 10");
			workoutProgram.get(0).get(2).add("Pull Ups 3 sets of 10");
			workoutProgram.get(0).get(2).add("SHOULDER ISOLATION 3 sets of 10");
			workoutProgram.get(0).get(2).add("ABDOMINAL EXERCISE 3 sets of 10");
		}

		return workoutProgram;
	}
	
	private ArrayList<ArrayList<List<String>>> getBulkerWorkout()
	{
		ArrayList<ArrayList<List<String>>> workoutProgram = 
				new ArrayList<ArrayList<List<String>>>();
		
		// BULKERs do an 8 week workout
		for (int i = 0; i < 8; ++i)
		{
			workoutProgram.add(new ArrayList<List<String>>());
			
			// BULKERs lift 4x a week
			for (int j = 0; j < 4; ++j)
			{
				workoutProgram.get(i).add(new ArrayList<String>());
			}
		}
		
		workoutProgram.get(0).get(0).add("Barbell Bench Press" + BULKWEEK04_MAIN_SETREP);
		workoutProgram.get(0).get(0).add("1ST CHOICE TRICEPS" + CUTWEEK04_MAIN_SETREP);
		
		
		return workoutProgram;
	}
	
	public class WeeksLevel extends BaseExpandableListAdapter
	{
		/*
		private List<String> weekHeaderList;	// week header titles
		// week child data in format of week title, day title, day exerciseStrings
		private HashMap<String, HashMap<String, List<String>>> weekChildData;	
		*/
		private Context _context;
		private ArrayList<ArrayList<List<String>>> weeksData;
		// Usage:
		// 	weeksData[1][2]= List<ExerciseString> for week1, day2

		public WeeksLevel(Context context,
						  ArrayList<ArrayList<List<String>>> data)
		{
			this._context = context;
			weeksData = data;
			//this.weekHeaderList = listDataHeader;
			//this.weekChildData = listChildData;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition)
		{
			/*return (this.weekChildData
				.get(this.weekHeaderList.get(groupPosition))
					.get(childPosition));
					*/
			return weeksData.get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition)
		{
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
								 boolean isLastChild, View convertView,
								 ViewGroup parent)
		{
			/*CustExpListView weekXLV = 
					new CustExpListView(ViewWorkouts.this);
			HashMap<String, List<String>> dayChildData;
			dayChildData
			weekXLV.setAdapter(new DaysLevel());
			weekXLV.setGroupIndicator(null);
			*/
			
			ArrayList<List<String>> toDaysData =
					weeksData.get(childPosition);
			CustExpListView weekXLV = 
					new CustExpListView(ViewWorkouts.this);
			weekXLV.setAdapter(new DaysLevel(ViewWorkouts.this, toDaysData));
			weekXLV.setGroupIndicator(null);
			return weekXLV;
		}

		@Override
		public int getChildrenCount(int groupPosition)
		{
			//return weeksData.get(groupPosition).size();
			//return weeksData.size();
			return weeksData.get(groupPosition).size() / 3;
		}

		@Override
		public Object getGroup(int groupPosition)
		{
			return groupPosition;
		}

		@Override
		public int getGroupCount()
		{
			return weeksData.size();
		}

		@Override
		public long getGroupId(int groupPosition)
		{
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition,
								 boolean isExpanded,
								 View convertView,
								 ViewGroup parent)
		{
			/*TextView tv = (TextView) findViewById(R.id.week_header_tv);
			tv.setText("Week " + groupPosition);
			*/
			TextView tv = new TextView(ViewWorkouts.this);
			tv.setText("Week " + (groupPosition + 1));
			tv.setTextColor(Color.BLACK);
			tv.setTextSize(20);
			tv.setBackgroundColor(Color.RED);
			return tv;
		}

		@Override
		public boolean hasStableIds()
		{
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition,
										 int childPosition)
		{
			return true;
		}
	}
	
	public class CustExpListView extends ExpandableListView
	{
		int myGroupPosition;
		int myChildPosition;
		int myGroupId;
		
		public CustExpListView(Context context)
		{
			super(context);
		}
		
		protected void onMeasure(int widthMeasureSpec,
								 int heightMeasureSpec)
		{
			widthMeasureSpec =
					MeasureSpec.makeMeasureSpec(960, MeasureSpec.AT_MOST);
			heightMeasureSpec =
					MeasureSpec.makeMeasureSpec(600, MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
					
		}
	}
	
	public class DaysLevel extends BaseExpandableListAdapter
	{
		private Context _context;
		private ArrayList<List<String>> daysData;
		//private List<String> dayHeaderList;	// list of headers for days: "Day 1" or "Chest Day", etc.
		// maps dayHeaders to its list of exerciseStrings
		//private HashMap<String, List<String>> dayDataChild;

		public DaysLevel(Context context,
						 ArrayList<List<String>> data)
		{
			this._context = context;
			daysData = data;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition)
		{
			return childPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition)
		{
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
								 boolean isLastChild, View convertView,
								 ViewGroup parent)
		{
			/*TextView exercisesAndSetsTV =
					(TextView) findViewById(R.id.exercise_name_and_sets_repsTV);
					*/
			//final String exercise = "Barbell Bench Press";
			
			//parent.setScrollContainer(true);
			//parent.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);
			
			final String exercise = daysData.get(groupPosition).get(childPosition);
			TextView exercisesAndSetsTV = new TextView(ViewWorkouts.this);
//			exercisesAndSetsTV.setText(exercise + "\t<Sets> sets of <Reps>");
			exercisesAndSetsTV.setTextColor(Color.BLACK);
			exercisesAndSetsTV.setTextSize(20);
			exercisesAndSetsTV.setBackgroundColor(Color.LTGRAY);

			/*TextView exercisesAndSetsTV = 
					(TextView) findViewById(R.id.exercise_name_and_sets_repsTV);
					*/
			exercisesAndSetsTV.setText(exercise);
			
			String eName = "";
			for (int i = 0; i < exercise.length(); ++i)
			{
				char next = exercise.charAt(i);
				if (Character.isDigit(next))
				{
					eName = exercise.substring(0, i-1);
					break;
				}
			}
			final String exerciseName = eName;

			exercisesAndSetsTV.setClickable(true);
			exercisesAndSetsTV.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Intent i = new Intent(getApplicationContext(),
											WatchDictionaryVideoActivity.class);
					Bundle b = new Bundle();
					//b.putString(WatchDictionaryVideoActivity.EXERCISE_NAME, exercise);
					
					// TODO: change this from "Barbell Bench Press" to the real exercise name
					//b.putString(WatchDictionaryVideoActivity.EXERCISE_NAME, "Barbell Bench Press");
					b.putString(WatchDictionaryVideoActivity.EXERCISE_NAME, exerciseName);
					
					i.putExtras(b);
					startActivity(i);
				}
			});
			
			return exercisesAndSetsTV;
		}

		@Override
		public int getChildrenCount(int groupPosition)
		{
			return daysData.get(groupPosition).size();
		}

		@Override
		public Object getGroup(int groupPosition)
		{
			return groupPosition;
		}

		@Override
		public int getGroupCount()
		{
			return daysData.size();
		}

		@Override
		public long getGroupId(int groupPosition)
		{
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
								 View convertView, ViewGroup parent)
		{
			TextView dayHeader = new TextView(ViewWorkouts.this);
			dayHeader.setText("Day " + (groupPosition + 1));
			dayHeader.setTextColor(Color.BLACK);
			dayHeader.setTextSize(20);
			dayHeader.setBackgroundColor(Color.DKGRAY);
			
			//parent.setScrollContainer(true);
			//parent.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

			//Toast.makeText(ViewWorkouts.this, "scrolling should work", Toast.LENGTH_LONG).show();
			
			/*TextView dayHeader =
					(TextView) findViewById(R.id.day_header_tv);
			dayHeader.setText("Day" + groupPosition);
			*/
			return dayHeader;
		}

		@Override
		public boolean hasStableIds()
		{
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition)
		{
			return true;
		}
	}
}
