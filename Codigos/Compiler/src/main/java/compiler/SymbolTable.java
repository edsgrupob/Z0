/**
 * Curso: Elementos de Sistemas
 * Arquivo: SymbolTable.java
 */

package compiler;

import java.util.*;

/**
 * MantÃ©m uma tabela com a correspondÃªncia entre os nomes das variÃ¡veis e seus detalhes.
 * Os dados salvos sÃ£o o tipo de dado que a variÃ¡vel suporta, o posicionamento no cÃ³digo e
 * o indice numÃ©rico no segmento de memÃ³ria relacionado.
 * Esta tabela de sÃ­mbolos pode ser usada para armazenar variÃ¡veis no contexto da Classe/objeto,
 * bem como atributos e variÃ¡veis de subrotinas (mÃ©todos, funÃ§Ãµes e construtores).
 */
public class SymbolTable {
	private Hashtable<String, Symbol> table;
	private int staticCounter;
	private int fieldCounter;
	private int argCounter;
	private int varCounter;

    /**
     * Cria uma tabela de sÃ­mbolos vazia.
     */
    public SymbolTable() {
    	table = new Hashtable<String, Symbol>();
    	staticCounter = 0;
    	fieldCounter = 0;
    	argCounter = 0;
    	varCounter = 0;

    }

    /**
     * Reinicia todos os valores da tabela de sÃ­mbolos, bem como quaisquer
     * contadores ou outra estrutura de dados que nÃ£o serÃ£o reusadas em um novo
     * contexto, por exemplo quando se muda para uma nova subrotina.
     */
    public void startSubroutine() {
    	table = new Hashtable<String, Symbol>();
    	staticCounter = 0;
    	fieldCounter = 0;
    	argCounter = 0;
    	varCounter = 0;

    }

    /**
     * Insere uma entrada na tabela de sÃ­mbolos, sendo essa tabela indexada pelo nome
     * da variÃ¡vel a ser inserida, os dados de type (tipo) e kind (posicionamento) sÃ£o
     * fornecidos, jÃ¡ o Ã­ndice de segmento de memÃ³ria Ã© gerado automaticamente nessa rotina.
     * As posicionamentos STATIC e FIELD sÃ£o usados para escopos de classes, enquando
     * ARG e VAR sÃ£o usados nos escopos de subrotinas.
     * @param  name nome da variÃ¡vel a ser armazenada na tabela de sÃ­mbolos e usada para indexar tabela.
     * @param  type tipo a ser armazenado na tabela de sÃ­mbolos, por exemplo: int, char, ou uma Classe qualquer.
     * @param  kind posicionamento no cÃ³digo da variÃ¡vel a ser armazenado na tabela de sÃ­mbolos, por exemplo: STATIC, ARG.
     * @return valor inteiro do Ã­ndice para segmento de memÃ³ria criado para a variÃ¡vel.
     */
    public Integer define(String name, String type, Symbol.Kind kind) {
       	if (kind.equals(Symbol.Kind.ARG)){
    			Symbol data = new Symbol(type, kind, argCounter);
    			table.put(name, data);
//    			System.out.println(table.size());
    			argCounter ++;
    			return argCounter-1;
       	}
    	if (kind.equals(Symbol.Kind.VAR)){
			Symbol data = new Symbol(type, kind, varCounter);
			table.put(name, data);
			varCounter ++;
			return varCounter-1;
		}
    	if (kind.equals(Symbol.Kind.STATIC)){
			Symbol data = new Symbol(type, kind, staticCounter);
			table.put(name, data);
			staticCounter ++;
			return staticCounter-1;
		}
    	if (kind.equals(Symbol.Kind.FIELD)){
			Symbol data = new Symbol(type, kind, fieldCounter);
			table.put(name, data);
			fieldCounter ++;
			return fieldCounter-1;
		}
        return null;
    }

    /**
     * Informa o nÃºmero de variÃ¡veis que foram alocadas, conform o posicionamento delas (kind).
     * Quando a tabela Ã© reiniciada, esses valores sÃ£o zerados.
     * @param kind forma de posicionamento de uma variÃ¡vel. Por exemplo: FIELD, VAR, etc.
     * @return quantidade de variÃ¡veis definidas para uma determinada forma de posicionamento (kind).
     */
    public Integer varCount(Symbol.Kind kind) {
    	String tipo = kind.toString().toLowerCase() + "Counter";
        if (tipo.equals("argCounter")){
        	return argCounter;
        }
        if (tipo.equals("staticCounter")){
        	return staticCounter;
        }
        if (tipo.equals("fieldCounter")){
        	return fieldCounter;
        }
        if (tipo.equals("varCounter")){
        	return varCounter;
        }
        return null;
    }

    /**
     * Retorna o tipo da variÃ¡vel buscada, se a variÃ¡vel nÃ£o for encontrada para o escopo
     * da tabela de sÃ­mbolos procurada, um valor null deve ser retornado informando que nÃ£o existe na tabela.
     * @param  name nome da variÃ¡vel a ser procurado na tabela de sÃ­mbolos.
     * @return tipo da variÃ¡vel procurada (null caso nÃ£o encontrado).
     */
    public String typeOf(String name) {
    	if (table.containsKey(name)){
    		return table.get(name).getType();
    	}
        return null;
    }

    /**
     * Retorna a forma de posicionamento (kind) da variÃ¡vel buscada, se a variÃ¡vel nÃ£o for encontrada para o escopo
     * da tabela de sÃ­mbolos procurada, um valor null deve ser retornado informando que nÃ£o existe na tabela.
     * @param  name nome da variÃ¡vel a ser procurado na tabela de sÃ­mbolos.
     * @return forma de posicionamento (kind) da variÃ¡vel procurada (null caso nÃ£o encontrado).
     */
    public Symbol.Kind kindOf(String name) {
    	if (table.containsKey(name)){
    		return table.get(name).getKind();
    	}
        return null;
    }

    /**
     * Retorna o Ã­ndice do segmento de memÃ³ria da variÃ¡vel buscada, se a variÃ¡vel nÃ£o for encontrada para o escopo
     * da tabela de sÃ­mbolos procurada, um valor null deve ser retornado informando que nÃ£o existe na tabela.
     * @param  name nome da variÃ¡vel a ser procurado na tabela de sÃ­mbolos.
     * @return Ã­ndice do segmento de memÃ³ria da variÃ¡vel procurada (null caso nÃ£o encontrado).
     */
    public Integer indexOf(String name) {
    	if (table.containsKey(name)){
    		return table.get(name).getIndex();
    	}
        return null;
    }

}
