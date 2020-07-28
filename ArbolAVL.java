
class ArbolAVL {
    NodoAVL raiz;
    
    ArbolAVL(){
        raiz=null;
    }
    
    public void insertar(int d){
        NodoAVL nuevo = new NodoAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            if(nuevo.dato<raiz.dato){
                raiz.hIzq=insertar(nuevo.dato,raiz.hIzq);
            }else{
                raiz.hDer=insertar(nuevo.dato,raiz.hDer);
            }
        }
    }
    
    private NodoAVL insertar(int d, NodoAVL raiz){
        NodoAVL nuevo = new NodoAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            if(nuevo.dato<raiz.dato){
                raiz.hIzq=insertar(nuevo.dato,raiz.hIzq);
            }else{
                raiz.hDer=insertar(nuevo.dato,raiz.hDer);
            }
        }
        return raiz;
    }
    
    public void preorden(){
        if(raiz!=null){
            System.out.print(raiz.dato + "-");
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
        }
        System.out.println("");
    }
    
    private void preorden(NodoAVL raiz){
        if(raiz!=null){
            System.out.print(raiz.dato + "-");
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
        }
    }
    
    public void inorden(){
        if(raiz!=null){
            preorden(raiz.hIzq);
            System.out.print(raiz.dato + "-");
            preorden(raiz.hDer);
        }
        System.out.println("");
    }
    
    private void inorden(NodoAVL raiz){
        if(raiz!=null){
            preorden(raiz.hIzq);
            System.out.print(raiz.dato + "-");
            preorden(raiz.hDer);
        }
    }
    
    public void postorden(){
        if(raiz!=null){
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
            System.out.print(raiz.dato + "-");
        }
        System.out.println("");
    }
    
    private void postorden(NodoAVL raiz){
        if(raiz!=null){
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
            System.out.print(raiz.dato + "-");
        }
    }
    
}
