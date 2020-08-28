package com.lowrisk.aiassistant.backend.reply;



import com.alibaba.fastjson.JSON;
import com.lowrisk.aiassistant.backend.reply.contentType.BaseReplyContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class ReplyObject<Content extends BaseReplyContent> implements Serializable {
    private static final long serialVersionUID = 233L;

    // 返回内容类型的classPath
    private String contentClass;
    // 返回内容
    private Content content;
    // 继续请求，非null表示还有更多内容，需要继续请求
    private String continueRequestId;

    public ReplyObject(Class<? extends Content> clazz) {
        this.contentClass = clazz.getCanonicalName();
    }

    public static String toJSONString(ReplyObject<?> o){
        return JSON.toJSONString(o);
    }

    public static ReplyObject<?> parseObject(String jsonString){
        try {
            return JSON.parseObject(jsonString,ReplyObject.class);
        }catch (Exception e){
            return null;
        }
    }
}
