package pres;

import metier.IGestion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "metier");
        IGestion gestion = (IGestion) context.getBean("gestion");
        System.out.println(gestion.calcul());
    }
}
