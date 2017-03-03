library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Not16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end entity;

architecture arch_not16 of chip_not16 is component chip_not16
	port (a: in STD_LOGIC;
	      q: out STD_LOGIC);
end component;
begin
	q <= not a;
	
end architecture;