/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rkstrocalc;

import java.util.Stack;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
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
    
    public void clearPila(){
        pila.removeAllElements();
    }
    
    public void setSuma(){ operador = 1; }
    public void setResta(){ operador = 2; }
    public void setMultiplicacion(){ operador = 3; }
    public void setDivision(){ operador = 4; }
    public String getNegacion(){
        BigDecimal a = BigDecimal.valueOf(Double.parseDouble(pila.pop()));
        return a.negate().toString();
    }
    
    
    public void setOperando(String op){
        pila.push(op);
    }
    
    public String getResultado(String op){
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
        
        //return r.toString();
        return df.format(Double.parseDouble(r.toString()));
    }
    
}
