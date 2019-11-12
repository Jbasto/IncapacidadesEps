/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.util;

import javax.faces.model.DataModel;

/**
 *
 * @author basto
 */
public abstract class PaginationHelper {

    private int pageSize;
    private int page;

    public PaginationHelper(int pageSize, int page) {
        this.pageSize = pageSize;
        this.page = page;
    }

    public abstract int getItemsCount();

    public abstract DataModel createPageDataModel();

    public int getPageFirstItem() {
        return page * pageSize;
    }

    public int getPageLastItem() {
        int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
    }

    public void nextPage() {
        if (isHasNextPage()) {
            page++;
        }
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    public void previousPage() {
        if (isHasPreviousPage()) {
            page--;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return page;
    }

    public int getFinalPage() {
        int count = getItemsCount();
        return count % pageSize == 0 ? (count / pageSize) - 1 : count / pageSize;
    }

    public void setFinalPages() {
        this.page = getFinalPage();

    }
}
