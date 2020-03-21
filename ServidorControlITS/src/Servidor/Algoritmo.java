package Servidor;

import javax.swing.WindowConstants;

public class Algoritmo {
    int dato1;
    int dato2;
    String operador;
    PIC pic;
    
    public Algoritmo(String Com){
        pic = new PIC();
        pic.configurar(Com);
    }    
    
    public void algoritmo(int dato1, int dato2, int operador){
        
        switch(operador){
            case 1:
                String resultadoAND = rellenarCeros(metodoAND(dato1, dato2));
                pic.enviar(resultadoAND);
                break;
                
            case 2:
                String resultadoOR = rellenarCeros(metodoOR(dato1, dato2));
                pic.enviar(resultadoOR);
                break;
                
            case 3:
                String resultadoXOR = rellenarCeros(metodoXOR(dato1, dato2));
                pic.enviar(resultadoXOR);
                break;
        }
    }
    
    //Rellenamos los 0's al enviar la informacion al PIC
    public static String rellenarCeros(int num){
        String r = String.format("%03d", num);
        return r;
    }
    
    public int metodoAND(int a, int b){
        int r = a & b;
        return r;
    }
    
    public int metodoOR(int a, int b){
        int r = a | b;
        return r;
    }
    
    public int metodoXOR(int a, int b){
        int r = a ^ b;
        return r;
    }
}
