library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mux4Way is
	port ( 
			a:   in  STD_LOGIC;
			b:   in  STD_LOGIC;
			c:   in  STD_LOGIC;
			d:   in  STD_LOGIC;
			sel: in  STD_LOGIC_VECTOR(1 downto 0);
			q:   out STD_LOGIC);
end entity;
architecture arch_Mux4Way of Mux4Way is
signal first, second, third, fourth, not_s0, not_s1 : STD_LOGIC;
begin
	not_s0 <= not sel(0);
	not_s1 <= not sel(1);
	first <= a and not_s0 and not_s1;
	second <= b and sel(0) and not_s1;
	third <= c and not_s0 and sel(1);
	fourth <= d and sel(0) and sel(1);
	q <= first or second or third or fourth;
end ;
