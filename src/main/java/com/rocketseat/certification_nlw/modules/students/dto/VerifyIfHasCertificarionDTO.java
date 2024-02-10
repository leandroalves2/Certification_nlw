package com.rocketseat.certification_nlw.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyIfHasCertificarionDTO {
    private String email;
    private String tecnology;
}
