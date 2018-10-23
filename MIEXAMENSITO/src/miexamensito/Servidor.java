package miexamensito;
import java.io.*;
import java.net.*;

public class Servidor{

    public static void main(String[] args) {
        ServerSocket yo=null; 
        Socket cliente=null;
        BufferedReader entrada;
        DataOutputStream salida;
        String llego;
        int numll;
        try{
        yo= new ServerSocket(5000);
        System.out.println("El Servidor esta en linea");
        
        cliente=yo.accept();
        System.out.println("La conexion se ha establecido");
        
        entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        salida= new DataOutputStream(cliente.getOutputStream());
        do{
            llego=entrada.readLine();
            numll= new Integer(llego);
            if(numll%2==0){
                System.out.println("Llego el numero par: "+llego);

            }else   System.out.println("Llego el numero inpar: "+llego);

        }while(llego.length()!=0);
        
        System.out.println("La conexion ha finalizado");
        
        entrada.close();
        cliente.close();
        yo.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }   
    }
}