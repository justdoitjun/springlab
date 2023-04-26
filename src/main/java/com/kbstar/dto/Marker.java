package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Marker {
    private int id;
    private String title;
    private String target;
    private double latitude;
    private double longitude;
    private String image;
    private String location;
}
