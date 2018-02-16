package com.app.statistics.api;

import com.app.statistics.model.Group;
import com.app.statistics.model.ResultModel;
import com.app.statistics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping(method = RequestMethod.POST, value = "/{group}", produces = "application/json")
    public ResponseEntity saveResult(@PathVariable Group group, @RequestBody ResultModel body){
        resultService.save(group, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
