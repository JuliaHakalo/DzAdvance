package ua.service;

import java.util.List;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.MealView;

public interface OrderService {
	List<MealView> findAllViews();

	// List<Table> findAllTable();
	void save(OrderRequest request);

	OrderRequest findOne(Integer id);

	void delete(Integer id);
	
	

	List<Order> findAllOrderForAllsTablesINCAFE(List<Integer> tablesId);
}
