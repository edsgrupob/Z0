-- Elementos de Sistemas
-- by Luciano Soares
-- ShiftRegisterPIPO16.vhd

-- shift register tipo PIPO de 16 bits:
-- If direction == 0 then out[t+1] = out[t] << 1
--                   else out[t+1] = out[t] >> 1
-- os novos bits podem ser preenchidos com 0

Library ieee; 
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ShiftRegisterPIPO16 is
	port(
		clock:     in  STD_LOGIC;
		input:     in  STD_LOGIC_VECTOR(15 downto 0);
		direction: in  STD_LOGIC;
		output:    out STD_LOGIC_VECTOR(15 downto 0)
	);

end entity;



architecture arch_pipo of ShiftRegisterPIPO16 is
	
	
	
	
	
	
	component FlipFlopD is
		port(
			clock:  in std_logic;
			d:      in std_logic;
			clear:  in std_logic;
			preset: in std_logic;
			q:     out std_logic
		);
	end component;
	
	component Mux2Way is
		port ( 
				a:   in  STD_LOGIC;
				b:   in  STD_LOGIC;
				sel: in  STD_LOGIC;
				q:   out STD_LOGIC);
	end component;
	
	signal outvector: STD_LOGIC_VECTOR(15 downto 0);
	signal FFout: STD_LOGIC_VECTOR(15 downto 0);
	--signal dir: STD_LOGIC;
	
	
	begin
	
	--dir <= direction;
	
	
	FFD0: FlipFlopD port map (clock, input(0), '1', '1', FFout(0));
	FFD1: FlipFlopD port map (clock, input(1), '1', '1', FFout(1));
	FFD2: FlipFlopD port map (clock, input(2), '1', '1', FFout(2));
	FFD3: FlipFlopD port map (clock, input(3), '1', '1', FFout(3));
	FFD4: FlipFlopD port map (clock, input(4), '1', '1', FFout(4));
	FFD5: FlipFlopD port map (clock, input(5), '1', '1', FFout(5));
	FFD6: FlipFlopD port map (clock, input(6), '1', '1', FFout(6));
	FFD7: FlipFlopD port map (clock, input(7), '1', '1', FFout(7));
	FFD8: FlipFlopD port map (clock, input(8), '1', '1', FFout(8));
	FFD9: FlipFlopD port map (clock, input(9), '1', '1', FFout(9));
	FFD10: FlipFlopD port map (clock, input(10), '1', '1', FFout(10));
	FFD11: FlipFlopD port map (clock, input(11), '1', '1', FFout(11));
	FFD12: FlipFlopD port map (clock, input(12), '1', '1', FFout(12));
	FFD13: FlipFlopD port map (clock, input(13), '1', '1', FFout(13));
	FFD14: FlipFlopD port map (clock, input(14), '1', '1', FFout(14));
	FFD15: FlipFlopD port map (clock, input(15), '1', '1', FFout(15));
	
	
	MUX0: Mux2Way port map ('0', FFout(1), direction, outvector(0));
	MUX1: Mux2Way port map (FFout(0), FFout(2), direction, outvector(1));
	MUX2: Mux2Way port map (FFout(1), FFout(3), direction, outvector(2));
	MUX3: Mux2Way port map (FFout(2), FFout(4), direction, outvector(3));
	MUX4: Mux2Way port map (FFout(3), FFout(5), direction, outvector(4));
	MUX5: Mux2Way port map (FFout(4), FFout(6), direction, outvector(5));
	MUX6: Mux2Way port map (FFout(5), FFout(7), direction, outvector(6));
	MUX7: Mux2Way port map (FFout(6), FFout(8), direction, outvector(7));
	MUX8: Mux2Way port map (FFout(7), FFout(9), direction, outvector(8));
	MUX9: Mux2Way port map (FFout(8), FFout(10), direction, outvector(9));
	MUX10: Mux2Way port map (FFout(9), FFout(11), direction, outvector(10));
	MUX11: Mux2Way port map (FFout(10), FFout(12), direction, outvector(11));
	MUX12: Mux2Way port map (FFout(11), FFout(13), direction, outvector(12));
	MUX13: Mux2Way port map (FFout(12), FFout(14), direction, outvector(13));
	MUX14: Mux2Way port map (FFout(13), FFout(15), direction, outvector(14));
	MUX15: Mux2Way port map (FFout(14), '0', direction, outvector(15));
	
	
	output <= outvector;
	

end architecture;