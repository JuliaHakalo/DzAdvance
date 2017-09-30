package ua.service;

import java.util.List;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.model.request.MealRequest;
import ua.model.view.MealView;

public interface MealService {

	List<String> findAllCuisines();
	
	List<String> findAllIngredients();
	
	List<MealView> findAllViews();
	
	List<Meal> findAll();
	
	MealView findViewByID(Integer id);
	
	MealRequest findOne(Integer id);
	
	void delete(Integer id);
	
	List<MealView> findAllViewsMealsByCafe(Integer id);

	void save(MealRequest request, Cafe cafe);
	
}