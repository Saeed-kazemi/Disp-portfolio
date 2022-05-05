package com.example.workflow;


import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class Message1 implements JavaDelegate {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String Name = (String) delegateExecution.getVariable("Name");

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("AskTDog")
                .setVariable("Passed_Name",Name)
                .correlate();
    }
}
