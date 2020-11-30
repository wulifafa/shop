package com.lf.test.admin.service;

import com.lf.test.admin.mbg.model.PmsBrand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Repository
public interface PmsBrandSercvcie {
    List<PmsBrand> getList(Integer pageNum,Integer pageSize);

    int insert(PmsBrand pmsBrand);

    int delete(Long id);

    int update(PmsBrand pmsBrand);
}
