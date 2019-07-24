package com.ListTuDu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import java.lang.String;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @NotEmpty
    private String name;
    private Status status;

    public enum Status {
        DoNotUse("Enum to adjust with MySQL db!"),
        NotStarted("Not Started"),
        InProgres("In Progress"),
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
