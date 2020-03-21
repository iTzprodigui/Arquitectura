package Servidor;

import ColaPrioridad.Cola;
import ColaPrioridad.Nodo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Servidor {
    Thread mutiplesconexiones;
    ServerSocket servidor;
    Socket socket;
    int puerto=9000;
    PrintStream salida;
    BufferedReader entrada;
    Cola prioridad;
    
    private JTextArea textoInterfaz;
    
    public static void main(String[] args){
//    Servidor sv = new Servidor();
//        sv.encender();
    }
    
    public Servidor(Cola prioridad, JTextArea textoInterfaz){
        this.prioridad = prioridad;
        this.textoInterfaz = textoInterfaz;
    }
    
    public void encender(){
        try {
            //Iniciamos el servidor
            servidor = new ServerSocket(puerto);
            textoInterfaz.append("SERVIDOR\n");
            textoInterfaz.append("Servidor encendido\n");
            
//Datos enviados por consola
//            System.out.println("SERVIDOR");
//            System.out.println("Servidor Encendido");
            
            mutiplesconexiones = new Thread(){
                
            public void run(){
            do{
                try{
                    /*establecemos conexcion y esperamos algun cliente*/
                    socket = new Socket();
                    socket = servidor.accept();
                    
                    /*recibimos datos del cliente*/
                    entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String dato1 = entrada.readLine();
                    String dato2 = entrada.readLine();
                    String operador = entrada.readLine();
                    
                    /*le enviamos datos al cliente*/
                    salida = new PrintStream(socket.getOutputStream());
                    String mensajedelservidor = "Conexion exitosa desde el servidor";
                    salida.println(mensajedelservidor);
                    
                    //Mostramos mensajes del cliente
                    
                    //Mensajes por consola
                    prioridad.agregar(Integer.parseInt(dato1), Integer.parseInt(dato2), Integer.parseInt(operador));
                    prioridad.imprimir();
                    System.out.println("El operador es: "+operador);
                    
                    //Mensajes por interfaz
                    textoInterfaz.append("================\n" );
                    textoInterfaz.append("Dato 1: " + dato1 + "\n" );
                    textoInterfaz.append("Dato 2: " + dato2 + "\n" );
                    
                    //Mostramos el tipo de operador
                    if(operador.equals("1")){
                        textoInterfaz.append("Operador: AND \n" );    
                    }else if(operador.equals("2")){
                        textoInterfaz.append("Operador: OR \n" );    
                    }else if(operador.equals("3")){
                        textoInterfaz.append("Operador: XOR \n" ); 
                    }
                    textoInterfaz.append("================\n" );
                    
                    /*cerramos el Buffer de datos para esperar otro cliente*/
                    entrada.close();
                    salida.close();
                    Thread.sleep(100);
                }catch(Exception error){}
                    }while(true);
                }
            };
            mutiplesconexiones.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
