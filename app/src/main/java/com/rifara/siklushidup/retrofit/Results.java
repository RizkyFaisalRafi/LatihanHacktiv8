package com.rifara.siklushidup.retrofit;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("name")
    private final String superName;

    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }


}
