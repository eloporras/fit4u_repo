package team.nofold.version1.workoutClasses;

import java.util.LinkedList;
import java.util.List;

public class Day
{
	String name;
	List<Exercise> exercises;
	
	public Day(String n)
	{
		name = n;
		exercises = new LinkedList<Exercise>();
	}
	
	public void addExercise(Exercise e)
	{
		exercises.add(e);
	}
	
	public int numExercises()
	{
		return exercises.size();
	}
	
	public List<String> getExerciseNames()
	{
		List<String> exNames = new LinkedList<String>();
		for (Exercise e : exercises)
		{
			exNames.add(e.name);
		}
		return exNames;
	}
	
	public void printDay()
	{
		// print name to cell
		
		for (Exercise e : exercises)
		{
			// TODO:	e.printExercise();
		}
	}

}
