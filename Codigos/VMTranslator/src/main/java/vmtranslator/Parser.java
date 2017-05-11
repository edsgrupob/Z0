/**
 * Curso: Elementos de Sistemas
 * Arquivo: Parser.java
 */

package vmtranslator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Encapsula o código de leitura. Carrega as instruções na linguagem de máquina virtual a pilha,
 * analisa, e oferece acesso aos comandos.
 * Além disso, remove todos os espaços em branco e comentários.
 */



public class Parser {
    String line;
	BufferedReader br;
	StringBuilder sb;
	String tipoComando;
    /** Enumerator para os tipos de comandos de Linguagem de Máquina Virtua a Pilha. */
	
    public enum CommandType {
        C_ARITHMETIC,      // comandos aritméticos
        C_PUSH,            // comandos de push
        C_POP,             // comandos de pop
        C_LABEL,           // 
        C_GOTO,            // 
        C_IF,              // 
        C_FUNCTION,        // 
        C_RETURN,          // 
        C_CALL             // 
    }
    
  

    /** 
     * Abre o arquivo de entrada VM e se prepara para analisá-lo.
     * @param file arquivo VM que será feito o parser.
     * @throws FileNotFoundException 
     */
    

    public Parser(String file) throws FileNotFoundException {
    	try(BufferedReader br = new BufferedReader(new FileReader(file))){
//    		StringBuilder sb = new StringBuilder();
//    		sb.append(line);
//	        sb.append(System.lineSeparator());

//    	    String everything = sb.toString();
    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	} 
        
    }
    /**
     * Carrega um comando e avança seu apontador interno para o próxima
     * linha do arquivo de entrada. Caso não haja mais linhas no arquivo de
     * entrada o método retorna "Falso", senão retorna "Verdadeiro".
     * @return Verdadeiro se ainda há instruções, Falso se as instruções terminaram.
     */
    public Boolean advance() {
    	try {
            line = br.readLine();
	    	if (line != null) {

		        return true;
			}
	    	else {
	    		return false;
	    	}
    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return null;

    }

    /**
     * Retorna o comando "intrução" atual (sem o avanço)
     * @return a instrução atual para ser analilisada
     */
    public String command() {
        return line;

    }

    /**
     * Retorna o tipo da instrução passada no argumento:
     *  C_PUSH para push, por exemplo push constant 1
     *  C_POP para pop, por exemplo pop constant 2
     * @param  command instrução a ser analisada.
     * @return o tipo da instrução.
     */
    public CommandType commandType(String command) {
    	String[] parts = command.split(" ");
    	if(parts[0].equals("push")){
    		return CommandType.C_PUSH;
    	}
    	if(parts[0].equals("pop")){
    		return CommandType.C_POP;
    	}
    	if(parts[0].equals("label")){
    		return CommandType.C_LABEL;
    	}
    	if(parts[0].equals("goto")){
    		return CommandType.C_GOTO;
    	}
    	if(parts[0].equals("if-goto")){
    		return CommandType.C_IF;
    	}
    	if(parts[0].equals("function")){
    		return CommandType.C_FUNCTION;
    	}
    	if(parts[0].equals("return")){
    		return CommandType.C_RETURN;
    	}
    	if(parts[0].equals("call")){
    		return CommandType.C_CALL;
    	}
    	else{
        return CommandType.C_ARITHMETIC;
    	}
    }
    

    /**
     * Retorna o primeiro argumento de um comando push ou pop passada no argumento.
     * Se for um comando aritmético, retorna o próprio texto do comando 
     * Deve ser chamado somente quando commandType() é diferente de C_RETURN.
     * @param  command instrução a ser analisada.
     * @return somente o símbolo ou o valor número da instrução.
     */
    public String arg1(String command) {
    	String[] partes = command.split(" ");
    	if(commandType(command) != CommandType.C_RETURN) {	
	    	if(commandType(command) == CommandType.C_ARITHMETIC){
	    		return command;}
	    	else{
	    		return command.split(" ")[1];	
	    	}
    }
    
    	return null;
    }

    /**
     * Retorna o segundo argumento de um comando push ou pop passada no argumento.
     * Deve ser chamado somente quando commandType() é C_PUSH, C_POP, C_FUNCTION, ou C_CALL.
     * @param  command instrução a ser analisada.
     * @return o símbolo da instrução (sem os dois pontos).
     */
    public Integer arg2(String command) {
    	return Integer.parseInt(command.split(" ")[2]);
    }
}
