package com.ListTuDu;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.lang.String;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotEmpty
    private String name;
    @Column(name = "date_dead_line")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeadLine;


    public enum Status {
        DoNotUse("Enum to adjust with MySQL db!"),
        NotStarted("Not Started"),
        InProgress("In Progress"),
        Completed("Completed");

        private String displayStatus;

        Status(String displayStatus) {
            this.displayStatus = displayStatus;
        }

        public void setStatus(String displayStatus){
            this.displayStatus = displayStatus;
        };
        public String getStatus(){
            return displayStatus;
        };
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Status getStatus() {
        return status;
    }
    public LocalDate getDateDeadLine() {
        return dateDeadLine;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setDateDeadLine(LocalDate dateDeadLine) {
        this.dateDeadLine = dateDeadLine;
    }
}
