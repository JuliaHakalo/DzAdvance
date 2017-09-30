package ua.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Meal;
import ua.model.filter.CafeFilter;
import ua.model.filter.MealFilter;
import ua.model.request.MealRequest;
import ua.repository.MealViewRepository;
import ua.service.CuisineService;
import ua.service.IngredientService;
import ua.service.MealService;

@Controller
@RequestMapping("/meal")
@SessionAttributes("meal")
public class MealController {
	private final IngredientService ingredietserv;
	private final MealService service;
	private final CuisineService service2;
	private final MealViewRepository repository;
	
	@Autowired
	public MealController(IngredientService ingredietserv, MealService service, CuisineService service2,
			MealViewRepository repository) {
		super();
		this.ingredietserv = ingredietserv;
		this.service = service;
		this.service2 = service2;
		this.repository = repository;
	}
	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}
	

	@GetMapping
	public String show(Model model, @ModelAttribute("MealFilter") MealFilter filter,@PageableDefault Pageable pageable) {
		model.addAttribute("ingredients", ingredietserv.findAll());
		model.addAttribute("cuisines", service2.findAll());
		model.addAttribute("meals", repository.findAll(filter, pageable,new Sort(Sort.Direction.DESC, "price")));
		return "meal";
	}
	@GetMapping("/{id}")
	public String showMealId(@PathVariable Integer id,Model model, @ModelAttribute("MealFilter") MealFilter filter,@PageableDefault Pageable pageable) {
		model.addAttribute("meal",service.findViewByID(id));
		return "mealid";
	}
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/meal";
	}
}