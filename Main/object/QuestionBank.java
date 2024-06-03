package object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionBank {
    private List<Question> questions = new ArrayList<>();

    public QuestionBank() {
        questions.add(new Question("i = 1; a = ++i + i++ ; a = ?", "5"));
        questions.add(new Question("i = 1; a = i++; a = ?", "1"));
        questions.add(new Question("i = 1; a = ++i; a = ?", "2"));
        questions.add(new Question("i = 1; a = (i-- * 2) + (++i / 2); a = ?", "7"));
        questions.add(new Question("i = 5; a = i++ - --i * i++;; a = ?", "-20"));
        questions.add(new Question("i = 2; j = 3; a = i++ + --j * i--; a = ?", "8"));
        questions.add(new Question("i = 5; a = i++ - --i * i++;; a = ?", "-0"));
        questions.add(new Question("i = 1; a = ++i; a = ?", "2"));
        questions.add(new Question("i = 1; a = ++i; a = ?", "2"));
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}