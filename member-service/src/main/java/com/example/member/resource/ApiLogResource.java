package com.example.member.resource;

import com.example.member.log.entity.ApiRequest;
import com.example.member.log.repository.ApiRequestRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ApiLogResource {

    private ApiRequestRepository apiRequestRepository;

    @GetMapping(path = "/logs")
    public Page<ApiRequest> getMemberList(@QuerydslPredicate Predicate predicate, Pageable page) {
        return apiRequestRepository.findAll(predicate, page);
    }

    @Autowired
    public void setApiRequestRepository(ApiRequestRepository apiRequestRepository) {
        this.apiRequestRepository = apiRequestRepository;
    }
}
