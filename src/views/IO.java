package views;

import java.io.IOException;
import java.util.Scanner;

public class IO {
  private static IO instance = null;
  private Scanner teclado = null;

  private IO() {
    teclado = new Scanner(System.in);
  }

  public Scanner getTeclado() {
    return teclado;
  }

  public void splitter(int type) {
    switch (type) {
      case 1:
        System.out.println("<------------------------------------------>");
        break;
      case 2:
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        break;
    }
  }

  public void waitKey() {
    System.out.println("Presiona enter para continuar");
    try {
      System.in.read();
    } catch (IOException e) {}
  }

  public Scanner resetTeclado() {
    teclado = new Scanner(System.in);
    return teclado;
  }

  public static IO getInstance() {
    if (instance == null) instance = new IO();
    return instance;
  }
}
