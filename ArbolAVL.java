import java.util.Scanner;
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
    
    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr){
        NodoAVL nuevoPadre=subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.hIzq==null){
                subAr.hIzq=nuevo;
            }else{
                subAr.hIzq=insertarAVL(nuevo, subAr.hIzq);
                if((obtenerFE(subAr.hIzq)-obtenerFE(subAr.hDer)==2)){
                    if(nuevo.dato<subAr.hIzq.dato){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.dato>subAr.dato){
            if(subAr.hDer==null){
                subAr.hDer=nuevo;
            }else{
                subAr.hDer=insertarAVL(nuevo, subAr.hDer);
                if((obtenerFE(subAr.hDer)-obtenerFE(subAr.hIzq)==2)){
                    if(nuevo.dato>subAr.hDer.dato){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado ");
        }
        
        if((subAr.hIzq==null)&&(subAr.hDer!=null)){
            subAr.fe=subAr.hDer.fe+1;
        }else if((subAr.hDer==null)&&(subAr.hIzq!=null)){
            subAr.fe=subAr.hIzq.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hIzq), obtenerFE(subAr.hDer))+1;
        }
        return nuevoPadre;
    }
    
    //insertar normal
    public void insertar(int d, String color, String material){
        NodoAVL nuevo;
        nuevo = new NodoAVL(d,color,material);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
    }
    
    /*public void insertar(int d){
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
    }*/
    
    public void preorden(){
        if(raiz!=null){
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
        }
        System.out.println("");
    }
    
    private void preorden(NodoAVL raiz){
        if(raiz!=null){
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
        }
    }
    
    public void inorden(){
        if(raiz!=null){
            preorden(raiz.hIzq);
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
            preorden(raiz.hDer);
        }
        System.out.println("");
    }
    
    private void inorden(NodoAVL raiz){
        if(raiz!=null){
            preorden(raiz.hIzq);
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
            preorden(raiz.hDer);
        }
    }
    
    public void postorden(){
        if(raiz!=null){
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
        }
        System.out.println("");
    }
    
    private void postorden(NodoAVL raiz){
        if(raiz!=null){
            preorden(raiz.hIzq);
            preorden(raiz.hDer);
            System.out.print(raiz.dato+"-");
            System.out.print(raiz.color + "-");
            System.out.print(raiz.material + "-");
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
   
   public boolean modificar(int d){
       NodoAVL actual = new NodoAVL(d);
       if(raiz==null){
           System.out.println("El elemento no se encuentra");
           return false;
       }else{
           if(actual.dato==raiz.dato){
               System.out.println("El elemento se encuentra");
               return true;
           }else{
               if(actual.dato<raiz.dato){
                   return modificar(actual.dato,raiz.hIzq);
               }else{
                   return modificar(actual.dato,raiz.hDer);
               }
           }
       }
   }
   
   private boolean modificar(int d, NodoAVL raiz){
       Scanner scan = new Scanner(System.in);
       NodoAVL actual = new NodoAVL(d);
       if(raiz==null){
           System.out.println("El elemento no se encuentra");
           return false;
       }else{
           if(actual.dato==raiz.dato){
               System.out.println("El elemento se encuentra");
               System.out.println("Ingrese un nuevo valor para el nodo:");
               int modifi=scan.nextInt();
               raiz.dato=modifi;
               return true;
           }else{
               if(actual.dato<raiz.dato){
                   return modificar(actual.dato,raiz.hIzq);
               }else{
                   return modificar(actual.dato,raiz.hDer);
               }
           }
       }
   }
    
}
