package Project2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jamieayer.project2.R;

import java.util.ArrayList;
import java.util.List;

import Project2.Objects.Restaurant;

/**
 * Created by JamieAyer on 3/22/16.
 */
public class CustomAdapterFavorites extends ArrayAdapter<Restaurant> {

    List<Restaurant> restaurantsArray;
    TextView mRestaurantName;
    TextView mRestaurantType;

    public CustomAdapterFavorites(Context context, ArrayList<Restaurant> objects) {
        super(context, -1, objects);
        this.restaurantsArray = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.cu, parent, false);
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_favorite_view, parent, false);

        mRestaurantName = (TextView)rowItem.findViewById(R.id.restaurantName);
        mRestaurantType = (TextView)rowItem.findViewById(R.id.restaurantType);
        Restaurant restaurant = restaurantsArray.get(position);

        mRestaurantName.setText(restaurant.getmName());
        mRestaurantType.setText(restaurant.getmType());

        return rowItem;
    }




}
