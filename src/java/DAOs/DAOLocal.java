package DAOs;

import Entidades.Local;
import java.util.ArrayList;
import java.util.List;

public class DAOLocal extends DAOGenerico<Local> {

    public DAOLocal() {
        super(Local.class);
    }

    public int autoIdLocal() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idLocal) FROM Local e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Local> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Local e WHERE e.nomeLocal LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Local> listById(int id) {
        return em.createQuery("SELECT e FROM Local e WHERE e.idLocal = :id").setParameter("id", id).getResultList();
    }

    public List<Local> listInOrderNome() {
        return em.createQuery("SELECT e FROM Local e ORDER BY e.nomeLocal").getResultList();
    }

    public List<Local> listInOrderId() {
        return em.createQuery("SELECT e FROM Local e ORDER BY e.idLocal").getResultList();
    }
    
    public List<Local> listInOrderId_nome(String nome) {
        return em.createQuery("SELECT e FROM Local e WHERE e.nomeLocal LIKE \"%" + nome + "%\" ORDER BY e.idLocal").getResultList();
    } 

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Local> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdLocal() + "-" + lf.get(i).getLocal());
        }
        return ls;
    }
}
