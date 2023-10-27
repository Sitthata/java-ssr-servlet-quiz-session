package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.model.QuizSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "QuizController", value = "/QuizController")
public class QuizController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizSession quizSession = (QuizSession) session.getAttribute("quizSession");
        if (quizSession == null) {
            quizSession = new QuizSession();
            quizSession.fetchQuestion();
            session.setAttribute("quizSession", quizSession);
        }
        Question currentQuestion = quizSession.getQuestions().get(quizSession.getCurrentQuestionIndex());
        request.setAttribute("currentQuestion", currentQuestion);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizSession quizSession = (QuizSession) session.getAttribute("quizSession");
        int selectedAnswerIndex = Integer.parseInt(request.getParameter("answer"));
        quizSession.checkCorrectQuestion(selectedAnswerIndex);
        quizSession.moveToNextQuestion();
        if (quizSession.isQuizEnded()) {
            request.setAttribute("totalQuestion", quizSession.getQuestions().size());
            request.setAttribute("correctAnswer", quizSession.getCorrectAnswersCount());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            response.sendRedirect("QuizController");
        }
    }
}