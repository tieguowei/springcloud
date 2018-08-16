package com.hzcf.basic.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * <dl>
 * <dt>类名：com.hzcf.basic.pojo</dt>
 * <dd>描述: 结算单管理</dd>
 * <dd>创建时间：下午 15:52 2018/8/14 0014 </dd>
 * <dd>创建人：朱广伟</dd>
 * <dt>版本历史: </dt>
 * </dl>
 */

@Document(collection = "logs")
public class Logs implements Serializable{
    @Id
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
