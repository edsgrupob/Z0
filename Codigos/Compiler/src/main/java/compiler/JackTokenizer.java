/**
 /**
 * Curso: Elementos de Sistemas
 * Arquivo: JackTokenizer.java
 */

package compiler;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Encapsula o código de leitura. Carrega as instruções na linguagem de máquina virtual a pilha,
 * analisa, e oferece acesso aos comandos.
 * Além disso, remove todos os espaços em branco e comentários.
 */
public class JackTokenizer {

    /** Enumerator para os tipos de símbolos terminais de Linguagem Jack. */
    public enum TokenType {
        KEYWORD,        // Palavras reservadas
        SYMBOL,         // Símbolos, como chaves, colchetes, pontuações, etc..
        IDENTIFIER,     // Identificadores, como nome de variáveis ou classes por exemplo
        INT_CONST,      // Inteiros constantes, ou seja, números no código
        STRING_CONST    // Strings constantes, ou seja, textos entre aspas
    }

    /** Enumerator para as palavras reservadas na linguagem Jack. */
    public enum KeywordType {
        CLASS,
        METHOD, 
        FUNCTION, 
        CONSTRUCTOR, 
        INT, 
        BOOLEAN, 
        CHAR, 
        VOID, 
        VAR, 
        STATIC, 
        FIELD, 
        LET, 
        DO, 
        IF, 
        ELSE, 
        WHILE, 
        RETURN, 
        TRUE, 
        FALSE, 
        NULL, 
        THIS
    }
    
    ArrayList<String> listaTokens;

    /** 
     * Abre o arquivo de entrada no formato Jack e se prepara para analisá-lo.
     * @param file arquivo VM que será feito o parser.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public JackTokenizer(String file) throws FileNotFoundException, IOException {
    	String line;
//    	String fixedDir = "Codigos/Compiler/";
//    	System.out.println("Working Directory = " +
//                System.getProperty("user.dir"));
    	try (
			InputStream fis = new FileInputStream( file);
    	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    	    BufferedReader br = new BufferedReader(isr);
    	) {
    		listaTokens = new ArrayList<String>();
    		
    	    while ((line = br.readLine()) != null) {
    	    	String[] linhaFormatada = splitTokens(line);

	    		if (linhaFormatada != null) {
    	    		for (int i = 0; i < linhaFormatada.length; i++) {
						listaTokens.add(linhaFormatada[i]);
						//System.out.println(linhaFormatada[i]);
						
					}
    	    	}    	        
    	    }
    	    
    	} catch (Exception e) {
    		System.out.println(e);
		}
    }
    
    /**
     * Separa os tokens de cada linha em uma array de Strings.
     * @param line linha que deve ter seus tokens separados
     * @return
     */
    private String[] splitTokens(String line){
    	
    	// Armazena todos os tokens de uma linha, separado
    	// por espaços

    	String[] newLine = line.trim().split(" ");
    	
    	// Armazena uma linha que tem comentário
    	String[] lineWithComment = null;
    	if (newLine[0].contains("//")) {
    		return null;
    	} else if (newLine[0].contains("/*")){
    		return null;
    	} else if (newLine[0].contains("*/")){
    		return null;
    	} else if (newLine[0].contains("*")){
    		return null;
    	} else if (newLine[0].contains("/**")){
    		return null;
    	} else {
    		// Procura por comentários no meio da linha
    		// e retorna o código até o index do comentário
    		for (int i = 0; i < newLine.length; i++) {
				if (newLine[i].contains("//")) {
					lineWithComment = new String[i];
					
					for (int j = 0; j < i; j++) {
						lineWithComment[j] = newLine[j];
					}
					break;
				}
			}
    		
    	}
    	
    	if (lineWithComment != null) {
    		filterSymbols(lineWithComment);
    		return lineWithComment;
    	} 
    	
    	// A linha não tinha nenhum comentário, retorna apenas
    	// ela separada por espaços
		return newLine;
    }
    
