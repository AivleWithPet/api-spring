package com.example.apispring.data.ai;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelData {
    private String prediction;

    public ModelData(String prediction) {
        this.prediction = prediction;
    }
}