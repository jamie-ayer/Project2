package Project2.Objects;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class Restaurant {

    private String mName;
    private String mType;
    private String mAddress;
    private String mNeighborhood;
    private String mWebsite;
    private String mDescription;
    private double lat;
    private double lng;
    private int mRestaurantID;

    public Restaurant(String mName, String mType, String mAddress, String mNeighborhood,
                      String mWebsite, String mDescription, double lat, double lng, int ID) {
        this.mName = mName;
        this.mType = mType;
        this.mAddress = mAddress;
        this.mNeighborhood = mNeighborhood;
        this.mWebsite = mWebsite;
        this.mDescription = mDescription;
        this.lat = lat;
        this.lng = lng;
        this.mRestaurantID = ID;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

<<<<<<< HEAD
    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getNeighborhood() {
        return mNeighborhood;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getRestaurantID() {
=======
    public String getmName() {
        return mName;
    }

    public String getmType() {
        return mType;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmNeighborhood() {
        return mNeighborhood;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmRestaurantID() {
>>>>>>> 9155b936c5f812ed9e07f3161552270f51dc96a5
        return mRestaurantID;
    }

    public void setmRestaurantID(int mRestaurantID) {
        this.mRestaurantID = mRestaurantID;
    }
}
