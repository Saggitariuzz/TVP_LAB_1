import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static Scanner in = new Scanner(System.in);
    public static void Run(){
        System.out.println("Введите слово");
        Word input = new Word(in.nextLine());
        if(input.getIsFits()){
            Checker check = new Checker();
            ArrayList<Integer> rules = check.Check(input);
            System.out.println("Слово соответствует языку. Его синтаксический разбор");
            for(int i:rules){
                String rule = check.GetValueFromMap(i);
                System.out.println(rule + " " + i);
            }
        }else {
            System.out.println("Слово не соответствует языку");
        }
    }
}
