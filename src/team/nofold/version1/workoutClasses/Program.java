package team.nofold.version1.workoutClasses;

import java.util.LinkedList;
import java.util.List;

public class Program
{
	List<Week> weeks;
	
	public Program()
	{
		weeks = new LinkedList<Week>();
	}
	
	public void addWeek(Week w)
	{
		weeks.add(w);
	}
	
	public void printProgram()
	{
		for (Week w : weeks)
		{
			// TODO:	w.printWeek()
		}
	}
}
