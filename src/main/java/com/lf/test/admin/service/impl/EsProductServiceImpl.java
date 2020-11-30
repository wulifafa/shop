package com.lf.test.admin.service.impl;

import com.lf.test.admin.dao.EsProductDao;
import com.lf.test.admin.elasticsearch.document.EsProduct;
import com.lf.test.admin.elasticsearch.repository.EsProductRepository;
import com.lf.test.admin.service.EsProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
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
@Service
@Transactional
@Slf4j
public class EsProductServiceImpl implements EsProductService {

    @Autowired
    private EsProductRepository esProductRepository;
    @Autowired
    private EsProductDao esProductDao;

    @Override
    public int importAll() {
        List<EsProduct> esProductList=esProductDao.getProductEs(null);
        Iterable<EsProduct> iterable=esProductRepository.saveAll(esProductList);
        Iterator<EsProduct> iterabtor=iterable.iterator();
        log.info("导入es数据{}：",iterabtor);
        int count=0;
        while (iterabtor.hasNext()){
            count++;
            iterabtor.next();
        }
        return count;
    }

    @Override
    public void delete(Long id) {
        log.info("删除ES中的商品{}:",id);
        esProductRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        List<EsProduct> esProducts = esProductDao.getProductEs(id);
        if (CollectionUtils.isEmpty(esProducts)) {
            return null;
        }
        EsProduct esProduct = esProducts.get(0);
        log.info("导入ES单条商品{}:",esProduct);
        return esProductRepository.save(esProduct);
    }

    @Override
    public void deletes(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            ids.forEach(id->{
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            });
            log.info("批量删除ES中的商品{}:",esProductList);
            esProductRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> searchPage(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return esProductRepository.findByKeyword(keyword,keyword,keyword,pageable);
    }
}
