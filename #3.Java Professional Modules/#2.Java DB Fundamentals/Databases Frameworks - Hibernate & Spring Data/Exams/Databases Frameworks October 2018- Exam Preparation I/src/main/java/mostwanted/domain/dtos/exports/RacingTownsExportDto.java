package mostwanted.domain.dtos.exports;

public class RacingTownsExportDto {

    private String townName;
    private Integer racersCount;

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getRacersCount() {
        return racersCount;
    }

    public void setRacersCount(Integer racersCount) {
        this.racersCount = racersCount;
    }
}

