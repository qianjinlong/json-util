package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * 类功能说明
 *
 * @author qianjinlong
 * @email 1277977370@qq.com
 * @date 2021/10/25
 */
public class JsonUtil {
    public static Object readJsonFromClassPath(String path, Type type) throws IOException {

        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()) {
            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
                                    // 自动关闭流
                                    Feature.AutoCloseSource,
                                    // 允许注释
                                    Feature.AllowComment,
                                    // 允许单引号
                                    Feature.AllowSingleQuotes,
                                    // 使用 Big decimal
                                    Feature.UseBigDecimal);
        } else {
            throw new IOException();
        }
    }
}
