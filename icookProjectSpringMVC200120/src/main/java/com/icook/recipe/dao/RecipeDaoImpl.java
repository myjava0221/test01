package com.icook.recipe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icook.model.RecipeBean;

@Repository
public class RecipeDaoImpl implements RecipeDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeBean> getAllRecipes() {
		String hql = "From RecipeBean";
		Session session = factory.getCurrentSession();
		List<RecipeBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public RecipeBean getRecipeByRecipeNo(int recipeNo) {
		Session session = factory.getCurrentSession();
		RecipeBean rb = session.get(RecipeBean.class, recipeNo);
		return rb;
	}

	@Override
	public void addRecipe(RecipeBean recipe) {
		Session session = factory.getCurrentSession();
//		memberBean mb = getMemberById(recipe.getMemberId());  要把userId加進來
//		recipe.setMemberBean(mb);
		session.save(recipe);
	}

}
