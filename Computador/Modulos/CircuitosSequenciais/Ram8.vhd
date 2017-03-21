-- Elementos de Sistemas
-- by Luciano Soares
-- Ram8.vhd

Library ieee; 
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
  
entity Ram8 is
	port(
		clock:   in  STD_LOGIC;
		input:   in  STD_LOGIC_VECTOR(15 downto 0);
		load:    in  STD_LOGIC;
		address: in  STD_LOGIC_VECTOR( 2 downto 0);
		output:  out STD_LOGIC_VECTOR(15 downto 0)
	);
end entity;

architecture arch_Ram8 of Ram8 is
   type memory is array(0 to 7) of std_logic_vector(15 downto 0);
   signal signal_ram : memory;

begin

	process(clock)
	begin
		if (clock'event and clock='1' and load='1') then
				signal_ram(to_integer(unsigned(address))) <= input;
		end if;
	end process;
	output <= signal_ram(to_integer(unsigned(address)));

end architecture;
