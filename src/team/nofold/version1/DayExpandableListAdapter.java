package team.nofold.version1;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class DayExpandableListAdapter 
	extends BaseExpandableListAdapter
{
	private Context _context;
	private List<String> _listDataHeader;	//	header titles
	private HashMap<String, List<String>> _listDataChild;
	
	public DayExpandableListAdapter(Context context,
									List<String> listDataHeader,
									HashMap<String, List<String>> listChildData)
	{
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition)
	{
		return (this._listDataChild
				.get(this._listDataHeader.get(groupPosition))
					.get(childPosition));
	}

	@Override
	public long getChildId(int groupPosition, int childPostion)
	{
		return childPostion;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition, 
							boolean isLastChild, View convertView,
							ViewGroup parent)
	{
		final String childText = (String) getChild(groupPosition, childPosition);
		
		if (convertView == null)
		{
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.day_child, null);
		}
		
		TextView exerciseNameAndSetsReps =
				(TextView) convertView.findViewById(R.id.exercise_name_and_sets_repsTV);
		exerciseNameAndSetsReps.setText(childText);
		
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition)
	{
		return (this
				._listDataChild
					.get(this._listDataHeader.get(groupPosition))
						.size());
	}

	@Override
	public Object getGroup(int groupPosition)
	{
		return (this._listDataHeader.get(groupPosition));
	}

	@Override
	public int getGroupCount()
	{
		return (this._listDataHeader.size());
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
		String dayTitle = (String) getGroup(groupPosition);
		if (convertView == null)
		{
			LayoutInflater infalInflater =
					(LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.week_child, null);
		}
		
		TextView dayHeader = (TextView) convertView.findViewById(R.id.day_header_tv);
		dayHeader.setTypeface(null,Typeface.BOLD);
		dayHeader.setText(dayTitle);
		return convertView;
	}

	@Override
	public boolean hasStableIds()
	{
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return true;
	}
}
