package com.in28minutes.learn_spring_framework.examples.b0;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;

@Component
class NormalClass {
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}

@ComponentScan
public class BeanScopesLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(BeanScopesLauncherApplication.class)) {
			
			// Singleton은 default, 호출할 때마다 같은 instance를 반환한다
			System.out.println("Singleton");
			for (int i = 0; i < 3; i++) {
				System.out.println(context.getBean(NormalClass.class));
			}
			
			// Prototype은 호출할 때마다 새로운 instance를 생성한다
			System.out.println("Prototype");
			for (int i = 0; i < 3; i++) {
				System.out.println(context.getBean(PrototypeClass.class));
			}
			
			
//			Singleton
//			com.in28minutes.learn_spring_framework.examples.b0.NormalClass@3d34d211
//			com.in28minutes.learn_spring_framework.examples.b0.NormalClass@3d34d211
//			com.in28minutes.learn_spring_framework.examples.b0.NormalClass@3d34d211
//			Prototype
//			com.in28minutes.learn_spring_framework.examples.b0.PrototypeClass@7dc0f706
//			com.in28minutes.learn_spring_framework.examples.b0.PrototypeClass@4009e306
//			com.in28minutes.learn_spring_framework.examples.b0.PrototypeClass@43c1b556
		}
	}
}
