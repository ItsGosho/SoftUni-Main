import java.util.*;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Map<String,List<Recruits>> recruits=new LinkedHashMap<>();
        recruits.put("Hydra",new LinkedList<>());
        recruits.put("Arrow",new LinkedList<>());
        recruits.put("Flame",new LinkedList<>());
        recruits.put("Pearl",new LinkedList<>());
        recruits.put("Orchid",new LinkedList<>());
        while(true){
            String line=skener.nextLine();
            if(line.equals("Recruit")){
                 String command=skener.nextLine();
                if(command.equals("DHARMA Initiative")){
                    recruits.entrySet().stream().sorted((x1,x2)->{
                        if(x1.getValue().size()==x2.getValue().size()){
                            return x1.getKey().compareTo(x2.getKey());
                        }else{
                            return Integer.compare(x2.getValue().size(),x1.getValue().size());
                        }
                    }).forEach(x-> System.out.println("The "+x.getKey()+" has "+x.getValue().size()+" DHARMA recruits in it."));
                  break;
                }else{
                    //check for valid via my dict
                    if(recruits.containsKey(command)){
                        //check if there are recruits
                        if(recruits.get(command).size()!=0){
                            switch(command){
                                case "Hydra":
                                    System.out.println("The Hydra station: Zoological Research.");
                                    break;
                                case "Arrow":
                                    System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.");
                                    break;
                                case "Flame":
                                    System.out.println("The Flame station: Communication.");
                                    break;
                                case "Pearl":
                                    System.out.println("The Pearl station: Psychological Research and/or Observation.");
                                    break;
                                case "Orchid":
                                    System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
                                    break;
                            }
                            recruits.get(command).stream()
                                    .sorted((x1,x2)->Integer.compare(x2.getFacilityNumber(),x1.getFacilityNumber()))
                                    .forEach(x-> System.out.println("###"+x.getPersonName()+" - "+x.getFacilityNumber()));
                        }else{
                            System.out.println("No recruits."); 
                        }
                    }else{
                        System.out.println("DHARMA Initiative does not have such a station!");
                    }
                    break;
                }
            }
            String[] splitted=line.split(":");
            String personName=splitted[0];
            int facilityNumber=Integer.parseInt(splitted[1]);
            String stantionName=splitted[2];
            switch(stantionName){
                case "Hydra":
                   recruits.get(stantionName).add(new Recruits(personName,facilityNumber,stantionName));
                    break;
                case "Arrow":
                    recruits.get(stantionName).add(new Recruits(personName,facilityNumber,stantionName));
                    break;
                case "Flame":
                    recruits.get(stantionName).add(new Recruits(personName,facilityNumber,stantionName));
                    break;
                case "Pearl":
                    recruits.get(stantionName).add(new Recruits(personName,facilityNumber,stantionName));
                    break;
                case "Orchid":
                    recruits.get(stantionName).add(new Recruits(personName,facilityNumber,stantionName));
                    break;
            }
        }
    }
}
class Recruits{
     private String personName;
     private int facilityNumber;
     private String stantionName;

    public Recruits(String personName, int facilityNumber, String stantionName) {
        this.personName = personName;
        this.facilityNumber = facilityNumber;
        this.stantionName = stantionName;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public int getFacilityNumber() {
        return facilityNumber;
    }
    public void setFacilityNumber(int facilityNumber) {
        this.facilityNumber = facilityNumber;
    }
    public String getStantionName() {
        return stantionName;
    }
    public void setStantionName(String stantionName) {
        this.stantionName = stantionName;
    }
}