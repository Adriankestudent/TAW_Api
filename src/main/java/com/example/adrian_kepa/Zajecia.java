package com.example.adrian_kepa;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Zajecia {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nazwa")
    private String name;

    @JsonProperty("ECTS")
    private Integer ECTS;

    @JsonProperty("sala")
    private Integer room;

    @JsonProperty("egzamin")
    private Boolean exam;

}
