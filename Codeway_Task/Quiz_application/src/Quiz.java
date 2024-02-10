import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Quiz {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Scanner scanner;

    public Quiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        
        questions.add(new Question("What is the capital of France?", 
                      new String[]{"1. London", "2. Paris", "3. Rome", "4. Berlin"}, 1));
        questions.add(new Question("What is the Prime Minister of India?", 
                new String[]{"1. Putin", "2. Obamma", "3. Trump", "4. Modi"}, 4));
        questions.add(new Question("Who is the current CEO of Google", 
                new String[]{"1. Bill gates", "2. Sunder Pichai", "3. Elon Musk", "4. Steve Jobs"}, 2));
        

        currentQuestionIndex = 0;
        score = 0;
    }

    public void startQuiz() {
        for (Question question : questions) {
            displayQuestion(question);
            if (!answerQuestion(question)) {
                System.out.println("Time's up!");
                break;
            }
        }
        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score);
        scanner.close();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
    }

    private boolean answerQuestion(Question question) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Time's up!");
                scanner.nextLine(); 
            }
        };
        timer.schedule(task, 10000); // 10 seconds timer

        System.out.print("Your answer: ");
        int userAnswer = scanner.nextInt();
        timer.cancel(); 

        if (userAnswer == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            score++;
            return true;
        } else {
            System.out.println("Incorrect!");
            return false;
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}
