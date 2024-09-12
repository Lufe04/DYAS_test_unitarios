package edu.unisabana.dyas.tdd.registry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistryTest {

    private Registry registry = new Registry();
    @Test
    public void validateRegistryResultInvalidAge() {
        // Preparar
        Person person = new Person("Jorge", 1, 120, Gender.MALE, true);
        // Accion
        RegisterResult result = registry.registerVoter(person);
        // Validar
        Assertions.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateRegistryResult(){
        //preparar
        Person person1 = new Person("Maria", 2, 54, Gender.FEMALE, true);
        //accion
        RegisterResult result1 = registry.registerVoter(person1);
        //validar
        Assertions.assertEquals(RegisterResult.VALID, result1);
    }

    @Test
    public void validateRegistryResultUnderage(){
        //preparar
        Person person2 = new Person("Lukas", 3, 17, Gender.MALE, true);
        //accion
        RegisterResult result2 = registry.registerVoter(person2);
        //validar
        Assertions.assertEquals(RegisterResult.UNDERAGE, result2);
    }

    @Test
    public void validateRegistryResultDead(){
        Person person3 = new Person("Luisa", 4, 25, Gender.FEMALE, false);
        RegisterResult result3 = registry.registerVoter(person3);
        Assertions.assertEquals(RegisterResult.DEAD, result3);
    }

    @Test
    public void validateRegistryResultDuplicated(){
        Person person1 = new Person("Maria", 2, 54, Gender.FEMALE, true);
        RegisterResult result1 = registry.registerVoter(person1);
        
        Person person4 = new Person("Sebastian", 2, 20, Gender.MALE, true);
        RegisterResult result4 = registry.registerVoter(person4);
        Assertions.assertEquals(RegisterResult.DUPLICATED, result4);
    }
    
}