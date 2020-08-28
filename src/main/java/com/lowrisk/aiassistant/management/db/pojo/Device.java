package com.lowrisk.aiassistant.management.db.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Device extends BasePojo {
    private String deviceName;
    private String deviceId;
    private Integer enabled;
}
