package com.wharvex.softwarevaluetracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String appName;

    // Exists only for the sake of JPA.
    protected App() {
    }

    public App(String appName) {
        this.appName = appName;
    }

    public Long getId() {
        return id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return String.format("App[id=%d, appName='%s']", id, appName);
    }

}
