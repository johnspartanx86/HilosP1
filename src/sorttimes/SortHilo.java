/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorttimes;

import javax.swing.JTextField;
/**
 *
 * @author macuser
 */
public class SortHilo extends Thread{
    
    int Tipo; // 1 QuickSort, 2 Bubblesort, 3 shellSort
    int[] Arreglo;
    JTextField Caja;
    
    public SortHilo(int[] A, int Metodo, JTextField Control)
    {
        Tipo = Metodo;
        Arreglo =A;
        Caja =Control;
    }
    
    @Override
    public void run()
    {
        switch(Tipo)
        {
            case 3: //QuickSort
                int sz = Arreglo.length;
                Sort.quicksort(Arreglo, 1, sz-1);
                break;
            case 1: //BubbleSort
                Sort.BubbleSort(Arreglo);
                break;
            case 2: //ShellSh
                Sort.shellSort(Arreglo);
                break;
                
        }
        System.out.print("\nListo tipo:" +Tipo);
        Caja.setText("Se chingo el "+Tipo);
    }
}
