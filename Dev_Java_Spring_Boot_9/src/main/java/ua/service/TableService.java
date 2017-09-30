package ua.service;

import java.util.List;

import ua.entity.Table;
import ua.model.request.TableRequest;
import ua.model.view.CafeView;

public interface TableService {

	List<Table> findAll();

	List<CafeView> findAllViewsCafe();

	// List<MealView> findAllViewsMeal();

	void save(TableRequest request);

	List<Table> findAllTablesbyIdCafe(Integer id);

	List<Table> findAllTablesbyIdCafeReserved(Integer id, boolean isFree);

	List<Integer> findAllTablesbyIdCafeReservedIDS(Integer id, boolean isFree);

	void delete(Integer id);

	Table findOneTable(Integer id);

	TableRequest findOne(Integer id);

}
