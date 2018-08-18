package app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TubeRepository {
    private static List<Tube> tubes=new LinkedList<>();

    public static Tube getByName(String tubeName) {
        return tubes
                .stream()
                .filter(x -> x.getTitle().equals(tubeName))
                .findFirst()
                .orElse(null);
    }

    public static List<Tube> getTubes() {
        return tubes;
    }

    public static void setTubes(List<Tube> cats) {
        TubeRepository.tubes = cats;
    }
}
