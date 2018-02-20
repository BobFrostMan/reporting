package com.app.statistics.exception.advice;

public class IncorrectDashboardBodyAdviceException extends BaseAdviceException {
    public IncorrectDashboardBodyAdviceException() {
        super(Functionality.INCORRECT_DASHBOARD_BODY);
    }
}