/**
 /**
 * Curso: Elementos de Sistemas
 * Arquivo: JackTokenizer.java
 */

package compiler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Vector;


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
    
    
    private List<String> tokens;
    private int counter;

    /** 
     * Abre o arquivo de entrada no formato Jack e se prepara para analis�-lo.
     * @param file arquivo VM que ser� feito o parser.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public JackTokenizer(String file) throws FileNotFoundException, IOException {
    	String line;
    	String[] temp;
    	
    	counter= 0;
    	//Talvez tenha que ser -1, n�o sei se tem que dar advance ou n�o pra ler o primeiro token
    	try (
			InputStream fis = new FileInputStream( file);
    	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    	    BufferedReader br = new BufferedReader(isr);
    	) {
    		tokens= new Vector<String>();
    		boolean isString= false;
    		String stringHolder="";
    		
    	    while ((line = br.readLine()) != null) {
    	    	temp = splitTokens(line);
    	    	   	    	
	    		for (int i = 0; i < temp.length; i++) {
	    			if(isString || temp[i].contains("\"") || temp[i].contains("\'")){
	    				stringHolder+=temp[i];
	    			}else{
	    				tokens.add(temp[i]);
	    			}
	    			
	    			if(temp[i].contains("\"") || temp[i].contains("\'")){
	    				isString= !isString;
	    				
	    				if(stringHolder!=""){
	    					tokens.add(stringHolder);
	    				}
	    				stringHolder="";
	    			}
				}
    	    }
    	    
    	} catch (Exception e) {
    		System.out.println(e);
		}
    	
    	//TESTES
    	
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
    	} else if(newLine.length==1 && newLine[0].equals("")){
    		return null;
    	} else {
    		// Procura por coment�rios no meio da linha
    		// e retorna o c�digo at� o index do coment�rio
    		int i=-1;
    		while((i+=1)!=newLine.length){
				if (newLine[i].contains("//")) {
					break;
				}
			}
    		String[] temp = newLine.clone();
    		newLine=new String[i];
			for(i=0; i != newLine.length ; ++i){
			
				newLine[i]=temp[i];
			}
    		
    	}
    	
		filterSymbols(newLine);
    	
    	// A linha n�o tinha nenhum coment�rio, retorna apenas
    	// ela separada por espa�os
		return newLine;
    }
    
    private void filterSymbols(String[] newLine) {
    	
    	String[] symbol = new String[19];
    	
    	symbol[0]= "}";
    	symbol[1]= "{";
    	symbol[2]= ")";
    	symbol[3]= "(";
    	symbol[4]= "=";
    	symbol[5]= ",";
    	symbol[6]= ".";
    	symbol[7]= ";";
    	symbol[8]= "[";
    	symbol[9]= "]";
    	symbol[10]= "+";
    	symbol[11]= "-";
    	symbol[12]= "|";
    	symbol[13]= "*";
    	symbol[14]= "~";
    	symbol[15]= "&";
    	symbol[16]= "<";
    	symbol[17]= ">";
    	symbol[18]= "/";
    	
    	List<String> line;
    	String[] temp;
    	
    	for(int i=0; i!=symbol.length; ++i){
    		line = new Vector<String>();
    		
    		for(int j=0; j!=newLine.length; ++j){
    			newLine[j]=" "+newLine[j]+" ";
    			temp=newLine[j].split("\\"+symbol[i]);
				newLine[j]=String.join(" "+symbol[i]+" ", temp);
    			temp=newLine[j].split(" ");
    			
    			for(int t=0; t!=temp.length; ++t){
    				if (!temp[t].equals("")){
    					line.add(temp[t]);
    				}
    			}
    		}
    		newLine=line.toArray(new String[line.size()]);
    	}   	
    	
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
    	++counter;
        return (counter < tokens.size());
    }

    /**
     * Retorna o token (�tomo) atual (sem o avan�o).
     * @return o �tomo atual para ser analilisado.
     */
    public String token() {
        return tokens.get(counter);
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
    	
    	String[] symbol = new String[19];
    	
    	symbol[0]= "}";
    	symbol[1]= "{";
    	symbol[2]= ")";
    	symbol[3]= "(";
    	symbol[4]= "=";
    	symbol[5]= ",";
    	symbol[6]= ".";
    	symbol[7]= ";";
    	symbol[8]= "[";
    	symbol[9]= "]";
    	symbol[10]= "+";
    	symbol[11]= "-";
    	symbol[12]= "|";
    	symbol[13]= "*";
    	symbol[14]= "~";
    	symbol[15]= "&";
    	symbol[16]= "<";
    	symbol[17]= ">";
    	symbol[18]= "/";
    	
    	switch(token){
			case "class":
			case "method":
			case "function":
			case "constructor":
			case "int":
			case "boolean":
			case "char":
			case "void":
			case "var":
			case "static":
			case "field":
			case "let":
			case "do":
			case "if":
			case "else":
			case "while":
			case "return":
			case "true":
			case "false":
			case "null":
			case "this":
			return TokenType.KEYWORD;
			default:
    	}
    	
    	for(int i=0; i!=symbol.length; ++i){
    		
    		if(symbol[i].equals(token)){
    			return TokenType.SYMBOL;
    		}
    	}
    	
    	try{
    		Integer.parseInt(token);
    		return TokenType.INT_CONST;
    	}catch(Exception e){
    		//N�o � INT_CONST
    	}
    	
    	if(token.contains("\"") || token.contains("\'")){
    		return TokenType.STRING_CONST;
    	}
    	
    	return TokenType.IDENTIFIER;
    }

    /**
     * Retorna o tipo de keyword (palavra reservada) do token passada no argumento.
     * O retorno � em fun��o dos tipos do enumerator KeywordType.
     * Rotina s� deve ser chamada se o tipo do token for um KEYWORD
     * @param  token a ser analisado.
     * @param KeywordType 
     * @return o tipo de keyword do token.
     */
    public static KeywordType keyWord(String token) {
    	
			if (tokenType(token) == TokenType.KEYWORD) {
			
				switch(token){
					case "class":
						return KeywordType.CLASS;
					case "method":
						return KeywordType.METHOD;
					case "function":
						return KeywordType.FUNCTION;
					case "constructor":
						return KeywordType.CONSTRUCTOR;
					case "int":
						return KeywordType.INT;
					case "boolean":
						return KeywordType.BOOLEAN;
					case "char":
						return KeywordType.CHAR;
					case "void":
						return KeywordType.VOID;
					case "var":
						return KeywordType.VAR;
					case "static":
						return KeywordType.STATIC;
					case "field":
						return KeywordType.FIELD;
					case "let":
						return KeywordType.LET;
					case "do":
						return KeywordType.DO;
					case "if":
						return KeywordType.IF;
					case "else":
						return KeywordType.ELSE;
					case "while":
						return KeywordType.WHILE;
					case "return":
						return KeywordType.RETURN;
					case "true":
						return KeywordType.TRUE;
					case "false":
						return KeywordType.FALSE;
					case "null":
						return KeywordType.NULL;
					case "this":
						return KeywordType.THIS;
        }
			}
			return null;
		}
    
    /**
     * Retorna o dado como um Character no caso de um token do tipo SYMBOL.
     * Deve ser chamado somente quando o tipo de token for um SYMBOL.
     * @param  command instru��o a ser analisada.
     * @return somente o s�mbolo ou o valor n�mero da instru��o.
     */
    public static Character symbol(String token) {
       if (tokenType(token) == TokenType.SYMBOL) {
        return token.charAt(0);
      }
      else {
        return null;
      }
    }

    /**
     * Retorna o valor num�rico de um token que � um n�mero constante.
     * Deve ser chamado somente quando o tipo de token for um INT_CONST.
     * @param  token a ser analisado.
     * @return o valor num�rico (Integer) do token informado (String).
     */
    public static Integer intVal(String token) {
      if (tokenType(token) == TokenType.INT_CONST) {
        return Integer.parseInt(token);
      }
      else {
        return null;
      }
    }

    /**
     * Retorna a String de um token fornecido no argumento.
     * Caso o token possua aspas, estas dever�o ser removidas.
     * Deve ser chamado somente quando o tipo de token for um STRING_CONST.
     * @param  token a ser analisado.
     * @return o valor num�rico (Integer) do token informado (String).
     */
    public static String stringVal(String token) {
      if (tokenType(token) == TokenType.STRING_CONST) {
        token = token.substring(1, token.length()-1);
        return token;
      }
      else {
    	  
        return null;
      }
    }

}