package com.emaratech.vision.rules.application;

import com.emaratech.vision.model.ApplicationDTO;
import com.sample.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashfak.Balooch on 3/27/2018.
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private KieContainer kieContainer;


    public void executeRules() {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        // go !
        ApplicationDTO applicationDTO = new ApplicationDTO();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Override
    public ApplicationDTO executeAgeRule(ApplicationDTO applicationDTO) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        kieSession.insert(applicationDTO);
        kieSession.fireAllRules();
        return applicationDTO;
    }
}
