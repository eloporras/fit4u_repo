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
 * Date Created 3/12/14
 * Author: Eloin Porras
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
	 * Date Created: 3/12/14
	 * Author: Eloin Porras
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
	 * Date Created: 3/12/14
	 * Author: Eloin Porras
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
		SQLiteQueryBuilder QB = new SQLiteQueryBuilder();
		QB.setTables(Multi_Table + " INNER JOIN " + Equip_Table + " ON " +
		Multi_ReqEquip + " = " + Equip_Equipname);
		
		String OrderBy = Multi_Rank;
		
		SQLiteDatabase db = this.getReadableDatabase();
		String [] sColumns = new String [] {Multi_Name, Multi_Rank, Equip_Has};
		
		String selection = Equip_Has + " = ?";
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
		db.execSQL(CREATE_MULTICHEST_T);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
		 // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Users_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Equip_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Multi_Table);
 
        // Create tables again
        onCreate(db);
	}
	
	/* Module Name: checkDuplicate
	 * 
	 * Description:
	 * Check for Duplicate for any table on any column
	 * 
	 * Date Created: 3/20/14
	 * Author: Eloin Porras
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


}
