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
public class Cola {
    private Nodo inicio;
    private Nodo ultimo;
    
    public void Lista(){
        inicio = null;
        ultimo = null;
    }
    
    public void agregar(int valor1, int valor2, int prioridad) {
        Nodo nuevo = new Nodo(valor1, valor2, prioridad);

        if (inicio == null) {
            inicio = ultimo = nuevo;
        } else {

            if (inicio.prioridad > prioridad) {
                nuevo.setSiguiente(inicio);
                inicio=nuevo;
            }else{
              Nodo ant=null;
              Nodo sig=inicio;
              while(sig!=null && prioridad>=sig.prioridad){
                  ant=sig;
                  sig=sig.getSiguiente();
              }
              nuevo.setSiguiente(sig);
              ant.setSiguiente(nuevo);
              if(sig==null){
                 ultimo=nuevo;
              }
            }
        }
    }

    public void eliminar(){
        inicio = inicio.getSiguiente();
    }

    public Nodo getInicio() {
        return inicio;
    }
    
    public void imprimir() {
        Nodo aux = inicio;
        do {
            System.out.println(aux);
            aux = aux.getSiguiente();
        } while (aux != null);

    }
    
}
