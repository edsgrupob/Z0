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
 * Encapsula o c�digo de leitura. Carrega as instru��es na linguagem de m�quina virtual a pilha,
 * analisa, e oferece acesso aos comandos.
 * Al�m disso, remove todos os espa�os em branco e coment�rios.
 */
public class JackTokenizer {

    /** Enumerator para os tipos de s�mbolos terminais de Linguagem Jack. */
    public enum TokenType {
        KEYWORD,        // Palavras reservadas
        SYMBOL,         // S�mbolos, como chaves, colchetes, pontua��es, etc..
        IDENTIFIER,     // Identificadores, como nome de vari�veis ou classes por exemplo
        INT_CONST,      // Inteiros constantes, ou seja, n�meros no c�digo
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
     * Abre o arquivo de entrada no formato Jack e se prepara para analis�-lo.
     * @param file arquivo VM que ser� feito o parser.
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
    	// por espa�os

    	String[] newLine = line.trim().split(" ");
    	
    	// Armazena uma linha que tem coment�rio
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
    		// Procura por coment�rios no meio da linha
    		// e retorna o c�digo at� o index do coment�rio
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
    	
    	// A linha n�o tinha nenhum coment�rio, retorna apenas
    	// ela separada por espa�os
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
     * Carrega um token (�tomo) e avan�a seu apontador interno para o pr�ximo token
     * Caso n�o haja mais tokens no arquivo de entrada o m�todo retorna "Falso", 
     * sen�o retorna "Verdadeiro".
     * Os tokens s�o os elementos de um documento que interessam, espa�os e tabula��es s�o removidos,
     * os coment�rios tamb�m s�o removidos como do barra(/) asterisco (*), at� um asterisco (*) barra (/),
     * duas barras seguidas, contudo os outros s�mbolos s�o separados e recuperados um a um. 
     * Em especial textos entre aspas s�o recuperados como um token s� e n�o devem ter seus dados internos
     * as aspas tratados, ou seja devem ser algo �nico.
     * @return Verdadeiro se ainda h� tokens, Falso se os tokens terminaram.
     */
    public Boolean advance() {
        return null;
    }

    /**
     * Retorna o token (�tomo) atual (sem o avan�o).
     * @return o �tomo atual para ser analilisado.
     */
    public String token() {
        return null;
    }

    /**
     * Retorna o tipo do token passada no argumento.
     * KEYWORD para class, constructor, function, method, field, static, var, int, char, boolean, void, true, false, null, this, let, do, if, else, while, return.
     * SYMBOL para { } ( ) [ ] . , ; + - * & | < > = ~ /
     * INT_CONST para n�meros
     * STRING_CONST para textos entre aspas
     * IDENTIFIER para os nomes de vari�veis, classes, m�todos, etc.
     * @param  token a ser analisado.
     * @return o tipo do token.
     */
    public static TokenType tokenType(String token) {
        return null;
    }

    /**
     * Retorna o tipo de keyword (palavra reservada) do token passada no argumento.
     * O retorno � em fun��o dos tipos do enumerator KeywordType.
     * Rotina s� deve ser chamada se o tipo do token for um KEYWORD
     * @param  token a ser analisado.
     * @return o tipo de keyword do token.
     */
    public static KeywordType keyWord(String token) {
        return null;
    }
    
    /**
     * Retorna o dado como um Character no caso de um toke do tipo SYMBOL.
     * Deve ser chamado somente quando o tipo de token for um SYMBOL.
     * @param  command instru��o a ser analisada.
     * @return somente o s�mbolo ou o valor n�mero da instru��o.
     */
    public static Character symbol(String token) {
        return null;
    }

    /**
     * Retorna o valor num�rico de um token que � um n�mero constante.
     * Deve ser chamado somente quando o tipo de token for um INT_CONST.
     * @param  token a ser analisado.
     * @return o valor num�rico (Integer) do token informado (String).
     */
    public static Integer intVal(String token) {
        return null;
    }

    /**
     * Retorna a String de um token fornecido no argumento.
     * Caso o token possua aspas, estas dever�o ser removidas.
     * Deve ser chamado somente quando o tipo de token for um STRING_CONST.
     * @param  token a ser analisado.
     * @return o valor num�rico (Integer) do token informado (String).
     */
    public static String stringVal(String token) {
        return null;
    }

}