/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
/* @author NoreGtz */
/*------Librerías para RMI--------*/
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.text.DecimalFormat;

public class Server extends UnicastRemoteObject implements iRMI 
{
     /*------Constructor--------*/
    public Server() throws RemoteException 
    {
    /*------Llamar al constructor de la clase padre--------*/
        super();
    }
    
    DecimalFormat df = new DecimalFormat("#.00");
   /*------Implementación Método Suma--------*/
   @Override
        public String sumar(int nA1, int nA2, int nB1, int nB2) throws RemoteException 
        {   
            int nom, den;
            nom = ((nA1 * nB2) + (nA2 * nB1));
            den = (nA2 * nB2);
            double dec;
            dec = (double) nom/den;
            String deci = df.format(dec);
            String text = "Modo a/b: " + nom + "/" + den + "\nModo decimal: " + deci;
            return (text);
        }
    /*------Implementación Método Resta--------*/
        public String restar(int nA1, int nA2, int nB1, int nB2) throws RemoteException 
        {
            int nom, den;
            den = (nA2 * nB2);
            nom = ((nA1 * nB2) - (nA2 * nB1));
            double dec;
            dec = (double) nom/den;
            String deci = df.format(dec);
            String text = "Modo a/b: " +  nom + "/" + den + "\nModo decimal: " + deci;
            return (text);
        }
    /*------Implementación Método Multiplicación--------*/
        public String multiplicar(int nA1, int nA2, int nB1, int nB2) throws RemoteException 
        {
            int nom, den;
            den = (nA2 * nB2);
            nom = (nA1 * nB1);
            double dec;
            dec = (double) nom/den;
             String deci = df.format(dec);
            String text = "Modo a/b: " +  nom + "/" + den + "\nModo decimal: " + deci;
            return (text);
        }
    /*------Implementación Método División--------*/
        public String dividir(int nA1, int nA2, int nB1, int nB2) throws RemoteException 
        {
            int nom, den;
            nom = (nA1 * nB2);
            den = (nA2 * nB1);
            double dec;
            dec = (double) nom/den;
             String deci = df.format(dec);
            String text = "Modo a/b: " +  nom + "/" + den + "\nModo decimal: " + deci;
            return (text);
        }
   
    public static void main(String[] args) 
    {
        try 
        {
            Registry registro = LocateRegistry.createRegistry(9999);
            registro.rebind("mates", new Server());
            System.out.println("Servidor activo");
        }
        catch (RemoteException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
