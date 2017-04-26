/**
 * Curso: Elementos de Sistemas
 * Arquivo: SymbolTable.java
 */

package assembler;

import java.util.Hashtable;
import java.util.Set;

/**
 * Mantém uma tabela com a correspondência entre os rótulos simbólicos e endereços numéricos de memória.
 */
public class SymbolTable {
	Hashtable<String, Integer> symbolTable;
	/**
     * Cria a tabela de símbolos.
     */
	
    public SymbolTable() {
    	symbolTable = new Hashtable<String, Integer>();
    	
    }

    /**
     * Insere uma entrada de um símbolo com seu endereço numérico na tabela de símbolos.
     * @param  symbol símbolo a ser armazenado na tabela de símbolos.
     * @param  address símbolo a ser armazenado na tabela de símbolos.
     */
    public void addEntry(String symbol, int address) {
    	
    	symbolTable.put(symbol, address);

    }

    /**
     * Confere se o símbolo informado já foi inserido na tabela de símbolos.
     * @param  symbol símbolo a ser procurado na tabela de símbolos.
     * @return Verdadeiro se símbolo está na tabela de símbolos, Falso se não está na tabela de símbolos.
     */
    public boolean contains(String symbol) {
    	boolean contains = false;
    	Set<String> keys = symbolTable.keySet();
    	for(String key: keys){
    		if (key == symbol) {
    			contains = true;
    		}
    	}
    	return contains;
    }

    /**
     * Retorna o valor númerico associado a um símbolo já inserido na tabela de símbolos.
     * @param  symbol símbolo a ser procurado na tabela de símbolos.
     * @return valor numérico associado ao símbolo procurado.
     */
    public int getAddress(String symbol) {
    	int getAddress = symbolTable.get(symbol);
    	return getAddress;
    }

}
