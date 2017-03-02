library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Not16 is
	port ( 
			a:   in  STD_LOGIC_VECTOR(15 downto 0);
			q:   out STD_LOGIC_VECTOR(15 downto 0));
end entity;

architecture arch_not16 of chip_not16 is component chip_not16
	port (a: in STD_LOGIC;
	      q: out STD_LOGIC);
end component;
begin
	u1: chip_not16 port map (a(0),q(0));
	u2: chip_not16 port map (a(1),q(1));
	u3: chip_not16 port map (a(2),q(2));
	u4: chip_not16 port map (a(3),q(3));
	u5: chip_not16 port map (a(4),q(4));
	u6: chip_not16 port map (a(5),q(5));
	u7: chip_not16 port map (a(6),q(6));
	u8: chip_not16 port map (a(7),q(7));
	u9: chip_not16 port map (a(8),q(8));
	u10: chip_not16 port map (a(9),q(9));
	u11: chip_not16 port map (a(10),q(10));
	u12: chip_not16 port map (a(11),q(11));
	u13: chip_not16 port map (a(12),q(12));
	u14: chip_not16 port map (a(13),q(13));
	u15: chip_not16 port map (a(14),q(14));
	u16: chip_not16 port map (a(15),q(15));
end architecture;