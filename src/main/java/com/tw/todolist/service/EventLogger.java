package com.tw.todolist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class EventLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventLogger.class);

    public EventLogger() {
    }


    public static void log(String eventName, String key,Object value) {
        Map<String, Object> message = Maps.newLinkedHashMap();
        message.put(key, value);
        log(eventName, message);
    }


    public static void log(String eventName, Map<String, Object> message) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode nodes = mapper.createObjectNode();
        nodes.put("event", eventName);

        for(String key: message.keySet()) {
            nodes.put(key, ObjectUtils.toString(message.get(key), "Undefined"));
        }

        LOGGER.info(nodes.toString());
    }


}
