library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity DMux4Way is
	port ( 
			a:   in  STD_LOGIC;
			sel: in  STD_LOGIC_VECTOR(1 downto 0);
			q0:  out STD_LOGIC;
			q1:  out STD_LOGIC;
			q2:  out STD_LOGIC;
			q3:  out STD_LOGIC);
end entity;
architecture arch_DMux4Way of DMux4Way is
signal not_s0, not_s1 : STD_LOGIC;
begin
	not_s0 <= not sel(0);
	not_s1 <= not sel(1);
	q0 <= not_s0 and not_s1 and a;
	q1 <= not_s0 and sel(1) and a;
	q2 <= sel(0) and not_s1 and a;
	q3 <= sel(0) and  sel(1) and a;
end ;

	