import java.util.Scanner;

public class T02_TriangleArea {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int Ax=skener.nextInt();
        int Ay=skener.nextInt();
        int Bx=skener.nextInt();
        int By=skener.nextInt();
        int Cx=skener.nextInt();
        int Cy=skener.nextInt();
        int result=Ax*(By-Cy)+Bx*(Cy-Ay)+Cx*(Ay-By);
        result/=2;
        System.out.printf("%d",Math.abs(result));
    }
}
