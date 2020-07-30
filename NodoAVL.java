
public class NodoAVL {
    int dato, fe;
    String color,material;
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

    NodoAVL(int dato, String color,String material) {
        this.dato = dato;
        this.color = color;
        this.material = material;
        
    }
    public boolean esHoja(){
        if((this.hIzq==null)&&(this.hDer==null)){
            return true;
        }else{
            return false;
        }
    }
}
