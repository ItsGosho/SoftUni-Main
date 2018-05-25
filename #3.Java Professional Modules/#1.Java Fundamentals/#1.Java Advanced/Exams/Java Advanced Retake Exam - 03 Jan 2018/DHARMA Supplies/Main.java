import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        List<String> allFoundMathches = new ArrayList<>();
        int numberOfLines = 0;

        //READ,FIND ALL MATCHES WITH [ and ]
        while (true) {
            String line = skener.nextLine();
            if (line.equals("Collect")) {
                break;
            }
            //String[] splitted = line.split("\\s+");
            //Search for occuries
            char[] wordsFromLine = line.toCharArray();
            String currentMatch = "";
            boolean ifFoundOpening = false;
            for (int i = 0; i < wordsFromLine.length; i++) {
                //if found opening
                if (wordsFromLine[i] == '[' && !ifFoundOpening) {
                    currentMatch += String.valueOf(wordsFromLine[i]);
                    ifFoundOpening = true;
                } else if (wordsFromLine[i] == ']' && ifFoundOpening) {
                    currentMatch += String.valueOf(wordsFromLine[i]);
                    allFoundMathches.add(currentMatch);
                    currentMatch = "";
                    ifFoundOpening = false;
                } else if (ifFoundOpening) {
                    currentMatch += String.valueOf(wordsFromLine[i]);
                }
            }
            numberOfLines++;
        }
        int N = allFoundMathches.size() / numberOfLines;
        //VALID THE FOUND MATCHES INSIDE
        String pattForFoodTag = "(\\[\\#([0-9]+)([A-Za-z0-9\\s]+)\\#\\2\\])";
        String pattForDrinkTag = "(\\[\\#([a-zA-z]+)([A-Za-z0-9\\s]+)\\#\\2\\])";
        int objtoNamereni = 0;
        int amountOfFood = 0;
        int amountOfDrinks = 0;
        for (int i = 0; i < allFoundMathches.size(); i++) {
            Matcher matcherFood = Pattern.
                    compile("(\\[\\#([0-9]+)([A-Za-z0-9\\s]+)\\#\\2\\])").matcher(allFoundMathches.get(i));
            Matcher matcherDrink = Pattern.
                    compile("(\\[\\#([a-zA-z]+)([A-Za-z0-9\\s]+)\\#\\2\\])").matcher(allFoundMathches.get(i));
            if (matcherFood.find()) {
                //found food
                if (matcherFood.group(2).length() == N) {
                    List<String> doSegaIzpolzvaniDumi = new ArrayList<>();
                    char[] word = matcherFood.group(3).toCharArray();
                    int calc = 0;
                    for (int j = 0; j < word.length; j++) {
                        if (!doSegaIzpolzvaniDumi.contains(String.valueOf(word[j]))) {
                            calc += word[j];
                            doSegaIzpolzvaniDumi.add(String.valueOf(word[j]));
                        }
                    }
                    amountOfFood += calc * N;
                    objtoNamereni++;
                }
            } else if (matcherDrink.find()) {
                //found drink
                if (matcherDrink.group(2).length() == N) {
                    char[] word = matcherDrink.group(3).toCharArray();
                    char[] wordTAG = matcherDrink.group(2).toCharArray();
                    int calc = 0;
                    int sumOfTag=0;
                    for (int j = 0; j < word.length; j++) {
                        calc += word[j];
                    }
                    for (int j = 0; j < wordTAG.length; j++) {
                        sumOfTag+=wordTAG[j];
                    }
                    amountOfDrinks+=calc*sumOfTag;
                    objtoNamereni++;
                }
            } else {
                //not matching
            }
        }
        if(objtoNamereni==0){
            System.out.println(allFoundMathches.size()+" crates found, no valid ones.");
        }else{
            System.out.println("Number of supply crates: "+objtoNamereni);
            System.out.println("Amount of food collected: "+amountOfFood);
            System.out.println("Amount of drinks collected: "+amountOfDrinks);
        }
    }
}