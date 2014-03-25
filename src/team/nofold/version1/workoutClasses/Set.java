package team.nofold.version1.workoutClasses;

public class Set
{
	int reps;
	int weight;
	static int DEFAULT_BEGINNER_REPS = 10;
	
	public Set(int w, int r)
	{
		setReps(r);
		setWeight(w);
	}
	
	public int getReps()
	{
		return reps;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setReps(int r)
	{
		if (r > 0) reps = r;
		else reps = DEFAULT_BEGINNER_REPS;
	}
	
	public void setWeight(int w)
	{
		if (w >= 0) weight = (w / 5) * 5;	// gives weight as a floor(5) 
		//if (w >= 0) weight = (w / 5) * 5 + 5;	// gives weight as ceiling(5)
		else weight = 0;
	}
}
