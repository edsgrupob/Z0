-- Elementos de Sistemas
-- by Luciano Soares
-- ShiftRegisterPISO16.vhd

-- shift register tipo PISO de 16 bits:
-- If shift == 0 then carrega dados da entrada (input)
-- Senão a saída (output) vai emitindo bit a bit o valor do registrar interno
-- ou seja, a cada pulso de clock: output = input[0], output = input[1], output = input[2], ...
-- os outros bits necessário para preencher o espaço que abriu no shift podem ser preenchidos com 0

Library ieee; 
use ieee.std_logic_1164.all;

entity ShiftRegisterPISO16 is
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC_VECTOR(15 downto 0);
		shift:   in STD_LOGIC;
		output: out STD_LOGIC
	);
end entity;
