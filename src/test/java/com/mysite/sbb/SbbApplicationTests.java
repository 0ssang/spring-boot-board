package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired //스프링의 DI 기능으로 questionRepository 객체를 스프링이 자동으로 생성해 준다.
    private QuestionRepository questionRepository;
    @Test
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
    }*/
    //FindBySubject
    /*void testJpa(){
        List<Question> ql = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        Question q = ql.get(0);//리스트 중에 첫 번째 값으로 하기.
        assertEquals(1, q.getId());
    }*/
    //FindBySubjectAndContent
    void testJpa(){
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }
}