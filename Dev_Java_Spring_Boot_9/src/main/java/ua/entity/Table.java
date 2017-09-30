package ua.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity{

	private int countOfPeople;
	@OneToMany(mappedBy = "table")
	private List<UserReserver> users;
	private boolean isFree;
	private	Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;
	
	public Table() {
		super();
	}

	public Table(int countOfPeople, boolean isFree) {
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
	}
	
	

	public List<UserReserver> getUsers() {
		return users;
	}

	public void setUsers(List<UserReserver> users) {
		this.users = users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean getisFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
}