package com.lf.test.admin.elasticsearch.document;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Data
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    //属性值id
    private Long id;
    //属性id
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    @Field(type = FieldType.Keyword)
    private String name;


}