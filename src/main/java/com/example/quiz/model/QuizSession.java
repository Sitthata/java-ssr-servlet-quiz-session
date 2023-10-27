package com.example.quiz.model;

import com.example.quiz.utils.CSVLoader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizSession {
    List<Question> questions;
    int currentQuestionIndex;
    int correctAnswersCount;

    public void fetchQuestion() {
        questions = CSVLoader.getQuestions();
    }

    public void moveToNextQuestion() {
        currentQuestionIndex++;
    }

    public boolean isQuizEnded() {
        return currentQuestionIndex == questions.size();
    }

    public void checkCorrectQuestion(int selectedIndex) {
        Question current = questions.get(currentQuestionIndex);
        if (current.checkAnswer(selectedIndex)) correctAnswersCount++;
    }

    public void resetQuiz() {
        currentQuestionIndex = 0;
        correctAnswersCount = 0;
    }
}
