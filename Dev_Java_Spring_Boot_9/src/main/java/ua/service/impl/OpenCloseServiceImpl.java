package ua.service.impl;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.entity.Ingredient;
import ua.entity.Meal;
import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;
import ua.model.request.MealRequest;
import ua.model.request.OpenCloseRequest;
import ua.repository.OpenCloseRepository;
import ua.service.OpenCloseService;
@Service
public class OpenCloseServiceImpl  implements OpenCloseService{

	private OpenCloseRepository repository;
	@Autowired
public OpenCloseServiceImpl(OpenCloseRepository repository) {
	this.repository = repository;
}
	
	
	@Override
	public List<String> findAllTimes() {
		List<LocalTime> times1 =repository.findAllTimes();
		List<String> times2 = new ArrayList<>();
		ListIterator<LocalTime> listIter2 = times1.listIterator();
		while(listIter2.hasNext()){
			LocalTime tmp = listIter2.next();
			String tm = tmp==null?null:tmp.format(DateTimeFormatter.ofPattern("HH:mm"));
			times2.add(tm);
		}
		return times2;
	}
	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	@Override
	public void save(OpenCloseRequest request) {
		OpenClose openclose = new OpenClose();
		openclose.setId(request.getId());
		openclose.setTime(LocalTime.parse(request.getTime()));
		repository.save(openclose);
	}

	@Override
	public OpenCloseRequest findOne(Integer id) {
		OpenClose openclose = repository.findOne(id);
		OpenCloseRequest request = new OpenCloseRequest();
		request.setTime(String.valueOf(openclose.getTime()));
		request.setId(openclose.getId());
		return request;
	}


	public List<OpenClose> findAll() {
		
		return repository.findAll();
	}


	@Override
	public Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter) {
		
		return  repository.findAll(filter(filter), pageable);
	}
	private Specification<OpenClose> filter(SimpleFilter filter){
		return (root, query, cb) ->{
			if(filter.getSearch().isEmpty()) return null;
			return cb.like(root.get("time"), filter.getSearch()+"%");
		};
	}
}
