import java.sql.Array;
import java.util.*;

public class Main {
    public static List<Personaje> cc = new GameData().getCharacters();
    public static Map<Integer,String> pp = new GameData().getQuestions();
    public  static Scanner sc = new Scanner(System.in);
    public static Random ran = new Random();
    public static List<Integer> pp_done = new ArrayList<>();;
    public static List<Double> re_done = new ArrayList<>();

    public static List<Personaje> cc_prop = new ArrayList<>();
    public  static Map<String, Double> probs = new HashMap<>();

    public static void main(String[] args) {


        int a;
        do {

            get_pregunta();

            set_string("0-no\n" +
                    "1-si\n"
            );

            a = sc.nextInt();
            switch (a){
                case 0:
                    re_done.add(0.0);
                    break;
                case 1:
                    re_done.add(1.0);
                    break;
                case 2:
                    re_done.add(0.5);

                    break;
                case 3:
                    re_done.add(0.25);

                    break;
                case 4:
                    re_done.add(0.75);
                    break;
            }
            displayProbabilities(calc_prob());

        }while (a!= 5);
    }
    public static void displayProbabilities(Map<String,Double> probs) {
        set_string("1");
        for (Map.Entry<String, Double> prob : probs.entrySet()) {
            String c_name = prob.getKey();
            double p = prob.getValue();

                System.out.println("Character: " + c_name + ", Probability: " + p);

        }
    }
    public static Map<String, Double> calc_prob() {
        set_string("2");

        Map<String,Double> probs = new HashMap<>();
            for (Personaje c : cc) {
                double prob = calc_char_prob(c);
                probs.put(c.getName(), prob);
            }

        return probs;
    }

    public  static void set_string(String x ){
         System.out.println(x);
    }
    
    public static void get_pregunta(){
        int rani;
        do {
            rani = ran.nextInt(pp.size()+1);
        }while (pp_done.contains(rani));
        pp_done.add(rani);
        set_string(pp.get(rani));
    }


    public static double calc_char_prob(Personaje c) {
        // Prior
        double P_character = 1.0/ cc.size();
        //
        // Likelihood
        double p_egh = 1.0;
        double p_egnh = 1.0;


        for (int i = 0; i < pp_done.size(); i++) {
            int question = pp_done.get(i);
            double answer = re_done.get(i);
             p_egh *= Math.max(1.0 - Math.abs(answer - characterAnswer(c,question)), 0.01);
            double p_anc = cal_ans_not_probr(answer, question, c.getName());
            p_egnh *= Math.max(p_anc, 0.01);

        }
        // Evidence
        double P_answers = P_character * p_egh + (1.0 - P_character) * p_egnh;

        // Bayes Theorem
        return p_egh * P_character / P_answers;
    }

    public static double cal_ans_not_probr(double a, int q, String cc_name ) {
        double total = 0.0;
        int count = 0;

        for (Personaje c : cc) {
            if (!c.getName().equals(cc_name) && c.getAnswers().containsKey(q)) {
                double nca = c.getAnswers().get(q);
                total += 1.0 - Math.abs(a - nca);
                count++;
            }
        }

        return count > 0 ? total / count : 0.5;
    }

    public static double characterAnswer(Personaje c, Integer pre) {

        if (c.getAnswers().containsKey(pre)) {
            return c.getAnswers().get(pre);
        }

        return 0.0;
    }


}