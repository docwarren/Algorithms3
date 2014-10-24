package TravellingSalesman;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by andrew on 24/10/14.
 */
public class GraphMaker {
    private BookFace graph;
    private String nodeFile;
    private String edgeFile;
    private BufferedReader br;

    public GraphMaker(String nodeFile, String edgeFile) throws FileNotFoundException {
        this.nodeFile = nodeFile;
        this.edgeFile = edgeFile;
        this.graph = new BookFace();
        this.getNodes();
        this.getEdges();
    }

    public BookFace getGraph() {
        return this.graph;
    }

    private void getNodes() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(this.nodeFile));
        try{
            String line;
            while( ( line = br.readLine() ) != null){
                String[] pAttr = line.split(",");
                Person p = new Person(pAttr);
                graph.addNode(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getEdges() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(this.edgeFile));
        try{
            String line;
            while( ( line = br.readLine() ) != null){
                String[] cons = line.split(",");
                Person left = graph.getNodeById(cons[0]);
                Person right = graph.getNodeById(cons[1]);
                this.graph.connect(left, right, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
