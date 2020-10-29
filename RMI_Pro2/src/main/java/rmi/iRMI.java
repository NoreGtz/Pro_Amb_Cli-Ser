/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/* @author NoreGtz */
import java.rmi.*;

public interface iRMI extends Remote
{
    public String sumar(int n1, int n2, int n3, int n4)throws RemoteException;
    public String restar(int n1, int n2, int n3, int n4)throws RemoteException;
    public String multiplicar(int n1, int n2, int n3, int n4)throws RemoteException;
    public String dividir(int n1, int n2, int n3, int n4)throws RemoteException;
}
