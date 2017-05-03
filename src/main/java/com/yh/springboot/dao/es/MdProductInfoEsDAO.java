package com.yh.springboot.dao.es;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yh.springboot.model.es.MdProductInfoIndex;

public interface MdProductInfoEsDAO extends ElasticsearchRepository<MdProductInfoIndex, String> {

//	@Query("{\"query\":{\"bool\":{\"should\":[{\"term\":{\"productCode\":\"?0\"}}]}}}")
	MdProductInfoIndex findByProductCode(String productCode);
}
