package com.example.fit4u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

/* Class Name: DB_Interface
 * 
 * Description:
 * This class would create a database using SQL_lite
 * This class is designed to work without any dependencies
 * and its a stand alone class
 * This class would have multiple methods to insert and 
 * query the database created within the class
 * 
 * Date Created 3/12/14 (Last edit: 4/1/14)
 * Authors: Eloin Porras & Kendall Clark
 * 
 */

public class DB_Interface extends SQLiteOpenHelper {
	
	/*
	 * Database Name and Version
	 */
	private final static String DBNAME = "FITDB.db";
	private final static int DATABASE_VERSION = 3;
	
	/*
	 * The following are SQL Create Table Statements
	 */
	private static final String CREATE_USER_T =
	"CREATE TABLE Users ( ID INTEGER PRIMARY KEY, Name TEXT, NumDays INTEGER, Program TEXT, Password TEXT )";
	private static final String CREATE_EQUIP_T =
	"CREATE TABLE Equipment ( ID INTEGER PRIMARY KEY, EquipName TEXT, Has TEXT);";
	private static final String CREATE_MULTICHEST_T =
	"CREATE TABLE MultiJointChest ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLECHEST_T=
	"CREATE TABLE SingleJointChest ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLECALF_T=
	"CREATE TABLE SingleCalf ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLEBICEP_T=
	"CREATE TABLE SingleJointBicep ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SQUATVAR_T=
	"CREATE TABLE SquatVariation ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_LUNGESTEP_T=
	"CREATE TABLE LungeStep ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_MULTISHOULDER_T=
	"CREATE TABLE MultiShoulder ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_DEADLIFTVAR_T=
	"CREATE TABLE DeadliftVariation ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLEFOREARM_T=
	"CREATE TABLE SingleForearm ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLETRI_T=
	"CREATE TABLE SingleTri( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_POWER_T=
	"CREATE TABLE Power ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_SINGLESHOULDER_T=
	"CREATE TABLE SingleJointShoulder ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_MULTIBACKVERT_T=
	"CREATE TABLE MultiJointBackVert ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_MULTIBACKHORIZ_T=
	"CREATE TABLE MultiJointBackHoriz ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	private static final String CREATE_ABS_T=
	"CREATE TABLE AbsTimed ( ID INTEGER PRIMARY KEY, Rank INTEGER, Name TEXT, ReqEquip TEXT);";
	
	
	/*
	 * The Following are the Column names for the Users Table
	 */
	private final static String Users_Table = "Users";
	private final static String Users_Name = "Name";
	private final static String Users_Pass = "Password";
	private final static String Users_NumDays = "NumDays";
	private final static String Users_Program = "Program";
	
	/*
	 * The following are the column names for the Equipment table
	 */
	
	private final static String Equip_Table = "Equipment";
	private final static String Equip_Equipname = "EquipName";
	private final static String Equip_Has = "Has";
	
