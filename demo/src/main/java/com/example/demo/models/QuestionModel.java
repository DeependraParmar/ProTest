package com.example.demo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {
    @NotNull(message = "Question can't be Null")
    @NotEmpty(message = "Question can't be Empty")
    private String question;

    @NotNull(message = "Option1 can't be Null")
    @NotEmpty(message = "Option1 can't be Empty")
    private String option1;

    @NotNull(message = "Option2 can't be Null")
    @NotEmpty(message = "Option2 can't be Empty")
    private String option2;

    @NotNull(message = "Option3 can't be Null")
    @NotEmpty(message = "Option3 can't be Empty")
    private String option3;

    @NotNull(message = "Option4 can't be Null")
    @NotEmpty(message = "Option4 can't be Empty")
    private String option4;

    @NotNull(message = "Answer can't be Null")
    private Integer answer;
}
