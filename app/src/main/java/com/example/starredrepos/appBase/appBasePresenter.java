package com.example.starredrepos.appBase;

public class appBasePresenter <K extends appBaseView> {

    /**
     * view associated with presenter
     */
    protected K view;

    /**
     * bind the view to presenter
     *
     * @param view view to bind
     */
    public void bind(K view) {
        this.view = view;
    }

    /**
     * view is gone, so unbind it from presenter
     */
    public void unbind() {
        this.view = null;
    }
}
