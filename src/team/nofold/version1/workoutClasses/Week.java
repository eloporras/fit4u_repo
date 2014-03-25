package team.nofold.version1.workoutClasses;

import java.util.LinkedList;
import java.util.List;

public class Week
{
	List<Day> days;
	
	public Week()
	{
		days = new LinkedList<Day>();
	}
	
	public void addDay(Day d)
	{
		days.add(d);
	}
	
	public void printWeek()
	{
		for (Day d: days)
		{
			// TODO:	d.printDay();
		}
	}
}