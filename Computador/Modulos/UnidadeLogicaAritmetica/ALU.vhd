-- Unidade Lógica Aritmética (ULA)
-- Recebe dois valores de 16bits e
-- calcula uma das seguintes funções:
-- X+y, x-y, y-x, 0, 1, -1, x, y, -x, -y,
-- X+1, y+1, x-1, y-1, x&y, x|y
-- De acordo com os 6 bits de entrada denotados:
-- zx, nx, zy, ny, f, no.
-- Também calcula duas saídas de 1 bit:
-- Se a saída == 0, zr é definida como 1, senão 0;
-- Se a saída <0, ng é definida como 1, senão 0.
-- a ULA opera sobre os valores, da seguinte forma:
-- se (zx == 1) então x = 0
-- se (nx == 1) então x =! X
-- se (zy == 1) então y = 0
-- se (ny == 1) então y =! Y
-- se (f == 1) então saída = x + y
-- se (f == 0) então saída = x & y
-- se (no == 1) então saída = !saída
-- se (out == 0) então zr = 1
-- se (out <0) então ng = 1

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity ALU is
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
end entity;
architecture arch_ALU of ALU is
-- Temos que criar as saídas das operações. Primeiro os zeradores e inversores
-- Depois, as saídas do And e Add juntas para colocar no Mux
-- Por fim, mais uma saída com o resultado da Mux para inverter no final

	signal zerador_x,zerador_y,inversor_x,inversor_y, saida_and, saida_add, saida_mux, saida_final: STD_LOGIC_VECTOR(15 downto 0);

	component Add16
		port(	a : in STD_LOGIC_VECTOR(15 downto 0);
				b : in STD_LOGIC_VECTOR(15 downto 0);
				q : out STD_LOGIC_VECTOR(15 downto 0));
	end component;

	component Mux16
		port(a:   in  STD_LOGIC_VECTOR(15 downto 0);
			  b:   in  STD_LOGIC_VECTOR(15 downto 0);
			  sel: in  STD_LOGIC;
			  q:   out STD_LOGIC_VECTOR(15 downto 0));
	end component;
-- Agora precisamos importar o Mux16 e o Add16 (fig: And é só código e Incre não é nada)
-- Inv e 0 como vi é codigo tbm
	begin
	-- Vamos começar pelo simples, pegar os resultados zerados/invertidos
		zerador_x <= x when (zx = '0') else ("0000000000000000");
		zerador_y <= y when (zy = '0') else ("0000000000000000");
		inversor_x <= zerador_x when (nx = '0') else (not zerador_x);
		inversor_y <= zerador_y when (ny = '0') else (not zerador_y);
	-- Agora precisamos juntar o resultado de And e Add para colocar no Mux
	-- VER COM O RAPHA O PORT MAP!!!
		saida_and <= inversor_x and inversor_y;
		u1: Add16 port map (inversor_x, inversor_y, saida_add);
		u2: Mux16 port map (saida_and, saida_add, f, saida_mux);
	-- Agora é só tratar o resultado
		saida_final <= saida_mux when (no = '0') else (not saida_mux);
		zr <= '1' when (saida_final = "0000000000000000") else '0';
		ng <= '1' when (saida_final(15) = '1') else '0';
		saida <= saida_final;
end architecture;