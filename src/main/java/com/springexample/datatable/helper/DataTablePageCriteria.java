package com.springexample.datatable.helper;

import org.springframework.data.domain.PageRequest;

import java.io.Serializable;


public class DataTablePageCriteria implements Serializable {
    private int offset;
    private int pageSize;
    private boolean ascending;
    private String column;
    private int upperRowBound;
    private Integer sortOnColumn;
    private String order; //"asc" or "desc"

    private PageRequest pageRequest;

    public DataTablePageCriteria() {
    }

    public Integer getSortOnColumn() {
        return sortOnColumn;
    }

    public void setSortOnColumn(Integer sortOnColumn) {
        this.sortOnColumn = sortOnColumn;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getUpperRowBound() {
        return upperRowBound;
    }

    public void setUpperRowBound(int upperRowBound) {
        this.upperRowBound = upperRowBound;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
}
