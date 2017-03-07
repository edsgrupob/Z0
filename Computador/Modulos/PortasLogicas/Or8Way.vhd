library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Or8Way is
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

architecture arch_Or8Way of Or8Way is 
signal w1,w2,w3,w4,w5,w6: STD_LOGIC;
begin
	w1 <= a or b;
	w2 <= c or d;
	w3 <= e or f;
	w4 <= g or h;
	w5 <= w1 or w2;
	w6 <= w3 or w4;
	q <= w5 or w6;
end architecture;