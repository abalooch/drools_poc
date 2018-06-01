package com.drools.rules.application;

import com.drools.rules.model.ApplicationDTO;

/**
 * Created by Ashfak.Balooch on 3/27/2018.
 */
public interface IApplicationService {
    void executeRules();
    ApplicationDTO executeAgeRule(ApplicationDTO applicationDTO);
}
