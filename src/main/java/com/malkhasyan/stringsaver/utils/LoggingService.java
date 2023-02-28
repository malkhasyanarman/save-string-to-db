package com.malkhasyan.stringsaver.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public interface LoggingService {
    Logger log = LoggerFactory.getLogger(MethodHandles.lookup().getClass());
}
