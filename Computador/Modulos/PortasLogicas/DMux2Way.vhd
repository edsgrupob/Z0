library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity DMux2Way is
	port ( 
			a:   in  STD_LOGIC;
			sel: in  STD_LOGIC;
			q0:  out STD_LOGIC;
			q1:  out STD_LOGIC);
end entity;
architecture arch_DMux2Way of DMux2Way is
signal not_sel : STD_LOGIC;
begin
	not_sel <= not sel;
	q0 <= a and not_sel;
	q1 <= a and sel;
end ;
