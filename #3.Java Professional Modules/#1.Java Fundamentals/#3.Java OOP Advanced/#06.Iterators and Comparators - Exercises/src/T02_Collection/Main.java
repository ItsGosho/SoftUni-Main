package T02_Collection;

import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line = skener.nextLine();
        if(line.length()>=7) {
            line = line.substring(7, line.length());
        }else{
            line="";
        }
        String[] splitted = line.split(" ");
        ListyIterator listyIterator = new ListyIterator(splitted);

        while (true) {
            String line2 = skener.nextLine();
            if (line2.equals("END")) {
                break;
            }
            String[] vhod = line2.split(" ");
            if (vhod[0].equals("HasNext")) {
                if (listyIterator.hasNext()) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else if (vhod[0].equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (vhod[0].equals("Print")) {
                listyIterator.print();
            }else if(vhod[0].equals("PrintAll")){
                listyIterator.PrintAll();
            }
        }
    }
}
