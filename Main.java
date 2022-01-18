import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Arquivo> arquivos = new ArrayList<>(Arrays.asList(
                new Arquivo(Arrays.asList("10", "11", "90")),
                new Arquivo(Arrays.asList("10", "11")),
                new Arquivo(Arrays.asList("10", "11", "65", "65", "90")),
                new Arquivo(Arrays.asList("10", "11", "65", "66")),
                new Arquivo(Arrays.asList("10", "11", "65", "65", "66", "90")),
                new Arquivo(Arrays.asList("10", "11", "65", "65", "66", "66", "90")),
                new Arquivo(Arrays.asList("10", "11", "65", "66", "90", "44")),
                new Arquivo(Arrays.asList("10", "11", "66", "90")),
                new Arquivo(Arrays.asList("10", "11", "65", "66", "90")),
                new Arquivo(Arrays.asList("65", "10", "90", "66", "11")) // elementos fora de ordem
        ));

        ArrayList<Layout> layouts = new ArrayList<>(Arrays.asList(
                FabricaDeLayout.cria(VersaoDoLayout.Um),
                FabricaDeLayout.cria(VersaoDoLayout.Dois),
                FabricaDeLayout.cria(VersaoDoLayout.Tres)
        ));

        layouts.forEach(layout -> {
            ValidadorDeLinhaLayout validadorLayout = new ValidadorDeLinhaLayout(layout);
            arquivos.forEach(arquivo -> {
                ResultadoDaValidacaoLinhaLayout resultado = validadorLayout.valida(arquivo);
                System.out.println("Lay:" + layout.getElementos() + " Obr:" + layout.getElementosObrigatorios() + " Arq:" + arquivo.getElementos() + " " + resultado.ehValido() + " " + resultado.getMensagensDeErro());
            });
            System.out.println();
        });

        // teste incluindo as linhas uma a uma
        Layout layoutTipoUm = FabricaDeLayout.cria(VersaoDoLayout.Um);
        ValidadorDeLinhaLayout validadorLayoutLinhaALinha = new ValidadorDeLinhaLayout(layoutTipoUm);
        validadorLayoutLinhaALinha.adicionaElementoAoArquivo("10");
        validadorLayoutLinhaALinha.adicionaElementoAoArquivo("11");
        validadorLayoutLinhaALinha.adicionaElementoAoArquivo("90");
        ResultadoDaValidacaoLinhaLayout resultado = validadorLayoutLinhaALinha.valida();
        System.out.println("Lay:" + layoutTipoUm.getElementos() + " Obr:" + layoutTipoUm.getElementosObrigatorios() + " Arq:" + validadorLayoutLinhaALinha.getArquivo().getElementos() + " " + resultado.ehValido() + " " + resultado.getMensagensDeErro());

//        ArrayList<String> memoria = new ArrayList<>();
//        try {
//            File myObj = new File("filename.txt");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                memoria.add(myReader.nextLine());
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        System.out.println("Acabou");
    }

//        try {
//            FileWriter myWriter = new FileWriter("filename.txt");
//            for (int i = 1; i <= 20000000; i++) {
//                myWriter.write("65222333444000960000000000000000000000000000000000000\n");
//            }
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
}