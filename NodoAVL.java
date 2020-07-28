
public class NodoAVL {
    int dato, fe;
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
    public boolean esHoja(){
        if((this.hIzq==null)&&(this.hDer==null)){
            return true;
        }else{
            return false;
        }
    }
}
