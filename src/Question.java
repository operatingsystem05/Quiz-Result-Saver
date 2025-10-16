public class Question
{
    private String question;
    private String[] options;
    private char answer;

    public Question(String question, String[] options, char answer)
    {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean isCorrect(char userAnswer)
    {
        return Character.toUpperCase(userAnswer) == answer;
    }

    public void display()
    {
        System.out.println(question);
        for (String option : options)
        {
            System.out.println(option);
        }
    }
}