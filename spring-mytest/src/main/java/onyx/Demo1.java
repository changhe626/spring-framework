package onyx;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo1.class);
		UserService bean = context.getBean(UserService.class);
		System.out.println(bean);


	}

}
