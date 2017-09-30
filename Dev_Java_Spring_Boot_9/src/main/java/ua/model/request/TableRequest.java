package ua.model.request;

import ua.entity.Cafe;

public class TableRequest {
	private Integer id;
	private int countOfPeople;
	private Cafe cafe;
	private String isFree;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCountOfPeople() {
		return countOfPeople;
	}
	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}
	public Cafe getCafe() {
		return cafe;
	}
	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	
	
	
	
}
