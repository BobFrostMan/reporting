package com.app.statistics.api;

import com.app.statistics.exception.advice.*;
import com.app.statistics.model.ResultModel;
import com.app.statistics.model.ResultTypeModel;
import com.app.statistics.service.ResultService;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.statistics.precondition.Precondition.checkNotNull;

@RestController
@RequestMapping("api/result")
public class ResultController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private ResultService resultService;

    @Autowired
    private ResultTypeService resultTypeService;

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ResponseEntity saveResult(@RequestBody ResultModel body){
        checkNotNull(body, new IncorrectResultBodyAdviceException());
        checkNotNull(body.getMeta(), new IncorrectResultMetaAdviceException());
        checkNotNull(body.getData(), new IncorrectResultDataAdviceException());

        resultService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "type", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ResponseEntity saveResultType(@RequestBody ResultTypeModel body){
        checkNotNull(body, new IncorrectResultTypeBodyAdviceException());
        checkNotNull(body.getType(), new IncorrectResultTypeAdviceException());

        resultTypeService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "type", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getResultTypes(){
        return new ResponseEntity<>(resultTypeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "type/{type}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getResultType(@PathVariable String type){
        checkNotNull(type, new IncorrectRequestParameterAdviceException());

        return new ResponseEntity<>(resultTypeService.findByType(type), HttpStatus.OK);
    }

    @RequestMapping(value = "type/{type}", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ResponseEntity deleteResultType(@PathVariable String type){
        checkNotNull(type, new IncorrectRequestParameterAdviceException());

        final boolean resultOfDelete = resultTypeService.deleteByType(type);
        if (!resultOfDelete) {
            throw new ResourceNotFoundAdviceException();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
