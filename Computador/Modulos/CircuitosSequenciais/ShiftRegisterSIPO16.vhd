-- Elementos de Sistemas
-- by Luciano Soares
-- ShiftRegisterSIPO16.vhd

-- shift register tipo SIPO de 16 bits:
-- out[0] = in[t], out[1] = in[t+1], out[2] = in[t+2], ...

Library ieee; 
use ieee.std_logic_1164.all;
  
entity ShiftRegisterSIPO16 is
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC;
		output: out STD_LOGIC_VECTOR(15 downto 0)
	);
end entity;

architecture arch_ShiftRegisterSIPO16 of ShiftRegisterSIPO16 is

signal w: STD_LOGIC_VECTOR(15 downto 0)

component BinaryDigit
port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC;
		load:    in STD_LOGIC;
		output: out STD_LOGIC
	);

end component;

begin 
	u1: BinaryDigit port map (clock, input, load, w(0));
	u2: BinaryDigit port map (clock, w(0), load, w(1));
	u3: BinaryDigit port map (clock, w(1), load, w(2));
	u4: BinaryDigit port map (clock, w(2), load, w(3));
	u5: BinaryDigit port map (clock, w(3), load, w(4));
	u6: BinaryDigit port map (clock, w(4), load, w(5));
	u7: BinaryDigit port map (clock, w(5), load, w(6));
	u8: BinaryDigit port map (clock, w(6), load, w(7));
	u9: BinaryDigit port map (clock, w(7), load, w(8));
	u10: BinaryDigit port map (clock, w(8), load, w(9));
	u11: BinaryDigit port map (clock, w(9), load, w(10));
	u12: BinaryDigit port map (clock, w(10), load, w(11));
	u13: BinaryDigit port map (clock, w(11), load, w(12));
	u14: BinaryDigit port map (clock, w(12), load, w(13));
	u15: BinaryDigit port map (clock, w(13), load, w(14));
	u16: BinaryDigit port map (clock, w(14), load, w(15));

	output <= w
end architecture;