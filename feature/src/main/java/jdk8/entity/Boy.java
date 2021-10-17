package jdk8.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/17 21:48:07
 */
@Data
@NoArgsConstructor
public class Boy {
    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }
}

