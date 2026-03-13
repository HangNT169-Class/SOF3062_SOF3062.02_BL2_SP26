package com.poly.server.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {

    // BeanUtil => ten trong request se trung vs ten trong enttiy
    private String categoryName;

    private String categoryCode;


}
