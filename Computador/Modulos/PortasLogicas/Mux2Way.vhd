library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mux2Way is
	port ( 
			a:   in  STD_LOGIC;
			b:   in  STD_LOGIC;
			sel: in  STD_LOGIC;
			q:   out STD_LOGIC);
end entity;
architecture arch_Mux2Way of Mux2Way is
signal sel_not, first, second : STD_LOGIC;
begin
	sel_not <= not sel;
	first <= a and sel_not;
	second <= b and sel;
	q <= first or second;
end ;