	/*
	 * The following are the column names for the MultiJointChest Table
	 */
	private final static String Multi_Table = "MultiJointChest";
	private final static String Multi_Rank = "Rank";
	private final static String Multi_Name = "Name";
	private final static String Multi_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SingleJointChest Table
	 */
	private final static String SJC_Table = "SingleJointChest";
	private final static String SJC_Rank = "Rank";
	private final static String SJC_Name = "Name";
	private final static String SJC_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SingleCalf Table
	 */
	private final static String SC_Table = "SingleCalf";
	private final static String SC_Rank = "Rank";
	private final static String SC_Name = "Name";
	private final static String SC_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SingleJointBicep Table
	 */
	private final static String SJB_Table = "SingleJointBicep";
	private final static String SJB_Rank = "Rank";
	private final static String SJB_Name = "Name";
	private final static String SJB_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SquatVariation Table
	 */
	private final static String SVAR_Table = "SquatVariation";
	private final static String SVAR_Rank = "Rank";
	private final static String SVAR_Name = "Name";
	private final static String SVAR_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the LungeStep Table
	 */
	private final static String LS_Table = "LungeStep";
	private final static String LS_Rank = "Rank";
	private final static String LS_Name = "Name";
	private final static String LS_ReqEquip = "ReqEquip";
	
		
	/*
	 * The following are the column names for the MultiJointShoulder Table
	 */
	private final static String MJS_Table = "MultiJointShoulder";
	private final static String MJS_Rank = "Rank";
	private final static String MJS_Name = "Name";
	private final static String MJS_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the DeadliftVariation Table
	 */
	private final static String DLV_Table = "DeadliftVariation";
	private final static String DLV_Rank = "Rank";
	private final static String DLV_Name = "Name";
	private final static String DLV_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SingleForearm Table
	 */
	private final static String SFA_Table = "SingleForearm";
	private final static String SFA_Rank = "Rank";
	private final static String SFA_Name = "Name";
	private final static String SFA_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the SingleJointTri Table
	 */
	private final static String SJT_Table = "SingleJointTri";
	private final static String SJT_Rank = "Rank";
	private final static String SJT_Name = "Name";
	private final static String SJT_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the Power Table
	 */
	private final static String Power_Table = "Power";
	private final static String Power_Rank = "Rank";
	private final static String Power_Name = "Name";
	private final static String Power_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the MultiJointBackVert Table
	 */
	private final static String MJBV_Table = "MultiJointBackVert";
	private final static String MJBV_Rank = "Rank";
	private final static String MJBV_Name = "Name";
	private final static String MJBV_ReqEquip = "ReqEquip";
	
	/*
	 * The following are the column names for the MultiJointBackHoriz Table
	 */
	private final static String MJBH_Table = "MultiJointBackHoriz";
	private final static String MJBH_Rank = "Rank";
	private final static String MJBH_Name = "Name";
	private final static String MJBH_ReqEquip = "ReqEquip";
	
	
	
	/*
	 * The following are the column names for the AbsTimed Table
	 */
	private final static String Abs_Table = "AbsTimed";
	private final static String Abs_Rank = "Rank";
	private final static String Abs_Name = "Name";
	private final static String Abs_ReqEquip = "ReqEquip";
	
	
	/* Module Name: insertUsers
	 * 
	 * Description:
	 * The insertUsers function would insert one row into the Users Table
	 * with the following parameters Name of the user, Number of Days for
	 * work out and the name of the program  
	 * 
	 * Date Created 3/12/14
	 * Author Eloin Porras
	 */
	
