package com.springexample.datatable;

import java.io.Serializable;

/**
 * Created by vashishta on 11/18/2014.
 */
public class SortColumnDirection implements Serializable {
    private Integer column = 0; // The sort column , integer placeholder for the column to sort on in the datatable
    private String dir = "asc"; // The sort direction

    /**
     * By default, first column and ascending order please
     */
    public SortColumnDirection() {
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public boolean checkAscending() {
        return "asc".equals(dir);
    }
}
