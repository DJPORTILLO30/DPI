package com.danilo.portillo;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Usuario users[] = new Usuario[50];
        int contador = 0;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < 50; i++) {
            users[i] = new Usuario();

        }

        while (contador<=50){
            System.out.println("Ingrese DPI");
            users[contador].setDPI(teclado.nextInt());
            System.out.println("Ingrese Nombre");
            users[contador].setNombre(teclado.next());
            System.out.println("Ingrese Edad");
            users[contador].setEdad(teclado.nextInt());

            System.out.println("Desea ingresar un nuevo usuario? Y/N");
            String op = teclado.next();
            if (op.toUpperCase().equals("Y")){
                contador++;
            }else if(op.toUpperCase().equals("N"))
            {
                break;
            }
        }
        contador=contador+1;
        int dpis[] = new int[contador];
        String names[] = new String[contador];
        int edades[] = new int[contador];
        for (int o=0; o<contador;o++){
            dpis[o] = users[o].getDPI();
            names[o] = users[o].getNombre();
            edades[o] = users[o].getEdad();
        }
        ordenar(dpis,names,edades);

        int op = teclado.nextInt();
        while (op!=3){
            System.out.println("1.Mostrar todo");
            System.out.println("2.Buscar");
            System.out.println("3.Salir");


            if (op == 1){
                System.out.println("Todos los contenidos almacenados:");
                System.out.println("DPIs: " + Arrays.toString(dpis));
                System.out.println("Nombres: " + Arrays.toString(names));
                System.out.println("Edad: " + Arrays.toString(edades));
            }else if(op == 2){
                System.out.println("Ingrese valor a buscar");
                int buscar = teclado.nextInt();

                int posicion = busqueda(dpis,buscar);
                System.out.println("DPI: " + dpis[posicion] + " Nombre: " + names[posicion] + " Edad: " + edades[posicion]);
            }else {
                System.out.println("esa opcion no exisite");
            }

        }

        }



    public static int busqueda(int[] numbers, int numberToSearch) {

        int tam = numbers.length;
        int mitad = tam/2;


        if (numbers[mitad] == numberToSearch)
            return mitad;
        else if (tam == 1)
            return -1;
        else if (numbers[mitad] > numberToSearch)
            return busqueda(Arrays.copyOfRange(numbers,0,mitad),numberToSearch); //llamada recursiva
        else
            return busqueda(Arrays.copyOfRange(numbers,mitad+1,tam),numberToSearch);

    }




    public static void ordenar(int a[], String b[], int c[]) {
        int menor;

        for (int i = 0;i<a.length; i++) {

            menor = i;
            for (int j = i+1; j<a.length; j++) {
                if (a[j] < a[menor]) {
                    menor = j;
                }

            }
            if (i != menor) {
                cambio(a, i, menor, b ,c);
            }
        }
    }

    static void cambio(int[] DPIs, int i, int j, String Nombres[], int Edades[]) {
        int auxD = DPIs[i];
        String auxN = Nombres[i];
        int auxE = Edades[i];
        DPIs[i] = DPIs[j];
        DPIs[j] = auxD;
        Nombres[i] = Nombres[j];
        Nombres[j] = auxN;
        Edades[i] = Edades[j];
        Edades[j] = auxE;
    }







    }