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

component HalfAdder is
	port(
		a,b:         in STD_LOGIC;   -- entradas
		soma,vaium: out STD_LOGIC   -- sum e carry
	);
end component;

architecture arch_Inc16 of Inc16 is 
signal carry : STD_LOGIC;
begin

    hold: HalfAdder port map (a(0),'1',a(0),carry);
    hold: HalfAdder port map (a(1),carry,a(1),carry);
    hold: HalfAdder port map (a(2),carry,a(2),carry);
    hold: HalfAdder port map (a(3),carry,a(3),carry);
    
    hold: HalfAdder port map (a(4),carry,a(4),carry);
    hold: HalfAdder port map (a(5),carry,a(5),carry);
    hold: HalfAdder port map (a(6),carry,a(6),carry);
    hold: HalfAdder port map (a(7),carry,a(7),carry);
    
    hold: HalfAdder port map (a(8),carry,a(8),carry);
    hold: HalfAdder port map (a(9),carry,a(9),carry);
    hold: HalfAdder port map (a(10),carry,a(10),carry);
    hold: HalfAdder port map (a(11),carry,a(11),carry);
    
    hold: HalfAdder port map (a(12),carry,a(12),carry);
    hold: HalfAdder port map (a(13),carry,a(13),carry);
    hold: HalfAdder port map (a(14),carry,a(14),carry);
    hold: HalfAdder port map (a(15),carry,a(15),carry);
end architecture;
