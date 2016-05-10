package com.ayer.jamie.project4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;

/**
 * Created by JamieAyer on 5/9/16.
 */
public class RecipeViewHolder extends RecyclerView.ViewHolder {

    protected ImageView recipePicture;
    protected TextView recipeName;
    protected TextView recipeDescription;
    protected TextView recipePrice;
    //protected TextView recipeList;

    public RecipeViewHolder(View v) {
        super(v);

        recipePicture = (ImageView)v.findViewById(R.id.thumbnail);
        recipeName = (TextView)v.findViewById(R.id.name);
        recipeDescription = (TextView)v.findViewById(R.id.description);
        recipePrice = (TextView)v.findViewById(R.id.price);
        //recipeList = (TextView)v.findViewById(R.id.recipe);
    }

}
