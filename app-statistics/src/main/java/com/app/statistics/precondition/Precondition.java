package com.app.statistics.precondition;

import com.app.statistics.exception.advice.BaseAdviceException;

public class Precondition {
    public static void checkIsTrue(final boolean expression, final BaseAdviceException e){
        if(!expression){
            throw e;
        }
    }

    public static void checkIsFalse(final boolean expression, final BaseAdviceException e){
        checkIsTrue(!expression, e);
    }

    public static void checkNotNull(final Object obj, final BaseAdviceException e) {
        checkIsTrue(obj != null, e);
    }
}
