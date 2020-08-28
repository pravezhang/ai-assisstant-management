package com.lowrisk.aiassistant.management.db.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VoiceQueryRecord extends BasePojo {
    private Integer deviceId ;
    private String queryMessage;
    private Integer replyType;
    private String replyMessage;

}
