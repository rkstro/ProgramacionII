/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * NOTA:
 *      Cambiar a funciones separadas que haga suma, resta, multiplicacion y division
 */
package rkstrocalc;

import java.util.Stack;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Todas las operaciones relacionadas con una calculadora
 * @author rkstro
 */
public class Calculadora {
    private Stack<String> pila;
    private Stack<String> resultados;
    private int operador;
    
    public Calculadora(){
        pila = new Stack<String>();
        resultados = new Stack<String>();
        operador = 0;
    }

    /**
     *  Borra la informacion de la pila, que almacena los operandos
     */
    public void clearPila(){
        pila.removeAllElements();
    }

    /**
     * Setea operacion de Suma
     */
    public void setSuma(){
        if(pila.size()==2){
            String tmp = this.getResultadoBinary();
            System.out.println(tmp);
            this.setOperando(tmp);
        }
        operador = 1;
    }
    /**
     * Setea operacion de Resta
     */
    public void setResta(){
        if(pila.size()==2){
            String tmp = this.getResultadoBinary();
            System.out.println(tmp);
            this.setOperando(tmp);
        }
        operador = 2;
    }
    /**
     * Setea operacion de Multiplicaicion
     */
    public void setMultiplicacion(){
        if(pila.size()==2){
            String tmp = this.getResultadoBinary();
            System.out.println(tmp);
            this.setOperando(tmp);
        }
        operador = 3;
    }
    /**
     * Setea operacion de Division
     */
    public void setDivision(){
        if(pila.size()==2){
            String tmp = this.getResultadoBinary();
            System.out.println(tmp);
            this.setOperando(tmp);
        }
        operador = 4;
    }
    /**
     * Realiza la operacion de negar el operando existente.
     * Operacion Unaria
     * @return String con el operando negado
     */
    public String getNegacion(){
        if(pila.isEmpty())
            return "";
        else {
            BigDecimal a = BigDecimal.valueOf(Double.parseDouble(pila.pop()));
            return a.negate().toString();
        }
    }
    /**
     * Realiza la operacion de elevar al cuadro el operando existente.
     * Operacion Unaria
     * @return String con el operando al cuadrado
     */
    public String getSquare(){
        if(pila.isEmpty())
            return "";
        else {
            BigDecimal a = BigDecimal.valueOf(Double.parseDouble(pila.pop()));
            return a.pow(2).toString();
        }
    }
    /**
     * Realiza la operacion de raiz cuadrada del operando existente.
     * Operacion Unaria
     * @return String con la raiz cuadrada del operando
     */
    public String getSqrt(){
        if(pila.isEmpty())
            return "";
        else {
            return String.valueOf(Math.sqrt(Double.parseDouble(pila.pop())));
        }
    }
    /**
     * Guarda en una pila un operando
     * @param op String, del operando a guardar en la pila
     */
    public void setOperando(String op){
        if(op.length() != 0 && !op.isEmpty())
            pila.push(op);
    }
    /**
     * Obtiene el resultado de las operaciones binarias y guarda su resultado
     * en una pila.
     * @return String con el resultado y formato especifico.
     */
    public String getResultadoBinary(){
        if(pila.size() != 2)
            return "";
        else {
            BigDecimal a = BigDecimal.valueOf(Double.parseDouble(pila.pop()));
            BigDecimal b = BigDecimal.valueOf(Double.parseDouble(pila.pop()));
            BigDecimal r = BigDecimal.ZERO;

            switch(operador){
                case 1: //Suma
                    r = a.add(b);
                    break;
                case 2: //Resta
                    r = b.subtract(a);
                    break;
                case 3: //Multiplicacion
                    r = a.multiply(b);
                    break;
                case 4: //Division
                    r = b.divide(a, 10, RoundingMode.HALF_EVEN);
                    break;
            }

            resultados.push(r.toString());
            DecimalFormat df = new DecimalFormat("###.#######");
            //this.setOperando(df.format(Double.parseDouble(r.toString())));
            
            return df.format(Double.parseDouble(r.toString())).replace(',', '.');
        }
    }
    
}
