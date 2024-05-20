//package asd.avl;
//
//public interface INodeAVL {
//}

package asd.avl;

public interface INodeAVL<V> {
    //Zwraca węzeł ojca
    INodeAVL<V> getOjciec();

    //Ustawia węzeł ojca na dany węzeł
    void setOjciec(INodeAVL<V> ojciec);

    //Zwraca węzeł lewego syna
    INodeAVL<V> getLewy();

    //Ustawia węzeł lewego syna
    void setLewy(INodeAVL<V> lewy);

    //Zwraca węzeł prawego syna
    INodeAVL<V> getPrawy();

    //Ustawia węzeł prawego syna
    void setPrawy(INodeAVL<V> prawy);

    //Zwraca przechowywaną wartość
    V getWartosc();

    //Ustawia przechowywaną wartość
    void setWartosc(V wartosc);

    //Zwraca wysokość na której znajduje się dany węzeł
    int getHeight();

    //Ustawia wysokość na której znajduje się dany wezeł
    void setHeight(int balance);

}
