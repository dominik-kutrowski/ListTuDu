package com.ListTuDu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @NotEmpty
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

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

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
