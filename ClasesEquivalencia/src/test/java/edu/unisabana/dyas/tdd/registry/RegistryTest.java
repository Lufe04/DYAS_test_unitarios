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
        Person person = new Person("Maria", 2, 54, Gender.FEMALE, true);
        //accion
        RegisterResult result = registry.registerVoter(person);
        //validar
        Assertions.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistryResultUnderage(){
        //preparar
        Person person = new Person("Lukas", 3, 17, Gender.MALE, true);
        //accion
        RegisterResult result = registry.registerVoter(person);
        //validar
        Assertions.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateRegistryResultDead(){
        Person person = new Person("Luisa", 4, 25, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateRegistryResultDuplicated(){
        Person person1 = new Person("Maria", 2, 54, Gender.FEMALE, true);
        RegisterResult result1 = registry.registerVoter(person1);
        
        Person person2 = new Person("Sebastian", 2, 20, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assertions.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test
    public void validateRegistryAge1(){
        Person person = new Person("Lukas", 5, 18, Gender.MALE, true);
        //accion
        RegisterResult result = registry.registerVoter(person);
        //validar
        Assertions.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validateRegistryAge2(){
        Person person = new Person("Lukas", 5, 119, Gender.MALE, true);
        //accion
        RegisterResult result = registry.registerVoter(person);
        //validar
        Assertions.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistryAge3(){
        Person person = new Person("Lukas", 5, 121,Gender.MALE, true);
        //accion
        RegisterResult result = registry.registerVoter(person);
        //validar
        Assertions.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
}