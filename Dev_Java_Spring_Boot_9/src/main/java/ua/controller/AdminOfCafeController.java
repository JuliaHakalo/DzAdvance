package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import ua.model.filter.CafeFilter;
import ua.model.filter.SimpleFilter;
import ua.model.request.CafeRequest;
import ua.repository.CafeViewOfProfilRepository;
import ua.service.CafeService;
import ua.service.CafeViewOfProfilService;
import ua.service.ProfilService;

@Controller
@RequestMapping("/adminCafe/cafe")
@SessionAttributes("cafe")
public class AdminOfCafeController {

	private final CafeService service;
	private final CafeViewOfProfilService profilService;
	@Autowired
	public AdminOfCafeController(CafeService service, CafeViewOfProfilService profilService) {
		super();
		this.service = service;
		this.profilService = profilService;
	}

	
	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter() {
		return new CafeFilter();
	}
	
	
	@GetMapping
	public String show(Model model, Principal principal,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable) {
		model.addAttribute("times", service.findAllTimes());
		model.addAttribute("types", service.findAllTypes());
		model.addAttribute("cafes", profilService.findAllViews(principal.getName(),filter, pageable,new Sort("rate")));
		
		return "CafeIdUpdateOrAddNewCafe";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable) {
		service.delete(id);
		return "redirect:/adminCafe/cafe";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cafe") CafeRequest request, SessionStatus status,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable,Principal principal) {
		service.save(request);
		return cancel(status,filter,pageable);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model,Principal principal,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable) {
		model.addAttribute("cafe", service.findOne(id));
		return show(model,principal,filter,pageable);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@ModelAttribute("cafeFilter") CafeFilter filter,@PageableDefault() Pageable pageable) {
		status.setComplete();
		return "redirect:/adminCafe/cafe";
	}
	
	
}