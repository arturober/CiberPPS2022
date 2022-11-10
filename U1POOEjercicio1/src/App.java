/**
 * Crea la clase CuerpoFuncionario
con los campos salario y trienio (incremento salarial cada 3 años)
- Crea un constructor para inicializar las propiedades y getters/setters
- Crea un método que le pases los años que lleva un funcionario en activo y te devuelva el sueldo resultante (pruébalo)
Fórmula: (años/3)*trienio+salario
 */

public class App {
    public static void main(String[] args) throws Exception {
        CuerpoFuncionario cuerpo = new CuerpoFuncionario(1500, 100);
        int sueldo = cuerpo.calculaSueldo(12);
        System.out.println("Salario total 12 años: " + sueldo);
    }
}