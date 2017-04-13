
library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity CPU is
    port(
        clock:	     in  STD_LOGIC;                        -- sinal de clock para CPU
        inM:         in  STD_LOGIC_VECTOR(15 downto 0);    -- dados lidos da memória RAM
        instruction: in  STD_LOGIC_VECTOR(15 downto 0);    -- instrução (dados) vindos da memória ROM
        reset:       in  STD_LOGIC;                        -- reinicia toda a CPU (inclusive o Program Counter)
        outM:        out STD_LOGIC_VECTOR(15 downto 0);    -- dados para gravar na memória RAM
        writeM:      out STD_LOGIC;                        -- faz a memória RAM gravar dados da entrada
        addressM:    out STD_LOGIC_VECTOR(14 downto 0);    -- envia endereço para a memória RAM
        pcout:       out STD_LOGIC_VECTOR(14 downto 0)     -- endereço para ser enviado a memória ROM
  );
end entity;
architecture arch_CPU of CPU is

component ALU
	port (
			x,y:   in STD_LOGIC_VECTOR(15 downto 0); -- entradas de dados da ALU
			zx:    in STD_LOGIC;                     -- zera a entrada x
			nx:    in STD_LOGIC;                     -- inverte a entrada x
			zy:    in STD_LOGIC;                     -- zera a entrada y
			ny:    in STD_LOGIC;                     -- inverte a entrada y
			f:     in STD_LOGIC;                     -- se 0 calcula x & y, senão x + y
			no:    in STD_LOGIC;                     -- inverte o valor da saída
			zr:    out STD_LOGIC;                    -- setado se saída igual a zero
			ng:    out STD_LOGIC;                    -- setado se saída é negativa
			saida: out STD_LOGIC_VECTOR(15 downto 0) -- saída de dados da ALU
	);
end component;

component Mux2Way
	port ( 
			a:   in  STD_LOGIC;
			b:   in  STD_LOGIC;
			sel: in  STD_LOGIC;
			q:   out STD_LOGIC);
end component;

component Register16
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC_VECTOR(15 downto 0);
		load:    in STD_LOGIC;
		output: out STD_LOGIC_VECTOR(15 downto 0)
	);
end component;

component PC
    port(
			clock     : in  STD_LOGIC;
			increment : in  STD_LOGIC;
			load      : in  STD_LOGIC;
			reset     : in  STD_LOGIC;
			input     : in  STD_LOGIC_VECTOR(15 downto 0);
			output    : out STD_LOGIC_VECTOR(14 downto 0)
    );
end component;

component ControlUnit
    port(
		instruction                 : in STD_LOGIC_VECTOR(15 downto 0);  -- instrução para executar
		zr,ng                       : in STD_LOGIC;                      -- valores zr(se zero) e ng(se negativo) da ALU
		muxALUI_A                   : out STD_LOGIC;                     -- mux que seleciona entre instrução e ALU para reg. A
		muxAM_ALU                   : out STD_LOGIC;                     -- mux que seleciona entre reg. A e Mem. RAM para ALU
		zx, nx, zy, ny, f, no       : out STD_LOGIC;                     -- sinais de controle da ALU
		loadA, loadD, loadM, loadPC : out STD_LOGIC                      -- sinais de load do reg. A, reg. D, Mem. RAM e Program Counter
    );
end component;

signal zr_cu,ng_cu,muxALUI_A,muxAM_ALU,zx_cu, nx_cu, zy_cu, ny_cu, f_cu, no_cu,loadA, loadD, loadM, loadPC, -- Control Unit
		 zx, nx, zy, ny, f, no, zr,ng,-- ALU
		 clock_pc, increment, load_pc, reset_pc, -- PC
		 a, b, sel, sel2, q, q2, -- MUX
		 clock_reg, load_reg, clock_reg2, load_reg2: STD_LOGIC;

signal x, y, instruction_cu, input_PC, input_reg, output_reg, output_reg2, saida_alu: STD_LOGIC_VECTOR(15 downto 0);
signal output_pc: STD_LOGIC_VECTOR(14 downto 0);
		 

begin
u1: ControlUnit port map (instruction_cu, zr_cu,ng_cu,muxALUI_A,muxAM_ALU,zx_cu, nx_cu, zy_cu, ny_cu, f_cu, no_cu,loadA, loadD, loadM, loadPC);
u2: Mux2Way port map (saida_alu, instruction_cu, sel, q);
u3: Register16 port map (clock_reg, q, load_reg, output_reg);
u4: Mux2Way port map (output_reg,inM,sel,q2);
u5: Register16 port map (clock_reg2, output_alu, load_reg2, output_reg2);
u6: ALU port map (q2, output_reg2, zx, nx, zy, ny, f, no, zr,ng, saida_alu);
u7: PC port map (clock_pc, increment, load_pc, reset_pc,q2, output_pc);
u8: CPU port map (clock,inM,instruction,reset,outM,writeM,addressM,output_pc);
end architecture;
