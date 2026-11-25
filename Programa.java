public class Programa {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        AuxiliarMain auxiliar = new AuxiliarMain(sistema);

        auxiliar.executar();
    }
}
