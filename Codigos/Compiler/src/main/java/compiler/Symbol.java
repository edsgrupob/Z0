/**
 * Curso: Elementos de Sistemas
 * Arquivo: Symbol.java
 */

package compiler;

/**
 * Classe que organiza os símbolos usados na tabela de símbolos
 */
public class Symbol {
	private String type;
	private Kind kind;
	private Integer index;
    /** Enumerator para os kind. */
    public enum Kind {
        STATIC,
        FIELD,
        ARG,
        VAR
    }

    /**
     * Cria um objeto que contem os dados dos símbolos
     */
    public Symbol(String type, Kind kind, Integer index) {
    	this.type = type;
    	this.kind = kind;
    	this.index = index;
    }
    public String getType() {
    	return type;
    }
    public Kind getKind() {
    	return kind;
    }
    public Integer getIndex() {
    	return index;
    }

}
