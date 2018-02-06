package com.lihy.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 * @author lihy
 * @date 2018/02/06
 */
@Data
public class User implements Serializable {
    private String userId;
    private String userName;
}
