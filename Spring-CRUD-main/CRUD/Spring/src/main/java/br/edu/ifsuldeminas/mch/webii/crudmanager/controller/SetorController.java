package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Setor;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.SetorRepository;



@Controller
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping("/setores")
	public String  setores (Model model) {
		
		List<Setor> setor = setorRepository.findAll();
		model.addAttribute("setores", setor);
		
		return "indexSetor";
	}
	

	@GetMapping("")
	public String index(Model model) {
		
		List<Setor> setores = setorRepository.findAll();
		model.addAttribute("setores", setores);
		
		return "indexSetor";
	}
	
	
	
	@GetMapping("/setores/form")
	public String setorForm(@ModelAttribute("setor") Setor setor) {
		
		return "setor_form";
	}
	
	@PostMapping("/setor/new")
	public String setorNew(@Valid @ModelAttribute("setor") Setor setor, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "setor_form";
		}
		
		setorRepository.save(setor);
		return "redirect:/setores";
	}
	
	
	@GetMapping("/setores/update/{id}")
	public String setorUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Setor> optSetor =setorRepository.findById(id);
		
		if(!optSetor.isPresent()) {
			//Gerar erro
		}
		
	Setor setor = optSetor.get();
		
		model.addAttribute("setor", setor);
		
		return "setor_form";
	}
	
	@GetMapping("/setores/delete/{id}")
	public String setorDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Setor> optSetor =setorRepository.findById(id);
		
		if(!optSetor.isPresent()) {
			//Gerar erro
		}
		
		Setor setor = optSetor.get();
		
		setorRepository.delete(setor);
		
		return "redirect:/setores";
	}
}
