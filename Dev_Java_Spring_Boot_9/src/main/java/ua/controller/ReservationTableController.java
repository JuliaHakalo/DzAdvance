package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Ingredient;
import ua.entity.Table;
import ua.entity.UserReserver;
import ua.repository.ReserverRepository;
import ua.service.CafeService;

import ua.service.ProfilService;
import ua.service.TableService;

@Controller
@RequestMapping("/cafe/{id}/tables")
@SessionAttributes("UserReserver")
public class ReservationTableController {

	private final  ReserverRepository reserverRepository;
	private final  TableService tableService;

	@Autowired
	public ReservationTableController(ReserverRepository reserverRepository, TableService tableService) {
		super();
		this.reserverRepository = reserverRepository;
		this.tableService = tableService;
	}
	@ModelAttribute("UserReserver")
	public UserReserver getForm() {
		return new UserReserver();
	}
	
	@PostMapping("/{id2}")
	public String save(@ModelAttribute("UserReserver") UserReserver reserver,SessionStatus status,@PathVariable Integer id2,@PathVariable Integer id) {
		UserReserver us = 	reserverRepository.save(reserver);
		Table table = tableService.findOneTable(id2);
		System.out.println(table.getId());
		us.setTable(table);
		table.setFree(false);
		return cancel(status,id);
	}
	@GetMapping("/cancel")
	public String cancel(SessionStatus status,@PathVariable Integer id) {
		status.setComplete();
		return "redirect:/cafe/"+id+"/tables";
	}
	@GetMapping
	public String showcafetables(@PathVariable Integer id, Model model) {
		model.addAttribute("tables", tableService.findAllTablesbyIdCafe(id));
		return "cafeidtables";
	}
	@GetMapping("/{id2}")
	public String showreservationform(@PathVariable Integer id,@PathVariable Integer id2, Model model) {
		model.addAttribute("table", tableService.findOne(id2));
		model.addAttribute("id2",id2);
		model.addAttribute("id1",id2);
		return "reservationtable";
	}
}