//package ua.converter;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import ua.entity.Meal;
//import ua.entity.Table;
//import ua.repository.MealRepository;
//import ua.repository.TableRepository;
//
//@Component
//public class MealIDConverter implements Converter<String, Meal>{
//
//	private final MealRepository repository;
//	
//	public MealIDConverter(MealRepository repository) {
//		this.repository = repository;
//	}
//
//	@Override
//	public Meal convert(String source) {
//		return repository.findOne(Integer.valueOf(source));
//	}
//
//}