package com.rocketseat.certification_nlw.modules.students.useCases;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;
import com.rocketseat.certification_nlw.modules.questions.repositories.QuestionRepository;
import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswersDTO;
import com.rocketseat.certification_nlw.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUserCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void execute(StudentCertificationAnswersDTO dto) throws Exception {

        var student = studentRepository.findByEmail(dto.getEmail());
         
        if(!student.isPresent()){
            throw new Exception("E-mail do estudante incorreto.");
        }

        List<QuestionEntity> questionsEntity =  questionRepository.findByTechnology(dto.getTechnology());
        
        dto.getQuestionAnswer().stream().forEach(questionAnswer -> { 
            var question = questionsEntity.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
            .findFirst().get(); 

            var findCorrectAlternative = question.getAlternatives().stream().filter(alternative -> alternative.isCorrect()).findFirst().get();        
        
            if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())){
                questionAnswer.setCorrect(true);
            }
            else{
                questionAnswer.setCorrect(false);
            }
        });

    }    
}