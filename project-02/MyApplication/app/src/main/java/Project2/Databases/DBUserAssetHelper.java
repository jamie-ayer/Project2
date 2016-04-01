package Project2.Databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class DBUserAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "AppDB";
    private static final int DATABASE_VERSION = 7;

    public DBUserAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
}