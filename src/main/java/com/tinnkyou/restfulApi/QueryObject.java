package com.tinnkyou.restfulApi;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wb-cq355812
 * @create 2019/02/14
 */
@Getter@Setter
public class QueryObject {
    private int page;
    private int rows;
    private String keyword;
    private Integer type;

    @Override
    public String toString() {
        return "QueryObject{" +
                "page=" + page +
                ", rows=" + rows +
                ", keyword='" + keyword + '\'' +
                ", type=" + type +
                '}';
    }
}
