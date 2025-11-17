import java.util.*;

public class ExamenUd2 {
    public static void main(String[] args) {
        /*
         * Gesstiona el inventario de smartphones
         * 
         * Datos de cada smartphone Marca, Modelo, Gama, Precio, Stock, RAM y SO
         * 
         * el sistema pide al usuario introducir un num de telfs (minimo 2 y max 40)
         * 
         * Leer y validar datos (Repetir hasta que los datos sean válidos)
         * 
         * Opciones
         * a) Listar marca y modelo de todos los telfs android con RAM >= 8gb y precio <
         * 400
         * b) Mostrar cuántos smartphones hay de cada gama y el precio medio de cada
         * gama
         * c) Identificar y guardar en un array los modelos con stock inferior a 5
         * unidades.
         * d) Del conjunto de smartphones Premium:
         * El más caro (marca, modelo y precio)
         * El que tiene más RAM
         * 
         * e) mostrar porcentaje del inventario corresponde a iOS vs Android
         * 
         */

        // definir las variables y los arrays
        // los arrays asi me vanaa permitir añadir nuevos datos en cada uno
        Scanner sc = new Scanner(System.in);
        String marca[] = new String[0];
        String newMarca[] = new String[marca.length + 1];
        String modelo[] = new String[0];
        String newModelo[] = new String[modelo.length + 1];
        String gama[] = new String[0]; // este solo puede tener 3 opciones Premium, MediaGama y Economico
        String newGama[] = new String[gama.length + 1];
        Double precio[] = new Double[0];
        Double newPrecio[] = new Double[precio.length + 1];
        int stock[] = new int[0];
        int newStock[] = new int[stock.length + 1];
        int ram[] = new int[0];
        int newRam[] = new int[ram.length + 1];
        String so[] = new String[0]; // solo puede ser o iOS o Android
        String newSo[] = new String[so.length + 1];

        String respuesta = "", infoString = "";
        int numTelf = 0, infoInt = 0;
        double infoDouble = 0;
        System.out.println("¿Cuantos smartphones desea añadir?");
        numTelf = sc.nextInt();

        if (numTelf >= 1 && numTelf <= 40) {
            for (int i = 0; i < numTelf; i++) {

                System.out.println("Para el smarthone numero " + (i + 1) + ": ");
                // Se lo pedimos al usuario
                System.out.println("Introduzca la marca: ");
                infoString = sc.nextLine();
                infoString = sc.nextLine();
                // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                // array
                for (int j = 0; j < marca.length; j++) {
                    newMarca[j] = marca[j];
                }

                // añadir nuevos datos
                newMarca[marca.length] = infoString;

                // convertimos el nuevo array en el default
                marca = newMarca;

                // repetimos con todos
                // Se lo pedimos al usuario
                System.out.println("Introduzca el modelo: ");
                infoString = sc.nextLine();
                // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                // array
                for (int j = 0; j < modelo.length; j++) {
                    newModelo[j] = modelo[j];
                }

                // añadir nuevos datos
                newModelo[modelo.length] = infoString;

                // convertimos el nuevo array en el default
                modelo = newModelo;

                // Se lo pedimos al usuario
                System.out.println("Introduzca la gama: ");
                infoString = sc.nextLine();

                if ((infoString.equalsIgnoreCase("Premium") || infoString.equalsIgnoreCase("MediaGama")
                        || infoString.equalsIgnoreCase("Economico"))) {

                    // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                    // array
                    for (int j = 0; j < gama.length; j++) {

                        newGama[j] = gama[j];
                    }

                    // añadir nuevos datos
                    newGama[gama.length] = infoString;

                    // convertimos el nuevo array en el default
                    gama = newGama;
                } else {
                    System.err.println("Valor no valido");
                }

                // Se lo pedimos al usuario
                System.out.println("Introduzca el Precio: ");
                infoDouble = sc.nextDouble();

                // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                // array
                for (int j = 0; j < precio.length; j++) {

                    newPrecio[j] = precio[j];
                }

                // añadir nuevos datos
                newPrecio[precio.length] = infoDouble;

                // convertimos el nuevo array en el default
                precio = newPrecio;

                // Se lo pedimos al usuario
                System.out.println("Introduzca el Stock: ");
                infoInt = sc.nextInt();

                // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                // array
                for (int j = 0; j < stock.length; j++) {

                    newStock[j] = stock[j];
                }

                // añadir nuevos datos
                newStock[stock.length] = infoInt;

                // convertimos el nuevo array en el default
                stock = newStock;

                // Se lo pedimos al usuario
                System.out.println("Introduzca la RAM: ");
                infoInt = sc.nextInt();

                if (infoInt == 4 || infoInt == 6 || infoInt == 8 || infoInt == 12 || infoInt == 16) {
                    // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                    // array
                    for (int j = 0; j < ram.length; j++) {

                        newRam[j] = ram[j];
                    }

                    // añadir nuevos datos
                    newRam[ram.length] = infoInt;

                    // convertimos el nuevo array en el default
                    ram = newRam;
                }

                // Se lo pedimos al usuario
                System.out.println("Introduzca el Sistema Operativo: ");
                infoString = sc.nextLine();
                infoString = sc.nextLine();

                if (infoString.equalsIgnoreCase("iOS") || infoString.equalsIgnoreCase("Android")) {
                    // Lo que estamos haciendo es recoger los nuevos datos y meterlos en el nuevo
                    // array
                    for (int j = 0; j < so.length; j++) {

                        newSo[j] = so[j];
                    }

                    // añadir nuevos datos
                    newSo[so.length] = infoString;

                    // convertimos el nuevo array en el default
                    so = newSo;
                }
            }

            do {
                // empezamos con las opciones creamos un menu para que pueda elegir el usuario
                System.out.println("¿Que quieres hacer?");
                System.out.println(
                        "a) Listar marca y modelo de todos los smartphones Android con RAM >= 8gb y precio inferior  a 400€");
                System.out.println("b) Mostrar cuantos smartphones hay de cada gama y el precio medio de cada gama");
                System.out.println("c) Identificar y guardar en un array los modelos inferior a 5 unidades");
                System.out.println("d) El conjunto de smartphones premium ");
                System.out.println("e) Mostrar el porcentaje del inventario total. ");
                System.out.println("Salir");

                respuesta = sc.nextLine();

                switch (respuesta) {
                    case "a":
                        // se miran cada movil que tenga so android que tenga mas de 8gb y que sea enor
                        // de 400€
                        // y se imprime por pantalla el modelo y la marca
                        System.out.println("Estos son los smartphones de RAM superio a 8GB y con precio inferior a 400");
                       
                        for (int i = 0; so[i] == "Android" && ram[i] >= 8 && precio[i] < 400; i++) {
                            System.out.println(marca[i] + modelo[i]);
                        }
                        break;
                    case "b":
                        // he creado un contador para cada gama y despues lo imprimo por pantalla
                        int contadorP = 0, contadorM = 0, contadorE = 0;
                        for (int i = 0; gama[i] == "Premium"; i++) {
                            contadorP += contadorP;
                        }
                        for (int i = 0; gama[i] == "MediaGama"; i++) {
                            contadorM += contadorM;
                        }
                        for (int i = 0; gama[i] == "Economico"; i++) {
                            contadorE += contadorE;
                        }
                        System.out.println("De la gama Premium hay " + contadorP + " smartphones, de la gama media hay "
                                + contadorM + " smartphones y de la gama economica hay " + contadorE + " smartphones");
                        // ahora la media de precios revisamos los precios de cada gama y hacemos la
                        // media (total/num)
                        int valorP = 0, valorM = 0, valorE = 0, mediaP, mediaM, mediaE;
                        for (int i = 0; gama[i] == "Premium"; i++) {
                            valorP += precio[i];
                            contadorP = 0;
                            contadorP++;
                        }
                        for (int i = 0; gama[i] == "MediaGama"; i++) {
                            valorM += precio[i];
                            contadorM = 0;
                            contadorM++;
                        }
                        for (int i = 0; gama[i] == "Economico"; i++) {
                            valorE += precio[i];
                            contadorE = 0;
                            contadorE++;
                        }
                        mediaP = (valorP / contadorP);
                        mediaM = (valorM / contadorM);
                        mediaE = (valorE / contadorE);

                        System.out.println("La media de precios de los PRemium son: " + mediaP);
                        System.out.println("La media de precios de los Medio son: " + mediaM);
                        System.out.println("La media de precios de los Economicos son: " + mediaE);
                        break;

                    case "c":
                        // revisar que posicion de stock es menor que 5 y el modelo se guarda en otro
                        // array nuevo
                        for (int i = 0; stock[i] < 5; i++) {
                            String Array[] = new String[0];
                            String newArray[] = new String[Array.length + 1];

                            for (int j = 0; j < marca.length; j++) {
                                newArray[j] = Array[j];
                            }

                            // añadir nuevos datos
                            newArray[Array.length] = modelo[i];

                            // convertimos el nuevo array en el default
                            Array = newArray;

                        }
                        break;
                    case "d":
                        // imprimir por pantalla el modelo marca y precio mas caro y el que tiene mas
                        // ram
                        int posicion = 0;

                        for (int i = 1; i < precio.length; i++) {
                            if (gama[i] == "Premium") {
                                if (precio[i] > precio[posicion]) {
                                    posicion = i;
                                }

                            }
                        }
                       System.out.println("El smartphone más caro es " + marca[posicion] + ", " + modelo[posicion]
                             + ", " + precio[posicion]);

               
                        for (int i = 1; i < precio.length; i++) {
                            if (gama[i] == "Premium") {
                                if (ram[i] > ram[posicion]) {
                                    posicion = i;
                                }

                            }
                        }
                        System.out.println("El smartphone con mas RAM es " + marca[posicion] + ", " + modelo[posicion]
                                + ", " + precio[posicion]);

                        break;

                    case "e":
                        // ver el procentaje correspondiente a ios vs android ( si 100% es el numero
                        // total de so cuanto es el contador de cada uno)
                        int contadorA = 0, contadorI = 0;
                        int porcentajeA, porcentajeI;
                        for (int i = 0; so[i] == "Android"; i++) {
                            contadorA += contadorA;
                        }
                        for (int i = 0; so[i] == "iOS"; i++) {
                            contadorI += contadorI;
                        }
                        porcentajeA = (contadorA * 100) / so.length;
                        porcentajeI = (contadorI * 100) / so.length;

                        System.out.println(" Los porcentajes son: ");
                        System.out.println("Android " + porcentajeA + "%");
                        System.out.println("iOS " + porcentajeI + "%");

                        break;
                        
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            } while (!respuesta.equalsIgnoreCase("Salir"));

        } else {
            System.out.println("Valor no válido");
        }

        sc.close();
    }
}
