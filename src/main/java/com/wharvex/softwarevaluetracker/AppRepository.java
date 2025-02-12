package com.wharvex.softwarevaluetracker;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<App, Long> {
    List<App> findByAppName(String appName);

    App findById(long id);

}
