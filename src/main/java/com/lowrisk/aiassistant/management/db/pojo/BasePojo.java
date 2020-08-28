package com.lowrisk.aiassistant.management.db.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public abstract class BasePojo implements Serializable {
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private Integer delFlag;
    private String remarks;
}
