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
import ua.model.filter.MealFilter;
import ua.model.request.MealRequest;
import ua.repository.MealViewRepository;
import ua.service.CafeService;
import ua.service.CuisineService;
import ua.service.IngredientService;
import ua.service.MealService;

@Controller
@RequestMapping("/cafe/{id}/meal")
@SessionAttributes("meal")
public class AdminOfCafeMeal {
	private final IngredientService ingredietserv;
	private final MealService service;
	private final CuisineService service2;
	private final MealViewRepository repository;
	private final CafeService service3;

	@Autowired
	public AdminOfCafeMeal(IngredientService ingredietserv, MealService service, CuisineService service2,
			MealViewRepository repository, CafeService service3) {
		super();
		this.ingredietserv = ingredietserv;
		this.service = service;
		this.service2 = service2;
		this.repository = repository;
		this.service3 = service3;
	}

	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}
	@ModelAttribute("maelFilter")
	public MealFilter getFilter() {
		return new MealFilter();
	}

	@GetMapping
	public String show(@PathVariable Integer id, Model model, @ModelAttribute("MealFilter") MealFilter filter,
			@PageableDefault Pageable pageable) {
		System.out.println(id);
		model.addAttribute("id",id);
		model.addAttribute("ingredients", ingredietserv.findAll());
		model.addAttribute("cuisines", service2.findAll());
		model.addAttribute("meals", repository.findAllByIdCafe(filter, pageable, new Sort("rate"), id));
		return "meal";
	}

	@GetMapping("/{id}")
	public String showMealId(@PathVariable Integer id, Model model, @ModelAttribute("MealFilter") MealFilter filter,
			@PageableDefault Pageable pageable) {
		model.addAttribute("meal", service.findViewByID(id));
		return "mealid";
	}

	@GetMapping("/delete/{id2}")
	public String delete(@PathVariable Integer id,@PathVariable Integer id2, @ModelAttribute("MealFilter") MealFilter filter,
			@PageableDefault Pageable pageable) {
		service.delete(id2);
		return "redirect:/cafe/{id}/meal";
	}

	@PostMapping
	public String save(@ModelAttribute("meal") MealRequest request, SessionStatus status,
			@ModelAttribute("MealFilter") MealFilter filter, @PageableDefault Pageable pageable, Principal principal,
			@PathVariable Integer id) {
		service.save(request,service3.findOneCafe(id));

		return cancel(status, filter, pageable);
	}

	@GetMapping("/update/{id2}")
	public String update(@PathVariable Integer id,@PathVariable Integer id2, Model model, @ModelAttribute("MealFilter") MealFilter filter,@PageableDefault Pageable pageable) {
		model.addAttribute("meal", service.findOne(id2));
		return show(id, model, filter, pageable);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@ModelAttribute("MealFilter") MealFilter filter,@PageableDefault() Pageable pageable) {
		status.setComplete();
		return "redirect:/cafe/{id}/meal";
	}
}