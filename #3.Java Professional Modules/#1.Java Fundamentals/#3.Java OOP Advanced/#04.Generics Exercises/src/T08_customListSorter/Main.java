package T08_customListSorter;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        CustomList<String> customList=new CustomList<>();
        while(true){
            String line=skener.nextLine();
            if(line.equals("END")){
                 break;
            }
            String[] vhod=line.split(" ");
            switch(vhod[0]){
                case "Add":
                    customList.add(vhod[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(vhod[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(vhod[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(vhod[1]),Integer.parseInt(vhod[2]));
                    break;
                case "Greater":
                    System.out.println(customList.greater(vhod[1]));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
        }
    }
}
