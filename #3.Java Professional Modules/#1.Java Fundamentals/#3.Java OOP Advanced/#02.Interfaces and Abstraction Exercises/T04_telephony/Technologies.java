package T04_telephony;

public class Technologies implements Telephone,Internet{

    @Override
    public void browsingIn(String site) {
        char[] sait=site.toCharArray();
        boolean validation=true;
        int a=0;
        for (int i = 0; i < sait.length; i++) {
            if(sait[i]=='0' ||
                    sait[i]=='1' ||
                    sait[i]=='2' ||
                    sait[i]=='3' ||
                    sait[i]=='4' ||
                    sait[i]=='5' ||
                    sait[i]=='6' ||
                    sait[i]=='7' ||
                    sait[i]=='8' ||
                    sait[i]=='9'){
                validation=false;
                break;
            }
        }
        if(validation) {
            System.out.println("Browsing: " + site+"!");
        }else{
            System.out.println("Invalid URL!");
        }
    }

    @Override
    public void callingTo(String number) {
        char[] num=number.toCharArray();
        boolean validation=true;
        int a=0;
        for (int i = 0; i < num.length; i++) {
            try{
                a=Integer.parseInt(String.valueOf(num[i]));
            }catch (NumberFormatException ex){
                validation=false;
            }
        }
        if(validation) {
            System.out.println("Calling... " + number);
        }else{
            System.out.println("Invalid number!");
        }
    }
}
