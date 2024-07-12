package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static boolean timerExpired = false;
    private static Timer timer;

    public static void main(String[] args) {
        // Define quiz questions
        List<String> options1 = List.of("Berlin", "London", "Paris", "Madrid");
        questions.add(new Question("What is the capital of France?", options1, 2));

        List<String> options2 = List.of("Earth", "Mars", "Jupiter", "Venus");
        questions.add(new Question("Which planet is known as the Red Planet?", options2, 1));

        List<String> options3 = List.of("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean");
        questions.add(new Question("What is the largest ocean on Earth?", options3, 3));

        // Start quiz
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            askQuestion(scanner, question);
        }

        // Display final results
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score is " + score + " out of " + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            System.out.println("  Correct answer: " + q.options.get(q.correctAnswer));
        }

        scanner.close();
    }

    private static void askQuestion(Scanner scanner, Question question) {
        System.out.println("\n" + question.questionText);
        for (int i = 0; i < question.options.size(); i++) {
            System.out.println((i + 1) + ". " + question.options.get(i));
        }

        startTimer(10);
        while (!timerExpired) {
            try {
                System.out.print("Your answer (1-4): ");
                int answer = scanner.nextInt() - 1;
                if (answer >= 0 && answer < question.options.size()) {
                    if (answer == question.correctAnswer) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Wrong! The correct answer was " + question.options.get(question.correctAnswer) + ".");
                    }
                    break;
                } else {
                    System.out.println("Please enter a valid option (1-4).");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        if (timerExpired) {
            System.out.println("\nTime's up!");
            System.out.println("The correct answer was " + question.options.get(question.correctAnswer) + ".");
        }
        timer.cancel();
    }

    private static void startTimer(int seconds) {
        timerExpired = false;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerExpired = true;
            }
        }, seconds * 1000);
    }
}
