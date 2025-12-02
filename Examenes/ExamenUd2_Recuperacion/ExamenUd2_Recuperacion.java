package ExamenUd2_Recuperacion;

import java.util.*;

public class ExamenUd2_Recuperacion {
    public static void main(String[] args) {
        /*
         * Primera parte
         * Se gestiona el inventario de pociones elaboradas en un laboratorio
         * se recogen los siguientes datos:
         * nombre; IngredienteP; Clase; Precio; Stock; NivelPureza %; Estabilidad;
         * minimo se pueden registrar 3 pociones y max 50
         * leer datos y validarlos
         */

        // definir variables
        Scanner sc = new Scanner(System.in);
        int total = 0, resInt = 0;
        String resString = "";
        double resDouble = 0;
        boolean correcto = false;
        // creamos contadores para cada clase y variables para la media
        int cura = 1, veneno = 1, encantamiento = 1;
        int mediaC = 0, mediaV = 0, mediaE = 0, precioC = 0, precioV = 0, precioE = 0;
        // para el apartado 4
        int posicion = 0;
        // para el apartado 5
        int contadorEst = 0, porcentajeEst = 0, porcentajIn = 0;
        // para el apartado 3
        String[] NuevoArray = new String[total];

        System.out.println(
                "Introduzca el número total de pociones que quiere añadir(mínimo son 3 pociones y como máximo son 50): ");
        total = sc.nextInt();

        if (total < 3 || total > 50) {
            System.out.println("Valor no válido");

        } else {
            String Nombre[] = new String[total];
            String IngredienteP[] = new String[total];
            String Clase[] = new String[total];
            double Precio[] = new double[total];
            int Stock[] = new int[total];
            int NivelPureza[] = new int[total];
            String Estabilidad[] = new String[total];

            for (int i = 0; i < total; i++) {
                System.out.println("Para la poción número " + (i + 1));
                System.out.println("Introduzca el nombre: ");
                resString = sc.nextLine();
                resString = sc.nextLine();
                Nombre[i] = resString;

                System.out.println("Introduzca el Ingrediente Pricipal: ");

                resString = sc.nextLine();
                IngredienteP[i] = resString;

                System.out.println("Introduzca la Clase: ");
                correcto = false;
                resString = sc.nextLine();

                if (resString.equalsIgnoreCase("Curativa") || resString.equalsIgnoreCase("Veneno")
                        || resString.equalsIgnoreCase("Encantamiento")) {
                    correcto = true;
                }
                while (correcto == false) {
                    System.out.println("Introduzca la Clase: ");
                    resString = sc.nextLine();

                    if (resString.equalsIgnoreCase("Curativa") || resString.equalsIgnoreCase("Veneno")
                            || resString.equalsIgnoreCase("Encantamiento")) {
                        correcto = true;
                    }
                }
                Clase[i] = resString;

                System.out.println("Introduzca el Precio por frasco: ");
                resDouble = sc.nextDouble();
                correcto = false;
                if (resDouble > 0) {
                    correcto = true;
                }
                while (correcto == false) {
                    System.out.println("Introduzca el Precio por frasco: ");
                    resDouble = sc.nextDouble();
                }
                Precio[i] = resDouble;

                System.out.println("Introduzca el Stock: ");
                resInt = sc.nextInt();
                correcto = false;
                if (resInt > 0) {
                    correcto = true;
                }
                while (correcto == false) {
                    System.out.println("Introduzca el Stock: ");
                    resInt = sc.nextInt();
                }
                Stock[i] = resInt;

                System.out.println("Introduzca el Nivel de pureza (en %) : ");
                resInt = sc.nextInt();
                correcto = false;
                if (resInt == 25 || resInt == 50 || resInt == 75 || resInt == 90 || resInt == 100) {
                    correcto = true;
                }
                while (correcto == false) {

                    System.out.println("Introduzca el Nivel de pureza (en %) : ");
                    resInt = sc.nextInt();
                    if (resInt == 25 || resInt == 50 || resInt == 75 || resInt == 90 || resInt == 100) {
                        correcto = true;
                    }

                }
                NivelPureza[i] = resInt;

                System.out.println("¿Es estable?");
                resString = sc.nextLine();
                resString = sc.nextLine();
                Estabilidad[i] = resString;

            }

            // Parte 2 una vez que ya funciona añadir datos vamos con los apartados

            // Hacer un menu
            do {
                System.out.println("----");
                System.out.println("");
                System.out.println("1. Listar inestables");
                System.out.println("2. Cuantas pociones hay de cada clase y su precio  medio");
                System.out.println("3.Añadir nuevo Array los nombres de las pociones cuyo stock sea inferior a 3");
                System.out.println("4.Decir de la clase Veneno la mas Cara y la que mayor pureza tiene");
                System.out.println("5. Mostrar  porcentaje del inventrio total corresponde a estables e inestables");
                System.out.println("0.salir");

                resInt = sc.nextInt();

                switch (resInt) {
                    case 1:
                        // Tego que leer todas las que sean inestables e imprimir las que tengan una
                        // pureza de 90 o superior, O que su precio sea > 50 y Stock > 10
                        for (int j = 0; j > total; j++) {
                            // el primer if es para que sepamos cuales son inestables
                            if (Estabilidad[j].equalsIgnoreCase("no")) {
                                if (NivelPureza[j] >= 90 || Precio[j] > 50 && Stock[j] > 10) { // el nivel de pureza y
                                    System.out.println(Nombre[j]);
                                }
                            }

                        }

                        break;

                    case 2:

                        for (int i = 0; i > total; i++) {
                            if (Clase[i].equalsIgnoreCase("Curativa")) {
                                cura++; // contador total
                                precioC += Precio[i]; // vamos registrando los precios para hacer la media
                            }

                            // asi 2 vesces mas
                            if (Clase[i].equalsIgnoreCase("Veneno")) {
                                veneno++;
                                precioV += Precio[i];
                            }
                            if (Clase[i].equalsIgnoreCase("Encantamiento")) {
                                encantamiento++;
                                precioE += Precio[i];
                            }
                        }
                        System.out.println(
                                "De la clase Curativa hay " + (cura - 1) + " de la clase Veneno hay " + (veneno - 1)
                                        + " de la clase Encantamiento hay" + (encantamiento - 1));
                        // para hacer el precio medio preciototal/ unidades
                        mediaC = precioC / cura;
                        mediaV = precioV / veneno;
                        mediaE = precioE / encantamiento;

                        System.out.println("La media de precio de la clase Cura es" + mediaC + " de la clase Veneno"
                                + mediaV + " De la clase Encantamiento " + mediaE);
                        break;
                    case 3:

                        for (int i = 0; i < total; i++) {
                            if (Stock[i] < 3) {
                                NuevoArray[i] = Nombre[i];

                            }
                        }

                        break;
                    case 4:

                        // hago un for que mire las posiciones una por una y las compare
                        for (int i = 1; i < Precio.length; i++) {
                            if (Clase[i].equalsIgnoreCase("Veneno")) {
                                if (Precio[i] > Precio[posicion]) {
                                    posicion = i;
                                }

                            }

                        }
                        System.out.println(
                                "La pocion mas cara es " + Nombre[posicion] + ", cuyo ingrediente principal es "
                                        + IngredienteP[posicion] + " y de precio " + Precio[posicion]);
                        for (int i = 1; i < Precio.length; i++) {
                            if (Clase[i].equalsIgnoreCase("Veneno")) {
                                if (NivelPureza[i] > NivelPureza[posicion]) {
                                    posicion = i;
                                }

                            }
                        }
                        System.out.println("La pocion con el nivel de pureza mas alto es " + Nombre[posicion]);
                        break;
                    case 5:

                        for (int i = 0; i > total; i++) {
                            if (Estabilidad[i].equalsIgnoreCase("si")) {
                                contadorEst++;
                            }
                        }
                        // calculo el porcentae de estables y luego le resto a 100 el numero que salga
                        // para el porcentaje de Inestables
                        porcentajeEst = contadorEst / total * 100;
                        porcentajIn = 100 - porcentajeEst;

                        System.out.println("El porcentaje de Estables es " + porcentajeEst + "% y el  de inestables es "
                                + porcentajIn);

                        break;
                    default:
                        // default
                        System.out.println("Opcion no valida");
                        break;
                }
            } while (resInt != 0); // mientras que el usuario no presione el 0 se sigue repitiendo el menu

        }
    }
}