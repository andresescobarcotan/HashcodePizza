import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
public class PizzaParser {
    /*
    * El objetivo de esta clase es el de parsear el fichero que pasen por entrada 
    * y devolver una estructura iterable que facilite la solucion del problema.
    */
    private  String FICHERO_PIZZA = "c_medium.in";
    private  int numeroFilas = 0;
    private  int numeroColumnas = 0;
    private  int numeroIngredientes = 0;
    private  int numeroMaxCeldasPorcion = 0;
    private  int numeroSetas = 0;
    private  int numeroTomates = 0;
    private final static String TOMATE = "T"; // Tomate sera 0 y Seta sera 1
    private ArrayList<Integer> pizzaPlana; 

    public int getNumeroIngredientes(){
        return numeroIngredientes;
    }
    
    public int getNumeroMaxCeldasPorcion(){
        return numeroMaxCeldasPorcion;
    }

    public int getNumeroFilas(){
        return numeroFilas;
    }

    public int getNumeroColumnas(){
        return numeroColumnas;
    }

    public ArrayList<Integer> getPizzaPlana(){
        return pizzaPlana;
    }

    public PizzaParser(String filename){
        this.FICHERO_PIZZA = filename;
        String linea = null;
        int lineaCounter = 0;
        boolean errorExtraccion = false;
        pizzaPlana = new ArrayList<Integer>();
        try{ 
            // Se ejecuta el FileReader
            FileReader miLectorPizzas = new FileReader(FICHERO_PIZZA);
            BufferedReader miLectorBuffered = new BufferedReader(miLectorPizzas); // Al leer por buffer hacemos una lectura mas efectiva
            System.out.println("Creacion finalizada");
            while(((linea = miLectorBuffered.readLine()) != null)&&!errorExtraccion) {
                if(lineaCounter==0){
                    // Si la linea es 0 hay que extraer las caracteristicas de la pizza
                    errorExtraccion = extraerCaracteristicasPizza(linea);
                } else {
                    aplanarPizza(lineaCounter-1, linea);
                }
                lineaCounter+=1; 
            }   
            miLectorBuffered.close();
        } catch (Exception e){
            System.out.println("Se ha producido una excepcion :"+ e.toString());
        }
    }
    
    private void aplanarPizza(int _numeroLinea, String _lineaMatriz){
        // Lo que hace esta funcion es aplanar la estructura de la pizza, eliminando caracteres 
        int numeroAuxiliar =  _numeroLinea*numeroColumnas;
        for(int i=0; i < _lineaMatriz.length(); i++){
            int posicionReal = i + numeroAuxiliar;
            if(String.valueOf(_lineaMatriz.charAt(i)).equals(TOMATE)){
                pizzaPlana.add(posicionReal, 0);
            } else {
                pizzaPlana.add(posicionReal, 1);
            }
        }
        
    }

    private boolean extraerCaracteristicasPizza(String _lineaCaracteristicas){
        boolean errorExtraccion = false;
        try {
           String[] caracteristicas = _lineaCaracteristicas.split(" ");
            numeroFilas = Integer.valueOf(caracteristicas[0]);
            numeroColumnas = Integer.valueOf(caracteristicas[1]);
            numeroIngredientes = Integer.valueOf(caracteristicas[2]);
            numeroMaxCeldasPorcion = Integer.valueOf(caracteristicas[3]);
        } catch (Exception e){
            System.out.println("Excepcion en extraerCaracteristicasPizza "+ e.toString());
            errorExtraccion = true;
        }
        return errorExtraccion;
    }

}

