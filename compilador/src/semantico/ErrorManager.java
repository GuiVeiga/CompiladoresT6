//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho

package semantico;

import java.util.ArrayList;
import java.util.List;


public class ErrorManager {

    static public List<String> erroslexicos = new ArrayList<>();
    static public List<String> errosSintaticos = new ArrayList<>();

    static public void addErroLexico(Integer kind, Integer row, Integer col, String image, String desc, String token) {
        String erro = "Erro " + kind + ": em [linha: " + row +
                ", coluna: " + col + "] - " + desc + " - " + image + "\n";
        erroslexicos.add(erro);
    }

    static public List<String> getErroslexicos() {
        return erroslexicos;
    }

    public static void addErroSintatico(ParseException e, String message) {

        if (e.getMessage().equals("EOF Found prematurely.")) {
            if (!errosSintaticos.contains("Fim do arquivo encontrado prematuramente.\n"))
                errosSintaticos.add("Fim do arquivo encontrado prematuramente.\n");
            return;
        }

        String error = "Encontrado " + e.tokenImage[e.currentToken.next.kind] + " \"" + e.currentToken.next.image + "\"" + " na linha: " + e.currentToken.next.beginLine + ", coluna: " + e.currentToken.next.beginColumn + ".\n";
        String eol = System.getProperty("line.separator", "\n");
        StringBuffer expected = new StringBuffer();
        int maxSize = 0;
        int[][] expectedTokenSequences = e.expectedTokenSequences;

        if (expectedTokenSequences.length > 1) {
            error += "Estava esperando uma das opcoes: \n";
        } else {
            error += "Estava esperando: \n";
        }

        for (int i = 0; i < expectedTokenSequences.length; i++) {
            if (maxSize < expectedTokenSequences[i].length) {
                maxSize = expectedTokenSequences[i].length;
            }
            for (int j = 0; j < expectedTokenSequences[i].length; j++) {
                expected.append(e.tokenImage[expectedTokenSequences[i][j]]).append(' ');
            }
            expected.append(eol);
        }

        //String result = (message != null) ? message + "\n" : "";

        errosSintaticos.add(error + expected.toString() + "\n");
    }

    static public List<String> getErrosSintaticos() {
        return errosSintaticos;
    }

    static public void removeLastError() {
        erroslexicos.remove(erroslexicos.size() - 1);
    }


}
