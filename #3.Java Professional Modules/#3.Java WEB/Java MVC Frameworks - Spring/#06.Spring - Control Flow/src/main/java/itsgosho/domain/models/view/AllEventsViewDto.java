package itsgosho.domain.models.view;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AllEventsViewDto {

    private String id;

    private String name;

    private String place;

    private LocalDateTime start;

    private LocalDateTime end;

    private Integer remainingTickets;

    private Integer pricePerTicket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Integer getRemainingTickets() {
        return remainingTickets;
    }

    public void setRemainingTickets(Integer remainingTickets) {
        this.remainingTickets = remainingTickets;
    }

    public Integer getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(Integer pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }
}
