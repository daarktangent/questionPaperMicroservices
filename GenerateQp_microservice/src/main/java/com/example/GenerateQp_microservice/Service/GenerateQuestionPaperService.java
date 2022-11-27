package com.example.GenerateQp_microservice.Service;


import com.example.GenerateQp_microservice.Dao.*;
import com.example.GenerateQp_microservice.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GenerateQuestionPaperService {


    @Autowired
    private McqsDao mcqsDao;
    @Autowired
    private MsqsDao msqsDao;

    @Autowired
    private QuestionPaperDao questionPaperDao;
    @Autowired
    private DescriptiveDao descriptiveDao;

    @Autowired
    private ExamPatternDao examPatternDao;
    public QuestionPaper generate(Long id)
    {
        QuestionPaper questionPaper=new QuestionPaper();
        ExamPattern examPattern=examPatternDao.getExamPatternByPid(id);//getting the exam pattern
        System.out.println("----------------------");
        System.out.println(examPattern);
        List<Mcqs> mcq=mcqsDao.findAll();
        List<Msqs> msq=msqsDao.findAll();
        List<Descriptive> descriptives= descriptiveDao.findAll();
        Collections.shuffle(descriptives);
        Collections.shuffle(msq);
        Collections.shuffle(mcq);
        for(int i=0;i<examPattern.getNo_of_mcqs();i++)
        {
            questionPaper.addMcq(mcq.get(i));
        }
        for(int i=0;i<examPattern.getNo_of_desc();i++)
        {
            questionPaper.addDesc(descriptives.get(i));
        }
        for (int i=0;i<examPattern.getNo_of_msqs();i++)
        {
            questionPaper.addMsqs(msq.get(i));
        }
        System.out.println(questionPaper+"-----------------------");
        questionPaperDao.save(questionPaper);
        return questionPaper;
    }
}
