package enumeradores;

public enum AlmacenAlimentos {

    SOPA(15), ASADO(25), CHORIPAN(20), ENSALADA (10), PORORO(5); // Son los alimentos que podria comer una
                                                                // mascota, los numeros es la cantidad de energia que aportan.
    private int energiaAportada;


     AlmacenAlimentos (int energia){
        this.energiaAportada=energia;
    }

    public int getEnergiaAportada() {
        return energiaAportada;
    }
}
