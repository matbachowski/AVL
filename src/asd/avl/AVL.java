//package asd.avl;
//
//public class AVL {
//}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asd.avl;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author Marcin
 */
public class AVL<T extends Comparable<T>> implements IBST<T> {

    INodeAVL<T> korzen;

    public AVL() {
    }

    /**
     * Zwraca korzeń drzewa
     * @return
     */
    public INodeAVL<T> getKorzen() {
        return this.korzen;
    }

    /**
     * Zwraca węzeł zaierający określoną wartość
     * @param node korzeń danego poddrzewa
     * @param wartosc szukana wartość
     * @return węzeł zawierający wartość
     */
    INodeAVL<T> znajdz(INodeAVL<T> node, T wartosc) {
        if (node == null || node.getWartosc().equals(wartosc)) {
            return node;
        }
        if (node.getWartosc().compareTo(wartosc) > 0) {
            return znajdz(node.getLewy(), wartosc);
        } else {
            return znajdz(node.getPrawy(), wartosc);
        }
    }

    /**
     * Sprawdza czy w drzewie jest określona wartość
     * @param wartosc
     * @return
     */
    @Override
    public boolean czyJest(T wartosc) {
        INodeAVL<T> val = znajdz(korzen, wartosc);
        return val == null ? false : true;
    }

    /**
     * Zwraca węzeł zawierający wartość minimalną
     */
    private INodeAVL<T> minimum(INodeAVL<T> node) {
        while (node.getLewy() != null) {
            node = node.getLewy();
        }
        return node;
    }

    /**
     * Zwraca wartość minimalną w drzewie
     * @return
     */
    @Override
    public T minimum() {
        INodeAVL<T> mi = minimum(korzen);
        return mi.getWartosc();
    }

    /**
     * Zwraca węzeł zawierający wartość maksymalną
     * @param node
     * @return
     */
    private INodeAVL<T> maksimum(INodeAVL<T> node) {
        while (node.getPrawy() != null) {
            node = node.getPrawy();
        }
        return node;
    }

    /**
     * Zwraca wartość maksymalną w drzewie
     * @return
     */
    @Override
    public T maksimum() {
        INodeAVL<T> mx = maksimum(korzen);
        return mx.getWartosc();
    }

    /**
     * Zwraca węzeł zawierajacy następną wartość w drzewie
     * @param node
     * @return
     */
    private INodeAVL<T> nastepnik(INodeAVL<T> node) {
        if (node.getPrawy() != null) {
            return minimum(node.getPrawy());
        }
        INodeAVL<T> nastepnik = node.getOjciec();
        while (nastepnik != null &&
                nastepnik.getPrawy().getWartosc().equals(node.getWartosc()) &&
                nastepnik.getWartosc().compareTo(node.getWartosc()) > 0) {
            node = nastepnik;
            nastepnik = node.getOjciec();
        }
        return nastepnik;
    }

    /**
     * Zwraca następna wartość
     * @return
     */
    public T nastepnik() {
        return nastepnik(korzen).getWartosc();
    }

    /**
     * Wstawia nowa wartośc do drzewa i dokonuje jego zbalansowania
     * @param wartosc
     */
    @Override
    public void wstaw(T wartosc) {
        INodeAVL<T> node = wstawAndReturn(wartosc); //Wstaw nowy węzeł zgodnie z regulą BST
        zbalansuj(node); //Jeśli trzeba dokonaj zbalansowania drzewa
    }

    /**
     * Zwraca węzeł zawierajacy wartość T
     * @param wartosc
     * @return
     */
    protected INodeAVL<T> wstawAndReturn(T wartosc) {
        //ToDo
        INodeAVL<T> newNode = new NodeAVL<T>(wartosc);

        if (korzen == null)
        {
            korzen = newNode;
            return newNode;
        }
        INodeAVL<T> node = korzen;
        while (node != null)
        {
            if (node.getWartosc().compareTo(wartosc) == 0) break;
            if (node.getWartosc().compareTo(wartosc) > 0)
            {
                node.setLewy(newNode);
                return node;
            }
            if (node.getWartosc().compareTo(wartosc) < 0)
            {
                node.setPrawy(newNode);
                return node;
            }
        }
        return node;
    }

    /**
     * Balansowanie drzewa
     * @param node
     * @return
     */

    protected int wspolczynnikBalansu(NodeAVL<T> node) {
        if (node == null) return -1;
        return node.getLewy().getHeight() - node.getPrawy().getHeight();
    }

    protected INodeAVL<T> zbalansuj(INodeAVL<T> node) {
        //Tu wstaw kod odpowiedialny za balansowanie
        if (node.getLewy().getHeight() - node.getPrawy().getHeight() > 1)
        {
            if (node.getLewy().getLewy().getHeight() - node.getLewy().getPrawy().getHeight() >= 0)
            {
                rotateRight(node);
                return node;
            }
            else if (node.getLewy().getLewy().getHeight() - node.getLewy().getPrawy().getHeight() == -1)
            {
                leftRotate(node.getLewy());
                rotateRight(node);
            }
        }
        if (node.getLewy().getHeight() - node.getPrawy().getHeight() < -1)
        {
            if(node.getPrawy().getLewy().getHeight() - node.getPrawy().getPrawy().getHeight() <= 0)
            {
                leftRotate(node);
                return node;
            }
            else if(node.getPrawy().getLewy().getHeight() - node.getPrawy().getPrawy().getHeight() == 1)
            {
                rotateRight(node.getPrawy());
                leftRotate(node);
                return node;
            }
        }
        return node;
    }

