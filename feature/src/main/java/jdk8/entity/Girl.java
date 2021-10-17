package jdk8.entity;

import lombok.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/17 21:48:30
 */
@Data
@NoArgsConstructor
public class Girl {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

}

