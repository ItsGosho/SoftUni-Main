package T01_ClassBox;

import java.util.Scanner;

public class Main {
    public static class Box {
        private double length;
        private double width;
        private double height;

        public Box(double length,double width,double height){
            this.length=length;
            this.width=width;
            this.height=height;
        }
        public double calculateSurface(){
            return 2*(this.length*this.width)+2*(this.length*this.height)+2*(this.width*this.height);
        }
        public double calculateLateralSurfaceArea(){
            return 2*(this.length*this.height)+2*(this.width*this.height);
        }

        public double calculateVolume() {
            return this.length*this.width*this.height;
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        double length=Double.parseDouble(skener.nextLine());
        double width=Double.parseDouble(skener.nextLine());
        double height=Double.parseDouble(skener.nextLine());
        Box box=new Box(length,width,height);
        System.out.printf("Surface Area - %.2f\n",box.calculateSurface());
        System.out.printf("Lateral Surface Area - %.2f\n",box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f\n",box.calculateVolume());
    }
}
