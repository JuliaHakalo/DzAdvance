package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Meal;
import ua.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer> {

	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();

	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();

	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m JOIN m.cuisine c")
	List<MealView> findAllViews();

	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight,cf.name,cf.id) FROM Meal m JOIN  m.cafe cf JOIN m.cuisine c WHERE m.id=?1")
	MealView findViewByID(Integer id);

	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m  WHERE m.id=?1")
	List<String> findAllIngredientsByMealId(Integer id);

	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m JOIN m.cuisine c JOIN m.cafe cf WHERE cf.id=?1")
	List<MealView> findAllViewsMealsByCafe(Integer id);

	@Query("SELECT m FROM Meal m WHERE m.title=?1")
	Meal findbyName(String name);

	@Query("SELECT DISTINCT m FROM Meal m JOIN FETCH m.cuisine JOIN FETCH m.cafe LEFT JOIN FETCH m.ingredients WHERE m.id=?1")
	Meal findOneRequest(Integer id);
}