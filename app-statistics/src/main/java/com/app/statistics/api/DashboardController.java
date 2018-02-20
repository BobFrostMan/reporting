package com.app.statistics.api;

import com.app.statistics.exception.advice.IncorrectDashboardBodyAdviceException;
import com.app.statistics.exception.advice.IncorrectDashboardNameAdviceException;
import com.app.statistics.exception.advice.IncorrectRequestParameterAdviceException;
import com.app.statistics.exception.advice.ResourceNotFoundAdviceException;

import com.app.statistics.model.DashboardModel;
import com.app.statistics.service.DashboardService;
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
@RequestMapping("api/dashboard")
@CrossOrigin(origins = "http://localhost:8000")
public class DashboardController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ResponseEntity saveDashboard(@RequestBody DashboardModel body) {
        checkNotNull(body, new IncorrectDashboardBodyAdviceException());
        checkNotNull(body.getName(), new IncorrectDashboardNameAdviceException());

        dashboardService.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public ResponseEntity updateDashboard(@RequestBody DashboardModel body) {
        checkNotNull(body, new IncorrectDashboardBodyAdviceException());
        checkNotNull(body.getName(), new IncorrectDashboardNameAdviceException());

        dashboardService.update(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getDashboards() {
        return new ResponseEntity<>(dashboardService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public ResponseEntity getDashboard(@PathVariable String name) {
        checkNotNull(name, new IncorrectRequestParameterAdviceException());

        return new ResponseEntity<>(dashboardService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ResponseEntity deleteDashboard(@PathVariable String name) {
        checkNotNull(name, new IncorrectRequestParameterAdviceException());

        final boolean resultOfDelete = dashboardService.deleteByName(name);
        if (!resultOfDelete) {
            throw new ResourceNotFoundAdviceException();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
