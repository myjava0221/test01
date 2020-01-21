package com.icook.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icook.model.RecipeBean;
import com.icook.recipe.dao.RecipeDao;

@Service
public class RecipeServiceImpl implements RecipeService {

	RecipeDao dao;
	
	@Autowired
	public void setDao(RecipeDao dao) {
		this.dao=dao;
	}
	
	@Transactional
	@Override
	public List<RecipeBean> getAllRecipes() {
		return dao.getAllRecipes();
	}

	@Transactional
	@Override
	public RecipeBean getRecipeByRecipeNo(int recipeNo) {
		return dao.getRecipeByRecipeNo(recipeNo);
	}

	@Transactional
	@Override
	public void addProduct(RecipeBean recipe) {
		dao.addRecipe(recipe);
	}

}
