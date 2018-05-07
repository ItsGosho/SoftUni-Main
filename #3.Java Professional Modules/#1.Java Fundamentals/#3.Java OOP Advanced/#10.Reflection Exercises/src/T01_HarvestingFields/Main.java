package T01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner skener = new Scanner(System.in);

	    while(true){
	        String line=skener.nextLine();
	        if(line.equals("HARVEST")){
                    break;
            }
            if(line.equals("protected")){
                Field[] protectedFields=RichSoilLand.class.getDeclaredFields();
                Arrays.stream(protectedFields).filter(x->Modifier.toString(x.getModifiers()).equals("protected"))
                        .forEach(x-> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
            }else if(line.equals("private")){
                Field[] privateFields=RichSoilLand.class.getDeclaredFields();
                Arrays.stream(privateFields).filter(x->Modifier.toString(x.getModifiers()).equals("private"))
                        .forEach(x-> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
            }else if(line.equals("public")){
                Field[] publicFields=RichSoilLand.class.getDeclaredFields();
                Arrays.stream(publicFields).filter(x->Modifier.toString(x.getModifiers()).equals("public"))
                        .forEach(x-> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
            } else if(line.equals("all")){
                Field[] publicFields=RichSoilLand.class.getDeclaredFields();
                Arrays.stream(publicFields)
                        .forEach(x-> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
            }
        }
	}
}
