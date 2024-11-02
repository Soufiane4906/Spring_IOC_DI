package pres;

import dao.ICalcul;
import metier.IGestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class InstanciationDynamique {
    public static void main(String[] args) throws Exception{
        Scanner scanner= null;
        try {
            scanner = new Scanner(new File("src/main/resources/config.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
        String daoClassName=scanner.nextLine();
        Class cCalcul=Class.forName(daoClassName);
        ICalcul calcul=(ICalcul)cCalcul.getConstructor().newInstance();
        System.out.println(calcul.getValue());
        String metierClassName=scanner.nextLine();
        Class cGestion=Class.forName(metierClassName);
        IGestion gestion=(IGestion)cGestion.getConstructor().newInstance();
        Method m=cGestion.getMethod("setCal",ICalcul.class);
        m.invoke(gestion,calcul);
        System.out.println(gestion.calcul());
    }
}
