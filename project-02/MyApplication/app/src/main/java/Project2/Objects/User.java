package Project2.Objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    private String mUserName;
    private String mUserPassword;
<<<<<<< HEAD
    private int mUserID;
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5

    private ArrayList<Restaurant> mUserFavorites;

    private static User user = new User( );

    private User(){ }

    public static User getInstance( ) {
        return user;
    }

<<<<<<< HEAD
    public User(String userName, String userPassword, int ID) {
        this.mUserName = userName;
        this.mUserPassword = userPassword;
        this.mUserID = ID;
=======
    public User(String userName, String userPassword) {
        this.mUserName = userName;
        this.mUserPassword = userPassword;
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getUserPassword() {
        return mUserPassword;
    }

    public void setUserPassword(String userPassword) {
        this.mUserPassword = userPassword;
    }

    public ArrayList<Restaurant> getUserFavorites() {
        return mUserFavorites;
    }

    public void setUserFavorites(Restaurant userFavorites) {
        if(mUserFavorites == null)
            mUserFavorites = new ArrayList<>();
        this.mUserFavorites.add(userFavorites);
    }
<<<<<<< HEAD

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int mUserID) {
        this.mUserID = mUserID;
    }
=======
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
}
