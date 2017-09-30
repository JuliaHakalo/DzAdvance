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

import ua.entity.Cuisine;
import ua.model.filter.CafeFilter;
import ua.model.request.CafeRequest;
import ua.repository.CafeViewOfProfilRepository;
import ua.repository.CafeViewRepository;
import ua.repository.ProfilRepository;
import ua.service.CafeService;
import ua.service.MealService;
import ua.service.TableService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("cafe")
public class CafeController {

	private final CafeService service;
	private final TableService service2;
	private final CafeViewRepository repository;
	private final MealService service3;

	@Autowired

	public CafeController(CafeService service, TableService service2, CafeViewRepository repository,
			MealService service3) {
		this.service = service;
		this.service2 = service2;
		this.repository = repository;
		this.service3 = service3;
	}
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter() {
		return new CafeFilter();
	}

	@GetMapping
	public String showcafe(Model model, Principal principal, @ModelAttribute("cafeFilter") CafeFilter filter,
			@PageableDefault() Pageable pageable) {
		model.addAttribute("meals", service3.findAllViews());
		model.addAttribute("cafes", repository.findAll(filter, pageable, new Sort("rate")));
		if (principal != null) {
			model.addAttribute("message", "Hello " + principal.getName());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		return "cafe";
	}

	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/cafe";
	}

//	@PostMapping
//	public String save(@ModelAttribute("cuisine") Cuisine cuisine, SessionStatus status) {
//		service.save(cuisine);
//		return cancel(status);
//	}
//	
//	@GetMapping("/update/{id}")
//	public String update(@PathVariable Integer id, Model model) {
//		model.addAttribute("cuisine", service.findOne(id));
//		return show(model);
//	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/cafe";
	}



}