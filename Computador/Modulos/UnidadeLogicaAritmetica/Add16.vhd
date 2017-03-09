-- Soma dois valores de 16 bits
-- ignorando o carry mais significativo

library IEEE; 
use IEEE.STD_LOGIC_1164.all;
  
entity Add16 is
	port(
		a   :  in STD_LOGIC_VECTOR(15 downto 0);
		b   :  in STD_LOGIC_VECTOR(15 downto 0);
		q   : out STD_LOGIC_VECTOR(15 downto 0) 
	); 
end entity; 

architecture arch_Add16 of Add16 is
signal c0:STD_LOGIC;
signal c1:STD_LOGIC;
signal c2:STD_LOGIC;
signal c3:STD_LOGIC;
signal c4:STD_LOGIC;
signal c5:STD_LOGIC;
signal c6:STD_LOGIC;
signal c7:STD_LOGIC;
signal c8:STD_LOGIC;
signal c9:STD_LOGIC;
signal c10:STD_LOGIC;
signal c11:STD_LOGIC;
signal c12:STD_LOGIC;
signal c13:STD_LOGIC;
signal c14:STD_LOGIC;
signal c15:STD_LOGIC;

component HalfAdder
	port (a,b: in STD_LOGIC;
	      soma, vaium: out STD_LOGIC);
end component;
component FullAdder
	port (a, b, c: in STD_LOGIC;
		  soma, vaium: out STD_LOGIC);
end component;
begin
	u1: HalfAdder port map (a(0), b(0), q(0), c0);
	u2: FullAdder port map (a(1), b(1), c0, q(1), c1);
	u3: FullAdder port map (a(2), b(2), c1, q(2), c2);
	u4: FullAdder port map (a(3), b(3), c2, q(3), c3);
	u5: FullAdder port map (a(4), b(4), c3, q(4), c4);
	u6: FullAdder port map (a(5), b(5), c4, q(5), c5);
	u7: FullAdder port map (a(6), b(6), c5, q(6), c6);
	u8: FullAdder port map (a(7), b(7), c6, q(7), c7);
	u9: FullAdder port map (a(8), b(8), c7, q(8), c8);
	u10: FullAdder port map (a(9), b(9), c8, q(9), c9);
	u11: FullAdder port map (a(10), b(10), c9, q(10), c10);
	u12: FullAdder port map (a(11), b(11), c10, q(11), c11);
	u13: FullAdder port map (a(12), b(12), c11, q(12), c12);
	u14: FullAdder port map (a(13), b(13), c12, q(13), c13);
	u15: FullAdder port map (a(14), b(14), c13, q(14), c14);
	u16: FullAdder port map (a(15), b(15), c14, q(15), c15);
	
end arch_Add16;
