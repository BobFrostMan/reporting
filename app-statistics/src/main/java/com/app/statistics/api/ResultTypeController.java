package com.app.statistics.api;


import com.app.statistics.exception.advice.IncorrectResultTypeBodyAdviceException;
import com.app.statistics.exception.advice.IncorrectResultTypeAdviceException;
import com.app.statistics.exception.advice.IncorrectRequestParameterAdviceException;
import com.app.statistics.exception.advice.ResourceNotFoundAdviceException;

import com.app.statistics.model.ResultTypeModel;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import static com.app.statistics.precondition.Precondition.checkNotNull;

@RestController
@RequestMapping("api/result-type")
@CrossOrigin(origins = "http://localhost:8000")
public class ResultTypeController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private ResultTypeService resultTypeService;


    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ResponseEntity saveResultType(@RequestBody ResultTypeModel body){
        checkNotNull(body, new IncorrectResultTypeBodyAdviceException());
        checkNotNull(body.getType(), new IncorrectResultTypeAdviceException());

        resultTypeService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public ResponseEntity updateResultType(@RequestBody ResultTypeModel body){
        checkNotNull(body, new IncorrectResultTypeBodyAdviceException());
        checkNotNull(body.getType(), new IncorrectResultTypeAdviceException());

        resultTypeService.update(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getResultTypes(){
        return new ResponseEntity<>(resultTypeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getResultType(@PathVariable String type){
        checkNotNull(type, new IncorrectRequestParameterAdviceException());

        return new ResponseEntity<>(resultTypeService.findByType(type), HttpStatus.OK);
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ResponseEntity deleteResultType(@PathVariable String type){
        checkNotNull(type, new IncorrectRequestParameterAdviceException());

        final boolean resultOfDelete = resultTypeService.deleteByType(type);
        if (!resultOfDelete) {
            throw new ResourceNotFoundAdviceException();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
