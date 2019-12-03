//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho

package semantico;


public class First {


    static public final RecoverySet header = new RecoverySet();
    static public final RecoverySet declaration = new RecoverySet();
    static public final RecoverySet body = new RecoverySet();
    static public final RecoverySet comentario = new RecoverySet();

    static {
        header.add(new Integer(langX.PROGRAM));
        declaration.add(new Integer(langX.DECLARE));
        body.add(new Integer(langX.EXECUTE));
        comentario.add(new Integer(langX.PURPOSE));
        comentario.add(new Integer(langX.EOF));
    }
}
