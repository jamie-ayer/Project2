package Project2.Databases;

import android.content.Context;
<<<<<<< HEAD
import android.database.sqlite.SQLiteDatabase;
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class DBRestaurantsAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "AppDB";
    private static final int DATABASE_VERSION = 7;

    public DBRestaurantsAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
}
