/**
 * Curso: Elementos de Sistemas
 * Arquivo: JackCompiler.java
 */

package compiler;

import java.io.File;

/**
 * Classe principal (main) que orquestra a tradução do arquivo em linguagem de máquina virtual à pilha.
 * Essa classe é responsável por ler os parametros da execução do programa pela linha de código, ou
 * seja, se o programa for invocado com parâmetros esses deverão ser carregados.
 * Opções:
 *   <arquivo jack>      primeiro parametro é o nome do arquivo jack a ser aberto 
 *   -o <arquivo vm>     parametro (opcional) que indica onde será salvo o arquivo gerado .vm
 */
class JackCompiler {

	/**
	 * Método estático que é carregado na execução do programa.
	 * Os parâmetros de linha de comando dever ser tratados nessa rotina.
	 */ 
	public static void main(String[] args) {
		
		File file = new File(args[0]);
		String inputName = null;
		String outputName = null;

		boolean exists =      file.exists();      // Check if the file exists
		boolean isDirectory = file.isDirectory(); // Check if it's a directory
		boolean isFile =      file.isFile();      // Check if it's a regular file
		
		if ((isFile && isDirectory) || exists) {
			inputName = file.getName().toString();
			outputName = file.getName().replace(".jack", ".vm").toString();
		}
		
		if (exists && (isFile && isDirectory)){
			System.err.println("Arquivo de entrada invalido");
			System.exit(1);
		}
		
		CompilationEngine codeVM = new CompilationEngine(inputName, outputName);
		codeVM.compileClass();
		//codeVM.close();
	}
}
