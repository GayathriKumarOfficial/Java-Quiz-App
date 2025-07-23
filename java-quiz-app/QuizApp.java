import java.util.*;

class QuizApp {
    static Scanner sc = new Scanner(System.in);
    static String validUsername = "Gayathri";
    static String validPassword = "1234";
    static int score = 0;

    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        void ask() {
            System.out.println("\n" + question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter your answer (1-4) within 10 seconds: ");
            long startTime = System.currentTimeMillis();
            String input = sc.nextLine();
            long endTime = System.currentTimeMillis();

            if (endTime - startTime > 10000) {
                System.out.println("⏰ Time's up! Answer ignored.");
            } else {
                try {
                    int answer = Integer.parseInt(input.trim());
                    if (answer == correctAnswer) {
                        System.out.println("✅ Correct!");
                        score += 10;
                    } else {
                        System.out.println("❌ Wrong!");
                    }
                } catch (Exception e) {
                    System.out.println("❌ Invalid input!");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("🎉 Welcome to the Java Quiz App!");
        System.out.print("👤 Enter Username: ");
        String username = sc.nextLine();
        System.out.print("🔒 Enter Password: ");
        String password = sc.nextLine();

        if (!username.equals(validUsername) || !password.equals(validPassword)) {
            System.out.println("❌ Invalid credentials. Exiting...");
            return;
        }

        System.out.println("✅ Login successful. Starting quiz...");

        List<Question> questions = List.of(
            new Question("What is the size of int in Java?",
                new String[]{"4 bytes", "2 bytes", "8 bytes", "Depends on OS"}, 1),
            new Question("Which keyword is used to inherit a class?",
                new String[]{"implement", "extends", "inherit", "super"}, 2),
            new Question("What is JVM?",
                new String[]{"Java Variable Machine", "Java Virtual Machine", "Java Very large Memory", "None"}, 2),
            new Question("Which method is the entry point in Java?",
                new String[]{"start()", "main()", "init()", "run()"}, 2),
            new Question("Which collection stores unique elements?",
                new String[]{"List", "Set", "Map", "Array"}, 2)
        );

        for (Question q : questions) {
            q.ask();
        }

        System.out.println("\n🎯 Quiz completed!");
        System.out.println("📊 Total Score: " + score + " / " + (questions.size() * 10));
    }
}
