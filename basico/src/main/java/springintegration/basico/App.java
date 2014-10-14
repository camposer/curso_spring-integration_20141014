package springintegration.basico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	holaMundoConFactory();
    	holaMundoConSpring();
    }

	private static void holaMundoConSpring() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HolaMundo hm = ctx.getBean("helloWorldImpl", HolaMundo.class);
		System.out.println(hm.saludar("Rodolfo"));
	}

	private static void holaMundoConFactory() {
        HolaMundo hm = HolaMundoFactory.createHolaMundo();
        System.out.println(hm.saludar("Rodolfo"));
	}
}
