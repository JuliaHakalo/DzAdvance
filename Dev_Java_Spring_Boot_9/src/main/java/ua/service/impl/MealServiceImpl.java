package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.model.request.MealRequest;
import ua.model.view.MealView;
import ua.repository.MealRepository;
import ua.service.MealService;

@Service
public class MealServiceImpl implements MealService{

	private final MealRepository repository;
	@Autowired
	public MealServiceImpl(MealRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllViews() {
		List<MealView> views = repository.findAllViews();
		views.forEach(this::loadIngredients);
		return views;
	}
	@Override
	public MealView findViewByID(Integer id) {
		MealView view = repository.findViewByID(id);
		loadIngredients(view);
		return view;
	}
	private void loadIngredients(MealView view) {
		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void save(MealRequest request,Cafe cafe) {
		Meal meal = new Meal();
		meal.setCuisine(request.getCuisine());
		meal.setDescription(request.getDescription());
		meal.setId(request.getId());
		meal.setCafe(cafe);
		System.out.println(request.getIngredients());
		meal.setIngredients(request.getIngredients());
		meal.setPhotoUrl(request.getPhotoUrl());
		meal.setPrice(new BigDecimal(request.getPrice()));
		meal.setTitle(request.getTitle());
		meal.setVersion(request.getVersion());
		meal.setWeight(Integer.valueOf(request.getWeight()));
		repository.save(meal);
	}

	@Override
	public MealRequest findOne(Integer id) {
		Meal meal = repository.findOneRequest(id);
		MealRequest request = new MealRequest();
		request.setCuisine(meal.getCuisine());
		request.setDescription(meal.getDescription());
		request.setId(meal.getId());
		request.setIngredients(meal.getIngredients());
		request.setPhotoUrl(meal.getPhotoUrl());
		request.setPrice(String.valueOf(meal.getPrice()));
		request.setTitle(meal.getTitle());
		request.setVersion(meal.getVersion());
		request.setWeight(String.valueOf(meal.getWeight()));
		return request;
	}

	@Override
	public List<Meal> findAll() {
		
		return repository.findAll();
	}

	@Override
	public List<MealView> findAllViewsMealsByCafe(Integer id) {
	
		return repository.findAllViewsMealsByCafe(id);
	}

	
}