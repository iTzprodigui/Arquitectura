/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaPrioridad;

/**
 *
 * @author david
 */
public class Nodo {
    private int valor1, valor2;
    private Nodo siguiente;
    
    int prioridad;
    
    Nodo(int valor1, int valor2, int prioridad){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.prioridad = prioridad;
    }
    
    Nodo(){
    }
    
    public void Nodo(){
        this.valor1 = 0;
        this.valor2 = 0;
        this.siguiente = null;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    @Override
    public String toString() {
        return "Nodo{" + "valor1=" + valor1 + ", valor2= " + valor2 + ", prioridad=" + prioridad + '}';
    }
    
}
