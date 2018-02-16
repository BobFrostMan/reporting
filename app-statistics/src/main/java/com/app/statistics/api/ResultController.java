package com.app.statistics.api;

import com.app.statistics.model.ResultModel;
import com.app.statistics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("api/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveResult(@RequestBody ResultModel body){
        resultService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
