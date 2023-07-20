package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired //스프링의 DI 기능으로 questionRepository 객체를 스프링이 자동으로 생성해 준다.
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;

    @Test
            //CREATE TEST
            //READ TEST
    /*
    FindAll
    void testJpa() {
       List<Question> all = this.questionRepository.findAll();
       assertEquals(6, all.size());

       Question q = all.get(0);
       assertEquals("sbb가 무엇인가요?", q.getSubject());
    }*/
    /*FindById
    void testJpa(){
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }
    */
    //FindBySubject
    /*
    void testJpa(){
        List<Question> ql = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        Question q = ql.get(0);//리스트 중에 첫 번째 값으로 하기.
        assertEquals(1, q.getId());
    }
    */
    //FindBySubjectAndContent

    //FindBySubjectLike
    /*
    void testJpa(){
        List<Question> ql = this.questionRepository.findBySubjectLike("sbb%");
        Question q = ql.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }
    */
            //UPDATE TEST
    /*
    void testJpa(){
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
    */
            //DELETE TEST
    /*void testJpa(){
        assertEquals(6, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(5, this.questionRepository.count());
    }*/
            //Answer CREATE
    /*void testJpa(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q); //어떤 질문의 답변인지 알기 위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }*/

    /*void testJpa(){
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }*/
    /*
    void testJpa(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
     */
    void testJpa(){
        for(int i = 1; i <= 300; i++){
            String subject = String.format("테스트 데이터 입니다: [%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }


}