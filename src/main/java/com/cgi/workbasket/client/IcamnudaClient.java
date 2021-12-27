package com.cgi.workbasket.client;

import com.cgi.workbasket.Models.request.AVariableKey;
import com.cgi.workbasket.Models.request.ClaimTaskRequest;
import com.cgi.workbasket.Models.request.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "camundaClient",url = "${cgi.userUpdate.host}")
public interface IcamnudaClient {
    @PostMapping(value = "/task/{id}/claim")
    String claimTask(ClaimTaskRequest request,@PathVariable(value = "id")String id);
    @GetMapping (path = "/task")
    List<Task>  retrieveTaskList(@RequestParam(value = "candidateUser")String id,@RequestParam(value = "includeAssignedTasks")Boolean value);
    @GetMapping (path = "/task/{id}/variables")
    Map<String, AVariableKey> retrieveVariables(@PathVariable(value = "id")String id);
    @GetMapping(value = "/group")
    List<Task> retrieveGroups();
}
