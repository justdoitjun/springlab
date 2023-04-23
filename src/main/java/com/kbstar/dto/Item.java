package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Item {
    private int id;
    private String name;
    private double price;
    private String imgName;
    private Date regdate;

}
