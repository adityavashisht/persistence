package com.springexample.datatable;

import java.io.Serializable;

/**
 * Created by vashishta on 11/18/2014.
 */
public class DataTableColumn implements Serializable {
    private String data;
    private String name;
    private Boolean orderable;
    private Boolean searchable;
    private DataTableSearchFilter search = new DataTableSearchFilter();

    public DataTableColumn() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public DataTableSearchFilter getSearch() {
        return search;
    }

    public void setSearch(DataTableSearchFilter search) {
        this.search = search;
    }
}
