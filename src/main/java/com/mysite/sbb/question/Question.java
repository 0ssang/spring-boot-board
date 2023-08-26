package com.mysite.sbb.question;
/*
질문 엔티티
 */
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
//Setter 사용 안하는 것을 권장.. 이때는 @Builder 빌드패턴 사용
@Entity //JPA가 Entity로 인식한다.
//@SequenceGenerator(name = "MY_SEQ_GENERATOR", sequenceName = "MY_SEQ", initialValue = 1, allocationSize = 1)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//해당 컬럼만의 독립적인 시퀀스 생성
    /*
    strategy 옵션을 생략할 경우에 @GeneratedValue 애너테이션이 지정된 컬럼들이
    모두 동일한 시퀀스로 번호를 생성하기 때문에
    일정한 순서의 고유번호를 가질수 없게 된다.
    이러한 이유로 보통 GenerationType.IDENTITY를 많이 사용한다.
     */
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")//글자 수를 제한할 수 없는 경우 적용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야 한다.
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}
