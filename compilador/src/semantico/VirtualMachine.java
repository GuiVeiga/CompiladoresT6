//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho

package semantico;

import com.sun.org.apache.xalan.internal.lib.ExsltMath;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class VirtualMachine {
    private int ponteiro;
    private CompilerStack pilha = new CompilerStack();
    private List<Instruction> instructions = new ArrayList<>();
    private List<String> listMessages = new ArrayList<String>();

    public VirtualMachine(List<Instruction> inst) {
        this.ponteiro = 1;
        this.instructions = inst;
    }

    /**
     * Metodo responsável por executar todas as instruções geradas por SemanticTable
     */
    public List<String> runVM() {
        for (Instruction instruction : instructions) {

            // Se for uma instrução de finalização não importa o restante
            if (instruction.getCode().equalsIgnoreCase("STP")) {
                STP();
                break;
            }
            executeInstruction(instruction);
        }
        return listMessages;
    }

    /**
     * Metodo responsável por executar uma instrução
     *
     * @param instruction instrução a ser executada
     */
    private void executeInstruction(Instruction instruction) {
        String action = instruction.getCode();

        switch (action) {
            case "ADD":
                ADD();
                break;
            case "DIV":
                DIV();
                break;
            case "MUL":
                MUL();
                break;
            case "MOD":
                MOD();
                break;
            case "POW":
                POW();
                break;
            case "SUB":
                SUB();
                break;
            case "ALB":
                ALB((int) instruction.getParameter().getObj());
                break;
            case "ALI":
                ALI((int) instruction.getParameter().getObj());
                break;
            case "ALR":
                ALR((int) instruction.getParameter().getObj());
                break;
            case "ALS":
                ALS((int) instruction.getParameter().getObj());
                break;
            case "LDB":
                LDB((boolean) instruction.getParameter().getObj());
                break;
            case "LDI":
                LDI((int) instruction.getParameter().getObj());
                break;
            case "LDR":
                LDR((float) instruction.getParameter().getObj());
                break;
            case "LDS":
                LDS((String) instruction.getParameter().getObj());
                break;
            case "LDV":
                LDV((int) instruction.getParameter().getObj());
                break;
            case "STR":
                STR((int) instruction.getParameter().getObj());
                break;
            case "STC":
                STC((int) instruction.getParameter().getObj());
                break;
            case "AND":
                AND();
                break;
            case "NOT":
                NOT();
                break;
            case "OR":
                OR();
                break;
            case "BGE":
                BGE();
                break;
            case "BGR":
                BGR();
                break;
            case "DIF":
                DIF();
                break;
            case "EQL":
                EQL();
                break;
            case "SME":
                SME();
                break;
            case "SMR":
                SMR();
                break;
            case "JMF":
                JMF((int) instruction.getParameter().getObj());
                break;
            case "JMP":
                JMP((int) instruction.getParameter().getObj());
                break;
            case "JMT":
                JMT((int) instruction.getParameter().getObj());
                break;
            case "STP":
                STP();
                break;
            case "REA":
                REA((int) instruction.getParameter().getObj());
                break;
            case "WRT":
                WRT();
                break;
            default:
                System.out.println("Comando na VM inválido!");
                break;
        }
    }

    /**
     * Metodo responsável por limpar a pilha
     */
    public void clearStack() {
        this.pilha.clear();
    }

    /**
     * Responsável por executar a expressão aritmética soma
     */
    public void ADD() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        int tipoDeDado = pilha.canBeUsedInOperations(item1, item2);

        if (tipoDeDado != TipoDeDado.TYPE_STRING && tipoDeDado != TipoDeDado.TYPE_BOOLEAN) {

            if (tipoDeDado == TipoDeDado.TYPE_INT) {
                int inteiro = (int) item1.getObj() + (int) item2.getObj();
                pilha.push(inteiro);

            } else {
                float real = (float) item1.getObj() + (float) item2.getObj();
                pilha.push(real);
            }

            ponteiro++;
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar o resto de uma divisão
     */
    public void MOD() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        int tipoDeDado = pilha.canBeUsedInOperations(item1, item2);

        if (tipoDeDado != TipoDeDado.TYPE_STRING && tipoDeDado != TipoDeDado.TYPE_BOOLEAN) {

            if (tipoDeDado == TipoDeDado.TYPE_INT) {
                int inteiro = (int) item2.getObj() % (int) item1.getObj();
                pilha.push(inteiro);

            } else {
                float real = (float) item2.getObj() % (float) item1.getObj();
                pilha.push(real);
            }

            ponteiro++;
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a potencia entre dois valores da pilha
     */
    public void POW() {
        Item base = pilha.pop();
        Item exp = pilha.pop();

        //VERIFICA SE BASE É INTEIRA OU FLOAT
        if (base.getType() == TipoDeDado.TYPE_INT || exp.getType() == TipoDeDado.TYPE_REAL) {
            if (exp.getType() == TipoDeDado.TYPE_INT) {
                double novo = 0.0;

                if (base.getType() == TipoDeDado.TYPE_INT && exp.getType() == TipoDeDado.TYPE_INT) {
                    int baseAux = (int) base.getObj();
                    int expAux = (int) exp.getObj();
                    novo = ExsltMath.power((double) baseAux, (double) expAux);
                } else {
                    novo = ExsltMath.power((double) base.getObj(), (double) exp.getObj());
                }
                pilha.push((float) novo);
            } else {
                listMessages.add("Tipo de dado incorreto no expoente da função POW!");
            }
        } else {
            listMessages.add("Tipo de dado incorreto na base da função POW!");
        }
    }

    /**
     * Responsável por executar a expressão aritmética divisão
     */
    public void DIV() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        int tipoDeDado = pilha.canBeUsedInOperations(item1, item2);

        if (tipoDeDado != TipoDeDado.TYPE_STRING && tipoDeDado != TipoDeDado.TYPE_BOOLEAN) {

            if (tipoDeDado == TipoDeDado.TYPE_INT) {
                int numA = (int) item1.getObj();
                int numB = (int) item2.getObj();

                float result = (float) numB / numA;
                pilha.push(result);

            } else {
                float numA = (float) item1.getObj();
                float numB = (float) item2.getObj();
                float real = numB / numA;
                pilha.push(real);
            }

            ponteiro++;
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a expressão aritmética multiplicação
     */
    public void MUL() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        int tipoDeDado = pilha.canBeUsedInOperations(item1, item2);

        if (tipoDeDado != TipoDeDado.TYPE_STRING && tipoDeDado != TipoDeDado.TYPE_BOOLEAN) {

            if (tipoDeDado == TipoDeDado.TYPE_INT) {
                int inteiro = (int) item1.getObj() * (int) item2.getObj();
                pilha.push(inteiro);

            } else {
                float real = (float) item1.getObj() * (float) item2.getObj();
                pilha.push(real);
            }

            ponteiro++;
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a expressão aritmética subtração
     */
    public void SUB() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        int tipoDeDado = pilha.canBeUsedInOperations(item1, item2);

        if (tipoDeDado != TipoDeDado.TYPE_STRING && tipoDeDado != TipoDeDado.TYPE_BOOLEAN) {

            if (tipoDeDado == TipoDeDado.TYPE_INT) {
                int inteiro = (int) item1.getObj() - (int) item2.getObj();
                pilha.push(inteiro);

            } else {
                float real = (float) item1.getObj() - (float) item2.getObj();
                pilha.push(real);
            }

            ponteiro++;
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por alocar espaço na pilha de dados, para variável do tipo lógico
     * igual ao deslocamento passado por parâmetro
     *
     * @param deslocamento quantidade de variáveis do tipo lógico alocadas.
     */
    public void ALB(int deslocamento) {
        for (int i = 0; i < deslocamento; i++) {
            pilha.push(false);
        }

        ponteiro++;
    }

    /**
     * Responsável por alocar espaço na pilha de dados, para variável do tipo inteiro
     * igual ao deslocamento passado por parâmetro
     *
     * @param deslocamento quantidade de variáveis do tipo inteiro alocadas.
     */
    public void ALI(int deslocamento) {
        for (int i = 0; i < deslocamento; i++) {
            pilha.push(0);
        }

        ponteiro++;
    }

    /**
     * Responsável por alocar espaço na pilha de dados, para variável do tipo real
     * igual ao deslocamento passado por parâmetro
     *
     * @param deslocamento quantidade de variáveis do tipo real alocadas.
     */
    public void ALR(int deslocamento) {
        for (int i = 0; i < deslocamento; i++) {
            pilha.push(0.0f);
        }

        ponteiro++;
    }

    /**
     * Responsável por alocar espaço na pilha de dados, para variável do tipo literal
     * igual ao deslocamento passado por parâmetro
     *
     * @param deslocamento quantidade de variáveis do tipo literal alocadas.
     */
    public void ALS(int deslocamento) {
        for (int i = 0; i < deslocamento; i++) {
            pilha.push("");
        }

        ponteiro++;
    }

    /**
     * Responsável por carregar na pilha de dados a constante lógica passada como parâmetro
     *
     * @param constante constante a ser carregada no topo da pilha de dados
     */
    public void LDB(boolean constante) {
        pilha.push(constante);
        ponteiro++;
    }

    /**
     * Responsável por carregar na pilha de dados a constante inteira passada como parâmetro
     *
     * @param constante constante a ser carregada no topo da pilha de dados
     */
    public void LDI(int constante) {
        pilha.push(constante);
        ponteiro++;
    }

    /**
     * Responsável por carregar na pilha de dados a constante real passada como parâmetro
     *
     * @param constante constante a ser carregada no topo da pilha de dados
     */
    public void LDR(float constante) {
        pilha.push(constante);
        ponteiro++;
    }

    /**
     * Responsável por carregar na pilha de dados a constante literal passada como parâmetro
     *
     * @param constante constante a ser carregada no topo da pilha de dados
     */
    public void LDS(String constante) {
        pilha.push(constante);
        ponteiro++;
    }

    /**
     * Responsável por carregar na pilha de dados o valor armazenado no esndereço passado como parâmetro
     *
     * @param endereco endereço para carregar na pilha de dados
     */
    public void LDV(int endereco) {
        Item aux = pilha.get(endereco - 1);
        pilha.push(aux.getObj());
        ponteiro++;
    }

    /**
     * Metodo responsável por armazenar o conteudo do topo da pilha no endereço passado por parâmetro
     *
     * @param endereco endereço que será armazenado o topo da pilha
     */
    public void STR(int endereco) {
        Item item = pilha.getLast();
        pilha.set(endereco - 1, item);
        ponteiro++;
    }

    /**
     * Responsável por executar a operação lógica E
     */
    public void AND() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        boolean result = (boolean) item2.getObj() && (boolean) item1.getObj();

        pilha.push(result);
        ponteiro++;
    }

    /**
     * Responsável por executar a operação lógica NÃO
     */
    public void NOT() {
        Item item1 = pilha.pop();

        if (item1.getType() == TipoDeDado.TYPE_BOOLEAN) {
            boolean result = (boolean) item1.getObj();
            pilha.push(!result);
            ponteiro++;
        } else {
            //GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a operação lógica OU
     */
    public void OR() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();
        boolean result = (boolean) item2.getObj() || (boolean) item1.getObj();

        pilha.push(result);
        ponteiro++;
    }

    /**
     * Responsável por executar a operação relacional maior ou igual
     */
    public void BGE() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if ((item1.getType() == TipoDeDado.TYPE_INT || item1.getType() == TipoDeDado.TYPE_REAL) &&
                ((item2.getType() == TipoDeDado.TYPE_INT || item2.getType() == TipoDeDado.TYPE_REAL))) {

            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }

            pilha.push((valor2 >= valor1));
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a operação relacional maior que
     */
    public void BGR() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if ((item1.getType() == TipoDeDado.TYPE_INT || item1.getType() == TipoDeDado.TYPE_REAL) &&
                ((item2.getType() == TipoDeDado.TYPE_INT || item2.getType() == TipoDeDado.TYPE_REAL))) {


            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }

            pilha.push((valor2 > valor1));
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a operação relacional diferente
     */
    public void DIF() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if ((item1.getType() == TipoDeDado.TYPE_INT || item1.getType() == TipoDeDado.TYPE_REAL) &&
                ((item2.getType() == TipoDeDado.TYPE_INT || item2.getType() == TipoDeDado.TYPE_REAL))) {

            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }

            pilha.push((valor2 != valor1));

        } else {
            if ((item1.getType() == TipoDeDado.TYPE_STRING) && (item2.getType() == TipoDeDado.TYPE_STRING)) {
                String aux1 = (String) item1.getObj();
                String aux2 = (String) item2.getObj();

                if (aux1.equals(aux2)) {
                    pilha.push(false);
                } else {
                    pilha.push(true);
                }
            } else {
                pilha.push(true);
            }
        }
    }

    /**
     * Responsável por executar a operação relacional igual
     */
    public void EQL() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if (item1.getType() == TipoDeDado.TYPE_INT && item2.getType() == TipoDeDado.TYPE_INT) {

            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }
            pilha.push((valor2 == valor1));

        } else if (item1.getType() == TipoDeDado.TYPE_REAL && item2.getType() == TipoDeDado.TYPE_REAL) {

            float valor1 = (float) item1.getObj();
            float valor2 = (float) item2.getObj();


            pilha.push((valor2 == valor1));
        } else {
            if ((item1.getType() == TipoDeDado.TYPE_STRING) && (item2.getType() == TipoDeDado.TYPE_STRING)) {
                String aux1 = (String) item1.getObj();
                String aux2 = (String) item2.getObj();

                if (aux1.equals(aux2)) {
                    pilha.push(true);
                } else {
                    pilha.push(false);
                }
            } else {
                pilha.push(false);
            }
        }
    }

    /**
     * Responsável por executar a operação relacional menor ou igual
     */
    public void SME() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if ((item1.getType() == TipoDeDado.TYPE_INT || item1.getType() == TipoDeDado.TYPE_REAL) &&
                ((item2.getType() == TipoDeDado.TYPE_INT || item2.getType() == TipoDeDado.TYPE_REAL))) {


            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }
            pilha.push((valor2 <= valor1));
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por executar a operação relacional menor que
     */
    public void SMR() {
        Item item1 = pilha.pop();
        Item item2 = pilha.pop();

        if ((item1.getType() == TipoDeDado.TYPE_INT || item1.getType() == TipoDeDado.TYPE_REAL) &&
                ((item2.getType() == TipoDeDado.TYPE_INT || item2.getType() == TipoDeDado.TYPE_REAL))) {


            float valor1 = (float) 0.0;
            float valor2 = (float) 0.0;

            if (item1.getType() == TipoDeDado.TYPE_INT) {
                valor1 = (float) ((int) item1.getObj());
            } else {
                valor1 = (float) item1.getObj();
            }

            if (item2.getType() == TipoDeDado.TYPE_INT) {
                valor2 = (float) ((int) item2.getObj());
            } else {
                valor2 = (float) item2.getObj();
            }
            pilha.push((valor2 < valor1));
        } else {
            // GERAR ALGUM ERRO
        }
    }

    /**
     * Responsável por desviar quando for falso para a instrução do endereço passado como parâmetro
     *
     * @param endereco endereço que será desviado
     */
    public void JMF(int endereco) {
        Item aux = pilha.pop();
        if (aux.getType() == TipoDeDado.TYPE_BOOLEAN) {
            boolean verif = (boolean) aux.getObj();

            if (verif == false) {
                ponteiro = endereco;
            } else {
                ponteiro++;
            }
        } else {
            //GERAR ALGUM ERRO
        }

//        topo--;
    }

    /**
     * Responsável por desviar para o endereço passado por parâmetro
     *
     * @param endereco endereço que será desviado
     */
    public void JMP(int endereco) {
        ponteiro = endereco;
    }

    /**
     * Responsável por desviar quando for verdadeiro para a instrução do endereço passado como parâmetro
     *
     * @param endereco endereço que será desviado
     */
    public void JMT(int endereco) {
        Item aux = pilha.pop();
        if (aux.getType() == TipoDeDado.TYPE_BOOLEAN) {
            boolean verif = (boolean) aux.getObj();

            if (verif == true) {
                ponteiro = endereco;
            } else {
                ponteiro++;
            }
        } else {
            //GERAR ALGUM ERRO
        }

//        topo--;
    }

    /**
     * Responsável por finalizar a execução
     */
    public void STP() {
        listMessages.add("\n\nPrograma Finalizado!");
    }

    /**
     * armazenar o conteúdo do	topo da	pilha de dados na últimas (deslocamento) constantes alocadas
     *
     * @param deslocamento
     */
    // TODO double check this
    public void STC(int deslocamento) {
        int size = pilha.size();
        Item item = pilha.get(size - 1);


        System.out.println(size);

        for (int i = size - deslocamento; i < size; ++i) {
            pilha.set(i, item);
        }

        ponteiro++;
    }

    /**
     * Responsável por ler dados do tipo passado como parâmetro
     *
     * @param tipo 1 = int | 2 = real | 3 = string
     */
    public void REA(int tipo) {
        Scanner sc = new Scanner(System.in);

        try {
            switch (tipo) {
                case 1:
                    System.out.println("Digite o inteiro:");
                    int auxInt = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Digite o float:");
                    float auxFloat = sc.nextFloat();
                    break;
                case 3:
                    System.out.println("Digite a string:");
                    String auxString = sc.nextLine();
                    break;
            }
        } catch (InputMismatchException e) {
            //GERAR ALGUM ERRO AQUI
        }
    }

    /**
     * Responsável por escrever dados
     */
    public void WRT() {
        Item aux = pilha.pop();
        switch (aux.getType()) {
            case TipoDeDado.TYPE_INT:
                int intAux = (int) aux.getObj();
                listMessages.add(intAux + "");
                break;
            case TipoDeDado.TYPE_REAL:
                float auxFloat = (float) aux.getObj();
                listMessages.add(auxFloat + "");
                break;
            case TipoDeDado.TYPE_STRING:
                listMessages.add((String) aux.getObj());
                break;
            case TipoDeDado.TYPE_BOOLEAN:
                boolean auxBoolean = (boolean) aux.getObj();
                listMessages.add(auxBoolean + "");
                break;
            default:
                System.out.println("Tipo Invalido WRT");
                break;
        }
    }

    static class TipoDeDado {
        public static final int TYPE_INT = 1;
        public static final int TYPE_REAL = 2;
        public static final int TYPE_STRING = 3;
        public static final int TYPE_BOOLEAN = 4;
    }

}
