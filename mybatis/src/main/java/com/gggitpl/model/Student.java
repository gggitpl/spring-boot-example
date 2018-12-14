package com.gggitpl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private Integer clazzId;
    private Clazz clazz;
    private List<Teacher> teachers;

}
