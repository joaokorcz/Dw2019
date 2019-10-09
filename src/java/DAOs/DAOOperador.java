package DAOs;

import Entidades.Operador;
import java.util.ArrayList;
import java.util.List;

public class DAOOperador extends DAOGenerico<Operador> {

    public DAOOperador() {
        super(Operador.class);
    }

    public int autoIdOperador() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idOperador) FROM Operador e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Operador> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Operador e WHERE e.nomeOperador LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Operador> listById(int id) {
        return em.createQuery("SELECT e FROM Operador e WHERE e.idOperador = :id").setParameter("id", id).getResultList();
    }

    public List<Operador> listInOrderNome() {
        return em.createQuery("SELECT e FROM Operador e ORDER BY e.nomeOperador").getResultList();
    }

    public List<Operador> listInOrderId() {
        return em.createQuery("SELECT e FROM Operador e ORDER BY e.idOperador").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Operador> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdOperador() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
}
