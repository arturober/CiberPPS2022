public class CuerpoFuncionario {
    private int salarioBase;
    private int trienio;

    public CuerpoFuncionario(int salarioBase, int trienio) {
        this.salarioBase = salarioBase;
        this.trienio = trienio;
    }

    public int calculaSueldo(int anyos) {
        return (anyos/3)*trienio + salarioBase;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTrienio() {
        return trienio;
    }

    public void setTrienio(int trienio) {
        this.trienio = trienio;
    }
    
}