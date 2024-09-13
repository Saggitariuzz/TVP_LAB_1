import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    private final static HashMap<String, Integer> _rules = new HashMap<>();

    public Checker(){
        _rules.put("I->e", 1);
        _rules.put("I->AB", 2);
        _rules.put("A->0", 3);
        _rules.put("A->0A", 4);
        _rules.put("B->10", 5);
        _rules.put("B->10B", 6);
        _rules.put("A->e", 7);
        _rules.put("B->e", 8);
    }

    public String GetValueFromMap(int value){
        for(Map.Entry<String, Integer> entry:_rules.entrySet()){
           if(entry.getValue().equals(value)){
               return entry.getKey();
           }
        }
        return null;
    }

    public ArrayList<Integer> Check(Word line){
        ArrayList<Integer> buildrule = new ArrayList<Integer>();
        if(line.getValue() == ""){
            buildrule.add(_rules.get("I->e"));
            return buildrule;
        }
        buildrule.add(_rules.get("I->AB"));
        Pattern pattern = Pattern.compile("(0*)((10)*)");
        Matcher matcher = pattern.matcher(line.getValue());
        if(matcher.find()){
            String zeros = matcher.group(1);
            String oneZeros = matcher.group(2);
            if(zeros.isEmpty()){
                buildrule.add(_rules.get("A->e"));
            }
            if(oneZeros.isEmpty()){
                buildrule.add(_rules.get("B->e"));
            }
            if(zeros.length() != 1){
                for(int i = 0;i<zeros.length()-1;i++) {
                    buildrule.add(_rules.get("A->0A"));
                    if (i == zeros.length() - 2) {
                        buildrule.add(_rules.get("A->0"));
                    }
                }
            }else{
                buildrule.add(_rules.get("A->0"));
            }
            if(oneZeros.length()!=2){
                for(int i = 0; i< oneZeros.length()/2-1; i++) {
                    buildrule.add(_rules.get("B->10B"));
                    if (i == oneZeros.length() / 2 - 2) {
                        buildrule.add(_rules.get("B->10"));
                    }
                }
            }else {
                buildrule.add(_rules.get("B->10"));
            }
        }
        return buildrule;
    }
}
