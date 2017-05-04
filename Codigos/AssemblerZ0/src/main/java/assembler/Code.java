/**
 * Curso: Elementos de Sistemas
 * Arquivo: Code.java
 */

package assembler;

/** 
 * Traduz mnemônicos da linguagem assembly para códigos binários da arquitetura Z0.
 */
public class Code {

    /**
     * Retorna o código binário do(s) registrador(es) que vão receber o valor da instrução.
     * @param  mnemnonic vetor de mnemônicos "instrução" a ser analisada.
     * @return Opcode (String de 3 bits) com código em linguagem de máquina para a instrução.
     */
    public static String dest(String[] mnemnonic) {
    	if (mnemnonic.length == 2) {
    		if (mnemnonic[1].equals("%D")) {
    			return "010";
    		}
    		else {
    			return "100";
    		}
    	}
    	else if (mnemnonic.length == 3) {
    		if (mnemnonic[2].equals("%D")) {
    			return "010";
    		}
    		else if (mnemnonic[2].equals("%A")) {
    			return "100";
    		}
    		else {
    			return "001";
    		}
    	}
    	else if (mnemnonic.length == 4) {
    		if (mnemnonic[3].equals("%D")) {
    			return "010";
    		}
    		else {
    			return "100";
    		}
    	}
    	else {
    		return "000";
    	}
    }

    /**
     * Retorna o código binário do mnemônico para realizar uma operação de cálculo.
     * @param  mnemnonic vetor de mnemônicos "instrução" a ser analisada.
     * @return Opcode (String de 7 bits) com código em linguagem de máquina para a instrução.
     */
    public static String comp(String[] mnemnonic) {
    	if (mnemnonic.length == 1) {
    		if (mnemnonic[0].equals("nop")) {
    			return "0101010";
    		}
    		else {
    			return "0001100";
    		}
    	}
    	
    	else if (mnemnonic.length == 2) {
    		
      		if (mnemnonic[0].equals("incw")) {
      			return "0011111";
      		}

      		else if (mnemnonic[0].equals("decw")) {
      			if (mnemnonic[1].equals("%A")) {
    	  			return "0110010";
    	  		}
    	  		else {
    	  			return "0001110";
    	  		}
    	  	}
      		
      		else if (mnemnonic[0].equals("notw")){
      			if (mnemnonic[1].equals("%A")) {
      				return "0110001";
      			}
      			else{
      				return "0001101";
      			}
      		}
      		else if (mnemnonic[0].equals("negw")) {
      			if (mnemnonic[1].equals("%A")) {
      				return "0110011";  				
      			}
      			else {
      				return "0001111";
      			}
      		}
      	}
    	
      	if (mnemnonic.length == 3){
      		if (mnemnonic[1].equals("%D")){
      			return "0001100";
      		}
      		else if (mnemnonic[1].equals("%A")){
      			return "0110000";
      		}
      		else {
      			return "1110000";
      		}
      	}
      	
      	if (mnemnonic.length == 4){
      		if (mnemnonic[0].equals("addw")){
      			if (mnemnonic[1].equals("%A")) {
      				return "0000010";
      			}
      			else{
      				return "1000010";
      			}
      		}
      		else if (mnemnonic[0].equals("andw")) {
      			if (mnemnonic[1].equals("%D")) {
      				return "0000000";  				
      			}
      			else {
      				return "1000000";
      			}
      		}
      		else if (mnemnonic[0].equals("orw")){
      			if (mnemnonic[1].equals("%D")) {
    				return "0010101";  				
      			}
      			else {
      				return "1010101";
      			}
      		}
      		else if (mnemnonic[0].equals("subw")){
      			return "1010011";
      		}

	  		else {
	  			return "1000111";
	  		}
      	}
      	return null;
    }

    /**
     * Retorna o código binário do mnemônico para realizar uma operação de jump (salto).
     * @param  mnemnonic vetor de mnemônicos "instrução" a ser analisada.
     * @return Opcode (String de 3 bits) com código em linguagem de máquina para a instrução.
     */
    public static String jump(String[] mnemnonic) {
    	if (mnemnonic[0].equals("jmp")) {
    		return "111";
    	} 
    	else if (mnemnonic[0].equals("je")) {
    		return "010";
    	}
    	else if (mnemnonic[0].equals("jne")) {
    		return "101";
    	}
    	else if (mnemnonic[0].equals("jg")) {
    		return "001";
    	}
    	else if (mnemnonic[0].equals("jge")) {
    		return "011";
    	}
    	else if (mnemnonic[0].equals("jl")) {
    		return "100";
    	}
    	else if (mnemnonic[0].equals("jle")) {
    		return "110";
    	}
    	else {
    		return "000";
    	}
    }

    /**
     * Retorna o código binário de um valor decimal armazenado numa String.
     * @param  symbol valor numérico decimal armazenado em uma String.
     * @return Valor em binário (String de 15 bits) representado com 0s e 1s.
     */
    public static String toBinary(String symbol) {
		int decimal = Integer.parseInt(symbol);
		String binary = Integer.toBinaryString(decimal);
		int size = binary.length();
		for (int i = 0; i < 15 - size; i++){
			binary = "0" + binary;
		}
		return binary;
    }

}
