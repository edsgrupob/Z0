library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mux4Way16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			b:   in  STD_LOGIC_VECTOR(15 downto 0);
			c:   in  STD_LOGIC_VECTOR(15 downto 0);
			d:   in  STD_LOGIC_VECTOR(15 downto 0);
			sel: in  STD_LOGIC_VECTOR(1 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end entity;

architecture ChipMux4Way16 of Mux4way16 is

signal not_s0, not_s1 : STD_LOGIC;

begin

	not_s0 <= not sel(0);
	not_s1 <= not sel(1);
	
	q <= a and not_s0 and not_s1 else
	b and sel(0) and not_s1 else
	c and not_s0 and sel(1) else
	d and sel(0) and sel(1) else a;
	
end ;
