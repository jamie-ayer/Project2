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

    private ArrayList<Restaurant> mUserFavorites;

    private static User user = new User( );

    private User(){ }

    public static User getInstance( ) {
        return user;
    }

    public User(String userName, String userPassword) {
        this.mUserName = userName;
        this.mUserPassword = userPassword;
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
}
