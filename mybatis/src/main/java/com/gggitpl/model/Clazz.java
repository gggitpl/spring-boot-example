package com.gggitpl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {

    private Integer id;
    private String name;

}
