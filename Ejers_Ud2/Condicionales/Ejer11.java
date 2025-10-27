package Condicionales;


import java.util.Date;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class Ejer11 {
    public static void main(String[] args) {
      /*
       * Utilizando la fecha actual del sistema para obtener el mes:
       * Si el mes ingresado es futuro este año, muestre: “Faltan X meses para [nombre del mes]”.
       * Si ya pasó, muestre: “[Nombre del mes] fue hace X meses”.Si es el mismo mes: “¡Estamos en [nombre del mes]!”
       * Usa un switch para convertir el número a nombre de mes. 
       * Después debe de sacar un mensaje poniendo los días que tiene dicho mes.
       */  

       //Aqui por lo que he visto necesitamos la utilidad Date para conseguir la fecha del sistema, el calendario es para obtener solo el mes de la fecha
       //Nota: Enero es el mes 0
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int actualMonth = cal.get(Calendar.MONTH);
    
    //Explicarle al usuario lo que hace el programa
        System.out.println("Programa Mes.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Deberá introducir el mes que quiera y el programa responderá con cuanto tiempo falta para que llegue.");
        System.out.println("");
        System.out.println("--------------------------------");

        Scanner sc = new Scanner(System.in);
        int askMonth = 0;
        int subs=0;
        System.out.println("Por favor, introduzca el mes (de forma numérica)");
        askMonth = sc.nextInt();

        //askMonth es un numero cualquiera y necesitamos que se convierta en el mes que quiere el usuario asi que vamos a utilizar el calendario
        Calendar userMonth = Calendar.getInstance();
        userMonth.set(Calendar.MONTH, askMonth - 1);
        userMonth.set(Calendar.DAY_OF_MONTH, 1);
        String userMonthName = "";

        //Hay que utilizar un switch para sacar el nombre del mes
        switch (userMonth.get(Calendar.MONTH)) {
            case 0: userMonthName = "Enero";break;
            case 1: userMonthName = "Febrero"; break;
            case 2: userMonthName = "Marzo" ; break;
            case 3: userMonthName = "Abril"; break;
            case 4: userMonthName = "Mayo"; break;
            case 5: userMonthName = "Junio"; break;
            case 6: userMonthName = "Julio"; break;
            case 7: userMonthName = "Agosto"; break;
            case 8: userMonthName = "Septiembre"; break;
            case 9: userMonthName = "Octubre"; break;
            case 10: userMonthName = "Noviembre"; break;
            case 11: userMonthName = "Diciembre"; break;
              
            default:
                System.err.println("Ese mes no existe");
                break;
        }

            askMonth -= 1;
            
        if (askMonth > actualMonth) {
             subs = askMonth - actualMonth;
            System.out.println("Faltan " + subs + " meses para " + userMonthName + ".");
        } else if (askMonth < actualMonth) {
             subs = actualMonth - askMonth;
            System.out.println(userMonthName + " fue hace " + subs + " meses.");
        } else {
            System.out.println("¡Estamos en " + userMonthName + "!");
        }

        userMonth.set(Calendar.DAY_OF_MONTH, 1);
        int days = userMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("El mes " + userMonthName+ " tiene " + days + " días");

           

        sc.close();
    }
}

