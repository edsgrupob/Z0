library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity BarrelShifter16 is
	port ( 
			a:    in  STD_LOGIC_VECTOR(15 downto 0);   -- input vector
			dir:  in  std_logic;                       -- 0=>left 1=>right
			size: in  std_logic_vector(2 downto 0);    -- shift amount
			q:    out STD_LOGIC_VECTOR(15 downto 0));  -- output vector (shifted)
end entity;
architecture chip_BarrelShifter16 of BarrelShifter16 is
begin
	process (a, size)
		begin
		if (dir = '1') then
			if (size ="000") then
				q <= a;
			elsif (size = "001") then
				q <= a(0) & a (15 downto 1);
			elsif (size ="010") then
				q <= a(1 downto 0) & a(15 downto 2);
			elsif (size ="011") then
				q <= a(2 downto 0) & a(15 downto 3);
			elsif (size ="100") then
				q <= a(3 downto 0) & a(15 downto 4);
			elsif (size ="101") then
				q <= a(4 downto 0) & a(15 downto 5);
			elsif (size ="110") then
				q <= a(5 downto 0) & a(15 downto 6);
			elsif (size ="111") then
				q <= a(6 downto 0) & a(15 downto 7);
			end if;
		end if;
		if (dir = '0') then
			if (size="000") then
				q <= a;
			elsif (size ="001") then
				q <= a(14 downto 0) & a(15);
			elsif (size ="010") then
				q <= a(13 downto 0) & a(15 downto 14);
			elsif (size ="011") then
				q <= a(12 downto 0) & a(15 downto 13);
			elsif (size ="100") then
				q <= a(11 downto 0) & a(15 downto 12);
			elsif (size ="101") then
				q <= a(10 downto 0) & a(15 downto 11);
			elsif (size ="110") then
				q <= a(9 downto 0) & a(15 downto 10);
			elsif (size ="111") then
				q <= a(8 downto 0) & a(15 downto 9);
			end if;
		end if;
	end process;
end architecture;