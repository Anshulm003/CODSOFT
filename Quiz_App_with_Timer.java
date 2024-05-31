// TASK 4 (QUIZ APPLICATION WITH TIMER)

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] option;
    int correctAnswer;

    public Question(String question, String[] option, int correctAnswer) {
        this.question = question;
        this.option = option;
        this.correctAnswer = correctAnswer;
    }
}

class QuizGame {
    public static final int TIME_LIMIT = 60; // Time limit in seconds
    private static int score = 0;
    private static int currentQuestion = 0;
    private static boolean answered = false;

public static class Quiz_App_with_Timer {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Defining Quiz Questions
                Question[] questions = new Question[]{
                        new Question("What is the Capital of France ?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2),
                        new Question("Which Planet is known as the Red Planet ?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 1),
                        new Question("Who Wrote ' Romeo and Juliet ' ?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. J.K. Rowling"}, 1),
                        new Question("What is the Largest Ocean on Earth ?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3),
                        new Question("What is the Boiling Point of Water ?", new String[]{"1. 90°C", "2. 100°C", "3. 110°C", "4. 120°C"}, 1),
                        new Question("What is the Chemical Symbol for Gold ?", new String[]{"1. Au", "2. Ag", "3. Pt", "4. Hg"}, 0),
                        new Question("Who is known as the father of computers?", new String[]{"1. Alan Turing", "2. Charles Babbage", "3. Bill Gates", "4. Steve Jobs"}, 1),
                        new Question("What is the Longest River in the World ?", new String[]{"1. Amazon", "2. Nile", "3. Yangtze", "4. Mississippi"}, 1),
                        new Question("What is the Hardest Natural Substance on Earth ?", new String[]{"1. Gold", "2. Iron", "3. Diamond", "4. Silver"}, 2),
                        new Question("Who Painted the Mona Lisa ?", new String[]{"1. Vincent van Gogh", "2. Pablo Picasso", "3. Leonardo da Vinci", "4. Claude Monet"}, 2)
                };

                boolean playAgain;

                do {
                    score = 0;
                    currentQuestion = 0;
                    for (Question question : questions) {
                        answered = false;
                        presentQuestion(question, scanner);
                        currentQuestion++;
                    }

                    System.out.println("Quiz is Over! Your final score is: " + score + " out of " + questions.length);
                    System.out.print("Do you want to Play Again ? (yes/no): ");
                    playAgain = scanner.next().equalsIgnoreCase("yes");

                } while (playAgain);

                scanner.close();
            }

            private static void presentQuestion (Question question, Scanner scanner) {
                System.out.println("Question " + (currentQuestion + 1) + ": " + question.question);
                for (String option : question.option) {
                    System.out.println(option);
                }

                // Implement Timer Task
                Timer timer = new Timer();
                TimerTask timeTask = new TimerTask() {
                    private int timerRemainig = TIME_LIMIT;
                    @Override
                    public void run() {
                        if (!answered) {
                            timer.cancel();
                        } else if (timerRemainig > 0) {
                            System.out.println("Time Remaining : " + timerRemainig + " sec");
                            timerRemainig--;
                        }else {
                            System.out.println("SORRY ! Your Time is Over .");
                            timer.cancel();
                            nextQuestion();
                        }
                    }
                };
                timer.scheduleAtFixedRate(timeTask, 0 , 1000);


                int userAnswer = getUserAnswer(scanner);
                timer.cancel();

                if (userAnswer == question.correctAnswer + 1) {
                    System.out.println("Congratulation ! Your Answer is Correct .");
                    score++;
                } else {
                    System.out.println("Your Answer is Incorrect. The correct answer was: " + (question.correctAnswer + 1));
                }
            }

            private static int getUserAnswer(Scanner scanner) {
                int userAnswer;
                while (true) {
                    System.out.print("Enter your Answer (1-4): ");
                    if (scanner.hasNextInt()) {
                        userAnswer = scanner.nextInt();
                        if (userAnswer >= 1 && userAnswer <= 4) {
                            answered = true;
                            break;
                        } else {
                            System.out.println("Please Enter a Number between 1 to 4.");
                        }
                    } else {
                        System.out.println("Invalid input. Please Enter a Number between 1 to 4.");
                        scanner.next();    // Clear invalid input
                    }
                }
                return userAnswer;
            }

            private static void nextQuestion() {
                currentQuestion++;
            }
        }
    }