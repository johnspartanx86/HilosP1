/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorttimes;
import java.util.Arrays;
import javax.swing.JTextPane;
/**
 * This collection contains three different ways to sort arrays of numbers
 *
 * 
 *
 * @author juan
 */
public class Sort{
  
   /**
    *QuickSort ordering method.
    * <p>
    * Its the fastest way to sort arrays. Its a recursive function.
    * @param A An unsorted unidimensional array on integers.
    * @param izq Left index of the array.
    * @param der Right index of the array.
    * 
    * @see Arrays, integer
    */
   public static void QuickSort(int A[], int izq, int der) {

  int pivote=A[izq]; 
  int i=izq; // i realiza la búsqueda de izquierda a derecha
  int j=der; // j realiza la búsqueda de derecha a izquierda
  int aux;
 
  while(i<j){            // mientras no se crucen las búsquedas
     while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
     while(A[j]>pivote) j--;         // busca elemento menor que pivote
     if (i<j) {                      // si no se han cruzado                      
         aux= A[i];                  // los intercambia
         A[i]=A[j];
         A[j]=aux;
     }
   }
   A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
   A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
   if(izq<j-1)
      QuickSort(A,izq,j-1); // ordenamos subarray izquierdo
   if(j+1 <der)
      QuickSort(A,j+1,der); // ordenamos subarray derecho
}
       
   
   
   public static void BubbleSort( int [ ] num )
{
     int j;
     boolean flag = true;   
     int temp;   

     while ( flag )
     {
            flag= false;    
            for( j=0;  j < num.length -1;  j++ )
            {
                   if ( num[ j ] > num[j+1] )   
                   {
                           temp = num[ j ];     
                           num[ j ] = num[ j+1 ];
                           num[ j+1 ] = temp;
                          flag = true;          
                  }
            }
      }
} 
 public static void shellSort(int A[]){
   int salto, aux, i;
   boolean cambios;
   for(salto=A.length/2; salto!=0; salto/=2){
           cambios=true;
           while(cambios){ // Mientras se intercambie algún elemento
                       cambios=false;
                       for(i=salto; i< A.length; i++) // se da una pasada
                               if(A[i-salto]>A[i]){ // y si están desordenados
                                     aux=A[i]; // se reordenan
                                     A[i]=A[i-salto];
                                     A[i-salto]=aux;
                                     cambios=true; // y se marca como cambio.
                               }
                        }
            }
}
}
