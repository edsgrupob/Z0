/**
 * Curso: Elementos de Sistemas
 * Arquivo: VMTranslator.java
 */

package vmtranslator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import vmtranslator.Parser;
import vmtranslator.Code;

/**
 * Classe principal que orquestra a tradução do arquivo em linguagem de máquina virtual à pilha.
 * Opções:
 *   <arquivo vm>         primeiro parametro é o nome do arquivo vm a ser aberto 
 *   -o <arquivo nasm>    parametro indica onde será salvo o arquivo gerado .nasm
 *   -n                   parametro indica não colocar rotina de bootstrap (conveniente para testar)
 */
class VMTranslator {

	private static final String FILENAME = "<arquivo vm>";
	private static final String OUTPUT = "<arquivo nasm>";

    public static void main(String[] args) {

    	Parser parser = new Parser();
    	Code code = new Code();

    	BufferedReader bufferedReader = null;
    	FileReader fileReader = null;

    	try {
    		fileReader = new FileReader(FILENAME);
    		bufferedReader = new BufferedReader(fileReader);

    		String sCurrentLine;

    		bufferedReader = new BufferedReader(new FileReader(FILENAME));

    		while ((sCurrentLine = br.readLine()) != null) {


    			












    		}

    	}

    	catch (IOException e) {
    		e.printStackTrace();
    	}

    	finally {
    		
    		try {
    			
    			if (bufferedReader != null) {
    				bufferedReader.close();
    			}
    		
    			if (fileReader != null) {
    				fileReader.close();
    			}
    		}

    		catch (IOException ex) {
    			ex.printStackTrace();
    		}
    	}

    }

}





