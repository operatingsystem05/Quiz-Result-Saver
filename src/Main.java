import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        int score = 0;

        while (true)
        {
            System.out.println("Enter your name (characters only): ");
            String input = scanner.nextLine();

            if (input.matches("[a-zA-Z]+"))
            {
                name = input;
                break;
            }
            else
            {
                System.out.println("Invalid input. Please use only letters.");
            }
        }

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "It beats without applause,\nhidden beneath our ribs.\nWhat organ, tireless and true,\nwhispers life into our limbs?",
                new String[]{
                        "A. Brain",
                        "B. Heart",
                        "C. Lungs",
                        "D. Liver"
                },
                'B'
        ));

        questions.add(new Question(
                "It holds our fears,\nweaves our dreams,\nand stores the echo of our first cry.\nWhat is this throne of thought?",
                new String[]{
                        "A. Brain",
                        "B. Soul",
                        "C. Spine",
                        "D. Heart"
                },
                'A'
        ));

        questions.add(new Question(
                "Carried through unseen rivers,\nwarm with memory and breath,\nwhat element of us bears oxygen’s gift?",
                new String[]{
                        "A. White blood cells",
                        "B. Hemoglobin",
                        "C. Platelets",
                        "D. Plasma"
                },
                'B'
        ));

        questions.add(new Question(
                "It never asks for praise,\nyet gifts us breath at every turn.\nWhich of these opens like wings inside your chest?",
                new String[]{
                        "A. Diaphragm",
                        "B. Lungs",
                        "C. Bronchi",
                        "D. Esophagus"
                },
                'B'
        ));

        questions.add(new Question(
                "It reflects both pain and joy,\nand holds the storm before the tear.\nWhich part lets in the light we see?",
                new String[]{
                        "A. Retina",
                        "B. Iris",
                        "C. Cornea",
                        "D. Pupil"
                },
                'D'
        ));

        for (Question q : questions)
        {
            q.display();
            char userAnswer;
            while (true)
            {
                System.out.print("Your answer (A/B/C/D): ");
                String answerInput = scanner.nextLine().trim().toUpperCase();

                if (answerInput.length() == 1 && "ABCD".indexOf(answerInput.charAt(0)) != -1) {
                    userAnswer = answerInput.charAt(0);
                    break;
                } else {
                    System.out.println("Please enter A, B, C, or D.");
                }
            }
            if (q.isCorrect(userAnswer))
                score++;
        }

        System.out.println("\nQuiz complete!");
        System.out.println("User: " + name);
        System.out.println("Score: " + score + "/" + questions.size());

        String pathName = "src" + File.separator + "results.txt";

        try (FileWriter file = new FileWriter(pathName))
        {
            file.write("User: " + name + "\n");
            file.write("Score: " + score + "/" + questions.size() + "\n");
        }

        catch (IOException e)
        {
            System.out.println("IO exception error");
        }
        System.out.println("Results saved to " + pathName);
        scanner.close();
    }
}