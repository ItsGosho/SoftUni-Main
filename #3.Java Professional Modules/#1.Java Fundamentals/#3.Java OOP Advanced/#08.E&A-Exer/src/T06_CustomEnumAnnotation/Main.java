package T06_CustomEnumAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String line=skener.nextLine();
      if(line.equals("Rank")){
        CustomAnnotation customAnnotation = RankPowers.class.getAnnotation(CustomAnnotation.class);
        System.out.println("Type = "+customAnnotation.type()+", Description = "+customAnnotation.description());
      }else if(line.equals("Suit")){
        CustomAnnotation customAnnotation = SuitPowers.class.getAnnotation(CustomAnnotation.class);
        System.out.println("Type = "+customAnnotation.type()+", Description = "+customAnnotation.description());
      }
    }
}
