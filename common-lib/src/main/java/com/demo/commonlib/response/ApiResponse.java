package com.demo.commonlib.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
 private  boolean success;
 private String massage;
 private T data;
}
