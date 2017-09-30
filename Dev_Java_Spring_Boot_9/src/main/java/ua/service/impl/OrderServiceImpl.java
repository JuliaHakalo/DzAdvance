package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Order;
import ua.model.request.OrderRequest;
import ua.model.view.MealView;
import ua.repository.OrderRepository;
import ua.service.OrderService;
@Service
public class OrderServiceImpl  implements OrderService {
	private final OrderRepository repository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository) {
		this.repository=repository;
	}
	@Override
	public List<MealView> findAllViews() {
		return repository.findAllViews();
	}
//	@Override
//	@Transactional(readOnly=true)
//	public List<MealView> findAllViews() {
//		List<MealView> views = repository.findAllViews();
//		views.forEach(this::loadIngredients);
//		return views;
//	}
//	
//	private void loadIngredients(MealView view) {
//		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
//	}
	@Override
	public void save(OrderRequest request) {
		Order order = new Order();
		order.setId(request.getId());
		order.setMeals(request.getMeals());
		order.setTable(request.getTable());
		repository.save(order);
	}

	@Override
	public OrderRequest findOne(Integer id) {
		Order order = repository.findOneRequest(id);
		System.out.println(order.getMeals());
		OrderRequest request = new OrderRequest();
		request.setId(order.getId());
		request.setMeals(order.getMeals());
		request.setTable(order.getTable());
		return request;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
//	@Override
//	public List<Table> findAllTable() {	
//		return repository.findAllTables();
//	}
	@Override
	@Transactional(readOnly=true)
	public List<Order> findAllOrderForAllsTablesINCAFE(List<Integer> tablesId) {
		
		return repository.findAllOrder(tablesId);
	}
	

}
