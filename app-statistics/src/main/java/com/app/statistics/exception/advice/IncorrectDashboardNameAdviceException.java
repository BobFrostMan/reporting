package com.app.statistics.exception.advice;

public class IncorrectDashboardNameAdviceException extends BaseAdviceException {
    public IncorrectDashboardNameAdviceException() {
        super(Functionality.INCORRECT_DASHBOARD_NAME);
    }
}
