library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity DMux8Way is
	port ( 
			a:   in  STD_LOGIC;
			sel: in  STD_LOGIC_VECTOR(2 downto 0);
			q0:  out STD_LOGIC;
			q1:  out STD_LOGIC;
			q2:  out STD_LOGIC;
			q3:  out STD_LOGIC;
			q4:  out STD_LOGIC;
			q5:  out STD_LOGIC;
			q6:  out STD_LOGIC;
			q7:  out STD_LOGIC);
end entity;
architecture arch_DMux8Way of DMux8Way is
signal not_s0, not_s1, not_s2 : STD_LOGIC;
begin
	not_s0 <= not sel(0);
	not_s1 <= not sel(1);
	not_s2 <= not sel(2);
	q0 <= not_s0 and not_s1 and not_s2 and a;
	q1 <= sel(0) and not_s1 and not_s2 and a;
	q2 <= not_s0 and sel(1) and not_s2 and a;
	q3 <= sel(0) and sel(1) and not_s2 and a;
	q4 <= not_s0 and not_s1 and sel(2) and a;
	q5 <= sel(0) and not_s1 and sel(2) and a;
	q6 <= not_s0 and sel(1) and sel(2) and a;
	q7 <= sel(0) and sel(1) and sel(2) and a;
end ;