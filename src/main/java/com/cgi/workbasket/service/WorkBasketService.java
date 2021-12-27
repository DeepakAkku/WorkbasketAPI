package com.cgi.workbasket.service;

import com.cgi.workbasket.Models.request.AVariableKey;
import com.cgi.workbasket.Models.request.ClaimTaskRequest;
import com.cgi.workbasket.Models.request.Task;
import com.cgi.workbasket.exception.WorkbasketException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface WorkBasketService {
    public String claimTask(ClaimTaskRequest claimTaskRequest,String id) throws WorkbasketException;

    public List<Task> retrieveTaskList(String id) throws WorkbasketException;

    public Map<String, AVariableKey> retrieveVariables(String id) throws WorkbasketException;
}

