import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameData {
    private Map<Integer, String> questions;
    private List<Personaje> characters;

    public GameData() {
        questions = new HashMap<>();
        questions.put(1, "Es de Grifindor?");
        questions.put(2, "Es de Haffelpuff?");
        questions.put(3, "Es de Ravenclaw?");
        questions.put(4, "Es de Slithering?");
        questions.put(5, "Es  humano?"); //!
        questions.put(6, "Es  famoso?");
        questions.put(7, "tiene una cicatriz?");
        questions.put(8, "es maggel?");
        questions.put(9, "es mago?");
        questions.put(10, "es animago?");
        questions.put(11, "es hombre?");//!
        questions.put(12, "es mujer?");//!


        characters = new ArrayList<>();
        characters.add(new Personaje ("Harry Potter", new HashMap<>() {{
            put(1, 1.0);
            put(5, 1.0);
            put(6, 1.0);
            put(7, 1.0);
            put(9, 1.0);
            put(11, 1.0);

        }}));
        characters.add(new Personaje ("Draco Malfoy", new HashMap<>() {{
            put(4, 1.0);
            put(5, 1.0);
            put(9, 1.0);
            put(11, 1.0);

        }}

        ));
        characters.add(new Personaje ("Ron Weasley", new HashMap<>() {{
            put(1, 1.0);
            put(9, 1.0);
            put(11, 1.0);
            put(5, 1.0);


        }}));
        characters.add(new Personaje ("Albus Dumbldore", new HashMap<>() {{
            put(9, 1.0);
            put(6, 1.0);
            put(11, 1.0);
            put(5, 1.0);


        }}));
        characters.add(new Personaje ("Severus Snape", new HashMap<>() {{
            put(9, 1.0);
            put(11, 1.0);
            put(5, 1.0);

        }}));
        characters.add(new Personaje ("Voldemort", new HashMap<>() {{
            put(9, 1.0);
            put(6, 1.0);
            put(4, 1.0);
            put(11, 1.0);
        }}));
        characters.add(new Personaje ("Sirius Black", new HashMap<>() {{
            put(9, 1.0);
            put(10, 1.0);
            put(11, 1.0);
            put(5, 1.0);

        }}));
        characters.add(new Personaje ("Minerva", new HashMap<>() {{
            put(9, 1.0);
            put(10, 1.0);
            put(12, 1.0);
            put(5, 1.0);

        }}));
        characters.add(new Personaje ("Hermione", new HashMap<>() {{
            put(1, 1.0);
            put(9, 1.0);
            put(12, 1.0);
            put(5, 1.0);

        }}));


    }
    public Map<Integer, String> getQuestions() {
        return questions;
    }
    public List<Personaje> getCharacters() {
        return characters;
    }

}
