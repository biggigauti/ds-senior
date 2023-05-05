package edu.carroll.ds.json.model;

import java.util.Objects;

/**
 * This is the JSON model that is used to make sense of data that we POST from the web application.
 *
 * We have to objectify the data to help Java understand it.
 */
public class DataModel {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return data.equals(dataModel.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "data='" + data + '\'' +
                '}';
    }
}
