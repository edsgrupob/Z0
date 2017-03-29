-- Elementos de Sistemas
-- by Luciano Soares
-- ShiftRegisterSISO16.vhd

-- shift register tipo SISO de 16 bits:
-- out[t+15] = in[t], out[t+16] = in[t+1], out[t+17] = in[t+2], ...

Library ieee; 
use ieee.std_logic_1164.all;
  
entity ShiftRegisterSISO16 is
	port(
		clock:   in STD_LOGIC;
		input:   in STD_LOGIC;
		output: out STD_LOGIC
	);
end entity;

architecture arch of ShiftRegisterSISO16 is

component FlipFlopD is
    port(
        clock, d, clear, preset: in STD_LOGIC;
        q: out STD_LOGIC
    );
end component;
signal c0, c1, c2, c3, c4, c5, c6, c7, c8, c9 , cA, cB, cC, cD, cE: STD_LOGIC;

begin

    FF0: FlipFlopD port map (clock, input, '1', '1', c0);
    FF1: FlipFlopD port map (clock, c0, '1', '1', c1);
    FF2: FlipFlopD port map (clock, c1, '1', '1', c2);
    FF3: FlipFlopD port map (clock, c2, '1', '1', c3);
    
    FF4: FlipFlopD port map (clock, c3, '1', '1', c4);
    FF5: FlipFlopD port map (clock, c4, '1', '1', c5);
    FF6: FlipFlopD port map (clock, c5, '1', '1', c6);
    FF7: FlipFlopD port map (clock, c6, '1', '1', c7);
    
    FF8: FlipFlopD port map (clock, c7, '1', '1', c8);
    FF9: FlipFlopD port map (clock, c8, '1', '1', c9);
    FFA: FlipFlopD port map (clock, c9, '1', '1', cA);
    FFB: FlipFlopD port map (clock, cA, '1', '1', cB);
    
    FFC: FlipFlopD port map (clock, cB, '1', '1', cC);
    FFD: FlipFlopD port map (clock, cC, '1', '1', cD);
    FFE: FlipFlopD port map (clock, cD, '1', '1', cE);
    FFF: FlipFlopD port map (clock, cE, '1', '1', output);
end architecture;
