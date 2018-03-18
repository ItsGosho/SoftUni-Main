import java.util.*;

public class T06_AcademyGraduation {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n=Integer.parseInt(skener.nextLine());
        Map<String,Double> dict=new TreeMap<>();
        for (int i = 0; i < n; i++) {
           String name=skener.nextLine();
           if(!dict.containsKey(name)){
               dict.put(name,0.0);
           }
           String[] gradesString=skener.nextLine().split(" ");
           double avg=0;
            for (int j = 0; j < gradesString.length; j++) {
                double grade=Double.parseDouble(gradesString[j]);
                avg+=grade;
            }
            avg/=gradesString.length;
            dict.put(name,avg);
        }
        for(Map.Entry<String, Double> item:dict.entrySet()){
            System.out.println(item.getKey()+" is graduated with "+item.getValue());
        }
    }
}
