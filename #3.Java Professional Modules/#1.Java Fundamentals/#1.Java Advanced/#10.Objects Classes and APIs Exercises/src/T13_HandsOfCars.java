import java.util.*;

public class T13_HandsOfCars {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String,Integer> dict=new HashMap<>();
        //NEDOVURSHENA! DUBLICATI PROVERKA ZA UTRE
        while(true){
            String line=skener.nextLine();
            if(line.contains("JOKER")){
                   break;
            }
            String[] vhod=line.split("[:,]\\s");
            String name=vhod[0];
            //cards 1<->vhod.length-1
            boolean notExisted=true;
            String dublicates="";
            //checkForDublicates
            for (int j = 1; j < vhod.length+1; j++) {
                for (int k = j + 1; k < vhod.length; k++) {
                    if (vhod[j].equals(vhod[k])) {
                        notExisted = false;
                        if(!dublicates.contains(vhod[j])){
                            dublicates += " " + vhod[j];
                        }
                    }
                }
            }
            //^^^^^^^^^^^^^^^^^^
            //SUM
            int result=0;
            int firstTime=0;
            for (int i = 1; i < vhod.length; i++) {
                int sum=0;
                char[] words=vhod[i].toCharArray();
                //Purvoto
                System.out.println(dublicates);
                if(vhod[i].contains(dublicates)) {
                    if (words[0] == '2' || words[0] == '3' || words[0] == '4'
                            || words[0] == '5' || words[0] == '6' || words[0] == '7' || words[0] == '8' ||
                            words[0] == '9' || words[0] == '1') {
                        if (words[0] == '1' && words[1] == '0') {
                            sum += 10;
                        } else {
                            sum += Integer.parseInt(String.valueOf(words[0]));
                        }
                    } else if (words[0] == 'J') {
                        sum += 11;
                    } else if (words[0] == 'Q') {
                        sum += 12;
                    } else if (words[0] == 'K') {
                        sum += 13;
                    } else if (words[0] == 'A') {
                        sum += 14;
                    }
                    //Vtoroto
                    if (words[1] == 'C') {
                        sum *= 1;
                    } else if (words[1] == 'D') {
                        sum *= 2;
                    } else if (words[1] == 'H') {
                        sum *= 3;
                    } else if (words[1] == 'S') {
                        sum *= 4;
                    }
                }
                result+=sum;
            }
            //SUM
            if(!dict.containsKey(name)){
                dict.put(name,result);
            }else{
                dict.put(name,dict.get(name)+result);
            }
        }
        for(Map.Entry<String, Integer> item:dict.entrySet()){
            System.out.println(item.getKey()+":"+item.getValue());
        }
    }
}
