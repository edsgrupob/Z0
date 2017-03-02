library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity And16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			b:   in  STD_LOGIC_VECTOR(15 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end entity;

architecture arch_and16 of chip_and16 is component chip_and16
	port (a,b: in STD_LOGIC;
	      q: out STD_LOGIC);
end component;
begin
	u1: chip_and16 port map (a(0),b(0),q(0));
	u2: chip_and16 port map (a(1),b(1),q(1));
	u3: chip_and16 port map (a(2),b(2),q(2));
	u4: chip_and16 port map (a(3),b(3),q(3));
	u5: chip_and16 port map (a(4),b(4),q(4));
	u6: chip_and16 port map (a(5),b(5),q(5));
	u7: chip_and16 port map (a(6),b(6),q(6));
	u8: chip_and16 port map (a(7),b(7),q(7));
	u9: chip_and16 port map (a(8),b(8),q(8));
	u10: chip_and16 port map (a(9),b(9),q(9));
	u11: chip_and16 port map (a(10),b(10),q(10));
	u12: chip_and16 port map (a(11),b(11),q(11));
	u13: chip_and16 port map (a(12),b(12),q(12));
	u14: chip_and16 port map (a(13),b(13),q(13));
	u15: chip_and16 port map (a(14),b(14),q(14));
	u16: chip_and16 port map (a(15),b(15),q(15));
end architecture;