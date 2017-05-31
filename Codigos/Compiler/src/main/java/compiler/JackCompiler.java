/**
 * Curso: Elementos de Sistemas
 * Arquivo: JackCompiler.java
 */

package compiler;

/**
 * Classe principal (main) que orquestra a tradução do arquivo em linguagem de máquina virtual à pilha.
 * Essa classe é responsável por ler os parametros da execução do programa pela linha de código, ou
 * seja, se o programa for invocado com parâmetros esses deverão ser carregados.
 * Opções:
 *   <arquivo jack>      primeiro parametro é o nome do arquivo jack a ser aberto 
 *   -o <arquivo vm>     parametro (opcional) que indica onde será salvo o arquivo gerado .vm
 *   -x                  gera arquivos de saída da análise sintática em XML
 */
class JackCompiler {

	/**
	 * Método estático que é carregado na execução do programa.
	 * Os parâmetros de linha de comando dever ser tratados nessa rotina.
	 */ 
	public static void main(String[] args) {
		String inputName = "";
    	String outputName = "";
    	String outputNameXML = "";
		int i = 0;

		if (args.length>0 && args[0].split(".")[1].equals("jack")) {
			inputName = args[0];
		}
		
		while(i != args.length){

			if (args[i].equals("-o")){
				outputName = args[i+1];
			}
			
			if (args[i].equals("-x")){
				outputNameXML = args[i+1];
			}
		
			i+=1;
		}
		
		if (inputName == null){
			System.err.println("Arquivo de entrada invalido");
			System.exit(1);
		}

		if (outputName == null){
			outputName = (inputName.split(".")[0]+".vm");
		}
		
		if (outputNameXML == null){
			outputNameXML = (inputName.split(".")[0]+".xml");
		}
		
		CompilationEngine codeVM = new CompilationEngine(inputName, outputName);
		codeVM.compileClass();
	}
}
