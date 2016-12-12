import edu.ifs.estruturaDadosII.ArvoreAvl;
import edu.ifs.estruturaDadosII.No;
import edu.ifs.estruturaDadosII.NoNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreAvlTest {
    private No noA,noB,noC,noD,noE,noF,noG;
    private ArvoreAvl tree;

    @Before
    public void start(){
        noA = new No(1);
        noB = new No(2);
        noC = new No(3);
        noD = new No(4);
        noE = new No(5);
        noF = new No(6);
        noG = new No(7);
        tree = new ArvoreAvl();
    }
    @Test
    public void inserirCrescenteTest() throws Exception {
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),null);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);
    }
    @Test
    public void inserirCrescenteTodosTest() throws Exception {
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);
        tree.inserir(noE);
        tree.inserir(noF);
        tree.inserir(noG);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),noD);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getDireita(),noF);
        assertEquals(noD.getEsquerda(),noB);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getDireita(),null);
        assertEquals(noE.getEsquerda(),null);

        assertEquals(noF.getPai(),noD);
        assertEquals(noF.getDireita(),noG);
        assertEquals(noF.getEsquerda(),noE);

        assertEquals(noG.getPai(),noF);
        assertEquals(noG.getDireita(),null);
        assertEquals(noG.getEsquerda(),null);
    }
    @Test
    public void inserirDecrescenteTest() throws Exception {
        tree.inserir(noC);
        tree.inserir(noB);
        tree.inserir(noA);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),null);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);
    }
    @Test
    public void inserirDecrescenteTodosTest() throws Exception {
        tree.inserir(noG);
        tree.inserir(noF);
        tree.inserir(noE);
        tree.inserir(noD);
        tree.inserir(noC);
        tree.inserir(noB);
        tree.inserir(noA);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),noD);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getDireita(),noF);
        assertEquals(noD.getEsquerda(),noB);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getDireita(),null);
        assertEquals(noE.getEsquerda(),null);

        assertEquals(noF.getPai(),noD);
        assertEquals(noF.getDireita(),noG);
        assertEquals(noF.getEsquerda(),noE);

        assertEquals(noG.getPai(),noF);
        assertEquals(noG.getDireita(),null);
        assertEquals(noG.getEsquerda(),null);
    }
    @Test
    public void inserirAleatorioTest() throws Exception {
        tree.inserir(noC);
        tree.inserir(noA);
        tree.inserir(noB);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),null);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);
    }
    @Test
    public void inserirAleatorioTodosTest() throws Exception {
        tree.inserir(noD);
        tree.inserir(noG);
        tree.inserir(noC);
        tree.inserir(noF);
        tree.inserir(noA);
        tree.inserir(noE);
        tree.inserir(noB);


        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),noD);
        assertEquals(noB.getDireita(),noC);
        assertEquals(noB.getEsquerda(),noA);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),null);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getDireita(),noF);
        assertEquals(noD.getEsquerda(),noB);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getDireita(),null);
        assertEquals(noE.getEsquerda(),null);

        assertEquals(noF.getPai(),noD);
        assertEquals(noF.getDireita(),noG);
        assertEquals(noF.getEsquerda(),noE);

        assertEquals(noG.getPai(),noF);
        assertEquals(noG.getDireita(),null);
        assertEquals(noG.getEsquerda(),null);
    }
    @Test
    public void inserirAleatorioIncompletaTest() throws Exception {
        tree.inserir(noD);
        tree.inserir(noG);
        tree.inserir(noC);
        tree.inserir(noF);
        tree.inserir(noA);
        tree.inserir(noE);


        assertEquals(noA.getPai(),noC);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noC.getPai(),noD);
        assertEquals(noC.getDireita(),null);
        assertEquals(noC.getEsquerda(),noA);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getDireita(),noF);
        assertEquals(noD.getEsquerda(),noC);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getDireita(),null);
        assertEquals(noE.getEsquerda(),null);

        assertEquals(noF.getPai(),noD);
        assertEquals(noF.getDireita(),noG);
        assertEquals(noF.getEsquerda(),noE);

        assertEquals(noG.getPai(),noF);
        assertEquals(noG.getDireita(),null);
        assertEquals(noG.getEsquerda(),null);
    }
    @Test
    public void localizarFolhaExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);

        assertEquals(tree.localizar(4),noD);

        assertEquals(noD.getPai(),noC);
        assertEquals(noD.getEsquerda(),null);
        assertEquals(noD.getDireita(),null);
    }
    @Test
    public void localizarNaoFolhaExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);

        assertEquals(tree.localizar(3),noC);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getEsquerda(),null);
        assertEquals(noC.getDireita(),noD);
    }
    @Test(expected = NoNotFoundException.class)
    public void localizarFolhaNaoExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);


        assertEquals(tree.localizar(4),noD);
    }
    @Test(expected = NoNotFoundException.class)
    public void localizarNaoFolhaNaoExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noD);

        assertEquals(tree.localizar(3),noC);
    }
    @Test
    public void removerFolhaExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);

        tree.remover(4);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getEsquerda(),null);
        assertEquals(noC.getDireita(),null);
    }
    @Test
    public void removerFolhaExiste2() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);
        tree.inserir(noE);

        tree.remover(3);

        assertEquals(noB.getPai(),null);
        assertEquals(noB.getEsquerda(),noA);
        assertEquals(noB.getDireita(),noD);

        assertEquals(noD.getPai(),noB);
        assertEquals(noD.getEsquerda(),null);
        assertEquals(noD.getDireita(),noE);
    }
    @Test
    public void removerRaiz() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);
        tree.inserir(noE);
        tree.inserir(noF);
        tree.inserir(noG);

        tree.remover(4);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),noC);
        assertEquals(noB.getEsquerda(),noA);
        assertEquals(noB.getDireita(),null);

        assertEquals(noC.getPai(),null);
        assertEquals(noC.getEsquerda(),noB);
        assertEquals(noC.getDireita(),noF);

        assertEquals(noF.getPai(),noC);
        assertEquals(noF.getEsquerda(),noE);
        assertEquals(noF.getDireita(),noG);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getEsquerda(),null);
        assertEquals(noE.getDireita(),null);

        assertEquals(noG.getPai(),noF);
        assertEquals(noG.getEsquerda(),null);
        assertEquals(noG.getDireita(),null);
    }
    @Test
    public void removerNaoFolha() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);
        tree.inserir(noE);
        tree.inserir(noF);
        tree.inserir(noG);

        tree.remover(6);

        assertEquals(noA.getPai(),noB);
        assertEquals(noA.getEsquerda(),null);
        assertEquals(noA.getDireita(),null);

        assertEquals(noB.getPai(),noD);
        assertEquals(noB.getEsquerda(),noA);
        assertEquals(noB.getDireita(),noC);

        assertEquals(noC.getPai(),noB);
        assertEquals(noC.getEsquerda(),null);
        assertEquals(noC.getDireita(),null);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getEsquerda(),noB);
        assertEquals(noD.getDireita(),noE);

        assertEquals(noE.getPai(),noD);
        assertEquals(noE.getEsquerda(),null);
        assertEquals(noE.getDireita(),noG);

        assertEquals(noG.getPai(),noE);
        assertEquals(noG.getEsquerda(),null);
        assertEquals(noG.getDireita(),null);
    }
    @Test
    public void removerNaoFolha2() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);
        tree.inserir(noD);
        tree.inserir(noE);
        tree.inserir(noF);
        tree.inserir(noG);
        No noH = tree.inserir(8);
        No noI = tree.inserir(9);
        No noJ = tree.inserir(10);

        tree.remover(8);

        assertEquals(noD.getPai(),null);
        assertEquals(noD.getEsquerda(),noB);
        assertEquals(noD.getDireita(),noG);

        assertEquals(noG.getPai(),noD);
        assertEquals(noG.getEsquerda(),noF);
        assertEquals(noG.getDireita(),noI);

        assertEquals(noF.getPai(),noG);
        assertEquals(noF.getEsquerda(),noE);
        assertEquals(noF.getDireita(),null);

        assertEquals(noE.getPai(),noF);
        assertEquals(noE.getEsquerda(),null);
        assertEquals(noE.getDireita(),null);

        assertEquals(noI.getPai(),noG);
        assertEquals(noI.getEsquerda(),null);
        assertEquals(noI.getDireita(),noJ);

        assertEquals(noJ.getPai(),noI);
        assertEquals(noJ.getEsquerda(),null);
        assertEquals(noJ.getDireita(),null);
    }
    @Test(expected = NoNotFoundException.class)
    public void removerNaoExiste() throws Exception{
        tree.inserir(noA);
        tree.inserir(noB);
        tree.inserir(noC);

        tree.remover(4);
    }

}

