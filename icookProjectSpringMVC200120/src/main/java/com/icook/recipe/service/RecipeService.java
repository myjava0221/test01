package com.icook.recipe.service;

import java.util.List;

import com.icook.model.RecipeBean;

public interface RecipeService {
	List<RecipeBean> getAllRecipes();
	public RecipeBean getRecipeByRecipeNo(int recipeNo);
	
	void addProduct(RecipeBean recipe);
}
