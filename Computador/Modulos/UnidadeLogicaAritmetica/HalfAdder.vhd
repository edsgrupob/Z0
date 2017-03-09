-- Half Adder
-- Half Adder contem: sum é um xor e carry é um and
Library ieee;
use ieee.std_logic_1164.all;

entity HalfAdder is
	port(
		a,b:         in STD_LOGIC;   -- entradas
		soma,vaium: out STD_LOGIC   -- sum e carry
	);
end entity;
architecture chip_HalfAdder of HalfAdder is
begin
	soma <= a xor b;
	vaium <= a and b;
end architecture;