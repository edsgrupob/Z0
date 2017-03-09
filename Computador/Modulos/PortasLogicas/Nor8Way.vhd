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
	w1 <= a or b;
	w2 <= c or d;
	w3 <= e or f;
	w4 <= g or h;
	w5 <= w1 or w2;
	w6 <= w3 or w4; 
	q <= not(w5 or w6);

end architecture;