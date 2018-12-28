package itsgosho.domain.dtos.virus;

import itsgosho.config.validators.dateBefore.DateBeforeToday;
import itsgosho.config.validators.equalsTo.EqualsTo;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

public class VirusEditDto {


    @NotNull
    @NotEmpty
    @Length(min = 3, message = "Name must be at least 3 characters long.")
    @Length(max = 10, message = "Name must be at least 10 characters long.")
    private String name;

    @NotNull
    @NotEmpty
    @Length(min = 5, message = "Description must be at least 5 characters long.")
    @Length(max = 100, message = "Description must be at least 100 characters long.")
    private String description;

    @Length(max = 50, message = "Side effects must be at least 50 characters long.")
    private String sideEffects;


    @EqualsTo(values = {"Corp","corp"},message = "Creator is invalid")
    private String creator;

    private boolean isDeadly;

    private boolean isCurable;

    @EqualsTo(values = {"ZOMBIE","T_078_TYRANT","GIANT_SPIDER"},message = "Mutation is invalid")
    private String mutation;

    @Min(value = 1,message = "Turnover rate must be over 1")
    @Max(value = 100,message = "Turnover rate must be below 100")
    private Integer turnoverRate;

    @Min(value = 1,message = "Hourse until turn must be over 1")
    @Max(value = 12,message = "Hourse until turn must be below 12")
    private Integer hoursUntilTurn;

    private String magnitude;

    @NotNull
    @Size(min = 1)
    private List<String> affectedCapitals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public List<String> getAffectedCapitals() {
        return affectedCapitals;
    }

    public void setAffectedCapitals(List<String> affectedCapitals) {
        this.affectedCapitals = affectedCapitals;
    }
}
