package views;

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

  public Scanner resetTeclado() {
    teclado = new Scanner(System.in);
    return teclado;
  }

  public static IO getInstance() {
    if (instance == null) instance = new IO();
    return instance;
  }
}
