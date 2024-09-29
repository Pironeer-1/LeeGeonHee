package com.pironeer._th.global.service;

import com.pironeer._th.global.dto.response.result.ListResult;
import com.pironeer._th.global.dto.response.result.SingleResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseService {

    public static <T> SingleResult <T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

    public static <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        return result;
    }
}
