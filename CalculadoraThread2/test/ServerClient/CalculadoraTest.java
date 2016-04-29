/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author viniciuscustodio
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of realizarAdicao method, of class Calculadora.
     */
    @Test
    public void testRealizarAdicao() {
        System.out.println("realizarAdicao");
        Calculadora instance = new Calculadora(1.0, 10.0);
        double expResult = 11.0;
        double result = instance.realizarAdicao();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of realizarSubtracao method, of class Calculadora.
     */
    @Test
    public void testRealizarSubtracao() {
        System.out.println("realizarSubtracao");
        Calculadora instance = new Calculadora(1.0, 10.0);
        double expResult = -9.0;
        double result = instance.realizarSubtracao();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of realizarMultiplicacao method, of class Calculadora.
     */
    @Test
    public void testRealizarMultiplicacao() {
        System.out.println("realizarMultiplicacao");
        Calculadora instance = new Calculadora(1.0, 10.0);
        double expResult = 10.0;
        double result = instance.realizarMultiplicacao();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of realizarDivisao method, of class Calculadora.
     */
    @Test
    public void testRealizarDivisao() {
        System.out.println("realizarDivisao");
        Calculadora instance = new Calculadora(1.0, 10.0);
        Double expResult = 1.0/10.0;
        Double result = instance.realizarDivisao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of realizarPotenciacao method, of class Calculadora.
     */
    @Test
    public void testRealizarPotenciacao() {
        System.out.println("realizarPotenciacao");
        Calculadora instance = new Calculadora(1.0, 10.0);
        double expResult = 1.0;
        double result = instance.realizarPotenciacao();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of realizarRaizQuadrada method, of class Calculadora.
     */
    @Test
    public void testRealizarRaizQuadrada() {
        System.out.println("realizarRaizQuadrada");
        Calculadora instance = new Calculadora(1.0, 10.0);
        double expResult = 1.0;
        double result = instance.realizarRaizQuadrada();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of realizarInverso method, of class Calculadora.
     */
    @Test
    public void testRealizarInverso() {
        System.out.println("realizarInverso");
        Calculadora instance = new Calculadora(1.0, 10.0);
        Double expResult = 1.0;
        Double result = instance.realizarInverso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