    private void filterSymbols(String[] tokenWithSymbol) {
    	ArrayList<String> filteredSymbol = new ArrayList<>();
    	
    	ArrayList<String> symbols = new ArrayList<String>();
    	symbols.add("}");
    	symbols.add("{");
    	symbols.add(")");
    	symbols.add("(");
    	symbols.add("=");
    	symbols.add(",");
    	symbols.add(".");
    	symbols.add(";");
    	symbols.add("[");
    	symbols.add("]");
    	symbols.add("+");
    	symbols.add("-");
    	symbols.add("|");
    	symbols.add("*");
    	symbols.add("~");
    	symbols.add("&");
    	symbols.add("<");
    	symbols.add(">");
    	symbols.add("/");
    	
    	
    	for (int token = 0; token < tokenWithSymbol.length; token++) {

    		for (String symbol : symbols) {
    			String [] separedToken;
    			if (tokenWithSymbol[token].contains(symbol)) {
    				tokenWithSymbol[token] = tokenWithSymbol[token].replace(symbol, " " + symbol + " ");	
    				separedToken = tokenWithSymbol[token].split("\\s");

    					
    					for (int i = 0; i < separedToken.length; i++) {
    						
    						filteredSymbol.add(separedToken[i]);
    						
    					}
    			
    				
    		}
 
    		
		}
    		
    	
    	
    	String[] returnArray = filteredSymbol.toArray(new String[0]);
//    	return returnArray;
    }
    	System.out.println(filteredSymbol);    	
}
    
    /**
     * Carrega um token (átomo) e avança seu apontador interno para o próximo token
     * Caso não haja mais tokens no arquivo de entrada o método retorna "Falso", 
     * senão retorna "Verdadeiro".
     * Os tokens são os elementos de um documento que interessam, espaços e tabulações são removidos,
     * os comentários também são removidos como do barra(/) asterisco (*), até um asterisco (*) barra (/),
     * duas barras seguidas, contudo os outros símbolos são separados e recuperados um a um. 
     * Em especial textos entre aspas são recuperados como um token só e não devem ter seus dados internos
     * as aspas tratados, ou seja devem ser algo único.
     * @return Verdadeiro se ainda há tokens, Falso se os tokens terminaram.
     */
    public Boolean advance() {
        return null;
    }

    /**
     * Retorna o token (átomo) atual (sem o avanço).
     * @return o átomo atual para ser analilisado.
     */
    public String token() {
        return null;
    }

    /**
     * Retorna o tipo do token passada no argumento.
     * KEYWORD para class, constructor, function, method, field, static, var, int, char, boolean, void, true, false, null, this, let, do, if, else, while, return.
     * SYMBOL para { } ( ) [ ] . , ; + - * & | < > = ~ /
     * INT_CONST para números
     * STRING_CONST para textos entre aspas
     * IDENTIFIER para os nomes de variáveis, classes, métodos, etc.
     * @param  token a ser analisado.
     * @return o tipo do token.
     */
    public static TokenType tokenType(String token) {
        return null;
    }

    /**
     * Retorna o tipo de keyword (palavra reservada) do token passada no argumento.
     * O retorno é em função dos tipos do enumerator KeywordType.
     * Rotina só deve ser chamada se o tipo do token for um KEYWORD
     * @param  token a ser analisado.
     * @return o tipo de keyword do token.
     */
    public static KeywordType keyWord(String token) {
        return null;
    }
    
    /**
     * Retorna o dado como um Character no caso de um toke do tipo SYMBOL.
     * Deve ser chamado somente quando o tipo de token for um SYMBOL.
     * @param  command instrução a ser analisada.
     * @return somente o símbolo ou o valor número da instrução.
     */
    public static Character symbol(String token) {
        return null;
    }

    /**
     * Retorna o valor numérico de um token que é um número constante.
     * Deve ser chamado somente quando o tipo de token for um INT_CONST.
     * @param  token a ser analisado.
     * @return o valor numérico (Integer) do token informado (String).
     */
    public static Integer intVal(String token) {
        return null;
    }

    /**
     * Retorna a String de um token fornecido no argumento.
     * Caso o token possua aspas, estas deverão ser removidas.
     * Deve ser chamado somente quando o tipo de token for um STRING_CONST.
     * @param  token a ser analisado.
     * @return o valor numérico (Integer) do token informado (String).
     */
    public static String stringVal(String token) {
        return null;
    }

}