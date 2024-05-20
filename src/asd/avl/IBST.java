//package asd.avl;
//
//public interface IBST {
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.avl;

public interface IBST<V extends Comparable<V>> {
    //Najmniejsza wartość w drzewie
    V minimum();
    //Zwraca największą wartość w drzewie
    V maksimum();
    //Wstaw do drzewa wartość x
    void wstaw(V x);
    //Sprawdz czy w drzewie jest wartość x
    boolean czyJest(V x);
}