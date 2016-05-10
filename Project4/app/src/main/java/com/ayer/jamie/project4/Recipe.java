package com.ayer.jamie.project4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by JamieAyer on 5/9/16.
 */
public class Recipe {

    protected int recipePicture;

    protected Context context;

    protected String recipeName;
    protected String recipeDescription;
    protected String recipePrice;
    //protected String recipeList;

    public Recipe(int recipePicture, String recipeName, String recipeDescription, String recipePrice) {
        this.recipePicture = recipePicture;
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipePrice = recipePrice;
        //this.recipeList = recipeList;
    }
}
