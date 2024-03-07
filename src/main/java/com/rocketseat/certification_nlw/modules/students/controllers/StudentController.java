package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyIfHasCertificarionDTO;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifyIfHasCertificarionUseCase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificarionUseCase verifyIfHasCertificarionUseCase;

    @PostMapping("/verifyIfHasCertificarion")    
    public String verifyIfHasCertificarion(@RequestBody VerifyIfHasCertificarionDTO verifyIfHasCertificarionDTO){
        
        var result = this.verifyIfHasCertificarionUseCase.execute(verifyIfHasCertificarionDTO);
        if(result){
            return "Usuario já fez a prova";
        } 
        return "Usuario pode fazer a prova";
    }
}
