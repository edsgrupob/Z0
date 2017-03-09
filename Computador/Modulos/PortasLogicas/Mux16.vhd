library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mux16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			b:   in  STD_LOGIC_VECTOR(15 downto 0);
			sel: in  STD_LOGIC;
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end entity;
architecture arch_Mux16 of Mux16 is 
begin
process (a,b,sel)
begin
		if (sel = '1') then
			q <= b;
		else
			q <= a;
		end if;
end process;
end architecture;	