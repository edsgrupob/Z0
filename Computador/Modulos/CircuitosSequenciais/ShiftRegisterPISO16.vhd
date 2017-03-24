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

architecture arch_ShiftRegisterPISO16 of ShiftRegisterPISO16 is

signal w: STD_LOGIC_VECTOR(30 downto 0);
signal sel: STD_LOGIC;

component FlipFlopD
	port(
		clock:  in std_logic;
		d:      in std_logic;
		clear:  in std_logic;
		preset: in std_logic;
		q:     out std_logic
	);
end component;

component Mux2Way
	port (
			a:   in  STD_LOGIC;
			b:   in  STD_LOGIC;
			sel: in  STD_LOGIC;
			q:   out STD_LOGIC);
end component;

begin
	sel <= not shift;
	u1: Mux2Way port map ('0', input(0), sel, w(0));
	u2: FlipFlopD port map (clock, w(0), '1', '1', w(1));
	u3: Mux2Way port map (w(1), input(1), sel, w(2));
	u4: FlipFlopD port map (clock, w(2), '1', '1',  w(3));
	u5: Mux2Way port map (w(3), input(2), sel, w(4));
	u6: FlipFlopD port map (clock, w(4), '1', '1',  w(5));
	u7: Mux2Way port map (w(5), input(3), sel, w(6));
	u8: FlipFlopD port map (clock, w(6), '1', '1',  w(7));
	u9: Mux2Way port map (w(7), input(4), sel, w(8));
	u10: FlipFlopD port map (clock, w(8), '1', '1',  w(9));
	u11: Mux2Way port map (w(9), input(5), sel, w(10));
	u12: FlipFlopD port map (clock, w(10), '1', '1',  w(11));
	u13: Mux2Way port map (w(11), input(6), sel, w(12));
	u14: FlipFlopD port map (clock, w(12), '1', '1',  w(13));
	u15: Mux2Way port map (w(13), input(7), sel, w(14));
	u16: FlipFlopD port map (clock, w(14), '1', '1',  w(15));
	u17: Mux2Way port map (w(15), input(8), sel, w(16));
	u18: FlipFlopD port map (clock, w(16), '1', '1',  w(17));
	u19: Mux2Way port map (w(17), input(9), sel, w(18));
	u20: FlipFlopD port map (clock, w(18), '1', '1',  w(19));
	u21: Mux2Way port map (w(19), input(10), sel, w(20));
	u22: FlipFlopD port map (clock, w(20), '1', '1',  w(21));
	u23: Mux2Way port map (w(21), input(11), sel, w(22));
	u24: FlipFlopD port map (clock, w(22), '1', '1',  w(23));
	u25: Mux2Way port map (w(23), input(12), sel, w(24));
	u26: FlipFlopD port map (clock, w(24), '1', '1',  w(25));
	u27: Mux2Way port map (w(25), input(13), sel, w(26));
	u28: FlipFlopD port map (clock, w(26), '1', '1',  w(27));
	u29: Mux2Way port map (w(27), input(14), sel, w(28));
	u30: FlipFlopD port map (clock, w(28), '1', '1',  w(29));
	u31: Mux2Way port map (w(29), input(15), sel, w(30));
	u32: FlipFlopD port map (clock, w(30), '1', '1',  output);
end architecture;
