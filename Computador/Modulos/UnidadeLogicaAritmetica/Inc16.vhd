-- Incrementador de 16 bits
-- adiciona 1 ao valore de entrada (adição aritmética)

library IEEE; 
use IEEE.STD_LOGIC_1164.all;
  
entity Inc16 is
	port(
		a   :  in STD_LOGIC_VECTOR(15 downto 0);
		q   : out STD_LOGIC_VECTOR(15 downto 0) 
	);
end entity;

architecture arch_Inc16 of Inc16 is

component HalfAdder is
	port(
		a,b:         in STD_LOGIC;   -- entradas
		soma,vaium: out STD_LOGIC   -- sum e carry
	);
end component;

signal carry : STD_LOGIC;
begin

    h0: HalfAdder port map (a(0),'1',a(0),carry);
    h1: HalfAdder port map (a(1),carry,a(1),carry);
    h2: HalfAdder port map (a(2),carry,a(2),carry);
    h3: HalfAdder port map (a(3),carry,a(3),carry);
    
    h4: HalfAdder port map (a(4),carry,a(4),carry);
    h5: HalfAdder port map (a(5),carry,a(5),carry);
    h6: HalfAdder port map (a(6),carry,a(6),carry);
    h7: HalfAdder port map (a(7),carry,a(7),carry);
    
    h8: HalfAdder port map (a(8),carry,a(8),carry);
    h9: HalfAdder port map (a(9),carry,a(9),carry);
    h10: HalfAdder port map (a(10),carry,a(10),carry);
    h11: HalfAdder port map (a(11),carry,a(11),carry);
    
    h12: HalfAdder port map (a(12),carry,a(12),carry);
    h13: HalfAdder port map (a(13),carry,a(13),carry);
    h14: HalfAdder port map (a(14),carry,a(14),carry);
    h15: HalfAdder port map (a(15),carry,a(15),carry);
end architecture;
