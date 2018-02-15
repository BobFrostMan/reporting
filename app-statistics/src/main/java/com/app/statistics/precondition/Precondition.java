package com.app.statistics.precondition;

import com.app.statistics.exception.advice.BaseAdviceException;

public class Precondition {
    public static void checkArgument(final boolean expression, final BaseAdviceException e){
        if(!expression){
            throw e;
        }
    }

    public static void checkNotNull(final Object obj, final BaseAdviceException e) {
        checkArgument(obj != null, e);
    }
}
