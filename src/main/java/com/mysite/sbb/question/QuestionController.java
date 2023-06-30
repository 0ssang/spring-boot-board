package com.mysite.sbb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    //private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        //타임리프는 model에 저장된 값을 읽을 수 있다.
        return "question_list";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
    /*
    redirect:<url> URL로 리다이렉트 (리다이렉트는 완전히 새로운 URL로 요청이 된다.)
    forward:<url> URL로 포워드 (포워드는 기존 요청 값들이 유지된 상태로 URL이 전환된다.)
     */

    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

}
