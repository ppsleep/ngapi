package com.niceof.nicegoapi.utils;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
    public static Object Msg(Object body) {
        Map<String, Object> resp = new HashMap<>();
        int status = 0;
        resp.put("data", body);
        if (body instanceof String) {
            status = 1;
            resp.put("status", status);
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(resp);
            } catch (JsonProcessingException e) {
                return "{\"status\": -1}";
            }
        } else if (body instanceof Integer) {
            if (body.equals(-1)) {
                status = -1;
            }
        }
        resp.put("status", status);
        return resp;
    }
}