	public void insertUsers(String name, String pass, int numDays, String Program)
	{
		
		long id = 0;
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(Users_Name, name);
		values.put(Users_Pass, pass);
		values.put(Users_NumDays, numDays);
		values.put(Users_Program, Program);
		
		if(!checkDuplicate(name, Users_Table, Users_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(Users_Table, null, values);
			db.close();
		}
		
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	/* Module Name: insertEquipment
	 * 
	 * Description:
	 * The insertEquipment function would insert one row into the 
	 * Equipment table with the following parameters Equipment Name,
	 * and the String Has for if he has the equipment
	 * 
	 * Date Created: 3/12/14 (Last edit 4/1/14)
	 * Author: Eloin Porras & Kendall Clark
	 */
	
	public void insertEquipment(String equipmentName, String has)
	{
		
		long id = 0;
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(Equip_Equipname, equipmentName);
		values.put(Equip_Has, has);
		
		if(!checkDuplicate(equipmentName, Equip_Table, Equip_Equipname))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(Equip_Table, null, values);
			db.close();
		}
		
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
	}
	/* Module Name: insertMultiJointTest
	 * 
	 * The insert Multi Joint Chest function would insert one row in the
	 * MultiJointChest table with the following parameters integer rank,
	 * string name, and string requirement
	 * 
	 * Date Created: 3/12/14 (Last edit)
	 * Author: Eloin Porras & Kendall Clark
	 */
	
	public void insertMultiJointChest(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(Multi_Rank, rank);
		values.put(Multi_Name, name);
		values.put(Multi_ReqEquip, req);
		
		if(!checkDuplicate(name, Multi_Table, Multi_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(Multi_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	public void insertSingleJointChest(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SJC_Rank, rank);
		values.put(SJC_Name, name);
		values.put(SJC_ReqEquip, req);
		
		if(!checkDuplicate(name, SJC_Table, SJC_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SJC_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertSingleCalf(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SC_Rank, rank);
		values.put(SC_Name, name);
		values.put(SC_ReqEquip, req);
		
		if(!checkDuplicate(name, SC_Table, SC_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SC_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertSingleJointBicep(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SJB_Rank, rank);
		values.put(SJB_Name, name);
		values.put(SJB_ReqEquip, req);
		
		if(!checkDuplicate(name, SJB_Table, SJB_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SJB_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertSquatVariation(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SVAR_Rank, rank);
		values.put(SVAR_Name, name);
		values.put(SVAR_ReqEquip, req);
		
		if(!checkDuplicate(name, SVAR_Table, SJC_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SVAR_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertLungeStep(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(LS_Rank, rank);
		values.put(LS_Name, name);
		values.put(LS_ReqEquip, req);
		
		if(!checkDuplicate(name, LS_Table, LS_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(LS_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	public void insertMultiJointShoulder(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(MJS_Rank, rank);
		values.put(MJS_Name, name);
		values.put(MJS_ReqEquip, req);
		
		if(!checkDuplicate(name, MJS_Table, MJS_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(MJS_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}

	
	public void insertDeadliftVariation(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(DLV_Rank, rank);
		values.put(DLV_Name, name);
		values.put(DLV_ReqEquip, req);
		
		if(!checkDuplicate(name, DLV_Table, DLV_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(DLV_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	public void insertSingleForearm(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SFA_Rank, rank);
		values.put(SFA_Name, name);
		values.put(SFA_ReqEquip, req);
		
		if(!checkDuplicate(name, SFA_Table, SFA_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SFA_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	public void insertSingleJointTricep(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(SJT_Rank, rank);
		values.put(SJT_Name, name);
		values.put(SJT_ReqEquip, req);
		
		if(!checkDuplicate(name, SJT_Table, SJT_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(SJT_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	public void insertPower(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(Power_Rank, rank);
		values.put(Power_Name, name);
		values.put(Power_ReqEquip, req);
		
		if(!checkDuplicate(name, Power_Table, Power_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(Power_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertMultiJointBackVert(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(MJBV_Rank, rank);
		values.put(MJBV_Name, name);
		values.put(MJBV_ReqEquip, req);
		
		if(!checkDuplicate(name, MJBV_Table, MJBV_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(MJBV_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	public void insertMultiJointBackHoriz(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(MJBH_Rank, rank);
		values.put(MJBH_Name, name);
		values.put(MJBH_ReqEquip, req);
		
		if(!checkDuplicate(name, MJBH_Table, MJBH_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(MJBH_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	
	public void insertAbsTimed(int rank, String name, String req)
	{
		long id = 0;
		
		
		ContentValues values;
		values = new ContentValues();
		
		values.put(Abs_Rank, rank);
		values.put(Abs_Name, name);
		values.put(Abs_ReqEquip, req);
		
		if(!checkDuplicate(name, Abs_Table, Abs_Name))
		{
			SQLiteDatabase db = this.getWritableDatabase();
			id = db.insert(Abs_Table, null, values);
			db.close();
		}
		if(id == -1)
		{
			Log.e("SQL_Error", "Insert has Fail");
		}
		
	}
	
	
	
	
	
	
	
	
	
	/* Module Name: chestJOINEquipment
	 * 
	 * Description:
	 * The following function would perform a query to find the lowest rank for
	 * exercise and match it to the equipment
	 * Example SQL Query for this function:
	 * 	
	 * SELECT MIN(Rank), Name 
	 * FROM MultiJointChest JOIN Equipment
	 * WHERE Equipment.Has = 'Yes';
	 * 
	 * Date Created: 3/12/14
	 * Author: Eloin Porras
	 */
	public String chestJOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(Multi_Table + " INNER JOIN " + Equip_Table + " ON " +
					 Multi_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = Multi_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {Multi_Name, Multi_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SJC_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SJC_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SJC_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = Multi_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SJC_Name, SJC_Rank, SJC_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SC_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SC_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SC_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = SC_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SC_Name, SC_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SJB_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SJB_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SJB_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = SJB_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SJB_Name, SJB_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SVAR_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SVAR_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SVAR_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = SVAR_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SVAR_Name, SVAR_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String LS_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(LS_Table + " INNER JOIN " + Equip_Table + " ON " +
					 LS_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = LS_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {LS_Name, LS_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String MJS_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(MJS_Table + " INNER JOIN " + Equip_Table + " ON " +
					 MJS_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = MJS_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {MJS_Name, MJS_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	
	public String DLV_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(DLV_Table + " INNER JOIN " + Equip_Table + " ON " +
					 DLV_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = DLV_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {DLV_Name, DLV_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SFA_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SFA_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SFA_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = SFA_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SFA_Name, SFA_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String SJT_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(SJT_Table + " INNER JOIN " + Equip_Table + " ON " +
					 SJT_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = SJT_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {SJT_Name, SJT_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	
	public String PowerJOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(power_Table + " INNER JOIN " + Equip_Table + " ON " +
					 power_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = power_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {power_Name, power_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String MJBV_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(MJBV_Table + " INNER JOIN " + Equip_Table + " ON " +
					 MJBV_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = MJBV_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {MJBV_Name, MJBV_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	public String MJBH_JOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(MJBH_Table + " INNER JOIN " + Equip_Table + " ON " +
					 MJBH_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = MJBH_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {MJBH_Name, MJBH_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	
	public String AbsTimedJOINEquipment()
	{
		
		String result = "None";
		// This to perform the Join Statement
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		// This the SQL join Statement
		QB.setTables(AbsTimed_Table + " INNER JOIN " + Equip_Table + " ON " +
					 AbsTimed_ReqEquip + " = " + Equip_Equipname);
		
		// This is order the list in acending order
		String OrderBy = AbsTimed_Rank;
		
		// DB will return the final result
		SQLiteDatabase db = this.getReadableDatabase();
		// the parameter for the select statement for the columns to return
		String [] sColumns = new String [] {AbsTimed_Name, AbsTimed_Rank, Equip_Has};
		
		// the question mark is a placeholder for the selection Args variable
		String selection = Equip_Has + " = ?";
		// this variable must be a string array 
		String[] selectionArgs = new String [] {"Yes"};
		
		Cursor cursor = QB.query(db, sColumns, selection, selectionArgs, null, null, OrderBy);
		
		cursor.moveToFirst();
		result = cursor.getString(0);
		
		return result;
	}
	
	
	
	// Constructor for the class. Must pass the getApplicationContext()
	DB_Interface(Context context) 
	{
		super(context, DBNAME, null, DATABASE_VERSION);
	}
	
	// Creates Tables for class
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(CREATE_USER_T);
		db.execSQL(CREATE_EQUIP_T);
		db.execSQL(CREATE_SINGLECHEST_T);
		db.execSQL(CREATE_SINGLECALF_T);
		db.execSQL(CREATE_SINGLEBICEP_T);
		db.execSQL(CREATE_SQUATVAR_T);
		db.execSQL(CREATE_LUNGESTEP_T);
		db.execSQL(CREATE_MULTISHOULDER_T);
		db.execSQL(CREATE_DEADLIFTVAR_T);
		db.execSQL(CREATE_SINGLEFOREARM_T);
		db.execSQL(CREATE_SINGLETRI_T);
		db.execSQL(CREATE_SINGLESHOULDER_T);
		db.execSQL(CREATE_POWER_T);
		db.execSQL(CREATE_MULTIBACKVERT_T);
		db.execSQL(CREATE_MULTIBACKHORIZ_T);
		db.execSQL(CREATE_ABS_T);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Users_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Equip_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Multi_Table);
		db.execSQL("DROP TABLE IF EXISTS " + SJC_Table);
        db.execSQL("DROP TABLE IF EXISTS " + SC_Table);
        db.execSQL("DROP TABLE IF EXISTS " + SJB_Table);
        db.execSQL("DROP TABLE IF EXISTS " + SVAR_Table);
        db.execSQL("DROP TABLE IF EXISTS " + LS_Table);
        db.execSQL("DROP TABLE IF EXISTS " + MJS_Table);
        db.execSQL("DROP TABLE IF EXISTS " + DLV_Table);
        db.execSQL("DROP TABLE IF EXISTS " + SFA_Table);
        db.execSQL("DROP TABLE IF EXISTS " + SJT_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Power_Table);
        db.execSQL("DROP TABLE IF EXISTS " + MJBV_Table);
        db.execSQL("DROP TABLE IF EXISTS " + MJBH_Table);
        db.execSQL("DROP TABLE IF EXISTS " + AbsTimed_Table);

		
        // Create tables again
        onCreate(db);
	}
	
	/* Module Name: checkDuplicate
	 * 
	 * Description:
	 * Check for Duplicate for any table on any column
	 * 
	 * Date Created: 3/20/14 (Last Edit 4/1/14)
	 * Author: Eloin Porras & Kendall Clark
	 */
	
	
	private Boolean checkDuplicate(String name, String table, String Column)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		String [] sColumns = new String [] {Column};
		
		Cursor cursor = db.query(table, sColumns, null, null, null, null, null);
		
		if(cursor.moveToFirst())
			do
			{
				//Log.w("Result", cursor.getString(0) + "...." + name);
				if(name.equals(cursor.getString(0)))
				{
					Log.w("Found", "Duplicate: " + name);
					return true;
				}
				
			}while(cursor.moveToNext());
		
		return false;
		
	}
	
	/* Module Name: authenticate_User
	 * 
	 * Description: Check if the password of the user matches
	 * for security reasons
	 * 
	 * Date Created: 3/20/14
	 * Author: Eloin Porras
	 */
	public Boolean authenticate_User(String name, String pass)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		
		String [] sColumns = new String [] {Users_Name,  Users_Pass};
		
		Cursor cursor = db.query(Users_Table, sColumns, null, null, null, null, null);
		
		if(cursor.moveToFirst())
			do
			{
				if(name.equals(cursor.getString(0)))
				{
					if(pass.equals(cursor.getString(1)))
						return true;
					else 
						return false;
				}
				
			}while(cursor.moveToNext());
		
		return false;
	}
	
	/*
	 * Module Name: UpdateRow
	 * 
	 * Description:
	 * Update a single row on any table with integer columns.
	 * 
	 * Note: Needs Work!!!!!!!!!
	 * 
	 * Date Created: 3/21/14
	 * Author: Eloin Porras
	 */
	
	public Boolean updateRowInterger(String table, String column, String id, int value)
	{
		long result = 0;
		SQLiteDatabase db = this.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put(column, value);
		
		result = db.update(table, values, Users_Name + " = ?", new String[] { id });
		
		if(result != -1)
			return true;
		
		return false;
	}
	
	/*
	 * Module Name: deleteAllRows
	 * 
	 * Description:
	 * Delete all rows from a single table
	 * 
	 * Note: Extreme Caution before use!
	 * 
	 * Date Created: 3/21/14
	 * Author: Eloin Porras
	 * 
	 */
	
	public void deleteAllRows(String table)
	{
		SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(table, null, null);
	    db.close();
	}
	
	public int findID()
	{
		int result = 0;
		
		return result;
	}
	
}