/**
 * Curso: Elementos de Sistemas
 * Arquivo: SymbolTable.java
 * 
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
    	addEntry("R0", 0);
    	addEntry("R1", 1);
    	addEntry("R2", 2);
    	addEntry("R3", 3);
    	addEntry("R4", 4);
    	addEntry("R5", 5);
    	addEntry("R6", 6);
    	addEntry("R7", 7);
    	addEntry("R8", 8);
    	addEntry("R9", 9);
    	addEntry("R10", 10);
    	addEntry("R11", 11);
    	addEntry("R12", 12);
    	addEntry("R13", 13);
    	addEntry("R14", 14);
    	addEntry("R15", 15);
    	addEntry("SCREEN", 16384);
    	addEntry("KBD", 24576);
    	addEntry("SP", 0);
    	addEntry("LCL", 1);
    	addEntry("ARG", 2);
    	addEntry("THIS", 3);
    	addEntry("THAT", 4);
    	
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
    		if (key.equals(symbol)) {
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
