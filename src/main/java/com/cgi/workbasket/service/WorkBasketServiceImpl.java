package com.cgi.workbasket.service;

import com.cgi.workbasket.Models.request.AVariableKey;
import com.cgi.workbasket.Models.request.ClaimTaskRequest;
import com.cgi.workbasket.Models.request.Task;
import com.cgi.workbasket.client.IcamnudaClient;
import com.cgi.workbasket.exception.WorkbasketException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Slf4j
public class WorkBasketServiceImpl implements WorkBasketService {

    private IcamnudaClient client;



    @Override
    public String claimTask(ClaimTaskRequest request,String id) throws WorkbasketException {

        try {
            String response = client.claimTask(request,id);

        } catch (Exception e) {
            log.error("Exception Occured while Assigning task  to User: "+id, e);
            throw new WorkbasketException(e.getMessage());
        }
        return "";


    }

    @Override
     public List<Task> retrieveTaskList( String id) throws WorkbasketException {

        try {
            return client.retrieveTaskList(id,true);
        } catch (Exception e) {
            log.error("Exception Occured while Updating User Credential", e);
            throw new WorkbasketException(e.getMessage());
        }

    }

    @Override
    public Map<String, AVariableKey> retrieveVariables(String id) throws WorkbasketException {


       try {
           return client.retrieveVariables(id);
       }catch (Exception e) {
           log.error("Exception Occured while retrieving variables", e);
           throw new WorkbasketException(e.getMessage());
       }
    }


}
