package com.mysite.sbb.question;

import com.mysite.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

import javax.naming.Binding;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    //private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        //타임리프는 model에 저장된 값을 읽을 수 있다.
        return "question_list";
    }

    /*
    redirect:<url> URL로 리다이렉트 (리다이렉트는 완전히 새로운 URL로 요청이 된다.)
    forward:<url> URL로 포워드 (포워드는 기존 요청 값들이 유지된 상태로 URL이 전환된다.)
     */

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){ //매개변수로 바인딩한 객체는 Model 객체로 전달하지 않아도  템플릿에서 사용이 가능하다.
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; //질문 후 저장 목록으로 이동
    }


}
