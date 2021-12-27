package com.cgi.workbasket.controller;


import com.cgi.workbasket.Models.request.AVariableKey;
import com.cgi.workbasket.Models.request.ClaimTaskRequest;
import com.cgi.workbasket.Models.request.Task;
import com.cgi.workbasket.exception.WorkbasketException;
import com.cgi.workbasket.service.WorkBasketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WorkbasketController {
    private WorkBasketService service;


    @PostMapping("/task/{id}/claim")
    public ResponseEntity claimTask(
            @PathVariable(required = true, name = "id") String id,
            @RequestBody ClaimTaskRequest claimTaskRequest) throws WorkbasketException {
        return new ResponseEntity(service.claimTask(claimTaskRequest, id), HttpStatus.NO_CONTENT);

    }


    @GetMapping(path = "/retrieve/task/{id}")
    public List<Task> retrieveTaskList(
            @PathVariable(required = true, name = "id") String id)
            throws WorkbasketException {
        return service.retrieveTaskList(id);

    }

    @GetMapping(path = "/task/{id}/variables")
    public Map<String, AVariableKey> getTaskVariables(@PathVariable(required = true, name = "id") String id) throws WorkbasketException {
        return service.retrieveVariables(id);

    }


}
