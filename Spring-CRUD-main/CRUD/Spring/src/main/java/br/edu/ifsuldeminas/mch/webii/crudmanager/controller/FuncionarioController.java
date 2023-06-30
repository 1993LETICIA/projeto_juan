package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Funcionario;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Setor;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.FuncionarioRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.SetorRepository;



@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping("/funcionarios")
	public String funcionarios(Model model) {
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		
		return "indexFuncionarios";
	}
	
	@GetMapping("/funcionarios/form")
	public String FuncionarioForm(Model model, @ModelAttribute("funcionario")Funcionario funcionario) {
		List<Setor> setores = setorRepository.findAll();
		model.addAttribute("setores",setores);
		return "funcionario_form";
	}
	
	@PostMapping("/funcionarios/new")
	public String funcionarioNew(@Valid 
			@ModelAttribute("funcionario") Funcionario funcionario, 
			BindingResult bindingResult, Model model) {
		
		
		if(bindingResult.hasErrors()) {
			List<Setor> setores = setorRepository.findAll();
			model.addAttribute("setor", setores);
			return "funcionario_form";
		
		}
		funcionarioRepository.save(funcionario);
		return "redirect:/funcionarios";
	
	}
	@GetMapping("/funcionarios/update/{id}")
	public String FuncionarioUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		
		if(!optFuncionario.isPresent()) {
			//Gerar erro
		}
		
		Funcionario funcionario = optFuncionario.get();
		
		model.addAttribute("funcionario", funcionario);
		
		List<Setor> setores = setorRepository.findAll();
		model.addAttribute("setores",setores);
		
		return "funcionario_form";
	}
	
	@GetMapping("/funcionarios/delete/{id}")
	public String funcionarioDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
		
		if(!optFuncionario.isPresent()) {
			//Gerar erro
		}
		
		Funcionario funcionarios= optFuncionario.get();
		
		funcionarioRepository.delete(funcionarios);
		
		return "redirect:/funcionarios";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
