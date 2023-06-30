package br.edu.ifsuldeminas.mch.webii.crudmanager;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Setor;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.FuncionarioRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.SetorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Funcionario;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private SetorRepository setorRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Setor setor1 = new Setor();
        setor1 .setNome("Desenvolvimento");
        setor1 .setResponsavelSet("Emerson");
        setor1 .setHorario("das 9 horas as 16 horas");
     
        
        Setor setor2 = new Setor();
        setor2.setNome("RH");
        setor2.setResponsavelSet("Matheus");
        setor2.setHorario("Das 10 as 15 horas");
      
        
   
        
    Funcionario funcionario1 = new Funcionario();
    funcionario1.setNome("Juan Pablo"); 
    funcionario1.setFuncao("Dev");
    funcionario1.setEmail("juan_Pablo@gmail.com");
    funcionario1.setSetor(setor1);

    Funcionario funcionario2 = new Funcionario();
    funcionario2.setNome("Maria"); 
    funcionario2.setFuncao("Recepcionista");
    funcionario2.setEmail("Maria.Helena@gmail.com");
    funcionario2.setSetor(setor2);
     
  



        setorRepository.save(setor1);
        setorRepository.save(setor2);
        funcionarioRepository.save(funcionario1);
        funcionarioRepository.save(funcionario2);
  
        
        
        
     }
    
}