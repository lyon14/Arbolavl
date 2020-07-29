
class ArbolAVL {
    NodoAVL raiz;
    
    ArbolAVL(){
        raiz=null;
    }
    //obtener factor de equilibrio
    public int obtenerFE(NodoAVL x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //rotacion simple a la izquierda
    public NodoAVL rotacionIzquierda(NodoAVL c){
        NodoAVL auxiliar=c.hIzq;
        c.hIzq=auxiliar.hDer;
        auxiliar.hIzq=c;
        c.fe=Math.max(obtenerFE(c.hIzq), obtenerFE(c.hDer))+1;//obtiene el maximo
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hIzq), obtenerFE(auxiliar.hDer))+1;
        return auxiliar;
    }
    
    //rotacion simple derecha
    public NodoAVL rotacionDerecha(NodoAVL c){
        NodoAVL auxiliar=c.hDer;
        c.hDer=auxiliar.hIzq;
        auxiliar.hIzq=c;
        c.fe=Math.max(obtenerFE(c.hIzq), obtenerFE(c.hDer))+1;//obtiene el maximo
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hIzq), obtenerFE(auxiliar.hDer))+1;
        return auxiliar;
    }
    
    //rotacion doble a la der
    public NodoAVL rotacionDobleIzquierda(NodoAVL c){
        NodoAVL temporal;
        c.hIzq=rotacionDerecha(c.hIzq);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    
    //rotacion doble a la izq
    public NodoAVL rotacionDobleDerecha(NodoAVL c){
        NodoAVL temporal;
        c.hDer=rotacionIzquierda(c.hDer);
        temporal=rotacionDerecha(c);
        return temporal;
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
    
    private int buscaMayorMenores(NodoAVL raiz){
        while(raiz.hDer!=null){
            raiz=raiz.hDer;
        }
        return raiz.dato;
    }
    
    public void eliminar(int d){
        NodoAVL actual = new NodoAVL(d);
        if(raiz==null){
            System.out.println("El elemento no se encuentra");
        }else{
            if(actual.dato==raiz.dato){
                if(raiz.esHoja()){
                    raiz=null;
                }else{
                    if(raiz.hIzq==null&&raiz.hDer!=null){
                        raiz=raiz.hDer;
                    }else{
                        if(raiz.hIzq!=null&&raiz.hDer==null){
                            raiz=raiz.hIzq;
                        }else{
                            raiz.dato=buscaMayorMenores(raiz.hIzq);
                            raiz.hIzq=eliminar(raiz.dato,raiz.hIzq);
                        }
                    }
                }
            }else{
                if(actual.dato<raiz.dato){
                    raiz.hIzq =eliminar(actual.dato,raiz.hIzq);
                }else{
                    raiz.hDer =eliminar(actual.dato,raiz.hDer);
                }
            }
        }
    }
    
   private NodoAVL eliminar(int d, NodoAVL raiz){
        NodoAVL actual = new NodoAVL(d);
        if(raiz==null){
            System.out.println("El elemento no se encuentra");
        }else{
            if(actual.dato==raiz.dato){
                if(raiz.esHoja()){
                    raiz=null;
                }else{
                    if(raiz.hIzq==null&&raiz.hDer!=null){
                        raiz=raiz.hDer;
                    }else{
                        if(raiz.hIzq!=null&&raiz.hDer==null){
                            raiz=raiz.hIzq;
                        }else{
                            raiz.dato=buscaMayorMenores(raiz.hIzq);
                            raiz.hIzq=eliminar(raiz.dato,raiz.hIzq);
                        }
                    }
                }
            }else{
                if(actual.dato<raiz.dato){
                    raiz.hIzq =eliminar(actual.dato,raiz.hIzq);
                }else{
                    raiz.hDer =eliminar(actual.dato,raiz.hDer);
                }
            }
        }
        return raiz;
    }
    
}
