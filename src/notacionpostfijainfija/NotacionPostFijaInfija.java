
package notacionpostfijainfija;

import java.util.StringTokenizer;
import javax.swing.JLabel;

public class NotacionPostFijaInfija {
 public void analizar(String entrada,JLabel salida,JLabel Infija,JLabel Postfija) {

    
    //Depurar la expresion algebraica e ingresar al arreglo
    String expr = Espacios(entrada);// Se inserta espacios entre los operadores para poder separar los numeros
    
    int cont=0;
    StringTokenizer tokens= new StringTokenizer(expr," ");
    String[] arregloEntrada = new String[tokens.countTokens()];
    while(tokens.hasMoreTokens()){
        arregloEntrada[cont]=tokens.nextToken();
        cont++;
    }

    //Declaración de las pilas
    PilaEnlazada E = new PilaEnlazada(); //Pila entrada
    PilaEnlazada P = new PilaEnlazada(); //Pila temporal para operadores
    PilaEnlazada S = new PilaEnlazada(); //Pila salida

    //Añadir la array a la Pila de entrada (E)
    for (int i = arregloEntrada.length - 1; i >= 0; i--) {
      E.apilar(arregloEntrada[i]);
    }

    try {
      //Algoritmo Infijo a Postfijo
      while (!E.esVacia()) {
        switch (pref((String) E.cima())){
          case 1:
            P.apilar(E.desapilar());
            break;
          case 3:
          case 4:
          case 5:
            while(pref((String) P.cima()) >= pref((String) E.cima())) {
              S.apilar(P.desapilar());
            }
            P.apilar(E.desapilar());
            break; 
          case 2:
            while(!P.cima().equals("(")) {
              S.apilar(P.desapilar());
            }
            P.desapilar();
            E.desapilar();
            break; 
          default:
            S.apilar(E.desapilar()); 
        } 
      } 

      //Eliminacion de `impurezas´ en la expresiones algebraicas
      String infija = expr.replace(" ", "");
      String postfija = S.toString().replaceAll("[\\]\\[,]", "");

      //Mostrar resultados en la ventana
      Infija.setText(infija);
      Postfija.setText(postfija);

    }catch(Exception ex){ 
      salida.setText("Error en la expresión algebraica");
    }
  } 

  //Jerarquia de los operadores
  private static int pref(String operador) {
    int prf = 99;
    if (operador.equals("^")) prf = 5;
    if (operador.equals("*") || operador.equals("/")) prf = 4;
    if (operador.equals("+") || operador.equals("-")) prf = 3;
    if (operador.equals(")")) prf = 2;
    if (operador.equals("(")) prf = 1;
    return prf;
  }
  
  
  //Depurar expresión algebraica
  private static String Espacios(String entrada) {
    entrada = entrada.replaceAll("\\s+", ""); //Elimina espacios en blanco iniciales
    entrada = "(" + entrada + ")";
    String operadores = "+-*/()^";
    String str = "";
  
    //Deja espacios entre operadores para poder separarlos de los numeros
    for (int i = 0; i < entrada.length(); i++) {
      if (operadores.contains("" + entrada.charAt(i))) {
        str += " " + entrada.charAt(i) + " ";
      }else str += entrada.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

 
}
