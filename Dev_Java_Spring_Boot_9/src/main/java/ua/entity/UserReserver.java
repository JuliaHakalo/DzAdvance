package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "_user_reserver")
public class UserReserver extends AbstractEntityName {
	@ManyToOne(fetch = FetchType.LAZY)
	private ua.entity.Table table;

	public ua.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.entity.Table table) {
		this.table = table;
	}

}
