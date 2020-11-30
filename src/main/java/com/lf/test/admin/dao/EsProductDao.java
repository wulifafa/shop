package com.lf.test.admin.dao;

import com.lf.test.admin.elasticsearch.document.EsProduct;

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
public interface EsProductDao {

    List<EsProduct> getProductEs(Long id);
}
