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
import org.springframework.web.bind.annotation.RequestMapping;

import ua.model.filter.CafeFilter;
import ua.service.MealService;
import ua.service.ProfilService;

@Controller
@RequestMapping("/profile")

public class ProfilController {
	private final ProfilService service;
	private final MealService mealservice;
	@Autowired
	public ProfilController(ProfilService service,MealService mealservice) {
		this.service = service;
		this.mealservice=mealservice;
	}

	@GetMapping
	public String show(Model model, Principal principal,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable) {
		model.addAttribute("cafes", service.findAllViews(principal.getName(),filter, pageable,new Sort("rate")));
		model.addAttribute("meals", mealservice.findAllViews());
		return "profile";

	}
}