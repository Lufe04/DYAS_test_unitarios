package edu.unisabana.dyas.tdd.registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Person> voters = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {
        // Verificar si el votante ya existe
        if (votersExistentes(p)) {
            return RegisterResult.DUPLICATED; 
        }
        // Verificar edad
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (p.getAge() >= 120) {
            return RegisterResult.INVALID_AGE;
        }
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        // Agregar a la lista si es válido
        voters.add(p);
        return RegisterResult.VALID;
    }

    private boolean votersExistentes(Person p) {
        for (Person voter : voters) {
            if (voter.getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    public List<Person> getValidVoters() {
        return voters;
    }

}
