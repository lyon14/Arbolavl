import java.util.Scanner;
class AppAVL {
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
        ArbolAVL a = new ArbolAVL();
        int op=0;
        int salir=0;
        System.out.println("Bienvenido al menu");
        System.out.println("--------------------");
                
        while(salir<1){
            System.out.println("1.-Insertar 2.-Eliminar 3.-Modificar 4.-in_orden 5.-pre_orden 6.-post_orden 7.-Salir");
            op=scan.nextInt();
            if(op==1){
                int dato;
                System.out.println("Ingrese Dato: ");
                dato=scan.nextInt();
                a.insertar(dato);
            }
            if(op==4){
                a.inorden();
            }
            if(op==5){
                a.preorden();
            }
            if(op==6){
                a.postorden();
            }        
            if(op==7){
                System.out.println("Hasta luego.\n");
                salir = 1;
            }
        }
    }
    
    public static void main(String[] args){
        AppAVL clase = new AppAVL();
        clase.menu();
    }
}
