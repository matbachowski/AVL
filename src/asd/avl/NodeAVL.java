package asd.avl;

public class NodeAVL<V> implements INodeAVL<V>{

    INodeAVL<V> m_ojciec;
    INodeAVL<V> m_lewy;
    INodeAVL<V> m_prawy;
    V m_wartosc;
    int m_height;

    public NodeAVL(V wartosc) {
        m_wartosc = wartosc;
    }

    @Override
    public INodeAVL<V> getOjciec() {
        return m_ojciec;
    }

    @Override
    public void setOjciec(INodeAVL<V> ojciec) {
        m_ojciec = ojciec;
    }

    @Override
    public INodeAVL<V> getLewy() {
        return m_lewy;
    }

    @Override
    public void setLewy(INodeAVL<V> lewy) {
        m_lewy = lewy;
    }

    @Override
    public INodeAVL<V> getPrawy() {
        return m_prawy;
    }

    @Override
    public void setPrawy(INodeAVL<V> prawy) {
        m_prawy = prawy;
    }

    @Override
    public V getWartosc() {
        return m_wartosc;
    }

    @Override
    public void setWartosc(V wartosc) {
        m_wartosc = wartosc;
    }

    @Override
    public int getHeight() {
        return m_height;
    }

    @Override
    public void setHeight(int balance) {
        m_height = balance;
    }
}
