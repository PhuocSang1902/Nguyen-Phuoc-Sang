package com.customermanegement.practice1.repository;

import com.customermanegement.practice1.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Integer> {

}
