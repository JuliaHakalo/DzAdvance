package ua.model.request;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Meal;

public class OrderRequest {
	Integer id;

	private List<Meal> meals = new ArrayList<>();

	private ua.entity.Table table;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public ua.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.entity.Table table) {
		this.table = table;
	}

}
