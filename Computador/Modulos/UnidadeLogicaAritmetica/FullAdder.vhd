-- Full Adder

Library ieee;
use ieee.std_logic_1164.all;

entity FullAdder is
	port(
		a,b,c:      in STD_LOGIC;   -- entradas
		soma,vaium: out STD_LOGIC   -- sum e carry
	);
end entity;
architecture arch_FullAdder of FullAdder is 
signal a_b_xor, a_b_and, abxor_c_and : STD_LOGIC;
begin
	a_b_xor <= a xor b;
	a_b_and <= a and b;
	abxor_c_and <= a_b_xor and c;
	soma <= a_b_xor xor c;
	vaium	 <= abxor_c_and or a_b_and;
end architecture;	
