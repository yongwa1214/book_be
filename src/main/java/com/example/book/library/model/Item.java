package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {
    private String id;
    private VolumeInfo volumeInfo;
}
