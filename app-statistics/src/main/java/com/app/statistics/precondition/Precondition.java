package com.app.statistics.precondition;

import com.app.statistics.exception.BaseException;

public class Precondition {
    public static void checkArgument(final boolean expression, final BaseException e){
        if(!expression){
            throw e;
        }
    }
}
