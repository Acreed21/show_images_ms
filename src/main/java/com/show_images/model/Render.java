package com.show_images.model;
import com.show_images.model.Image;
import java.util.List;

public class Render{
    private List<Image> data;
    private String errors;


    public Render() {
    }

    public Render(List<Image> data, String errors) {
        this.data = data;
        this.errors = errors;
    }

    public List<Image> getData() {
        return this.data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }

    public String getErrors() {
        return this.errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Render data(List<Image> data) {
        this.data = data;
        return this;
    }

    public Render errors(String errors) {
        this.errors = errors;
        return this;
    }   

}