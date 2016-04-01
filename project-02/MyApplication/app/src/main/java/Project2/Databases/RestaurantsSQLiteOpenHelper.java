package Project2.Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import Project2.Objects.Restaurant;

/**
 * Created by Jamie 3/16/16.
 */

public class RestaurantsSQLiteOpenHelper extends SQLiteOpenHelper{
    private static final String TAG = RestaurantsSQLiteOpenHelper.class.getCanonicalName();

    //region Conts Declarations
    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "AppDB";
    public static final String RESTAURANT_LIST_TABLE_NAME = "restaurants";

    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_ADDRESS = "ADDRESS";
    public static final String COL_NEIGHBORHOOD = "NEIGHBORHOOD";
    public static final String COL_WEBSITE = "WEBSITE";
    public static final String COL_LAT = "LAT";
    public static final String COL_LNG = "LNG";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    //endregion

    public static final String[] RESTAURANT_COLUMNS = {COL_ID + " AS _id",COL_NAME,COL_TYPE,COL_ADDRESS,COL_NEIGHBORHOOD,
                                    COL_WEBSITE, COL_LAT, COL_LNG, COL_DESCRIPTION};

    private static final String CREATE_RESTAURANT_LIST_TABLE =
            "CREATE TABLE " + RESTAURANT_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_TYPE + " TEXT, " +
                    COL_ADDRESS + " TEXT, " +
                    COL_NEIGHBORHOOD + " TEXT, " +
                    COL_WEBSITE + " TEXT, " +
                    COL_LAT + " DOUBLE, " +
                    COL_LNG + " DOUBLE, " +
                    COL_DESCRIPTION + " TEXT )";

    public RestaurantsSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static RestaurantsSQLiteOpenHelper instance;

    public static RestaurantsSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new RestaurantsSQLiteOpenHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RESTAURANT_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }

    public Cursor getRestaurantList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(RESTAURANT_LIST_TABLE_NAME, // a. table
                RESTAURANT_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Restaurant getRestaurantByID(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(RESTAURANT_LIST_TABLE_NAME,
                new String[]{COL_NAME, COL_TYPE, COL_ADDRESS, COL_NEIGHBORHOOD, COL_WEBSITE, COL_DESCRIPTION, COL_LAT, COL_LNG, COL_ID},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            Restaurant restaurant = new Restaurant(
                    cursor.getString(cursor.getColumnIndex(COL_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                    cursor.getString(cursor.getColumnIndex(COL_ADDRESS)),
                    cursor.getString(cursor.getColumnIndex(COL_NEIGHBORHOOD)),
                    cursor.getString(cursor.getColumnIndex(COL_WEBSITE)),
                    cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_LAT)),
                    cursor.getDouble(cursor.getColumnIndex(COL_LNG)),
                    cursor.getInt(cursor.getColumnIndex(COL_ID)));
            return restaurant;
        } else {
            return null;
        }
    }

    /**
     * Querys multiple fields for searching across more than just one.
     */

    public Cursor searchList(String query){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(true,
                RESTAURANT_LIST_TABLE_NAME,
                new String[]{COL_ID + " AS _id", COL_NAME, COL_TYPE, COL_ADDRESS, COL_NEIGHBORHOOD},
                     "_id LIKE" + "'%" + query + "%' OR " + COL_NAME +
                        " LIKE" + "'%" + query + "%' OR " + COL_TYPE +
                        " LIKE" + "'%" + query + "%' OR " + COL_ADDRESS +
                        " LIKE" + "'%" + query + "%' OR " + COL_NEIGHBORHOOD + " LIKE" + "'%" + query + "%'",

                null,
                null,
                null,
                null,
                null);

        return  cursor;

    }


}
