package itsgosho.domain.models.view;

import java.time.LocalDateTime;

public class MyEventsViewDto {

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private Integer totalTicketsBought;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getTotalTicketsBought() {
        return totalTicketsBought;
    }

    public void setTotalTicketsBought(Integer totalTicketsBought) {
        this.totalTicketsBought = totalTicketsBought;
    }
}
