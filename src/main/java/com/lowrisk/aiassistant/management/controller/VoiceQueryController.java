package com.lowrisk.aiassistant.management.controller;

import com.alibaba.fastjson.JSON;
import com.lowrisk.aiassistant.backend.reply.ReplyObject;
import com.lowrisk.aiassistant.backend.reply.contentType.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/voice-query")
public class VoiceQueryController extends BaseController {
    @RequestMapping("/test1")
    public String test1(
            String query, String token, String user
    ){
        ReplyObject<MeetingContent> reply = new ReplyObject<>();
        MeetingContent content = new MeetingContent();
        content.setEmail("pravez@pravez.com");
        content.setName("国家主席");
        content.setTitle("全国代表大会");
        content.setMeetingUrl("MeetingURL");
        reply.setContent(content);
        reply.setContentClass(MeetingContent.class.getCanonicalName());
        reply.setContinueRequestId(UUID.randomUUID().toString());
        return JSON.toJSONString(reply);
    }
    @RequestMapping("/test2")
    public String test2(
            String query, String token, String user
    ){
        ReplyObject<PlainTextContent> reply = new ReplyObject<>(PlainTextContent.class);
        PlainTextContent content = new PlainTextContent();
        content.setText("衣阿华刚给你额那你弄让然年后哦让你或或或或或或或或或或或或或女死偶女肉所女红女若或过女若过in人际关机恩柔咯饥挼弄个机构iron三个");
        reply.setContent(content);
        content.setTitle("纯文本标题");
        reply.setContinueRequestId(UUID.randomUUID().toString());
        return JSON.toJSONString(reply);
    }


    @RequestMapping("/test3")
    public String test3(
            String query, String token, String user
    ){
        ReplyObject<ImageContent> reply = new ReplyObject<>(ImageContent.class);
        ImageContent content = new ImageContent();
        content.setImageUrl("https://i0.hdslb.com/bfs/article/438b21a5e0d5c25ebbe618b01df93c32d55a09ee.png");
        content.setTitle("蕾姆标题");
        reply.setContent(content);
        reply.setContinueRequestId(UUID.randomUUID().toString());
        return JSON.toJSONString(reply);
    }

    @RequestMapping("/test4")
    public String test4(
            String query, String token, String user
    ){
        ReplyObject<HyperlinkContent> reply = new ReplyObject<>(HyperlinkContent.class);
        HyperlinkContent content = new HyperlinkContent();
        content.setUrl("https://www.baidu.com");
        content.setTitle("百度");
        reply.setContent(content);
        reply.setContinueRequestId(UUID.randomUUID().toString());
        return JSON.toJSONString(reply);
    }
    @RequestMapping("")
    public String query(
            String query, String token, String user
    ){
        if(query .contains("图片"))
            return test3(query,token,user);
        else if(query.contains("文"))
            return test2(query,token,user);
        else if(query.contains("会议"))
            return test1(query,token,user);
        else if(query.contains("百度"))
            return test4(query,token,user);
        else return null;
    }



}
