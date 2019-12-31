package com.example.starredrepos.models.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationRQ {

    @Expose
    @SerializedName("page")
    int page;

    public PaginationRQ() {
        this.page = 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
