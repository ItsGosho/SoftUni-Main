package org.softuni.mostwanted.domain.dtos.exports.json;

public class RacingTownsExportJSONDto {

    private String name;
    private int racers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRacers() {
        return racers;
    }

    public void setRacers(int racers) {
        this.racers = racers;
    }
}
