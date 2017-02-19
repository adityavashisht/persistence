package com.springexample.persistence.dto;

/**
 * Created by Ady on 2/19/17.
 */
public class JsonResponse {

    private Object data;

    public JsonResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
