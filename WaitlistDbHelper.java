package com.example.android.waitlist.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

//Completed TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper{
    //Completed TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    private static final String DATABASE_NAME = "waitlist.db";
    //Completed TODO (3) Create a static final int called DATABASE_VERSION and set it to 1
    private static final int DATABASE_VERSION = 1;
    //Completed TODO (4) Create a Constructor that takes a context and calls the parent constructor
    WaitlistDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    //Completed: TODO (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Completed: TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE_TABLE" +
                WaitlistContract.WaitlistEntry.TABLE_NAME + " (" +
                WaitlistContract.WaitlistEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + "TEXT NOT NULL," +
                WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + "INTEGER NOT NULL," +
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" + ")";
        //Completed: TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    //Completed: TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Completed: TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
        db.execSQL("DROP TABLE IF EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(db);

    }

















}