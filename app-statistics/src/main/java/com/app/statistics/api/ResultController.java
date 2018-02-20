package com.app.statistics.api;

import com.app.statistics.exception.advice.IncorrectResultBodyAdviceException;
import com.app.statistics.exception.advice.IncorrectResultDataAdviceException;
import com.app.statistics.exception.advice.IncorrectResultMetaAdviceException;
import com.app.statistics.model.ResultModel;
import com.app.statistics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.statistics.precondition.Precondition.checkNotNull;

@RestController
@RequestMapping("api/result")
@CrossOrigin(origins = "http://localhost:8000")
public class ResultController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private ResultService resultService;

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ResponseEntity saveResult(@RequestBody ResultModel body){
        checkNotNull(body, new IncorrectResultBodyAdviceException());
        checkNotNull(body.getMeta(), new IncorrectResultMetaAdviceException());
        checkNotNull(body.getData(), new IncorrectResultDataAdviceException());

        resultService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
