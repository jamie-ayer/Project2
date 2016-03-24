package Project2.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jamie 3/16/16.
 */

public class UserSQLiteOpenHelper extends SQLiteOpenHelper{
    private static final String TAG = RestaurantsSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "UsersDB";
    public static final String USER_LIST_TABLE_NAME = "users";

    public static final String COL_ID = "_id";
    public static final String COL_USER_NAME = "USER_NAME";
    public static final String COL_PASSWORD = "USER_PASSWORD";


    public static final String[] USER_COLUMNS = {COL_ID,COL_USER_NAME,COL_PASSWORD};

    private static final String CREATE_USER_LIST_TABLE =
            "CREATE TABLE " + USER_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_USER_NAME + " TEXT, " +
                    COL_PASSWORD + " TEXT )";

    public UserSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static UserSQLiteOpenHelper instance;

    public static UserSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new UserSQLiteOpenHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_LIST_TABLE_NAME);
        this.onCreate(db);
    }


    public Cursor getUserList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(USER_LIST_TABLE_NAME, // a. table
                USER_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public String getUserName(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(USER_LIST_TABLE_NAME,
                new String[]{COL_USER_NAME},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_USER_NAME));
        } else {
            return "No Name Found";
        }
    }

    public String getUserPassword(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(USER_LIST_TABLE_NAME,
                new String[]{COL_PASSWORD},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        } else {
            return "No Password Found";
        }
    }

    public void insert(String user, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_USER_NAME, user);
        values.put(COL_PASSWORD, password);

        db.insert(USER_LIST_TABLE_NAME, null, values);
    }

    public boolean CheckIfUserInDB(String userName, String userPassword) {
        SQLiteDatabase db = getReadableDatabase();
        String Query = "SELECT * FROM " + USER_LIST_TABLE_NAME + " WHERE " + COL_USER_NAME + " = ? " +
                "AND "+ COL_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(Query, new String[]{userName, userPassword});
        if(cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