    /**
     * Implementacja obrotu w prawo
     * @param node - węzał wymagający zbalansowania
     * @return
     */
    protected INodeAVL<T> rotateRight(INodeAVL<T> node) {
        //ToDo
        //Jeżeli node jest null zwróć null
        //W przeciwnym wypadku dokonaj obrotu.
        //Obrót nastąpi wokół węzła lewego
        //Po identyfikacji następców dokonaj aktualizacji ojców.
        //Pamiętaj aby sprawdzić czy przypadkiem węzeł główny nie jest korzeniem, jesli tak dokonaj aktualizacji korzenia
        //Jako wynik zwróc węzeł lewy
        //Pamiętaj o aktualizacji wysokości
        NodeAVL<T> node2 = (NodeAVL<T>) node.getLewy();
        NodeAVL<T> node3 = (NodeAVL<T>) node2.getPrawy();

        node2.setLewy(node);
        node.setPrawy(node3);
        return node2;
    }

    /**
     * Implementacja obrotu w lewo
     * @param node - węzał wymagający zbalansowania
     * @return
     */
    protected INodeAVL<T> leftRotate(INodeAVL<T> node) {
        //ToDo
        //Jeżeli node jest null zwróć null
        //W przeciwnym wypadku dokonaj obrotu.
        //Obrót nastąpi wokół węzła prawego
        //Po identyfikacji następców dokonaj aktualizacji ojców.
        //Pamiętaj aby sprawdzić czy przypadkiem węzeł główny nie jest korzeniem, jesli tak dokonaj aktualizacji korzenia
        //Jako wynik zwróc węzeł prawy
        //Pamiętaj o aktualizacji wysokości
        NodeAVL<T> node2 = (NodeAVL<T>) node.getPrawy();
        NodeAVL<T> node3 = (NodeAVL<T>) node2.getLewy();

        node2.setLewy(node);
        node.setPrawy(node3);
        return node2;
    }

    /***
     * Funkcja służy do aktualizacji ojców w poszczególnych węzłach.
     * Do wykorzystania po identyfikacji które węzły będą podlegały obrotowi
     * @param node - główny węzeł bazowy
     * @param nastepca - węzeł wokół którego następuje obrót
     * @param nastepca2 - węzeł podrzędny do węzła obracanego
     */
    protected void aktualizujOjcow(INodeAVL<T> node, INodeAVL<T> nastepca, INodeAVL<T> nastepca2){
        INodeAVL<T> ojciec = node.getOjciec();
        if (ojciec != null) {
            if (ojciec.getLewy() == node) {
                ojciec.setLewy(nastepca);
            } else if (ojciec.getPrawy() == node) {
                ojciec.setPrawy(nastepca);
            }
            nastepca.setOjciec(node.getOjciec());
            node.setOjciec(nastepca);
            if (nastepca2 != null) nastepca2.setOjciec(node);
        }
    }

    /**
     * Funkcja zwraca wysokość węzła i obsługuje przypadek gdy node==null
     */
    protected int wysokosc(INodeAVL<T> node) {
        //Jeżeli node jest null to zwróc 0, w przeciwnym wypadku zwróc wysokość
        return (node == null) ?  0 : node.getHeight();
    }

    /**
     * Funkcja zwraca wartośc balansu i obsługuje przypadek gdy node==null
     */
    protected int balans(INodeAVL<T> node) {
        //Jeżeli node jest null to zwróć 0, a przeciwnym wypadku oblicz balans
        return (node == null) ? 0 : wysokosc(node.getLewy()) - wysokosc(node.getPrawy());
    }

    /**
     * Generuje listę stringów do wyświetlenia począwszy od węzła wezel
     * @param wezel
     * @return
     */
    private List<String> wypisz(INodeAVL<T> wezel) {
        List<String> s = new ArrayList<String>();
        if (wezel == null) return s;
        s.add("wartosc = " + wezel.getWartosc());
        if (wezel.getLewy() != null) {
            List<String> tmpList = wypisz(wezel.getLewy());
            tmpList.set(0, "--L:" + tmpList.get(0));
            for (int i = 1; i < tmpList.size(); i++) {
                tmpList.set(i, "---" + tmpList.get(i));
            }
            s.addAll(tmpList);
        }
        if (wezel.getPrawy() != null) {
            List<String> tmpList = wypisz(wezel.getPrawy());
            tmpList.set(0, "--P:" + tmpList.get(0));
            for (int i = 1; i < tmpList.size(); i++) {
                tmpList.set(i, "---" + tmpList.get(i));
            }
            s.addAll(tmpList);
        }
        return s;
    }

    /**
     *  Zwraca string opisujący drzewo
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        List<String> ss = wypisz(korzen);
        ss.stream().forEach((t) -> {
            s.append(t + "\n");
        });
        return s.toString();
    }
}
