library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Nor8Way is
	port ( 
			a:   in  STD_LOGIC;
			b:   in  STD_LOGIC;
			c:   in  STD_LOGIC;
			d:   in  STD_LOGIC;
			e:   in  STD_LOGIC;
			f:   in  STD_LOGIC;
			g:   in  STD_LOGIC;
			h:   in  STD_LOGIC;
			q:   out STD_LOGIC);
end entity;

architecture arch_nor8way of Nor8Way is
component chip_nor
end component;

signal w1,w2,w3,w4,w5,w6: STD_LOGIC;
begin
	w1 <= a nor b;
	w2 <= c nor d;
	w3 <= e nor f;
	w4 <= g nor h;
	w5 <= w1 nor w2;
	w6 <= w3 nor w4; 
	q <= w5 nor w6;
end architecture;