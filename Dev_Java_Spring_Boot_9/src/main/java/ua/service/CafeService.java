package ua.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Sort;

import ua.entity.Cafe;
import ua.model.request.CafeRequest;
import ua.model.request.MealRequest;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;

public interface CafeService {
	List<String> findAllTimes();

	List<String> findAllTypes();

	List<CafeView> findAllViews();
	
	CafeView findCafeViewById(Integer id);
	
	List<CafeIndexView> findAllIndexViews();

	void save(CafeRequest request);

	CafeRequest findOne(Integer id);
	
	Cafe findOneCafe(Integer id);

	void delete(Integer id);

	List<CafeIndexView> findAllViewsByDesc(Sort sort);
	List<CafeIndexView> findAllIndexViewsByDesc(Sort sort);
}