package com.icook.recipe.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.icook.model.RecipeBean;
import com.icook.recipe.service.RecipeService;

@Controller
public class RecipeController {
	
	RecipeService service;
	ServletContext context;
	
	@Autowired
	public void setService(RecipeService service) {
		this.service = service;
	}
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@RequestMapping("/recipes")
	public String list(Model model) {
		List<RecipeBean> list = service.getAllRecipes();
		model.addAttribute("recipes", list);
		return "recipe/recipes";
	}
	
	@RequestMapping("/recipe")
	public String getRecipeByRecipeNo(@RequestParam("no") Integer recipeNo, Model model) {
		model.addAttribute("recipe", service.getRecipeByRecipeNo(recipeNo));
		return "recipe/RecipeDetail";
	}
	
	
	@RequestMapping(value="/recipes/add", method=RequestMethod.GET)
	public String getAddNewRecipeForm(Model model) {
		RecipeBean rb = new RecipeBean();
		model.addAttribute("recipeBean", rb);
		return "recipe/addRecipe";
	}
	
	@RequestMapping(value="/recipes/add", method=RequestMethod.POST)
	public String getAddNewRecipeForm(@ModelAttribute("RecipeBean") RecipeBean rb, BindingResult result) {
		MultipartFile coverImg = rb.getRecipeImage();
		
		
		return "recipe/addRecipe";
	}
	
	
//	@ModelAttribute("cookingTimeList")
//	public List<String> getCookingTimeList() {
//		List<String> CookingTime =null;
//		CookingTime.add("5");
//		return CookingTime;
//	}
	
}
