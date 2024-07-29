package com.heyder.DemoApp.contollers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
//@AllArgsConstructor
@NoArgsConstructor
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Test {



    public Test(String m) {
        System.out.println(m);
    }
}
