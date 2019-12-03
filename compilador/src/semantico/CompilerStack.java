//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho

package semantico;

import java.util.Stack;


public class CompilerStack {

    private Stack<Item> pilha = new Stack<>();

    /**
     * Insere um novo objeto no topo da pilha
     *
     * @param object Objeto a ser inserido
     */
    public void push(Object object) {
        pilha.push(new Item(object));
    }

    /**
     * Remove o objeto do topo da pilha
     */
    public Item remove(int index) {
        return this.pilha.remove(index);
    }

    public Item pop() {
        return this.pilha.pop();
    }

    public Item getLast() {
        return this.pilha.lastElement();
    }

    /**
     * Metodo responsável por pegar um objeto de um determinado enderaco
     *
     * @param index endereco
     * @return objeto
     */
    public Item get(int index) {
        return this.pilha.get(index);
    }

    public boolean empty() {
        return this.pilha.empty();
    }

    public void clear() {
        this.pilha.clear();
    }

    /**
     * Metodo responsável por pegar um elemento do topo e armazenar em uma determinada posicao
     *
     * @param indexTopo
     * @param newIndex
     */
    public void setFromTop(int indexTopo, int newIndex) {
//        if(indexTopo == newIndex){
//            return;
//        }
//        pilha.set(newIndex, pilha.remove(indexTopo));
        // TODO check if this actually makes sense?
    }

    public void set(int index, Item element) {
        this.pilha.set(index, element);
    }

    public int size() {
        return this.pilha.size();
    }

    /**
     * Metodo define se dois itens podem ser utilizados em operações matematicas
     *
     * @param item1 objeto 1
     * @param item2 objeto 2evt
     * @return 1 = OBJETOS DO TIPO INT | 2 = ALGUM OBJETO REAL | 3 = ALGUM
     * OBJETO REAL
     */
    public int canBeUsedInOperations(Item item1, Item item2) {
        int tipo1 = item1.getType();
        int tipo2 = item2.getType();

        // TIPO DOS DOIS OBJETOS IGUAIS, RETORNA QUALQUER UM
        if (tipo1 == tipo2) {
            return tipo1;

            // ALGUM OBJETO É DO TIPO REAL E O OUTRO DO TIPO INT, RETORNA REAL
        } else if (((tipo1 == TipoDeDado.TYPE_INT) && (tipo2 == TipoDeDado.TYPE_REAL))
                || ((tipo1 == TipoDeDado.TYPE_REAL) && (tipo2 == TipoDeDado.TYPE_INT))) {
            return TipoDeDado.TYPE_REAL;
        }

        // ALGUM DOS OBJETOS É DO TIPO STRING NÃO PODE SER UTILIZADO EM OPERACOES
        return TipoDeDado.TYPE_STRING;
    }

    static class TipoDeDado {

        public static final int TYPE_INT = 1;
        public static final int TYPE_REAL = 2;
        public static final int TYPE_STRING = 3;
        public static final int TYPE_BOOLEAN = 4;
    }
}
