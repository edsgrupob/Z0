-- Elementos de Sistemas
-- by Luciano Soares
-- Register8.vhd

Library ieee; 
use ieee.std_logic_1164.all;
  
entity Register8 is
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC_VECTOR(7 downto 0);
		load:    in STD_LOGIC;
		output: out STD_LOGIC_VECTOR(7 downto 0)
	);
end entity;

architecture arch_Register8 of Register8 is

component BinaryDigit
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC;
		load:    in STD_LOGIC;
		output: out STD_LOGIC
	);
end component;

begin 
	u1: BinaryDigit port map (input[0], clock, output[0], load);
	u2: BinaryDigit port map (input[1], clock, output[1], load);
	u3: BinaryDigit port map (input[2], clock, output[2], load);
	u4: BinaryDigit port map (input[3], clock, output[3], load);
	u5: BinaryDigit port map (input[4], clock, output[4], load);
	u6: BinaryDigit port map (input[5], clock, output[5], load);
	u7: BinaryDigit port map (input[6], clock, output[6], load);
	u8: BinaryDigit port map (input[7], clock, output[7], load);
end architecture;