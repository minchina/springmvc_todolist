package org.tw.todo;

import com.tw.todolist.domain.ClassA;
import com.tw.todolist.domain.ClassB;
import com.tw.todolist.utils.ClassAtoClassBMapper;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapperTest {

    @Test
    public void Test1() {
        ClassA classA = new ClassA();
        classA.setName("maoningchuan");
        classA.setAge(null);

        ClassB classB = new ClassB();
        classB.setAge(13);

        ClassAtoClassBMapper classAtoClassBMapper = new ClassAtoClassBMapper();
        classAtoClassBMapper.getMapperFactory().getMapperFacade().map(classA, classB);
        System.out.println(classB.getFullName());
        System.out.println(classB.getAge());
    }

    @Test
    public void Test2(){
        ClassA classA = new ClassA();
        classA.setName("maoningchuan");
        classA.setAge(13);

        ClassB classB = new ClassB();
        classB.setFullName("maoningchuan");
        classB.setAge(13);

        int i = compare(classA, classB);

        assertThat(i, is(0));
    }

    @Test
    public void Test3() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> classB = Class.forName("com.tw.todolist.domain.ClassB");
        Field[] declaredFields = classB.getDeclaredFields();
        Field fullName = classB.getDeclaredField("fullName");
        Object newInstance = classB.newInstance();
        fullName.setAccessible(true);
        fullName.set(newInstance, "maoningchuan");
        System.out.println(fullName.get(newInstance));


    }


    private int compare(ClassA classA, ClassB classB) {
        return new CompareToBuilder()
                .append(classA.getName(), classB.getFullName())
                .append(classA.getAge(), classB.getAge())
                .toComparison();
    }
}
