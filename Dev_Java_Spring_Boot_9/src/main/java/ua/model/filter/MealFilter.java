package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ua.entity.Type;

public class MealFilter {

	private static final Pattern INT_PATTERN = Pattern.compile("^[0-9]{1,10}$");

	private static final Pattern DECIMAL_PATTERN = Pattern
			.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");

	private String minWeight = "";

	private String maxWeight = "";

	private String minPrice = "";

	private String maxPrice = "";
	
	private String serchTitle = "";

	private List<Integer> ingredientIds = new ArrayList<>();
	
	private List<Integer> cuisinesIds = new ArrayList<>();

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(maxWeight).matches())
		this.maxWeight = maxWeight;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}

	public List<Integer> getIngredientIds() {
		return ingredientIds;
	}

	public void setIngredientIds(List<Integer> ingredientIds) {
		this.ingredientIds = ingredientIds;
	}

	public List<Integer> getCuisinesIds() {
		return cuisinesIds;
	}

	public void setCuisinesIds(List<Integer> cuisineIds) {
		this.cuisinesIds = cuisineIds;
	}

	public String getSerchTitle() {
		return serchTitle;
	}

	public void setSerchTitle(String serchTitle) {
		this.serchTitle = serchTitle;
	}

	
	

}