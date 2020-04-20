package com.HACL.x00238219;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        String opc; int opcValidada;
        do{
            System.out.println(mainMenu());
            System.out.print("Opcion: ");opc=in.nextLine();
            try{
                opcValidada=Integer.parseInt(opc);
                switch (opcValidada){
                    case 1: calcularServicioProfesional(); break;
                    case 2: calcularPlazafija(); break;
                    case 3: System.out.println(CalculadoraImpuestos.mostrarTotal()); break;
                }
            }
            catch (NumberFormatException nfe){
                opcValidada=0;
                System.out.println("Ingrese una opción correcta");
            }
            System.out.println(" ");
        }while(opcValidada!=4);
    }

    static String mainMenu(){
        return "1. Servicio Profesional\n2. Plaza Fija\n" +
                "3. Mostrar Totales\n4. Salir";
    }

    static void calcularServicioProfesional(){
        boolean continuar; double salarioValidado = 0; int mesesContValidados=0;

        System.out.print("Ingrese su nombre: "); String nombre = in.nextLine();
        System.out.print("Ingrese su puesto: "); String puesto = in.nextLine();

        do{
            System.out.print("Ingrese su salario: "); String salario = in.nextLine();
            try{
                salarioValidado=Double.parseDouble(salario);
                continuar=true;
            }
            catch (NumberFormatException nfe){
                System.out.println("Datos invalidos!");
                continuar=false;
            }
        }while(!continuar);

        do{
            System.out.print("Ingrese sus meses contratados: "); String mesesContratados = in.nextLine();
            try{
                mesesContValidados=Integer.parseInt(mesesContratados);
                continuar=true;
            }
            catch (NumberFormatException nfe){
                System.out.println("Datos Invalidos!");
                continuar=false;
            }
        }while(!continuar);

        ServivicioProfesional emp = new ServivicioProfesional(nombre, puesto, salarioValidado, mesesContValidados);

        System.out.println("Su pago total es "+CalculadoraImpuestos.calcularPago(emp));

    }

    static void calcularPlazafija(){
        boolean continuar; double salarioValidado = 0; int extenValidada=0;

        System.out.print("Ingrese su nombre: "); String nombre = in.nextLine();
        System.out.print("Ingrese su puesto: "); String puesto = in.nextLine();

        do{
            System.out.print("Ingrese su salario: "); String salario = in.nextLine();
            try{
                salarioValidado=Double.parseDouble(salario);
                continuar=true;
            }
            catch (NumberFormatException nfe){
                System.out.println("Datos invalidos!");
                continuar=false;
            }
        }while(!continuar);

        do{
            System.out.print("Ingrese sus extensión: "); String extencion = in.nextLine();
            try{
                extenValidada=Integer.parseInt(extencion);
                continuar=true;
            }
            catch (NumberFormatException nfe){
                System.out.println("Datos Invalidos!");
                continuar=false;
            }
        }while(!continuar);

        PlazaFija emp = new PlazaFija(nombre, puesto, salarioValidado, extenValidada);

        System.out.println("Su pago total es "+CalculadoraImpuestos.calcularPago(emp));
    }
}
