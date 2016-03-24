package com.example.jamieayer.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import Project2.Databases.RestaurantsSQLiteOpenHelper;
import Project2.Objects.Restaurant;
import Project2.Objects.User;

/**
 * Created by JamieAyer on 3/21/16.
 */
public class DetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private TextView mName;
    private TextView mType;
    private TextView mAddress;
    private TextView mNeighborhood;
    private TextView mWebsite;
    private TextView mDescription;

    private Restaurant restaurant;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        mName = (TextView) findViewById(R.id.name);
        mType = (TextView) findViewById(R.id.type);
        mAddress = (TextView) findViewById(R.id.address);
        mNeighborhood = (TextView) findViewById(R.id.neighborhood);
        mWebsite = (TextView) findViewById(R.id.website);
        mDescription = (TextView) findViewById(R.id.description);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RestaurantsSQLiteOpenHelper helper = RestaurantsSQLiteOpenHelper.getInstance(DetailActivity.this);

        id = getIntent().getIntExtra("id", -1);

        if(id >= 0) {
            restaurant = helper.getRestaurantByID(id);
            mName.setText(restaurant.getmName());
            mType.setText(restaurant.getmType());
            mAddress.setText(restaurant.getmAddress());
            mNeighborhood.setText(restaurant.getmNeighborhood());
            mDescription.setText(restaurant.getmDescription());
        }

        mWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(restaurant.getmWebsite()));
                startActivity(intent);
            }
        });
    }

    /**
     * Zooms to latlng, so it has animation instead of a blank screen
     * while loading the map.
     * @param googleMap
     */

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        LatLng loc = new LatLng(restaurant.getLat(), restaurant.getLng());

        mMap.addMarker(new MarkerOptions().position(loc).title(restaurant.getmName()));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(loc)
                .zoom(17)
                .bearing(0)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public void saveRestaurant(View view) {
        User.getInstance().setUserFavorites(restaurant);
        Intent intent = new Intent(DetailActivity.this, HomeScreenActivity.class);
        startActivity(intent);
    }
}
