package com.ysmjjsy.goya.cojo.configuration.doc;

import io.swagger.v3.oas.models.Paths;

/**
 * 单独使用一个类便于判断 解决springdoc路径拼接重复问题
 *
 * @author Goya
 * @version 1.0
 * @since 2024/3/3 22:52
 */
public class PlusPaths extends Paths {

    public PlusPaths() {
        super();
    }
}
