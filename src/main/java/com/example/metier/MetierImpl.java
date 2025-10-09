package com.example.metier;

import com.example.dao.IDao;
import com.example.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("metier")
public class MetierImpl implements IMetier {

    // metier/MetierImpl.java (optionnel: petite trace non intrusive)
    @PostConstruct
    private void init() {
        System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
    }

    @Autowired
    @Qualifier("dao2")  // Spécifie quelle implémentation de IDao utiliser
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
