package com.poly.server.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponse {
    // response: du lieu tra ra => cac truong trong response se lay tu de bai
    // CAM THUA HOAC THIEU
    private String code;

    private String name;

}
