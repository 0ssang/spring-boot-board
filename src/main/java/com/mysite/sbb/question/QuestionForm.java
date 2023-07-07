//화면에서 전달되는 입력 값을 검증하기위 폼 클래스
// 폼클래스는 입력값의 검증에도 사용하지만 화면에서 전달한 입력 값을 바인딩 할 때에도 사용된다.
package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수 항복입니다.")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
