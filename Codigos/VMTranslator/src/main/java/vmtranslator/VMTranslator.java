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

class VM Translator {

    public static void main(String[] args) {

    	String inputName;
    	String outputName;
		int i = 0;

		if args.length>0 && args[0].split(".")[1].equals(".vm"){
			inputName = args[0];
		}
		
		while(i != args.length){

			if (args[i].equals("-o") && (i+2) != args.length){
				outputName = args[i+1];
			}
		
			i+=1;
		}
		
		if (inputName == null){
			System.err.println("Arquivo de entrada invalido");
			System.exit(1);
		}

		if (outputName == null){
			outputName = (inputName.split(".")[0]+".nasm");
		}
    	
    	Parser parser = new Parser(fileName);
    	Code code = new Code(fileName.split(".")[0]+".nasm");


    	while(parser.advance()){

			switch(parser.commandType(parser.command())){

					case "C_ARITHMETIC":
						code.writeArithmetic(parser.arg1(parser.command()));
						break;

					case "C_PUSH":
					case "C_POP":
						code.writePushPop(parser.arg1(parser.command()),parser.arg2(parser.command()));
						break;

					case "C_LABEL":
						code.writeLabel(parser.arg1(parser.command()));
						break;

					case "C_GOTO":
						code.writeGoto(parser.arg1(parser.command()));
						break;

					case "C_IF":
						code.writeIf(parser.arg1(parser.command()));
						break;

					case "C_FUNCTION":
						code.writeFunction(parser.arg1(parser.command()),parser.arg2(parser.command()));
						break;

					case "C_RETURN":
						code.writeReturn();
						break;

					case "C_CALL":
						code.writeCall(parser.arg1(parser.command()),parser.arg2(parser.command()));
						break;

			}
		}
    }
}




