-- Elementos de Sistemas
-- by Luciano Soares
-- Ram64.vhd

Library ieee; 
use ieee.std_logic_1164.all;
  
entity Ram64 is
	port(
		clock:   in  STD_LOGIC;
		input:   in  STD_LOGIC_VECTOR(15 downto 0);
		load:    in  STD_LOGIC;
		address: in  STD_LOGIC_VECTOR( 5 downto 0);
		output:  out STD_LOGIC_VECTOR(15 downto 0)
	);
end entity;

architecture arch_Ram64 of Ram64 is

component Ram8
	port(
		clock:   in  STD_LOGIC;
		input:   in  STD_LOGIC_VECTOR(15 downto 0);
		load:    in  STD_LOGIC;
		address: in  STD_LOGIC_VECTOR( 2 downto 0);
		output:  out STD_LOGIC_VECTOR(15 downto 0)
	);
end component;

signal w1, w2, w3, w4, w5, w6, w7, w8: STD_LOGIC_VECTOR(15 downto 0);

begin
	u1: Ram8 port map (clock, input, load, address, w1);
	u2: Ram8 port map (clock, input, load, address, w2);
	u3: Ram8 port map (clock, input, load, address, w3);
	u4: Ram8 port map (clock, input, load, address, w4);
	u5: Ram8 port map (clock, input, load, address, w5);
	u6: Ram8 port map (clock, input, load, address, w6);
	u7: Ram8 port map (clock, input, load, address, w7);
	u8: Ram8 port map (clock, input, load, address, w8);
	
end architecture;
