/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorttimes;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import javax.swing.JTextField;
/**
 *
 * @author macuser
 */
public class SortHilo extends Thread{
    
    int Tipo; // 1 QuickSort, 2 Bubblesort, 3 shellSort
    int[] Arreglo;
    JTextField Caja;
    JTextField CMostrar;
    
    public SortHilo(int[] A, int Metodo, JTextField tTiempo, JTextField tMostrar)
    {
        Tipo = Metodo;
        Arreglo =A;
        Caja =tTiempo;
        CMostrar = tMostrar;
    }
    
    @Override
    public void run()
    {
        Instant start = Instant.now();
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
        Instant end = Instant.now();
        String time = Duration.between(start, end).toString();
        Caja.setText("time");
        CMostrar.setText(Arrays.toString(Arreglo));
        
    }
}
