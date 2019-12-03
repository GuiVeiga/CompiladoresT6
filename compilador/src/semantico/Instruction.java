//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho

package semantico;


public class Instruction {

    private Integer pointer;
    private String code;
    private Item parameter;

    public Instruction(Integer pointer, String code, Item parameter) {
        this.pointer = pointer;
        this.code = code;
        this.parameter = parameter;
    }

    public Integer getPointer() {
        return pointer;
    }

    public void setPointer(int Integer) {
        this.pointer = pointer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Item getParameter() {
        return parameter;
    }

    public void setParameter(Item parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "{pointer=" + pointer + ", code='" + code + '\'' + ", parameter=" + parameter.toString() + '}';
    }
}
