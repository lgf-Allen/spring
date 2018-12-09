package com.allen.spring.custom;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * Created by meng on 2018/12/1.
 */
public class MyTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //Obtains current classes annotation info
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> types = annotationMetadata.getAnnotationTypes();
        for (String type : types) {
            System.out.println("annotation type is ---->" + type);
        }
        // Filter component by component annotation type
        if(types.contains("org.springframework.stereotype.Controller")){
            return true;
        }

        //Obtains class info of current scanned classes
        ClassMetadata classMetadata= metadataReader.getClassMetadata();

        // 根据组件名称过滤
        //String name = classMetadata.getClassName();
        //System.out.println("----->" + name);
        // Filter component by component name.
        //if(name.contains("troller")){
        //    return true;
        //}

        //Obtains current class resource
        Resource resource = metadataReader.getResource();
        return false;
    }
}
