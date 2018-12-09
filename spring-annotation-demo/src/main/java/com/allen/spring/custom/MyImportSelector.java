package com.allen.spring.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by meng on 2018/12/1.
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //配置需要导入的类全类名，可导入多个
        return new String[]{"com.allen.spring.bean.Vegetable"};
    }
}
