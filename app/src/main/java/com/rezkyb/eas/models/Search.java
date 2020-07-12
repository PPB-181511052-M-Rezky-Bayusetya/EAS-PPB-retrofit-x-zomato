package com.rezkyb.eas.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("results_found")
    @Expose
    private String resultsFound;
    @SerializedName("results_start")
    @Expose
    private String resultsStart;
    @SerializedName("results_shown")
    @Expose
    private String resultsShown;
    @SerializedName("restaurants")
    @Expose
    private List<Restaurants> restaurants = null;

    public String getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(String resultsFound) {
        this.resultsFound = resultsFound;
    }

    public String getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(String resultsStart) {
        this.resultsStart = resultsStart;
    }

    public String getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(String resultsShown) {
        this.resultsShown = resultsShown;
    }

    public List<Restaurants> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }


}
