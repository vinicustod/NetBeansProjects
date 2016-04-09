package ServerClient;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viniciuscustodio
 */
public class Calculadora {

    private double firstNumber;
    private double secondNumber;

    public Calculadora(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Calculadora(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double realizarAdicao() {
        return this.firstNumber + this.secondNumber;
    }

    public double realizarSubtracao() {
        return this.firstNumber - this.secondNumber;
    }

    public double realizarMultiplicacao() {
        return this.firstNumber * this.secondNumber;
    }

    public java.lang.Double realizarDivisao() {
        if (this.secondNumber == 0) {
            return null;
        }
        return this.firstNumber / this.secondNumber;
    }

    public double realizarPotenciacao() {
        if (this.secondNumber == 0) {
            return 1;
        }
        return pow(this.firstNumber, this.secondNumber);
    }

    public double realizarRaizQuadrada() {
        return sqrt(this.firstNumber);
    }

    public java.lang.Double realizarInverso() {
        if (this.firstNumber == 0) {
            return null;
        }
        return 1 / this.firstNumber;
    }

}
