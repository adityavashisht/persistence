package com.springexample.datatable;

import java.io.Serializable;

/**
 * Created by vashishta on 11/18/2014.
 */
public class DataTableSearchFilter implements Serializable {
    private Boolean regex;
    private String value;

    public DataTableSearchFilter() {
    }

    public Boolean getRegex() {
        return regex;
    }

    public void setRegex(Boolean regex) {
        this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
