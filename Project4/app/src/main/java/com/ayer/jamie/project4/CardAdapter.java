package com.ayer.jamie.project4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by JamieAyer on 5/9/16.
 */
public class CardAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private List<Recipe> recipeList;

    public CardAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);
        holder.recipeName.setText(recipe.recipeName);
        holder.recipeDescription.setText(recipe.recipeDescription);
        holder.recipePrice.setText(recipe.recipePrice);
        //holder.recipeName.setText(recipe.recipeName);

    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecipeViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.cardview_layout, parent, false);
        viewHolder = new RecipeViewHolder(v);

        return viewHolder;
    }
}
