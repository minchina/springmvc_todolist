package com.tw.todolist.utils;

import com.tw.todolist.domain.ClassA;
import com.tw.todolist.domain.ClassB;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ClassAtoClassBMapper {

    private MapperFactory mapperFactory;

    public ClassAtoClassBMapper() {
        testMapMethod();
    }

    private void testMapMethod(){

        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(ClassA.class, ClassB.class)
                .mapNulls(false).mapNullsInReverse(false)
                .field("name", "fullName")
                .byDefault()
                .register();
    }

    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
