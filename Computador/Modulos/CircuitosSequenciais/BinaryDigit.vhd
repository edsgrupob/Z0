-- Elementos de Sistemas
-- by Luciano Soares
-- BinaryDigit.vhd

Library ieee;
use ieee.std_logic_1164.all;

entity BinaryDigit is
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC;
		load:    in STD_LOGIC;
		output: out STD_LOGIC
	);
end entity;
architecture arch_BinaryDigit of BinaryDigit is
	signal w1,w2: std_logic;
	
	component Mux2Way is
		port ( 
				a:   in  STD_LOGIC;
				b:   in  STD_LOGIC;
				sel: in  STD_LOGIC;
				q:   out STD_LOGIC);
	end component;
	
	component FlipFlopD is
		port(
			clock:  in std_logic;
			d:      in std_logic;
			clear:  in std_logic;
			preset: in std_logic;
			q:     out std_logic);
	end component;
begin

	u1: FlipFlopD port map (clock, w1, '1', '1', w2);
	u2: Mux2Way port map (w2, input, load, w1);
	output <= w1;
end architecture;


