import java.io.*;
import java.util.ArrayList;
import java.util.List;
import PizzaParser;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class PizzaMain{

    public static void main(String args[]){
        // Se lanza el programa principal
        if(args.length> 0) {
            PizzaParser miPizza = new PizzaParser(args[0]);
            int numeroFilas = miPizza.getNumeroFilas();
            int numeroColumnas = miPizza.getNumeroColumnas();
            int numeroIngredientes = miPizza.getNumeroIngredientes();
            int numeroMaxCeldasPorcion = miPizza.getNumeroMaxCeldasPorcion();
            ArrayList<Integer> pizzaPlana = miPizza.getPizzaPlana();
            System.out.println("Caracteristicas: ");
            System.out.print("Numero de filas: "+ String.valueOf(numeroFilas));
            System.out.print("Numero de columnas: "+ String.valueOf(numeroColumnas));
            System.out.print("Numero de Ingredientes: "+ String.valueOf(numeroIngredientes));
            System.out.print("Numero de maximo de celdas por porcion: "+ String.valueOf(numeroMaxCeldasPorcion));
            System.out.println("Pizza aplanada : ");
            System.out.println(pizzaPlana.toString());
        }
    }
}