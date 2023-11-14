import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje {
    private String name;
    private Map<Integer, Double> answers;

    public Personaje(String name, Map<Integer, Double> answers) {
        this.name = name;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Double> getAnswers() {
        return answers;
    }
}
