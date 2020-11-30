package com.lf.test.admin.elasticsearch.repository;

import com.lf.test.admin.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface EsProductRepository  extends ElasticsearchRepository<EsProduct,Long>{

    /**
     * 搜索查询
     * @param name
     * @param detailTitle
     * @param keyword
     * @param page
     * @return
     */
    Page<EsProduct> findByKeyword(String name, String detailTitle, String keyword, Pageable page);
}
