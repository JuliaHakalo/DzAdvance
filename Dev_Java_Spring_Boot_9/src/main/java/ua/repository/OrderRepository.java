package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.view.MealView;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m JOIN m.cuisine c")
	List<MealView> findAllViews();
	@Query("SELECT t FROM Table t")
	List<Table> findAllTables();
	@Query("SELECT DISTINCT m FROM Order m  LEFT JOIN  m.meals WHERE m.id=?1")
	Order findOneRequest(Integer id);
	@Query("SELECT o FROM Order o JOIN  o.table t WHERE t.id in (?1)")
	List<Order> findAllOrder(List<Integer> tablesId);
	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m JOIN m.cuisine c  WHERE m.id=?1")
	List<MealView> findAllMealsbyid(Integer id);
}