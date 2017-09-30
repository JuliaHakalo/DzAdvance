package ua.service.impl;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.catalina.startup.ClassLoaderFactory.RepositoryType;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.entity.Type;
import ua.model.request.CafeRequest;
import ua.model.request.MealRequest;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl  implements CafeService {
private final CafeRepository repository;
	@Autowired
	public CafeServiceImpl(CafeRepository repository) {
		this.repository=repository;
	}
	@Override
	public List<String> findAllTimes() {
//	List<Time> times=repository.findAllTimes();
	List<LocalTime> times1 =repository.findAllTimes();
	List<String> times2 = new ArrayList<>();
//		ListIterator<Time> listIter = times.listIterator(times.size());
//		while(listIter.hasNext()){
//			Time tmp = listIter.next();
//			LocalTime tm = tmp==null?null:tmp.toLocalTime();
//			times1.add(tm);
//		}
		ListIterator<LocalTime> listIter2 = times1.listIterator();
		while(listIter2.hasNext()){
			LocalTime tmp = listIter2.next();
			String tm = tmp==null?null:tmp.format(DateTimeFormatter.ofPattern("HH:mm"));
			times2.add(tm);
		}
		return times2;
	}
	@Override
	public List<String> findAllTypes() {
		Type[] type = Type.values();
		List<String> typeStrin = new ArrayList<>(); 
		for (int i = 0; i < type.length; i++) {
			typeStrin.add(String.valueOf(type[i]));
		}
		return typeStrin;
	}
	@Override
	public List<CafeView> findAllViews() {
		
		return repository.findAllViews();
	}
	@Override
	public List<CafeIndexView> findAllIndexViews() {
		
		return repository.findAllIndexViews();
	}
	@Override
	public void save(CafeRequest request) {
		Cafe cafe = new Cafe();
		cafe.setId(request.getId());
		cafe.setRate(request.getRate());
		cafe.setAddress(request.getAddress());
		cafe.setUser(request.getUser());
		cafe.setFullDescription(request.getFullDescription());
		cafe.setType(Type.valueOf(request.getType()));
		cafe.setClose(request.getOpen());
		cafe.setOpen(request.getClose());
		cafe.setName(request.getName());
		cafe.setPhone(request.getPhone());
		cafe.setPhotoUrl(request.getPhotoUrl());
		cafe.setShortDescription(request.getShortDescription());
		repository.save(cafe);
	}

	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe = repository.findById(id);
		CafeRequest request = new CafeRequest();
		request.setId(cafe.getId());
		request.setRate(cafe.getRate());
		request.setAddress(cafe.getAddress());
		request.setUser(cafe.getUser());
		request.setFullDescription(cafe.getFullDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setClose(cafe.getClose());
		request.setOpen(cafe.getOpen());
		request.setName(cafe.getName());
		request.setPhone(cafe.getPhone());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setShortDescription(cafe.getShortDescription());
		return request;
	}
	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}
	@Override
	public CafeView findCafeViewById(Integer id) {
		
		return repository.findCafeViewById(id);
	}
	@Override
	public List<CafeIndexView> findAllViewsByDesc(Sort sort) {
		
		return repository.findAllViewsByDesc(sort);
	}
	@Override
	public List<CafeIndexView> findAllIndexViewsByDesc(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cafe findOneCafe(Integer id) {
		
		return repository.findById(id);
	}
}