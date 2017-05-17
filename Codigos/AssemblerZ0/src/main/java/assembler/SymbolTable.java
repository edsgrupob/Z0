/**
 * Curso: Elementos de Sistemas
 * Arquivo: SymbolTable.java
 * 
 */

package assembler;

import java.util.Hashtable;
import java.util.Set;

/**
 * Mant�m uma tabela com a correspond�ncia entre os r�tulos simb�licos e endere�os num�ricos de mem�ria.
 */
public class SymbolTable {
	Hashtable<String, Integer> symbolTable;
	/**
     * Cria a tabela de s�mbolos.
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
     * Insere uma entrada de um s�mbolo com seu endere�o num�rico na tabela de s�mbolos.
     * @param  symbol s�mbolo a ser armazenado na tabela de s�mbolos.
     * @param  address s�mbolo a ser armazenado na tabela de s�mbolos.
     */
    public void addEntry(String symbol, int address) {
    	
    	symbolTable.put(symbol, address);

    }

    /**
     * Confere se o s�mbolo informado j� foi inserido na tabela de s�mbolos.
     * @param  symbol s�mbolo a ser procurado na tabela de s�mbolos.
     * @return Verdadeiro se s�mbolo est� na tabela de s�mbolos, Falso se n�o est� na tabela de s�mbolos.
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
     * Retorna o valor n�merico associado a um s�mbolo j� inserido na tabela de s�mbolos.
     * @param  symbol s�mbolo a ser procurado na tabela de s�mbolos.
     * @return valor num�rico associado ao s�mbolo procurado.
     */
    public int getAddress(String symbol) {
    	int getAddress = symbolTable.get(symbol);
    	return getAddress;
    }

}
