package team.nofold.version1.workoutClasses;

import java.util.LinkedList;
import java.util.List;

public class Exercise
{
	String name;
	List<Set> sets;
	
	public Exercise(String n)
	{
		name = n;
		sets = new LinkedList<Set>();
	}
	
	public void addSet(Set s)
	{
		sets.add(s);
	}
	
	public void addSet(int weight, int reps)
	{
		Set newSet = new Set(weight, reps);
		sets.add(newSet);
	}
	
	public int numSets()
	{
		return sets.size();	// need to research to see if this is right func
	}
	
	public void printExercise()
	{
		/* TODO:	Make cells that contain the name of the exercise
		 * 			in a subcell above cells containing the sets in
		 * 			the notation "weight x reps"
		 */
		
		// print name exercise
		for (Set s : sets)
		{
			// TODO:	print s.getWeight() "x" s.getReps()
		}
	}

}
