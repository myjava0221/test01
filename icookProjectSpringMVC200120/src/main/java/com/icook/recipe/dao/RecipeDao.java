package com.icook.recipe.dao;

import java.util.List;

import com.icook.model.RecipeBean;

public interface RecipeDao {
	List<RecipeBean> getAllRecipes();
	public RecipeBean getRecipeByRecipeNo(int recipeNo);
	
	void addRecipe(RecipeBean recipe);
	
}
