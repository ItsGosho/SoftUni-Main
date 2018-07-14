package com.masdefect.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AnomalyExportJSONDto implements Serializable {

    @Expose
    private String originPlanet;
    @Expose
    private PlanetExportJSONDto homePlanet;

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public PlanetExportJSONDto getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(PlanetExportJSONDto homePlanet) {
        this.homePlanet = homePlanet;
    }
}
