
public class NodoAVL {
    int dato, fe;
    String color;
    NodoAVL hIzq;
    NodoAVL hDer;
    
    NodoAVL(){
        this.hIzq=null;
        this.hDer=null;
    }
    NodoAVL(int dato){
        this.dato = dato;
        this.fe = 0;
        this.hIzq=null;
        this.hDer=null;
    }

    NodoAVL(int dato, String color) {
        this.dato = dato;
        this.color = color;
        
    }
    public boolean esHoja(){
        if((this.hIzq==null)&&(this.hDer==null)){
            return true;
        }else{
            return false;
        }
    }
}
