package com.rocketseat.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyIfHasCertificarionDTO;

@Service
public class VerifyIfHasCertificarionUseCase {
    
    public boolean execure(VerifyIfHasCertificarionDTO dto){

        if(dto.getEmail().equals("leandro@gmail.com") && dto.getTecnology().equals("JAVA")){
            return true;
        }
        return false;
    }
}
