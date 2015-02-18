package com.philheenan.presenter;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public interface Presenter<T, D> {

    public void start();
    public void finish();
    public void setViewModel(T viewModel);
    public void setData(D data);
}
