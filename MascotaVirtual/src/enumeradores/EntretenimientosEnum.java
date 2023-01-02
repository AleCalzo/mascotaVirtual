package enumeradores;

public enum EntretenimientosEnum {

    BAILAR (30), MORDER (50), JUGAR (80), LEER (10);


    private int desaburrimiento;

    EntretenimientosEnum (int desaburrimiento){
        this.desaburrimiento = desaburrimiento;
    }

    public int getDesaburrimiento(){
        return this.desaburrimiento;
    }
}
