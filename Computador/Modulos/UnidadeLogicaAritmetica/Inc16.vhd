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

signal carry_flip, carry_flop : STD_LOGIC;
begin

    h0: HalfAdder port map (a(0),'1',q(0),carry_flip);
    h1: HalfAdder port map (a(1),carry_flip,q(1),carry_flop);
    h2: HalfAdder port map (a(2),carry_flop,q(2),carry_flip);
    h3: HalfAdder port map (a(3),carry_flip,q(3),carry_flop);
    
    h4: HalfAdder port map (a(4),carry_flop,q(4),carry_flip);
    h5: HalfAdder port map (a(5),carry_flip,q(5),carry_flop);
    h6: HalfAdder port map (a(6),carry_flop,q(6),carry_flip);
    h7: HalfAdder port map (a(7),carry_flip,q(7),carry_flop);
    
    h8: HalfAdder port map (a(8),carry_flop,q(8),carry_flip);
    h9: HalfAdder port map (a(9),carry_flip,q(9),carry_flop);
    h10: HalfAdder port map (a(10),carry_flop,q(10),carry_flip);
    h11: HalfAdder port map (a(11),carry_flip,q(11),carry_flop);
    
    h12: HalfAdder port map (a(12),carry_flop,q(12),carry_flip);
    h13: HalfAdder port map (a(13),carry_flip,q(13),carry_flop);
    h14: HalfAdder port map (a(14),carry_flop,q(14),carry_flip);
    h15: HalfAdder port map (a(15),carry_flip,q(15),carry_flop);
end architecture;
