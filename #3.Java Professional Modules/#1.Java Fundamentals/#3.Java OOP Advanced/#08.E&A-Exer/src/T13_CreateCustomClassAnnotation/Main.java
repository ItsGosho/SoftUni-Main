package T13_CreateCustomClassAnnotation;

import java.lang.annotation.Annotation;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        CustomAnnotation weapon=Weapon.class.getAnnotation(CustomAnnotation.class);
        StringBuilder str=new StringBuilder();
        str.append("Author: "+weapon.author()+"\n");
        str.append("Revision: "+weapon.revision()+"\n");
        str.append("Class description: "+weapon.description()+"\n");
        str.append("Reviewers: "+weapon.reviewers()+"\n");
        System.out.println(str.toString());
    }
}
