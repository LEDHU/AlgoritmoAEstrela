import java.util.List;

public class Main {
    public static void main(String[] args) {
        AEstrela grafo = new AEstrela();

        //VERTICES

        Vertice FdI = new Vertice("Foz do Iguacu", -25.5468978, -54.5881716);
        Vertice PB = new Vertice("Pato Branco", -26.2294701, -52.6715615);
        Vertice Cas = new Vertice("Cascavel", -24.9554503, -53.4552361);
        Vertice CM = new Vertice("Campo Mourao", -24.0460254, -52.3838048);
        Vertice Mar = new Vertice("Maringa", -23.425734, -51.936864);
        Vertice Gua = new Vertice("Guarapuava", -25.393449, -51.456379);
        Vertice Lon = new Vertice("Londrina", -23.310404, -51.165469);
        Vertice UdV = new Vertice("Uniao da Vitoria", -26.2303886, -51.0866321);
        Vertice Ira = new Vertice("Irati", -25.467734, -50.651069);
        Vertice PG = new Vertice("Ponta Grossa", -25.094939, -50.163104);
        Vertice Cur = new Vertice("Curitiba", -25.440029, -49.276691);

        //ARESTAS

        //Foz do Iguacu
        FdI.adicionarAresta(new Aresta(Cas, 132));
        FdI.adicionarAresta(new Aresta(PB, 207));

        //Pato Branco
        PB.adicionarAresta(new Aresta(FdI, 207));
        PB.adicionarAresta(new Aresta(Gua, 154));

        //Cascavel
        Cas.adicionarAresta(new Aresta(FdI, 132));
        Cas.adicionarAresta(new Aresta(CM, 149));
        Cas.adicionarAresta(new Aresta(Gua, 207));
        Cas.adicionarAresta(new Aresta(UdV, 227));

        //Campo Mourao
        CM.adicionarAresta(new Aresta(Cas, 149));
        CM.adicionarAresta(new Aresta(Gua, 177));
        CM.adicionarAresta(new Aresta(Mar, 83));

        //Maringa
        Mar.adicionarAresta(new Aresta(CM, 83));
        Mar.adicionarAresta(new Aresta(Lon, 80));

        //Londrina
        Lon.adicionarAresta(new Aresta(Mar, 80));
        Lon.adicionarAresta(new Aresta(Gua, 236));
        Lon.adicionarAresta(new Aresta(PG, 226));

        //Guarapuava
        Gua.adicionarAresta(new Aresta(PB, 154));
        Gua.adicionarAresta(new Aresta(Cas, 207));
        Gua.adicionarAresta(new Aresta(CM, 177));
        Gua.adicionarAresta(new Aresta(Lon, 236));
        Gua.adicionarAresta(new Aresta(PG, 135));
        Gua.adicionarAresta(new Aresta(Ira, 82));

        //Uniao da Vitoria
        UdV.adicionarAresta(new Aresta(Cas, 227));
        UdV.adicionarAresta(new Aresta(Ira, 96));
        UdV.adicionarAresta(new Aresta(Cur, 202));

        //Irati
        Ira.adicionarAresta(new Aresta(UdV, 96));
        Ira.adicionarAresta(new Aresta(Gua, 82));
        Ira.adicionarAresta(new Aresta(Cur, 139));

        //Ponta Grossa
        PG.adicionarAresta(new Aresta(Lon, 226));
        PG.adicionarAresta(new Aresta(Gua, 135));
        PG.adicionarAresta(new Aresta(Cur, 98));

        //Curitiba
        Cur.adicionarAresta(new Aresta(PG, 98));
        Cur.adicionarAresta(new Aresta(Ira, 139));
        Cur.adicionarAresta(new Aresta(UdV, 202));

        grafo.adicionarVertice(FdI);
        grafo.adicionarVertice(PB);
        grafo.adicionarVertice(Cas);
        grafo.adicionarVertice(CM);
        grafo.adicionarVertice(Mar);
        grafo.adicionarVertice(Gua);
        grafo.adicionarVertice(Lon);
        grafo.adicionarVertice(UdV);
        grafo.adicionarVertice(Ira);
        grafo.adicionarVertice(PG);
        grafo.adicionarVertice(Cur);

        Vertice inicio = grafo.encontrarVertice("Foz do Iguacu");
        Vertice fim = grafo.encontrarVertice("Curitiba");

        if(inicio != null && fim != null) {

            List<Vertice> caminho = grafo.encontrarCaminho(inicio, fim);

            if(caminho != null) grafo.printar(caminho);

        }
        else System.out.println("Cidade não estar no grafo");

    }
}
