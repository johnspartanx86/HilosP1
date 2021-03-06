/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorttimes;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * Runnable class to sort arrays of integers
 * <p>
 * It will use the method selected and print in the objects sent as parameters.
 * 
 * 
 * 
 * @author JuanChacon
 */
public class SortThread extends Thread{
    
    int Kind; // 1 QuickSort, 2 Bubblesort, 3 shellSort
    int[] Array;
    boolean State;
    JTextField ShowBoxTime;
    JTextPane ShowBoxArray;
    String time;
    frmShow forma;
    /**
     * 
     * @param A Array to sort
     * @param Metodo Selection of method, 1 for BubbleSort, 2 for ShellSort, 3 for QuickSort
     * @param tTiempo JTextField were the time is going to display.
     * @param tMostrar JTextPane were the sorted array is going to be displayed.
     */
    public SortThread(int[] A, int Metodo, JTextField tTiempo, JTextPane tMostrar, frmShow frm)
    {
        Kind = Metodo;
        Array =A;
        ShowBoxTime =tTiempo;
        ShowBoxArray = tMostrar;
        State=false;
        forma = frm;
    }
    public int GetKind()
    {
        return Kind;
    }
    
    public boolean GetState()
    {
        return State;
    }
    
    public String GetTime()
    {
       return time;
    }
    
    
    @Override
    public void run()
    {
        Instant start = Instant.now();
        switch(Kind)
        {
            case 3: //QuickSort
                int sz = Array.length;
                Sort.QuickSort(Array, 1, sz-1);
                break;
            case 1: //BubbleSort
                Sort.BubbleSort(Array);
                break;
            case 2: //ShellSort
                Sort.shellSort(Array);
                break;
                
        }
        Instant end = Instant.now();
        
        time = Duration.between(start, end).toString();
        forma.Fastest(ShowBoxTime,time);
        ShowBoxTime.setText(time);
        ShowBoxArray.setText(Arrays.toString(Array));
    }
}
