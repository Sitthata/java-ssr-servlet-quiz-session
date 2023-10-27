package com.example.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    String title;
    List<String> options;
    int correctAnswerIndex;

    public boolean checkAnswer(int selectedIndex) {
        return correctAnswerIndex == selectedIndex;
    }
}
