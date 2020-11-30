package com.lf.test.admin.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
@Document(indexName = "pms", shards = 1, replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    private Long brandId;
    private Long productCategoryId;
    private Long productAttributeCategoryId;
    private String unit;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal marketPrice;
    private String description;
    private BigDecimal stockTotal;
    private BigDecimal weight;
    @Field(type = FieldType.Keyword)
    private String productSn;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String detailTitle;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String detailSubTitle;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String keyword;
    @Field(type = FieldType.Nested)     //嵌套对象类型
    private List<EsProductAttributeValue> attrValueList;


}