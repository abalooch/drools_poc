package com.drools.rules;

import com.drools.rules.model.ApplicationDTO;
import com.drools.rules.application.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ashfak.Balooch on 3/27/2018.
 */

@RestController
public class IndexController {
    @Autowired
    private IApplicationService applicationService;

    @RequestMapping(value = "/")
    public String hello() {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationService.executeRules();
        return ":test";
    }

    @RequestMapping(value = "/ageRule" , method = RequestMethod.GET, produces = "application/json")
    public ApplicationDTO ageRule(@RequestParam(required = true) Integer age) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setAge(age);
        applicationService.executeAgeRule(applicationDTO);
        return applicationDTO;
    }
}
