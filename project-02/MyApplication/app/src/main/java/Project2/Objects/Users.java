package Project2.Objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JamieAyer on 3/23/16.
 */
public class Users implements Serializable {

    private static long SerializeKeyForUsers = 156236723672366L;

    private ArrayList<ArrayList<Restaurant>> mUsersFavorites;

    private static Users user = new Users();

    private Users(){ }

    public static Users getInstance( ) {
        return user;
    }



}
