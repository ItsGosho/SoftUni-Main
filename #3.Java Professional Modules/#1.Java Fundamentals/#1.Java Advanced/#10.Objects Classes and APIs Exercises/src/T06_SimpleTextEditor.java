import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T06_SimpleTextEditor {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n = Integer.parseInt(skener.nextLine());
        int x = 0;
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean undonedAPPEND = false;
        boolean undonedDELETE = false;
        ArrayList<Character> memory = new ArrayList<>();
        ArrayList<Character> memory2 = new ArrayList<>();
        while (n > x) {
            String[] line = skener.nextLine().split(" ");
            if (line[0].equals("1")) {
                //append
                char[] words = line[1].toCharArray();
                memory.clear();
                if (queue.size() != 0) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {

                        memory.add(queue.poll());
                    }
                    for (int i = 0; i < size; i++) {

                        queue.add(memory.get(i));
                    }
                }
                for (int i = 0; i < words.length; i++) {
                    queue.add(words[i]);
                }
                undonedAPPEND = true;
                undonedDELETE = false;
            } else if (line[0].equals("2")) {
                //DELETE         ->>>>>>>
                memory2.clear();
                if (queue.size() != 0) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {

                        memory2.add(queue.poll());
                    }
                    for (int i = 0; i < size; i++) {

                        queue.add(memory2.get(i));
                    }
                }
                for (int i = 0; i < Integer.parseInt(line[1]); i++) {
                    queue.remove();
                }
                undonedAPPEND = false;
                undonedDELETE = true;
            } else if (line[0].equals("3")) {
                //print
                System.out.println(queue.peekLast());
            } else if (line[0].equals("4")) {
                //undo
                if (undonedAPPEND) {
                    if (memory.size() != 0) {
                        int size = memory.size();
                        queue.clear();
                        for (int i = size-1; i > -1; i--) {

                            queue.add(memory.get(i));
                        }
                    }else{
                        queue.clear();
                    }
                    undonedAPPEND = false;
                    undonedDELETE = true;
                } else if (undonedDELETE) {
                    if (memory2.size() != 0) {
                        int size = memory2.size();
                        queue.clear();
                        for (int i = size-1; i > -1; i--) {

                            queue.add(memory2.get(i));
                        }
                    }
                    undonedAPPEND = true;
                    undonedDELETE = false;
                }
            }
            x++;
        }
    }
}
