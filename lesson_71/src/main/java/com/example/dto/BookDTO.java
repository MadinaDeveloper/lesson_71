package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BookDTO {
    private  Integer id;
    private  String title;
    private  String author;
    private Integer amount;
    private Boolean visible;
}
