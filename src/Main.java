import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        //Vértices
        grafo.adicionarVertice("Foz do Iguacu");
        grafo.adicionarVertice("Pato Branco");
        grafo.adicionarVertice("Cascavel");
        grafo.adicionarVertice("Campo Mourao");
        grafo.adicionarVertice("Maringa");
        grafo.adicionarVertice("Guarapuava");
        grafo.adicionarVertice("Londrina");
        grafo.adicionarVertice("Uniao da Vitoria");
        grafo.adicionarVertice("Irati");
        grafo.adicionarVertice("Ponta Grossa");
        grafo.adicionarVertice("Curitiba");

        //Arestas
        grafo.adicionarAresta("Foz do Iguacu", "Cascavel", 140);
        grafo.adicionarAresta("Foz do Iguacu", "Pato Branco", 337);

        grafo.adicionarAresta("Pato Branco", "Guarapuava", 188);

        grafo.adicionarAresta("Cascavel", "Uniao da Vitoria", 414);
        grafo.adicionarAresta("Cascavel", "Guarapuava", 332);
        grafo.adicionarAresta("Cascavel", "Campo Mourao", 195);

        grafo.adicionarAresta("Campo Mourao", "Guarapuava", 206);
        grafo.adicionarAresta("Campo Mourao", "Maringa", 91);

        grafo.adicionarAresta("Guarapuava", "Londrina", 318);
        grafo.adicionarAresta("Guarapuava", "Ponta Grossa", 163);
        grafo.adicionarAresta("Guarapuava", "Irati", 104);

        grafo.adicionarAresta("Maringa", "Londrina", 98);

        grafo.adicionarAresta("Londrina", "Ponta Grossa", 274);

        grafo.adicionarAresta("Uniao da Vitoria", "Irati", 123);
        grafo.adicionarAresta("Uniao da Vitoria", "Curitiba", 241);

        grafo.adicionarAresta("Irati", "Curitiba", 154);

        grafo.adicionarAresta("Ponta Grossa", "Curitiba", 114);

        String inicio = "Foz do Iguacu";
        String fim = "Uniao da Vitoria";

        List<String> caminho = grafo.aStar(inicio, fim);

        if (caminho != null) {
            System.out.println("Caminho encontrado:");
            for (String no : caminho) {
                if(!no.equals(fim))
                    System.out.print(no + " -> ");
                else
                    System.out.print(no);
            }
        } else {
            System.out.println("Caminho não encontrado.");
        }

    }
}
