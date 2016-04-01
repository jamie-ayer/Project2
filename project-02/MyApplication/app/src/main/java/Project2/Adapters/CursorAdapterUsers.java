package Project2.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.jamieayer.project2.R;

import Project2.Databases.UserSQLiteOpenHelper;

/**
 * Created by JamieAyer on 3/22/16.
 */
public class CursorAdapterUsers extends CursorAdapter {

    private LayoutInflater cursorInflater;

    // Default constructor
    public CursorAdapterUsers(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

    }

    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewUser = (TextView)view.findViewById(R.id.userNameText);
        TextView textViewPassword = (TextView)view.findViewById(R.id.userPasswordText);

        String first = cursor.getString( cursor.getColumnIndex(UserSQLiteOpenHelper.COL_USER_NAME));
        String second = cursor.getString( cursor.getColumnIndex(UserSQLiteOpenHelper.COL_PASSWORD));

        textViewUser.setText("User: "+first);
        textViewPassword.setText("Password: "+second);

    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // R.layout.list_row is your xml layout for each row
        return cursorInflater.inflate(R.layout.custom_user_view, parent, false);
    }
}
