/*
Vamos a crear un programa de mensajería, donde unas personas podrán enviar un
mensaje a otra persona. A continuación se definen las necesidades de cada
elemento:
● Mensaje:
○ asunto, String
○ Cuerpo, String
○ fechaEnvío, LocalDate
○ remitente, Persona
○ destinatario, Persona
● Persona:
○ nombre, String
○ mensajesRecibidos
○ mensajesEnviados
○ metodo enviarMensaje. Debe comprobar que el mensaje tiene asunto,
cuerpo y destinatario. Debe poner automáticamente el remitente y la fecha de
envío. Además, debe añadir el mensaje a los buzones correspondientes de
cada persona (mensajesRecibidos o mensajesEnviados). Los buzones
tendrán una capacidad de 5 mensajes. Si el buzón está lleno, no podrá
enviar o recibir ningún mensaje y se mostrará un error.
○ metodo borrarMensajeEnviadoMásAntiguo. Debe borrar el primer mensaje
que haya en el buzón (posición 0). Si el buzón está vacío dará un error. Se
deben reordenar todos los demás mensajes que haya en el buzón, es decir,
el que ocupara la posición 1 pasará a ocupar la posición 0, el que ocupara la
2, a la 1, etc.
○ metodo borrarMensajeRecibidoMásAntiguo. Misma lógica que el anterior
pero en el buzón de recibidos.
Realiza algunas pruebas de envío. Comprueba que los mensajes están en los
buzones correspondiente. Intenta enviar mensajes cuando los buzones están llenos.
 */

package Boletin4_3.Ejercicio2;


import Boletin4_3.Ejercicio2.Exception.MensajeException;
import MiEntradaSalida.MiEntradaSalida;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Bienvenido a Correos Ancio-----");
        System.out.println();
        System.out.println("Dime tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Escriba el destinatario");
        String destinatario = sc.nextLine();
        System.out.println("Escriba el asunto");
        String asunto = sc.nextLine();
        System.out.println("Escribe el cuerpo del mensaje");
        String cuerpo = sc.nextLine();

        Persona p = new Persona(nombre);
        Persona p2 = new Persona("Pepe");

        try {
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto,cuerpo,p2);
            p.enviarMensaje(asunto,cuerpo,p2);
        } catch (MensajeException e) {
            System.out.println(e.getMessage());;
        }

        try {
            p.borrarMensajeEnviadoMasAntiguo();
            p2.borrarMensajeRecibidoMasAntiguo();
            p.enviarMensaje(asunto,cuerpo,p2);
        } catch (MensajeException e) {
            System.out.println(e.getMessage());;
        }
    }


}
