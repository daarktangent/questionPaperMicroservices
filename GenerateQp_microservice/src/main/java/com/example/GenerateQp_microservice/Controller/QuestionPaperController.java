package com.example.GenerateQp_microservice.Controller;


import com.example.GenerateQp_microservice.Entity.QuestionPaper;
import com.example.GenerateQp_microservice.Service.GenerateQuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionPaperController {


    @Autowired
    private GenerateQuestionPaperService generateQuestionPaperService;
    @GetMapping("generate/{id}")
    public QuestionPaper generate(@PathVariable Long id)
    {
       return generateQuestionPaperService.generate(id);
    }
    @GetMapping("generate/test")
    public String test()
    {
        return "inside generate question paper test microservice";
    }
}
