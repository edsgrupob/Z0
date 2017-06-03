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
    
    
    private List<String> tokens;
    private int counter;

    /** 
     * Abre o arquivo de entrada no formato Jack e se prepara para analisá-lo.
     * @param file arquivo VM que será feito o parser.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public JackTokenizer(String file) throws FileNotFoundException, IOException {
    	String line;
    	String[] temp;
    	
    	counter= 0;
    	//Talvez tenha que ser -1, não sei se tem que dar advance ou não pra ler o primeiro token
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
    	// por espaços

    	String[] newLine = line.trim().split(" ");
    	
    	// Armazena uma linha que tem comentário
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
    		// Procura por comentários no meio da linha
    		// e retorna o código até o index do comentário
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
    	
    	// A linha não tinha nenhum comentário, retorna apenas
    	// ela separada por espaços
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
    	++counter;
        return (counter < tokens.size());
    }

    /**
     * Retorna o token (átomo) atual (sem o avanço).
     * @return o átomo atual para ser analilisado.
     */
    public String token() {
        return tokens.get(counter);
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
    		//Não é INT_CONST
    	}
    	
    	if(token.contains("\"") || token.contains("\'")){
    		return TokenType.STRING_CONST;
    	}
    	
    	return TokenType.IDENTIFIER;
    }

    /**
     * Retorna o tipo de keyword (palavra reservada) do token passada no argumento.
     * O retorno é em função dos tipos do enumerator KeywordType.
     * Rotina só deve ser chamada se o tipo do token for um KEYWORD
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
     * @param  command instrução a ser analisada.
     * @return somente o símbolo ou o valor número da instrução.
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
     * Retorna o valor numérico de um token que é um número constante.
     * Deve ser chamado somente quando o tipo de token for um INT_CONST.
     * @param  token a ser analisado.
     * @return o valor numérico (Integer) do token informado (String).
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
     * Caso o token possua aspas, estas deverão ser removidas.
     * Deve ser chamado somente quando o tipo de token for um STRING_CONST.
     * @param  token a ser analisado.
     * @return o valor numérico (Integer) do token informado (String).
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