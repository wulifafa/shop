package com.lf.test.admin.service;

import com.lf.test.admin.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

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
public interface EsProductService {

    /**
     * 从数据库中导入商品到ES
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deletes(List<Long> ids);

    /**
     * 根据关键字搜索
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> searchPage(String keyword, Integer pageNum, Integer pageSize);
}
