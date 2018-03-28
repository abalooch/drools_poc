package com.emaratech.vision.rules.application;

import com.emaratech.vision.model.ApplicationDTO;

/**
 * Created by Ashfak.Balooch on 3/27/2018.
 */
public interface IApplicationService {
    void executeRules();
    ApplicationDTO executeAgeRule(ApplicationDTO applicationDTO);
}
