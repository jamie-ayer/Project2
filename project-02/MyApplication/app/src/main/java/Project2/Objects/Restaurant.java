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
        return mRestaurantID;
    }

    public void setmRestaurantID(int mRestaurantID) {
        this.mRestaurantID = mRestaurantID;
    }
}
